/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.beam.examples;

import org.apache.beam.DoFn.JsonToMutation;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.gcp.pubsub.PubsubIO;
import org.apache.beam.sdk.io.gcp.spanner.SpannerIO;
import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollectionTuple;
import org.apache.beam.sdk.values.TupleTagList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An example that counts words in Shakespeare and includes Beam best practices.
 *
 * <p>This class, {@link GgTrailToSpanner}, is the second in a series of four successively more
 * detailed 'word count' examples. You may first want to take a look at {@link MinimalWordCount}.
 * After you've looked at this example, then see the {@link DebuggingWordCount} pipeline, for
 * introduction of additional concepts.
 *
 * <p>For a detailed walkthrough of this example, see <a
 * href="https://beam.apache.org/get-started/wordcount-example/">
 * https://beam.apache.org/get-started/wordcount-example/ </a>
 *
 * <p>Basic concepts, also in the MinimalWordCount example: Reading text files; counting a
 * PCollection; writing to text files
 *
 * <p>New Concepts:
 *
 * <pre>
 *   1. Executing a Pipeline both locally and using the selected runner
 *   2. Using ParDo with static DoFns defined out-of-line
 *   3. Building a composite transform
 *   4. Defining your own pipeline options
 * </pre>
 *
 * <p>Concept #1: you can execute this pipeline either locally or using by selecting another runner.
 * These are now command-line options and not hard-coded as they were in the MinimalWordCount
 * example.
 *
 * <p>To change the runner, specify:
 *
 * <pre>{@code
 * --runner=YOUR_SELECTED_RUNNER
 * }</pre>
 *
 * <p>To execute this pipeline, specify a local output file (if using the {@code DirectRunner}) or
 * output prefix on a supported distributed file system.
 *
 * <pre>{@code
 * --output=[YOUR_LOCAL_FILE | YOUR_OUTPUT_PREFIX]
 * }</pre>
 *
 * <p>The input file defaults to a public data set containing the text of King Lear, by William
 * Shakespeare. You can override it and choose your own input with {@code --inputFile}.
 */
public class GgTrailToSpanner {

  private static final Logger LOG = LoggerFactory.getLogger(GgTrailToSpanner.class);

  /**
   * Options supported by {@link GgTrailToSpanner}.
   *
   * <p>Concept #4: Defining your own configuration options. Here, you can add your own arguments to
   * be processed by the command-line parser, and specify default values for them. You can then
   * access the options values in your pipeline code.
   *
   * <p>Inherits standard configuration options.
   */
  // [START wordcount_options]
  public interface WordCountOptions extends PipelineOptions {

    /**
     * By default, this example reads from a public dataset containing the text of King Lear. Set
     * this option to choose a different input file or glob.
     */
    @Description(
        "name path of subsribtion /project/{projectname}/subscriptions/{subscriptionsname}")
    @Default.String("projects/ggspandf/subscriptions/mytopicjson-sub")
    String getSubscriptionsName();

    void setSubscriptionsName(String value);
  }

  // [END wordcount_options]

