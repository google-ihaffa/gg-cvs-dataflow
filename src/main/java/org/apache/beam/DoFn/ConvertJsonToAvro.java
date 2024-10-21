package org.apache.beam.DoFn;

import com.google.cloud.spanner.Mutation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ibm.icu.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import org.apache.beam.examples.pojo.Prescription;
import org.apache.beam.sdk.metrics.Counter;
import org.apache.beam.sdk.metrics.Metrics;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.TupleTag;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConvertJsonToAvro extends DoFn<String, KV<Long, Mutation>> {
  private static final Logger LOG = LoggerFactory.getLogger(JsonToMutation.class);
  public static final TupleTag<KV<Long, Mutation>> main = new TupleTag<KV<Long, Mutation>>() {};
  public static final TupleTag<KV<Long, Mutation>> splitPrescriptionTupleTag =
      new TupleTag<KV<Long, Mutation>>() {};

  private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private Counter fillPrescriptionCounter =
      Metrics.counter(JsonToMutation.class, "fill_prescription");
  private Counter parseFail = Metrics.counter(ConvertJsonToAvro.class, "fail_structure");

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
      String op_type = json.getString("op_type");
      JSONObject after = null;

      try {
        after = json.getJSONObject("after");
      } catch (Exception e) {
        LOG.info("Parsing issue");
        parseFail.inc();
        return;
      }

      if (after.has("PRESCRIPTION_FILL_ID")) {
        // fillPrescriptionCounter.inc();
        Mutation.WriteBuilder firstMutationBuilder = null;
        Mutation.WriteBuilder secondMutationBuilder = null;
        long pk = after.getLong("PRESCRIPTION_ID");

        if (op_type.equalsIgnoreCase("I")) {
          firstMutationBuilder = Mutation.newInsertOrUpdateBuilder("prescriptionfill_uc2_first");
          // secondMutationBuilder =
          // Mutation.newInsertOrUpdateBuilder("prescriptionfill_uc2_second_conc");

        } else if (op_type.equalsIgnoreCase("U")) {
          firstMutationBuilder = Mutation.newInsertOrUpdateBuilder("prescriptionfill_uc2_first");
          // secondMutationBuilder =
          // Mutation.newInsertOrUpdateBuilder("prescriptionfill_uc2_second_conc");
        }
        firstMutationBuilder = fillPrescriptionSplit1MutationBuilder(firstMutationBuilder, after);
        // secondMutationBuilder = fillPrescriptionSplit2MutationBuilder(secondMutationBuilder,
        // after);

        c.output(KV.of(pk, firstMutationBuilder.build()));
        // c.output(KV.of(pk, secondMutationBuilder.build()));

      } else {
        long pk = after.getLong("PRESCRIPTION_ID");
        Mutation.WriteBuilder mutationBuilder = null;
        Prescription prescription = null;

        if (op_type.equalsIgnoreCase("I")) {
          mutationBuilder = Mutation.newInsertOrUpdateBuilder("prescription_uc1_im");
        } else if (op_type.equalsIgnoreCase("U")) {
          mutationBuilder = Mutation.newInsertOrUpdateBuilder("prescription_uc1_im");
        }
        prescription = gson.fromJson(after.toString(), Prescription.class);
        mutationBuilder = prescriptionMutationBuilder(mutationBuilder, prescription);
        c.output(KV.of(pk, mutationBuilder.build()));
      }

    } catch (Exception e) {
      // Handle parsing errors.

      //   LOG.error("Error parsing JSON");
      LOG.error("original message: " + e.getMessage());
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

  public com.google.cloud.Timestamp convertTimestamp(Date date) {
    if (date == null) return null;

    return com.google.cloud.Timestamp.of(date);
  }

  public Mutation.WriteBuilder fillPrescriptionSplit1MutationBuilder(
      Mutation.WriteBuilder mutationBuilder, JSONObject prescriptionFillObject)
      throws JSONException, ParseException {

    if (prescriptionFillObject.has("PRESCRIPTION_FILL_ID")
        && prescriptionFillObject.get("PRESCRIPTION_FILL_ID") != null) {
      mutationBuilder
          .set("prescription_fill_id")
          .to(prescriptionFillObject.getLong("PRESCRIPTION_FILL_ID"));
    }
    if (prescriptionFillObject.has("PATIENT_ID")
        && prescriptionFillObject.get("PATIENT_ID") != null) {
      mutationBuilder.set("patient_id").to(prescriptionFillObject.getLong("PATIENT_ID"));
    }
    if (prescriptionFillObject.has("PRESCRIPTION_ID")
        && prescriptionFillObject.get("PRESCRIPTION_ID") != null) {
      mutationBuilder.set("prescription_id").to(prescriptionFillObject.getLong("PRESCRIPTION_ID"));
    }
    // if (prescriptionFillObject.has("CREATED_DATE")
    //     && prescriptionFillObject.get("CREATED_DATE") != null) {
    //   // "yyyy-mm-dd hh:mm:ss" date convert string to
    //   Date date = formatter.parse(prescriptionFillObject.getString("CREATED_DATE"));
    //   mutationBuilder.set("created_date").to(convertTimestamp(date));
    // }
    if (prescriptionFillObject.has("CREATED_BY")
        && prescriptionFillObject.get("CREATED_BY") != null) {
      mutationBuilder.set("created_by").to(prescriptionFillObject.getString("CREATED_BY"));
    } else {
      mutationBuilder.set("created_by").to("MISSING_VALUE");
    }
    if (prescriptionFillObject.has("LAST_UPDATED_DATE")
        && prescriptionFillObject.get("LAST_UPDATED_DATE") != null) {
      Date date = formatter.parse(prescriptionFillObject.getString("LAST_UPDATED_DATE"));
      mutationBuilder.set("last_updated_date").to(convertTimestamp(date));
    }
    if (prescriptionFillObject.has("LAST_UPDATED_BY")
        && prescriptionFillObject.get("LAST_UPDATED_BY") != null) {
      mutationBuilder
          .set("last_updated_by")
          .to(prescriptionFillObject.getString("LAST_UPDATED_BY"));
    }
    if (prescriptionFillObject.has("FILL_VERSION")
        && prescriptionFillObject.get("FILL_VERSION") != null) {
      mutationBuilder.set("fill_version").to(prescriptionFillObject.getLong("FILL_VERSION"));
    }
    // if (prescriptionFillObject.has("IS_ALLIGNMENT_FILL") &&
    // prescriptionFillObject.get("IS_ALLIGNMENT_FILL") != null) {
    //   mutationBuilder
    //       .set("is_allignment_fill")
    //       .to(prescriptionFillObject.getString("IS_ALLIGNMENT_FILL"));
    // }

    // if (prescriptionFillObject.has("FILL_SUB_STATUS")) {
    //
    // mutationBuilder.set("fill_sub_status").to(prescriptionFillObject.getLong("FILL_SUB_STATUS"));
    // }
    // if (prescriptionFillObject.has("ACTION_TIME") && prescriptionFillObject.get("ACTION_TIME") !=
    // null) {
    //   Date date = formatter.parse(prescriptionFillObject.getString("ACTION_TIME"));
    //   mutationBuilder.set("action_time").to(convertTimestamp(date));
    // }

    return mutationBuilder;
  }

  public Mutation.WriteBuilder fillPrescriptionSplit2MutationBuilder(
      Mutation.WriteBuilder mutationBuilder, JSONObject prescriptionFillObject)
      throws JSONException, ParseException {
    if (prescriptionFillObject.has("PRESCRIPTION_FILL_ID")
        && prescriptionFillObject.get("PRESCRIPTION_FILL_ID") != null) {
      mutationBuilder
          .set("prescription_fill_id")
          .to(prescriptionFillObject.getLong("PRESCRIPTION_FILL_ID"));
    }
    if (prescriptionFillObject.has("PATIENT_ID")
        && prescriptionFillObject.get("PATIENT_ID") != null) {
      mutationBuilder.set("patient_id").to(prescriptionFillObject.getLong("PATIENT_ID"));
    }
    if (prescriptionFillObject.has("PRESCRIPTION_ID")
        && prescriptionFillObject.get("PRESCRIPTION_ID") != null) {
      mutationBuilder.set("prescription_id").to(prescriptionFillObject.getLong("PRESCRIPTION_ID"));
    }

    if (prescriptionFillObject.has("LAST_UPDATED_DATE")
        && prescriptionFillObject.get("LAST_UPDATED_DATE") != null) {
      Date date = formatter.parse(prescriptionFillObject.getString("LAST_UPDATED_DATE"));
      mutationBuilder.set("last_updated_date").to(convertTimestamp(date));
    }
    if (prescriptionFillObject.has("LAST_UPDATED_BY")
        && prescriptionFillObject.get("LAST_UPDATED_BY") != null) {
      mutationBuilder
          .set("last_updated_by")
          .to(prescriptionFillObject.getString("LAST_UPDATED_BY"));
    }

    // TODO: Fill it with PRESCRIPTIONFILL_UC2_SECOND file

    return mutationBuilder;
  }

  public Mutation.WriteBuilder prescriptionMutationBuilder(
      Mutation.WriteBuilder mutationBuilder, Prescription prescription) {
    return
    //
    mutationBuilder
        .set("prescription_id")
        .to(prescription.getPrescriptionId())
        .set("acquired_id")
        .to(prescription.getAcquiredId())
        .set("last_updated_by")
        .to(prescription.getLastUpdatedBy())
        .set("last_updated_date")
        .to(convertTimestamp(prescription.getLastUpdatedDate()))
        // .set("hc_rescan_flag")
        // .to(prescription.getHcRescanFlag())
        // .set("prohibited_ind")
        // .to(prescription.getProhibitedInd())
        // .set("ready_fill_enrollment_cd")
        // .to(prescription.getReadyFillEnrollmentCd())
        // .set("ready_fill_enrollment_date")
        // .to(convertTimestamp(prescription.getReadyFillEnrollmentDate()))
        // .set("readyfill_due_ss_change")
        // .to(prescription.getReadyfillDueSsChange())
        // .set("ss_enrollment_ind")
        // .to(prescription.getSsEnrollmentInd())
        // .set("rf_enrollment_credentials")
        // .to(prescription.getRfEnrollmentCredentials())
        .set("patient_id")
        .to(prescription.getPatientId());
    // .set("prescriber_id")
    // .to(prescription.getPrescriberId())
    // .set("prescription_date_written")
    // .to(convertTimestamp(prescription.getPrescriptionDateWritten()))
    // .set("prescription_expiration_date")
    // .to(convertTimestamp(prescription.getPrescriptionExpirationDate()))
    // .set("product_num")
    // .to(prescription.getProductNum())
    // .set("rx_number")
    // .to(prescription.getRxNumber())
    // .set("sig")
    // .to(prescription.getSig())
    // .set("is_compound")
    // .to(prescription.getIsCompound())
    // .set("ndc_prescribed_drug")
    // .to(prescription.getNdcPrescribedDrug())
    // .set("rx_state")
    // .to(prescription.getRxState())
    // .set("prescribed_quantity")
    // .to(prescription.getPrescribedQuantity())
    // .set("refill_quantity")
    // .to(prescription.getRefillQuantity())
    // .set("prescribed_number_of_refills")
    // .to(prescription.getPrescribedNumberOfRefills())
    // .set("refills_remaining")
    // .to(prescription.getRefillsRemaining())
    // .set("quantity_remaining")
    // .to(prescription.getQuantityRemaining())
    // .set("number_of_labels_to_print")
    // .to(prescription.getNumberOfLabelsToPrint())
    // .set("print_drug_name_on_label")
    // .to(prescription.getPrintDrugNameOnLabel())
    // .set("facility_num")
    // .to(prescription.getFacilityNum())
    // .set("facility_id")
    // .to(prescription.getFacilityId())
    // .set("expanded_sig")
    // .to(prescription.getExpandedSig())
    // .set("linkage_type_cd")
    // .to(prescription.getLinkageTypeCd())
    // .set("linked_to_rx_number")
    // .to(prescription.getLinkedToRxNumber())
    // .set("generated_to_rx_number")
    // .to(prescription.getGeneratedToRxNumber())
    // .set("transfer_in_original_rx_number")
    // .to(prescription.getTransferInOriginalRxNumber())
    // .set("transferred_ind")
    // .to(prescription.getTransferredInd())
    // .set("transfer_in_indicator")
    // .to(prescription.getTransferInIndicator())
    // .set("transfer_in_type")
    // .to(prescription.getTransferInType())
    // .set("transfer_in_facility_number")
    // .to(prescription.getTransferInFacilityNumber())
    // .set("transfer_in_facility_name")
    // .to(prescription.getTransferInFacilityName())
    // .set("transfer_in_facility_addline1")
    // .to(prescription.getTransferInFacilityAddline1())
    // .set("transfer_in_facility_addline2")
    // .to(prescription.getTransferInFacilityAddline2())
    // .set("transfer_in_facility_city")
    // .to(prescription.getTransferInFacilityCity())
    // .set("transfer_in_facility_state")
    // .to(prescription.getTransferInFacilityState())
    // .set("transfer_in_facility_zip")
    // .to(prescription.getTransferInFacilityZip())
    // .set("transfer_in_facility_nabp_num")
    // .to(prescription.getTransferInFacilityNabpNum())
    // .set("transfer_in_facility_dea_num")
    // .to(prescription.getTransferInFacilityDeaNum())
    // .set("transfer_in_facility_ph_num")
    // .to(prescription.getTransferInFacilityPhNum())
    // .set("transfer_in_pharmacist_name")
    // .to(prescription.getTransferInPharmacistName())
    // .set("transfer_in_rph_license_num")
    // .to(prescription.getTransferInRphLicenseNum())
    // .set("transfer_in_date")
    // .to(convertTimestamp(prescription.getTransferInDate()))
    // .set("transfer_out_new_rx_number")
    // .to(prescription.getTransferOutNewRxNumber())
    // .set("transfer_out_indicator")
    // .to(prescription.getTransferOutIndicator())
    // .set("transfer_out_type")
    // .to(prescription.getTransferOutType())
    // .set("transfer_out_facility_number")
    // .to(prescription.getTransferOutFacilityNumber())
    // .set("transfer_out_facility_name")
    // .to(prescription.getTransferOutFacilityName())
    // .set("transfer_out_facility_addline1")
    // .to(prescription.getTransferOutFacilityAddline1())
    // .set("transfer_out_facility_addline2")
    // .to(prescription.getTransferOutFacilityAddline2())
    // .set("transfer_out_facility_city")
    // .to(prescription.getTransferOutFacilityCity())
    // .set("transfer_out_facility_state")
    // .to(prescription.getTransferOutFacilityState())
    // .set("transfer_out_facility_zip")
    // .to(prescription.getTransferOutFacilityZip())
    // .set("transfer_out_facility_nabp_num")
    // .to(prescription.getTransferOutFacilityNabpNum())
    // .set("transfer_out_facility_dea_num")
    // .to(prescription.getTransferOutFacilityDeaNum())
    // .set("transfer_out_facility_ph_num")
    // .to(prescription.getTransferOutFacilityPhNum())
    // .set("transfer_out_pharmacist_name")
    // .to(prescription.getTransferOutPharmacistName())
    // .set("transfer_out_rph_license_num")
    // .to(prescription.getTransferOutRphLicenseNum())
    // .set("transfer_out_date")
    // .to(convertTimestamp(prescription.getTransferOutDate()))
    // .set("transfer_out_fax_date")
    // .to(convertTimestamp(prescription.getTransferOutFaxDate()))
    // .set("prescriber_address_id")
    // .to(prescription.getPrescriberAddressId())
    // .set("generated_from_rx_number")
    // .to(prescription.getGeneratedFromRxNumber())
    // .set("is_dirty")
    // .to(prescription.getIsDirty())
    // .set("is_current_version")
    // .to(prescription.getIsCurrentVersion())
    // .set("rx_version")
    // .to(prescription.getRxVersion())
    // .set("lock_indicator")
    // .to(prescription.getLockIndicator())
    // .set("generated_from_file_buy_ind")
    // .to(prescription.getGeneratedFromFileBuyInd())
    // .set("drug_substituted_ind")
    // .to(prescription.getDrugSubstitutedInd())
    // .set("transferred_in_num_of_refill")
    // .to(prescription.getTransferredInNumOfRefill())
    // .set("transfer_in_facility_comp_code")
    // .to(prescription.getTransferInFacilityCompCode())
    // .set("transfer_in_facility_lic_no")
    // .to(prescription.getTransferInFacilityLicNo())
    // .set("rx_lastfill_date")
    // .to(convertTimestamp(prescription.getRxLastfillDate()))
    // .set("transfer_out_facility_com_code")
    // .to(prescription.getTransferOutFacilityComCode())
    // .set("transfer_out_facility_lic_no")
    // .to(prescription.getTransferOutFacilityLicNo())
    // .set("original_fill_date")
    // .to(convertTimestamp(prescription.getOriginalFillDate()))
    // .set("local_pres_date_written")
    // .to(convertTimestamp(prescription.getLocalPresDateWritten()))
    // .set("local_transfer_in_date")
    // .to(convertTimestamp(prescription.getLocalTransferInDate()))
    // .set("local_transfer_in_date_written")
    // .to(convertTimestamp(prescription.getLocalTransferInDateWritten()))
    // .set("local_transfer_out_date")
    // .to(convertTimestamp(prescription.getLocalTransferOutDate()))
    // .set("local_inactivate_date")
    // .to(convertTimestamp(prescription.getLocalInactivateDate()))
    // .set("supervising_prescriber_id")
    // .to(prescription.getSupervisingPrescriberId())
    // .set("acquired_rx_number")
    // .to(prescription.getAcquiredRxNumber())
    // .set("transferred_in_orig_fills")
    // .to(prescription.getTransferredInOrigFills())
    // .set("transferred_in_rx_date_written")
    // .to(convertTimestamp(prescription.getTransferredInRxDateWritten()))
    // .set("prescriber_order_number")
    // .to(prescription.getPrescriberOrderNumber())
    // .set("controlled_substance_id_qual")
    // .to(prescription.getControlledSubstanceIdQual())
    // .set("controlled_substance_id")
    // .to(prescription.getControlledSubstanceId())
    // .set("rx_serial_number")
    // .to(prescription.getRxSerialNumber())
    // .set("scheduled_fill_date")
    // .to(convertTimestamp(prescription.getScheduledFillDate()))
    // .set("scheduled_fill_reason")
    // .to(prescription.getScheduledFillReason());
  }
}
