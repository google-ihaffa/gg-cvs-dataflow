package org.apache.beam.DoFn;

import com.google.cloud.spanner.Mutation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.beam.sdk.io.gcp.spanner.MutationGroup;
import org.apache.beam.sdk.metrics.Counter;
import org.apache.beam.sdk.metrics.Metrics;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.DoFn.Element;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.util.DynamicSchemaMapping;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MutationToGroupMutation extends DoFn<KV<Long, Iterable<String>>, MutationGroup> {

  private static final Logger LOG = LoggerFactory.getLogger(MutationToGroupMutation.class);

  private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
  private Counter fillPrescriptionCounter =
      Metrics.counter(JsonToMutation.class, "fill_prescription");
  private Counter parseFail = Metrics.counter(MutationToGroupMutation.class, "fail_structure");

  Gson gson;

  @Setup
  public void setup() {
    gson = new GsonBuilder().setDateFormat("yyyy-mm-dd hh:mm:ss").create();
  }

  @ProcessElement
  public void processElement(
      @Element KV<Long, Iterable<String>> element, OutputReceiver<MutationGroup> receiver)
      throws JSONException, ParseException {

    List<JSONObject> sortedList = new ArrayList<>();

    // Insert to list so as jsonObject can be order by LAST_UPDATED_DATE
    for (String jsonString : element.getValue()) {
      try {
        JSONObject json = new JSONObject(jsonString);
        sortedList.add(json);
      } catch (Exception e) {
        LOG.error("Fails to parse JSON to JSON Object: " + e.getMessage());
        return;
      }
    }

    Collections.sort(
        sortedList,
        (jsonObj1, jsonObj2) -> {
          String updateTimeKey = "LAST_UPDATED_DATE";
          com.google.cloud.Timestamp timestamp1 = null;
          com.google.cloud.Timestamp timestamp2 = null;

          // There are some records missing LAST_UPDATED_DATE which causing issue for ordering
          try {
            String dateString = jsonObj1.getString("LAST_UPDATED_DATE");
            timestamp1 = DynamicSchemaMapping.convertTimestamp(dateString);
          } catch (JSONException e) {
            // TODO Auto-generated catch block
            LOG.error("Unable to parse JSON timestamp in MutationToGroupMethod: " + e.getMessage());
            LOG.error("Original json message: " + jsonObj1);
            timestamp1 = com.google.cloud.Timestamp.MIN_VALUE;
          }
          try {
            String dateString = jsonObj2.getString("LAST_UPDATED_DATE");
            timestamp2 = DynamicSchemaMapping.convertTimestamp(dateString);
          } catch (JSONException e) {
            // TODO Auto-generated catch block
            LOG.error("Unable to parse JSON timestamp in MutationToGroupMethod: " + e.getMessage());
            LOG.error("Original json message: " + jsonObj1);
            timestamp2 = com.google.cloud.Timestamp.MIN_VALUE;
          }
          return timestamp1.compareTo(timestamp2);
        });

    List<Mutation> mutationList = new ArrayList<>();
    Mutation primary = null;

    for (JSONObject jsonObject : sortedList) {
      if (jsonObject.has("PRESCRIPTION_FILL_ID")) {
        // fillPrescriptionCounter.inc();
        Mutation.WriteBuilder mutationWriter =
            Mutation.newInsertOrUpdateBuilder("prescriptionfill_uc2_second");
        mutationWriter = fillPrescriptionSplit1MutationBuilder(mutationWriter, jsonObject);
        primary = mutationWriter.build();
        mutationList.add(primary);
        // secondMutationBuilder = fillPrescriptionSplit2MutationBuilder(secondMutationBuilder,
        // after);

        // c.output(KV.of(pk, secondMutationBuilder.build()));

      } else {
        Mutation.WriteBuilder mutationWriter =
            Mutation.newInsertOrUpdateBuilder("prescription_uc1_im");
        mutationWriter = prescriptionMutationBuilder(mutationWriter, jsonObject);
        primary = mutationWriter.build();
        mutationList.add(primary);

        // prescription = gson.fromJson(after.toString(), Prescription.class);
        // mutationBuilder = prescriptionMutationBuilder(mutationBuilder, prescription);
        //    c.output(KV.of(pk, after.toString()));
      }
      receiver.output(MutationGroup.create(primary, mutationList));
    }
  }

  public JSONObject updateJsonObject(JSONObject before, JSONObject after) {
    for (String key : after.keySet()) {
      if (before.has(key)) {
        before.put(key, after.get(key));
      }
    }
    return before;
  }

  public Mutation.WriteBuilder fillPrescriptionSplit1MutationBuilder(
      Mutation.WriteBuilder mutationBuilder, JSONObject prescriptionFillObject)
      throws JSONException, ParseException {
    return DynamicSchemaMapping.buildMutationFromMapping(
        mutationBuilder, prescriptionFillObject, "prescriptionfill_uc2_second");
  }

  public Mutation.WriteBuilder fillPrescriptionSplit2MutationBuilder(
      Mutation.WriteBuilder mutationBuilder, JSONObject prescriptionFillObject)
      throws JSONException, ParseException {
    return DynamicSchemaMapping.buildMutationFromMapping(
        mutationBuilder, prescriptionFillObject, "prescriptionfill_uc2_second");
  }

  public Mutation.WriteBuilder prescriptionMutationBuilder(
      Mutation.WriteBuilder mutationBuilder, JSONObject jsonObject) {

    return DynamicSchemaMapping.buildMutationFromMapping(
        mutationBuilder, jsonObject, "prescription_uc1_im");
  }
}