  static void runWordCount(WordCountOptions options) {
    String mockJson =
        "{\"table\":\"RXOWNER.RXP_PRESCRIPTION\",\"op_type\":\"U\",\"op_ts\":\"2024-09-24 17:04:49.448121\",\"current_ts\":\"2024-10-16 22:04:33.689002\",\"pos\":\"00000000000010164161\",\"FILE_SNO\":\"0000000000\",\"CSN\":\"14161995276876\",\"RECORD_TS\":\"2024-09-24 17:04:49.448121\",\"before\":{\"PRESCRIPTION_ID\":707407153166,\"ACQUIRED_ID\":null,\"ORGANIZATION_ID\":null,\"PATIENT_ADDRESS_ID\":674669279,\"FACILITY_NUM\":12835,\"PRESCRIBER_ID\":34268573,\"PATIENT_ID\":1248593598,\"CREATED_DATE\":\"2022-04-28 09:16:37\",\"CREATED_BY\":\"wks04\",\"LAST_UPDATED_DATE\":\"2024-09-24 13:04:49\",\"LAST_UPDATED_BY\":\"rac2rxthatl125v\",\"PRODUCT_NUM\":4181134,\"IMAGE_NUM\":null,\"RX_NUMBER\":\"14*****\",\"RX_TYPE\":1,\"SIG\":\"PHARMACY ADMINISTERED\",\"IS_COMPOUND\":\"N\",\"NDC_PRESCRIBED_DRUG\":\"59267102504\",\"RX_STATE\":1,\"INACTIVATE_DATE\":null,\"INACTIVATION_REASON\":null,\"PRESCRIPTION_DATE_WRITTEN\":\"2022-04-28 12:00:00\",\"PRESCRIPTION_EXPIRATION_DATE\":\"2025-06-30 00:00:00\",\"PRN_INDICATOR\":\"N\",\"RENEW_REFILL_REQUEST_INDICATOR\":\"N\",\"ACQUIRED_INDICATOR\":\"N\",\"READY_FILL_ENROLLMENT_CD\":\"X\",\"CURRENT_FILL_NUMBER\":0,\"PRESCRIBED_QUANTITY\":0.300,\"REFILL_QUANTITY\":0,\"PRESCRIBED_NUMBER_OF_REFILLS\":70,\"REFILLS_REMAINING\":70,\"QUANTITY_REMAINING\":21.000,\"NUMBER_OF_LABELS_TO_PRINT\":1,\"PRINT_DRUG_NAME_ON_LABEL\":\"Y\",\"ORIGINAL_PRESCRIBER_ID\":null,\"FACILITY_ID\":\"06379\",\"EXPANDED_SIG\":\"PHARMACY ADMINISTERED\",\"LINKAGE_TYPE_CD\":null,\"LINKED_TO_RX_NUMBER\":null,\"GENERATED_TO_RX_NUMBER\":null,\"TRANSFER_IN_ORIGINAL_RX_NUMBER\":null,\"TRANSFERRED_IND\":null,\"TRANSFER_IN_INDICATOR\":null,\"TRANSFER_IN_TYPE\":null,\"TRANSFER_IN_FACILITY_NUMBER\":null,\"TRANSFER_IN_FACILITY_NAME\":null,\"TRANSFER_IN_FACILITY_ADDLINE1\":null,\"TRANSFER_IN_FACILITY_ADDLINE2\":null,\"TRANSFER_IN_FACILITY_CITY\":null,\"TRANSFER_IN_FACILITY_STATE\":null,\"TRANSFER_IN_FACILITY_ZIP\":null,\"TRANSFER_IN_FACILITY_NABP_NUM\":null,\"TRANSFER_IN_FACILITY_DEA_NUM\":null,\"TRANSFER_IN_FACILITY_PH_NUM\":null,\"TRANSFER_IN_PHARMACIST_NAME\":null,\"TRANSFER_IN_RPH_LICENSE_NUM\":null,\"TRANSFER_IN_DATE\":null,\"TRANSFER_OUT_NEW_RX_NUMBER\":null,\"TRANSFER_OUT_INDICATOR\":null,\"TRANSFER_OUT_TYPE\":null,\"TRANSFER_OUT_FACILITY_NUMBER\":null,\"TRANSFER_OUT_FACILITY_NAME\":null,\"TRANSFER_OUT_FACILITY_ADDLINE1\":null,\"TRANSFER_OUT_FACILITY_ADDLINE2\":null,\"TRANSFER_OUT_FACILITY_CITY\":null,\"TRANSFER_OUT_FACILITY_STATE\":null,\"TRANSFER_OUT_FACILITY_ZIP\":null,\"TRANSFER_OUT_FACILITY_NABP_NUM\":null,\"TRANSFER_OUT_FACILITY_DEA_NUM\":null,\"TRANSFER_OUT_FACILITY_PH_NUM\":null,\"TRANSFER_OUT_PHARMACIST_NAME\":null,\"TRANSFER_OUT_RPH_LICENSE_NUM\":null,\"TRANSFER_OUT_DATE\":null,\"TRANSFER_OUT_FAX_DATE\":null,\"PRESCRIBER_ADDRESS_ID\":266718840,\"GENERATED_FROM_RX_NUMBER\":null,\"IS_DIRTY\":\"N\",\"IS_CURRENT_VERSION\":null,\"RX_VERSION\":1,\"LOCK_INDICATOR\":null,\"GENERATED_FROM_FILE_BUY_IND\":\"0\",\"DRUG_SUBSTITUTED_IND\":null,\"TRANSFERRED_IN_NUM_OF_REFILL\":null,\"TRANSFER_IN_FACILITY_COMP_CODE\":null,\"TRANSFER_IN_FACILITY_LIC_NO\":null,\"RX_LASTFILL_DATE\":\"2022-04-28 09:15:33\",\"TRANSFER_OUT_FACILITY_COM_CODE\":null,\"TRANSFER_OUT_FACILITY_LIC_NO\":null,\"ORIGINAL_FILL_DATE\":\"2022-04-28 09:15:33\",\"LOCAL_PRES_DATE_WRITTEN\":null,\"LOCAL_TRANSFER_IN_DATE\":null,\"LOCAL_TRANSFER_IN_DATE_WRITTEN\":null,\"LOCAL_TRANSFER_OUT_DATE\":null,\"LOCAL_INACTIVATE_DATE\":null,\"SUPERVISING_PRESCRIBER_ID\":null,\"ACQUIRED_RX_NUMBER\":null,\"TRANSFERRED_IN_ORIG_FILLS\":null,\"TRANSFERRED_IN_RX_DATE_WRITTEN\":null,\"PRESCRIBER_ORDER_NUMBER\":null,\"CONTROLLED_SUBSTANCE_ID_QUAL\":null,\"CONTROLLED_SUBSTANCE_ID\":null,\"RX_SERIAL_NUMBER\":null,\"READY_FILL_ENROLLMENT_DATE\":\"2024-09-23 23:44:04\",\"SCHEDULED_FILL_DATE\":null,\"SCHEDULED_FILL_REASON\":null,\"CREDENTIAL_COUNT\":0,\"GEN_SUB_PERFORMED_CODE\":1,\"DPS_NUMBER\":null,\"DIAGNOSIS_CODE\":null,\"PROCEDURE_MODIFIER_CODE\":null,\"SRD_STATE\":null,\"RX_ORIGIN_CODE\":\"5\",\"MAX_DAILY_DOSE_VALUE\":null,\"MAX_DAILY_DOSE_DOSAGE_UNIT\":null,\"LINKED_FROM_RX_NUMBER\":null,\"INACTIVATION_CODE\":null,\"PATIENT_WEIGHT_KG\":null,\"PAT_WEIGHT_CAPTURED_DATE\":null,\"DRUG_SEARCH_INDICATORS\":null,\"DO_NOT_FILL_BEFORE_DATE\":null,\"IS_CONTROLLED_SUBSTANCE\":null,\"CALCULATED_REFILLS_REMAINING\":null,\"TRANSFER_IN_CVS_PHARM_NAME\":null,\"IS_EPCS_RX\":\"N\",\"SUPERVISING_PRES_ADDRESS_ID\":null,\"WEB_RF_ENROLLMENT_UPDATED_VIA\":1,\"CVS_CUSTOMER_ID\":\"667328814\",\"SIG_CODE_ORIGIN\":2,\"LOCATION\":null,\"ISSUE_CONTACT_NUMBER\":null,\"IS_SIG_AVAILABLE\":null,\"IS_QUANTITY_AVAILABLE\":null,\"IS_DIAGNOSIS_CODE_AVAILABLE\":null,\"IS_DAW_AVAILABLE\":null,\"IS_HARD_COPY_CHECK_PERFORMED\":null,\"ISP_INDICATOR\":\"N\",\"ISP_RX_PARTICIPATES_IND\":null,\"ISP_METHOD_OF_TRANSITION\":0,\"ISP_TRANSITION_DATE\":null,\"ISP_FILL_CODE\":null,\"ISP_TRACKER_CODE\":null,\"ENROLLMENT_DECLINE_COUNT\":null,\"PATIENT_CONTROL_GROUP\":null,\"LINKAGE_METHOD\":null,\"RF_ENROLLMENT_CREDENTIALS\":\"MWHIT\",\"READY_FILL_EMPLOYEE_ID\":null,\"READY_FILL_ENROLLMENT_REASON\":null,\"RF_PATIENT_CONF_ATTEMPT_NO\":null,\"RF_PATIENT_CONF_RESPONSE\":null,\"RF_PATIENT_CONF_TIMESTAMP\":null,\"PPI_MESSAGE_ID\":null,\"PRESCRIBER_ORDER_NUM\":null,\"DRUG_DB_CODE\":null,\"DRUG_DB_CODE_QUALIFIER\":null,\"LINK_DATE\":null,\"RX_SUB_TYPE\":null,\"RX_REASSIGN_INDICATOR\":null,\"SS_ENROLLMENT_IND\":null,\"READYFILL_DUE_SS_CHANGE\":\"Y\",\"POS_RF_ENROLL_UNENROLLMENT_IND\":null,\"SS_INELIGIBILITY_REASON\":4,\"PROACTIVE_PROG_OUTCOME\":0,\"ASSOCIATED_FROM_RX_NUMBER\":null,\"IS_PRESCRIBER_NPI_AVAILABLE\":null,\"PROACTIVE_DISPOSITION_DATE\":null,\"EXTENDED_SIG\":null,\"EXPANDED_EXTENDED_SIG\":null,\"HC_RESCAN_FLAG\":\"N\",\"PROHIBITED_IND\":\"N\"},\"after\":{\"PRESCRIPTION_ID\":707407153166,\"LAST_UPDATED_DATE\":\"2024-09-24 13:04:49\",\"LAST_UPDATED_BY\":\"rac2rxthatl125v\",\"READY_FILL_ENROLLMENT_CD\":\"X\",\"READY_FILL_ENROLLMENT_DATE\":\"2024-09-24 13:04:49\",\"SCHEDULED_FILL_DATE\":null,\"SCHEDULED_FILL_REASON\":null,\"WEB_RF_ENROLLMENT_UPDATED_VIA\":1,\"RF_ENROLLMENT_CREDENTIALS\":\"MWHIT\",\"READY_FILL_EMPLOYEE_ID\":null,\"READY_FILL_ENROLLMENT_REASON\":null,\"RF_PATIENT_CONF_ATTEMPT_NO\":null,\"RF_PATIENT_CONF_RESPONSE\":null,\"SS_ENROLLMENT_IND\":\"I\",\"READYFILL_DUE_SS_CHANGE\":\"Y\",\"HC_RESCAN_FLAG\":\"N\",\"PROHIBITED_IND\":\"N\"}}";
    Pipeline p = Pipeline.create(options);

    PCollectionTuple pTuple =
        p.apply(
                "Read JSON pubsub",
                PubsubIO.readStrings().fromSubscription(options.getSubscriptionsName()))
            // p.apply(Create.of(mockJson))
            .apply(
                "Convert JSON object",
                ParDo.of(new JsonToMutation())
                    .withOutputTags(
                        JsonToMutation.main,
                        TupleTagList.of(JsonToMutation.splitPrescriptionTupleTag)));

    pTuple
        .get(JsonToMutation.main)
        .apply(
            SpannerIO.write()
                .withProjectId("ggspandf")
                .withInstanceId("spanner1")
                .withDatabaseId("rxc"));

    pTuple
        .get(JsonToMutation.splitPrescriptionTupleTag)
        .apply(
            SpannerIO.write()
                .withProjectId("ggspandf")
                .withInstanceId("spanner1")
                .withDatabaseId("rxc"));

    p.run();
  }

  public static void main(String[] args) {
    WordCountOptions options =
        PipelineOptionsFactory.fromArgs(args).withValidation().as(WordCountOptions.class);

    runWordCount(options);
  }
}
