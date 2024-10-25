package org.apache.beam.DoFn;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.beam.sdk.metrics.Counter;
import org.apache.beam.sdk.metrics.Metrics;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.values.KV;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConvertJsonToKV extends DoFn<String, KV<Long, String>> {
  private static final Logger LOG = LoggerFactory.getLogger(JsonToMutation.class);

  private Counter fillPrescriptionCounter =
      Metrics.counter(JsonToMutation.class, "fill_prescription");
  private Counter parseFail = Metrics.counter(ConvertJsonToKV.class, "fail_structure");

  Gson gson;

  @Setup
  public void setup() {
    gson = new GsonBuilder().setDateFormat("yyyy-mm-dd hh:mm:ss").create();
  }

  @ProcessElement
  public void processElement(ProcessContext c) {
    String message = c.element();
    try {
      JSONObject json = new JSONObject(message);
      json.get("CSN");
      JSONObject after = json.getJSONObject("after");
      long pk = after.getLong("PRESCRIPTION_ID");
      if (pk == 14783909288L
          && json.getString("table").equalsIgnoreCase("RXOWNER.RXP_PRESCRIPTION_FILL")) {
        LOG.info("before \n" + json.getJSONObject("before"));
        LOG.info("after \n" + after);
      }

      c.output(KV.of(pk, after.toString()));
    } catch (Exception e) {
      LOG.error("Parsing issue on ConvertJsonToKV");
      parseFail.inc();
      return;
    }
  }
}
