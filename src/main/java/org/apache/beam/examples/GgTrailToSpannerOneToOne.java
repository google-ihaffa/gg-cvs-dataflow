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

import com.google.cloud.spanner.Mutation;
import org.apache.beam.DoFn.ConvertJsonToAvro;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.gcp.pubsub.PubsubIO;
import org.apache.beam.sdk.io.gcp.spanner.SpannerIO;
import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.GroupByKey;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.Reshuffle;
import org.apache.beam.sdk.transforms.Values;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
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
public class GgTrailToSpannerOneToOne {

  private static final Logger LOG = LoggerFactory.getLogger(GgTrailToSpannerOneToOne.class);

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
        "\t\n"
            + //
            "{\"table\":\"RXOWNER.RXP_PRESCRIPTION_FILL\",\"op_type\":\"U\",\"op_ts\":\"2024-09-24 17:04:54.648429\",\"current_ts\":\"2024-10-16 19:05:32.342003\",\"pos\":\"00000000000026300451\",\"FILE_SNO\":\"0000000000\",\"CSN\":\"14161995317885\",\"RECORD_TS\":\"2024-09-24 17:04:54.648429\",\"before\":{\"PRESCRIPTION_FILL_ID\":412372873046,\"PATIENT_ID\":8741637992,\"PRESCRIPTION_ID\":411238877760,\"CREATED_DATE\":\"2024-09-24 13:04:52\",\"CREATED_BY\":\"rac2rxthatl127v\",\"LAST_UPDATED_DATE\":\"2024-09-24 13:04:54\",\"LAST_UPDATED_BY\":\"rac2rxthatl127v\",\"LOCAL_DATE_OF_SERVICE\":null,\"LOCAL_DRUG_EXPIRATION_DATE\":null,\"LOCAL_PICKUP_DATE\":null,\"LOCAL_PROMISE_TIME\":null,\"PHARMACIST_LICENSE_NUMBER\":null,\"COMPLETIONFILL_DAYS_SUPPLY\":null,\"FILL_TAX_EXEMPT\":null,\"RTS_COUNT\":null,\"PICKUP_ID\":null,\"PICKUP_ID_QUAL\":null,\"RECON_QUEUE_INDICATOR\":null,\"TLOG_STATUS\":0,\"PRODUCT_NUM\":8279,\"FILL_NUMBER\":0,\"FILL_STATUS\":0,\"FILL_STATE\":1,\"FILL_TYPE\":1,\"IS_FILLABLE\":null,\"NDC_DISPENSED_DRUG\":\"00093310905\",\"DRUG_MANUFACTURER_NAME\":\"TEVA USA\",\"DRUG_EXPIRATION_DATE\":\"2025-09-24 12:00:00\",\"DISPENSED_QUANTITY\":21.000,\"NDC_LOCALLY_ADDED\":\"N\",\"PARTIAL_FILL_SEQUENCE_NUMBER\":-1,\"DAYS_SUPPLY\":7,\"FREQUENCY\":\"XXD\",\"TOTAL_DAILY_DOSE\":3.000,\"PROMISE_TIME\":\"2025-09-24 13:04:45\",\"DAW_CD\":0,\"FILL_VERSION\":1,\"NUMBER_OF_LABELS\":1,\"INACTIVATION_DATE\":null,\"INACTIVATION_REASON\":null,\"PACKSIZE\":500.00000000,\"NUMBER_IN_ORDER\":5,\"PATIENT_PAY_AMOUNT\":null,\"AUDIT_IND\":null,\"ACC_SCAN_STS_CODE\":null,\"FILL_SOURCE_CD\":4,\"ACTION_NOTE_IND\":\"Y\",\"PATIENT_COUNSEL_IND\":\"Y\",\"PATIENT_PAY_OVERRIDE_CODE\":null,\"PATIENT_COUNSELLING_CODE\":\"3\",\"PHAR_COUNSEL_IND\":null,\"PRINT_DRUG_NAME_ON_LABEL\":\"Y\",\"PICKUP_DATE\":null,\"DESTINATION\":1006,\"PROMISE_TIME_CODE\":2,\"PRICE_OVERRIDE_CODE\":null,\"TP_PATIENT_NUM_PRI\":5155433150,\"TP_PATIENT_NUM_SEC\":null,\"TP_PATIENT_NUM_TERT\":null,\"TP_PATIENT_NUM_QUAT\":null,\"FACILITY_ID\":\"02364\",\"RX_NUMBER\":\"21*****\",\"DUR_INTERVENTION_CODE\":null,\"ACTION_NOTE_REASON_CODE\":null,\"ACTION_NOTE_CONDITION_CODE\":null,\"ACTION_NOTE_MSG_CENTER_CODE\":null,\"INTENDED_DISPENSE_QTY\":21.000,\"INTENDED_DAYS_SUPPLY\":7.000,\"PAYMENT_TYPE\":2,\"DRUG_NAME\":\"AMOXICILLIN 500 MG CAPSULE\",\"DRUG_STRENGTH\":\"500 MG\",\"DOSAGE_FORM\":\"CAPSULE\",\"ORIGINAL_DRUG_MANUFACTURER\":\"TEVA USA\",\"IS_GENERIC\":\"Y\",\"IS_MULTISOURCE\":\"N\",\"IS_DOWNTIME_PRO_PRESCRIPTION\":null,\"COB_OVERRIDE_INDICATOR\":\"N\",\"CURRENT_VERSION\":null,\"LOCK_INDICATOR\":null,\"TRANSFER_OUT_INDICATOR\":null,\"TRANSFER_OUT_FACILITY_NUMBER\":null,\"TRANSFER_OUT_FACILITY_ADDLINE1\":null,\"TRANSFER_OUT_FACILITY_ADDLINE2\":null,\"TRANSFER_OUT_FACILITY_CITY\":null,\"TRANSFER_OUT_FACILITY_STATE\":null,\"TRANSFER_OUT_FACILITY_ZIP\":null,\"TRANSFER_OUT_FACILITY_DEA_NUM\":null,\"TRANSFER_OUT_FACILITY_NABP_NUM\":null,\"TRANSFER_OUT_FACILITY_PH_NUM\":null,\"TRANSFER_OUT_PHARMACIST_NAME\":null,\"TRANSFER_OUT_RPH_LICENSE_NUM\":null,\"TRANSFER_OUT_NEW_RXNUMBER\":null,\"TRANSFER_OUT_DATE\":null,\"TRANSFER_OUT_FAX_DATE\":null,\"TRANSFER_OUT_TYPE\":null,\"TRANSFER_OUT_FACILITY_NAME\":null,\"DRUG_SCHEDULE\":\"Legend Rx\",\"FILL_DATE\":\"2024-09-24 13:04:30\",\"DISPENSED_DATE\":null,\"VERIFYING_RPH\":null,\"VERIFYING_DATE\":null,\"COMP_FILL_PROMISE_TIME\":null,\"COMP_FILL_PROMISE_TIME_CODE\":null,\"IS_DIRTY\":\"N\",\"TP_PATIENT_NUM_PRI_CAL\":null,\"TP_PATIENT_NUM_SEC_CAL\":null,\"TP_PATIENT_NUM_TERT_CAL\":null,\"TP_PATIENT_NUM_QUAT_CAL\":null,\"COMMULATIVE_PARTIAL_QUANTITY\":0,\"TP_DT_PATIENT_PAY\":null,\"TP_DT_FILLSTATUS\":null,\"TRANSFER_OUT_FACILITY_COM_CODE\":null,\"OFFLINE_PATIENT_PAY_AMOUNT\":null,\"CTT_LEGACY_NUMBER\":null,\"SHARED_WORK_INDICATOR\":null,\"CF_STATUS_UPDATED_DATE\":null,\"CF_EXPECTED_DELIVERY_DATE\":null,\"JURISDICTION_ID\":null,\"RELATIONSHIP_CODE\":null,\"UPC_CODE\":null,\"POS_STATUS\":null,\"AUTOSUB_PRODUCTID\":null,\"CASH_AI_DAW_CD\":null,\"GEN_SUB_LIST_PERFORMED\":null,\"GEN_SUB_PERFORMED_CODE\":null,\"NTI_MESSAGE_PRINT_INDICATOR\":null,\"ACQUIRED_RX_NUMBER\":null,\"IS_PROCESSOR_FEE\":\"N\",\"IS_PATIENT_INFO\":\"N\",\"IS_DUR\":\"N\",\"IS_ELECTRONIC_CPN\":\"N\",\"IS_OTHERPAYERINFO\":\"N\",\"SUBOXONE_DEA\":null,\"NDC_SCANNED1\":null,\"NDC_SCANNED2\":null,\"COUPON_INELIGIBLE\":\"N\",\"PATIENT_ID_QUALIFIER_VALUE\":null,\"PATIENT_QUALIFIER_TYPE\":null,\"PATIENT_ID_JURISDICTION_CODE\":null,\"PATIENT_ID_EXP_DATE\":null,\"IS_PMP_TRANSACTION_REQUIRE\":null,\"PICKUP_PATIENT_ID_INDICATOR\":\"N:N\",\"IS_GCN_SRD\":null,\"RXC_FILL_SOLD_MARK_DATE\":null,\"PHONE_NOTIFICATION_IND\":null,\"IS_NOPP_PRINTED\":\"N\",\"TP_PATIENT_PRI_REJECT_CODE\":null,\"TP_PATIENT_SEC_REJECT_CODE\":null,\"TP_PATIENT_TERT_REJECT_CODE\":null,\"TP_PATIENT_QUAT_REJECT_CODE\":null,\"VERIFICATION_REJECT_CODE\":null,\"VERIFICATION_REJECT_COMMENT\":null,\"VERIFICATION_REJECT_DATE\":null,\"IS_EXPEDITED\":null,\"ACTION_NOTE_MSG_CENTER_CODE2\":null,\"ACTION_NOTE_MSG_CENTER_CODE3\":null,\"REJECT_COUNTER\":null,\"ACUTE_INDICATOR\":null,\"INDUCTION_TIME\":null,\"DATA_ENTRY_STARTED\":null,\"VERIFY_READY_STARTED\":null,\"IS_RTS\":\"N\",\"SMS_NOTIFICATION_IND\":0,\"TP_PATIENT_PRI_APPROVE_CODE\":null,\"TP_PATIENT_SEC_APPROVE_CODE\":null,\"TP_PATIENT_TERT_APPROVE_CODE\":null,\"TP_PATIENT_QUAT_APPROVE_CODE\":null,\"IS_MED_B_FORM\":\"N\",\"SCANNED_PACKAGE_COUNT\":null,\"RTS_DATE\":null,\"IS_RTS_AVAILABLE\":null,\"ISP_FILL_CODE\":null,\"NEEDS_BY_DATE\":null,\"ISP_PROCESS_TYPE\":null,\"SHIPPING_STATUS\":null,\"ISP_TRACKER_CODE\":null,\"AUTHORIZATION_NUMBER\":null,\"DNDA_DATE\":null,\"REMS_PATIENT_ID\":null,\"RESIDENT_STATE_CODE\":null,\"NON_RESIDENT_STATE_CODE\":null,\"PICKUP_FIRST_NAME\":null,\"PICKUP_LAST_NAME\":null,\"PICKUP_STREET_ADDRESS\":null,\"PICKUP_CITY\":null,\"PICKUP_STATE\":null,\"PICKUP_ZIPCODE\":null,\"PICKUP_DATE_OF_BIRTH\":null,\"PATIENT_FIRST_NAME\":null,\"PATIENT_LAST_NAME\":null,\"RESI_CONFIRMATION_CODE\":null,\"NONRESI_CONFIRMATION_CODE\":null,\"NUMBER_OF_DAYS_EARLY\":0,\"MEDGUIDE_BARCODE_SCAN\":null,\"IMMUNIZATION_ADMIN_TYPE\":0,\"SPOKE_TO\":null,\"ACTION_PERFORMED\":null,\"INTERVENTION_DUR_COMMENTS\":null,\"PRODUCT_CHARACTERISTICS_NUM\":null,\"PRESCRIBER_CONSULT_RESOLUTION\":null,\"PROMPT_INDICATOR\":null,\"APPLICATION_VERSION\":null,\"PATIENT_ENROLLMENT_ID\":null,\"BASKET_SEQ_NUMBER\":null,\"IS_ALLIGNMENT_FILL\":null,\"FILL_SUB_STATUS\":0,\"ACTION_TIME\":null,\"UOU_CHECK_OUTCOME\":null,\"CF_STATUS_INDICATOR\":null},\"after\":{\"PRESCRIPTION_FILL_ID\":412372873046,\"PRESCRIPTION_ID\":411238877760,\"LAST_UPDATED_DATE\":\"2024-09-24 13:04:54\",\"LAST_UPDATED_BY\":\"rac2rxthatl127v\",\"PATIENT_COUNSEL_IND\":\"N\",\"PATIENT_COUNSELLING_CODE\":\"7\"}}";
    Pipeline p = Pipeline.create(options);

