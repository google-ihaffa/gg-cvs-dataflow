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

    List<JSONObject> list = new ArrayList<>();

    // Insert to list so as jsonObject can be order by LAST_UPDATED_DATE
    com.google.cloud.Timestamp pres_timestamp = com.google.cloud.Timestamp.MIN_VALUE;
    com.google.cloud.Timestamp pres_fill_timestamp = com.google.cloud.Timestamp.MIN_VALUE;
    int pres_idx = -1;
    int pres_fill_idx = -1;
    int idx = 0;
    String updateTimeKey = "LAST_UPDATED_DATE";

    for (String jsonString : element.getValue()) {
      try {
        JSONObject json = new JSONObject(jsonString);
        if (json.has("PRESCRIPTION_FILL_ID")) {
          com.google.cloud.Timestamp timestamp =
              DynamicSchemaMapping.convertTimestamp(json.getString(updateTimeKey));
          if (timestamp.compareTo(pres_fill_timestamp) > 0) {
            pres_fill_timestamp = timestamp;
            pres_fill_idx = idx;
          }
        } else {
          com.google.cloud.Timestamp timestamp =
              DynamicSchemaMapping.convertTimestamp(json.getString(updateTimeKey));
          if (timestamp.compareTo(pres_timestamp) > 0) {
            pres_fill_timestamp = timestamp;
            pres_idx = idx;
          }
        }
        idx++;
        list.add(json);
      } catch (Exception e) {
        LOG.error("Fails to parse JSON to JSON Object: " + e.getMessage());
        return;
      }
    }

    List<Mutation> mutationList = new ArrayList<>();
    // Mutation.WriteBuilder presWriter = null;
    // Mutation.WriteBuilder presFillWriter = null;

    /*
     *  Do not remove these code, These might be needed in case spanner doesnt respect ordering.
     *  Might need to use logic to only insert latest record instead. 
     */

    // if (pres_idx >= 0) {

    //   presWriter = Mutation.newInsertOrUpdateBuilder("prescription_uc1_im");
    //   presWriter =
    //       prescriptionMutationBuilder(presWriter, list.get(pres_idx), "prescription_uc1_im");
    //   mutationList.add(presWriter.build());
    // }

    // if (pres_fill_idx >= 0) {
    //   presFillWriter = Mutation.newInsertOrUpdateBuilder("prescriptionfill_uc2_second");
    //   presWriter =
    //   fillPrescriptionSplit1MutationBuilder(
    //           presWriter, list.get(pres_fill_idx));
    //   mutationList.add(presFillWriter.build());
    // }

    // if (presWriter != null) {
    //   receiver.output(MutationGroup.create(presWriter.build(), mutationList));
    // } else {
    //   receiver.output(MutationGroup.create(presFillWriter.build(), mutationList));
    // }

      /*
     *  The code below sort the for groupMutation to be inserted together. Ensure primary is the latest Object of insertion. 
     */

    Collections.sort(
        list,
        (jsonObj1, jsonObj2) -> {
          com.google.cloud.Timestamp timestamp1 = null;
          com.google.cloud.Timestamp timestamp2 = null;

          // There are some records missing LAST_UPDATED_DATE which causing issue for ordering
          try {
            String dateString = jsonObj1.getString("LAST_UPDATED_DATE");
            timestamp1 = DynamicSchemaMapping.convertTimestamp(dateString);
            if(jsonObj1.getLong("PRESCRIPTION_ID") == 14783909288L &&
    jsonObj1.has("PRESCRIPTION_FILL")) {
              LOG.info("LAST UPDATED DATE OF FIRST OBJECT "  + dateString + " converted timestamp is:" + timestamp1);
            }
          } catch (JSONException e) {
            // TODO Auto-generated catch block
            LOG.error("Unable to parse JSON timestamp in MutationToGroupMethod: " +
    e.getMessage());
            LOG.error("Original json message: " + jsonObj1);
            timestamp1 = com.google.cloud.Timestamp.MIN_VALUE;
          }
          try {
            String dateString = jsonObj2.getString("LAST_UPDATED_DATE");
            timestamp2 = DynamicSchemaMapping.convertTimestamp(dateString);
            if(jsonObj2.getLong("PRESCRIPTION_ID") == 14783909288L &&
    jsonObj2.has("PRESCRIPTION_FILL")) {
              LOG.info("LAST UPDATED DATE OF FIRST OBJECT "  + dateString + " converted timestamp is:" + timestamp2);
            }
          } catch (JSONException e) {
            // TODO Auto-generated catch block
            LOG.error("Unable to parse JSON timestamp in MutationToGroupMethod: " +
    e.getMessage());
            LOG.error("Original json message: " + jsonObj2);
            timestamp2 = com.google.cloud.Timestamp.MIN_VALUE;
          }
          return timestamp1.compareTo(timestamp2);
        });

    Mutation primary = null;
    for (JSONObject jsonObject : list) {
      if (jsonObject.has("PRESCRIPTION_FILL_ID")) {
        // fillPrescriptionCounter.inc();
        Mutation.WriteBuilder mutationWriter =
            Mutation.newInsertOrUpdateBuilder("prescriptionfill_uc0_final");
        mutationWriter = prescriptionMutationBuilder(mutationWriter, jsonObject, "prescriptionfill_uc0_final");
        primary = mutationWriter.build();
        mutationList.add(primary);

      } else {
        Mutation.WriteBuilder mutationWriter =
            Mutation.newInsertOrUpdateBuilder("prescription_uc0_final");
        mutationWriter = prescriptionMutationBuilder(mutationWriter, jsonObject, "prescription_uc0_final");
        primary = mutationWriter.build();
        mutationList.add(primary);

      }
    }
    receiver.output(MutationGroup.create(primary, mutationList));
  }

  public JSONObject updateJsonObject(JSONObject before, JSONObject after) {
    for (String key : after.keySet()) {
      if (before.has(key)) {
        before.put(key, after.get(key));
      }
    }
    return before;
  }

  // public Mutation.WriteBuilder fillPrescriptionSplit1MutationBuilder(
  //     Mutation.WriteBuilder mutationBuilder, JSONObject prescriptionFillObject)
  //     throws JSONException, ParseException {
  //   return DynamicSchemaMapping.buildMutationFromMapping(
  //       mutationBuilder, prescriptionFillObject, "prescriptionfill_uc2_second");
  // }

  // public Mutation.WriteBuilder fillPrescriptionSplit2MutationBuilder(
  //     Mutation.WriteBuilder mutationBuilder, JSONObject prescriptionFillObject)
  //     throws JSONException, ParseException {
  //   return DynamicSchemaMapping.buildMutationFromMapping(
  //       mutationBuilder, prescriptionFillObject, "prescriptionfill_uc2_second");
  // }

  public Mutation.WriteBuilder prescriptionMutationBuilder(
      Mutation.WriteBuilder mutationBuilder, JSONObject jsonObject, String table_name)  throws JSONException, ParseException {

    return DynamicSchemaMapping.buildMutationFromMapping(mutationBuilder, jsonObject, table_name);
  }
}
