package org.apache.beam.DoFn;

import com.google.cloud.spanner.Mutation;
import org.apache.beam.sdk.state.StateSpec;
import org.apache.beam.sdk.state.StateSpecs;
import org.apache.beam.sdk.state.ValueState;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.DoFn.ProcessContext;
import org.apache.beam.sdk.transforms.DoFn.ProcessElement;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.util.DynamicSchemaMapping;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StateDataFilter extends DoFn<KV<Long, String>, Mutation> {
  private static final Logger LOG = LoggerFactory.getLogger(StateDataFilter.class);

  @StateId("pres")
  private final StateSpec<ValueState<com.google.cloud.Timestamp>> presTimestampState =
      StateSpecs.value();

  @StateId("presfill")
  private final StateSpec<ValueState<com.google.cloud.Timestamp>> presfillTimestampState =
      StateSpecs.value();

  @ProcessElement
  public void processElement(
      ProcessContext c,
      @StateId("pres") ValueState<com.google.cloud.Timestamp> presTimestampState,
      @StateId("presfill") ValueState<com.google.cloud.Timestamp> presfillTimestampState) {
    String message = c.element().getValue();
    JSONObject json = null;
    try {
      json = new JSONObject(message);

    } catch (Exception e) {
      LOG.error("Parsing issue on ConvertJsonToKV " + e.getMessage());
      return;
    }
    String updateTimeKey = "LAST_UPDATED_DATE";

    if (json.has("PRESCRIPTION_FILL_ID")) {
      com.google.cloud.Timestamp presfillTimestamp = com.google.cloud.Timestamp.MIN_VALUE;
      if (presfillTimestampState.read() != null) {
        presfillTimestamp = presfillTimestampState.read();
      }

      com.google.cloud.Timestamp timestamp =
          DynamicSchemaMapping.convertTimestamp(json.getString(updateTimeKey));
      if (timestamp.compareTo(presfillTimestamp) <= 0) {
        LOG.info(
            "PrescriptionFill stale on presId: {} timestamp: {} stateTimestamp: {}",
            c.element().getKey(),
            timestamp,
            presfillTimestamp);
        return;
      }

      presfillTimestamp = timestamp;
      presfillTimestampState.write(timestamp);
      Mutation result =
          DynamicSchemaMapping.buildMutationFromMapping(
                  Mutation.newInsertOrUpdateBuilder("prescriptionfill_uc0_im"),
                  json,
                  "prescriptionfill_uc0_im")
              .build();
      c.output(result);
    } else {
      com.google.cloud.Timestamp presTimestamp = com.google.cloud.Timestamp.MIN_VALUE;
      if (presTimestampState.read() != null) {
        presTimestamp = presTimestampState.read();
      }
      com.google.cloud.Timestamp timestamp =
          DynamicSchemaMapping.convertTimestamp(json.getString(updateTimeKey));
      if (timestamp.compareTo(presTimestamp) <= 0) {
        LOG.info(
            "PrescriptionFill stale on presId: {} timestamp: {} stateTimestamp: {}",
            c.element().getKey(),
            timestamp,
            presTimestamp);
        return;
      }

      presTimestamp = timestamp;
      presTimestampState.write(timestamp);
      Mutation result =
          DynamicSchemaMapping.buildMutationFromMapping(
                  Mutation.newInsertOrUpdateBuilder("prescription_uc0_im"),
                  json,
                  "prescription_uc0_im")
              .build();

      c.output(result);
    }
  }
}