    PCollection<KV<Long, Mutation>> pColl =
        p.apply(
                "Read JSON pubsub",
                PubsubIO.readStrings().fromSubscription(options.getSubscriptionsName()))
            // p.apply(Create.of(mockJson))
            .apply("Convert JSON to KV pairs", ParDo.of(new ConvertJsonToAvro()));
    // .withOutputTags(
    //     ConvertJsonToAvro.main,
    //     TupleTagList.of(ConvertJsonToAvro.splitPrescriptionTupleTag)));

    // pTuple
    //     .get(ConvertJsonToAvro.main)

    // pColl.apply("Group By Prescription ID", GroupByKey.create())
    // .apply(null);


    pColl
        .apply(Reshuffle.of())
        .apply("Get Mutation From keys", Values.create())
        .apply(
            SpannerIO.write()
                .withProjectId("ggspandf")
                .withInstanceId("spanner1")
                .withDatabaseId("rxc"));
    // .withFailureMode(SpannerIO.FailureMode.REPORT_FAILURES));

    // pTuple
    //     .get(ConvertJsonToAvro.splitPrescriptionTupleTag)
    //     .apply(Reshuffle.of())
    //     .apply(Values.create())
    //     .apply(
    //         SpannerIO.write()
    //             .withProjectId("ggspandf")
    //             .withInstanceId("spanner1")
    //             .withDatabaseId("rxc"));

    p.run();
  }

  public static void main(String[] args) {
    WordCountOptions options =
        PipelineOptionsFactory.fromArgs(args).withValidation().as(WordCountOptions.class);

    runWordCount(options);
  }
}
