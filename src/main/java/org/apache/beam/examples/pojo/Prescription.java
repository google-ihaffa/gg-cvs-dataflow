package org.apache.beam.examples.pojo;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Date;

public class Prescription implements Serializable {

  @SerializedName("PRESCRIPTION_ID")
  private Long prescriptionId;

  @SerializedName("ACQUIRED_ID")
  private Long acquiredId;

  @SerializedName("ORGANIZATION_ID")
  private Long organizationId;

  @SerializedName("PATIENT_ADDRESS_ID")
  private Long patientAddressId;

  @SerializedName("FACILITY_NUM")
  private Long facilityNum;

  @SerializedName("PRESCRIBER_ID")
  private Long prescriberId;

  @SerializedName("PATIENT_ID")
  private Long patientId;

  @SerializedName("CREATED_DATE")
  private Date createdDate;

  @SerializedName("CREATED_BY")
  private String createdBy;

  @SerializedName("LAST_UPDATED_DATE")
  private Date lastUpdatedDate;

  // work until here

  @SerializedName("LAST_UPDATED_BY")
  private String lastUpdatedBy;

  @SerializedName("PRODUCT_NUM")
  private Long productNum;

  @SerializedName("IMAGE_NUM")
  private Long imageNum;

  @SerializedName("RX_NUMBER")
  private String rxNumber;

  @SerializedName("RX_TYPE")
  private Long rxType;

  @SerializedName("SIG")
  private String sig;

  @SerializedName("IS_COMPOUND")
  private String isCompound;

  @SerializedName("NDC_PRESCRIBED_DRUG")
  private String ndcPrescribedDrug;

  @SerializedName("RX_STATE")
  private Long rxState;

  @SerializedName("INACTIVATE_DATE")
  private Date inactivateDate;

  @SerializedName("INACTIVATION_REASON")
  private String inactivationReason;

  @SerializedName("PRESCRIPTION_DATE_WRITTEN")
  private Date prescriptionDateWritten;

  @SerializedName("PRESCRIPTION_EXPIRATION_DATE")
  private Date prescriptionExpirationDate;

  @SerializedName("PRN_INDICATOR")
  private String prnIndicator;

  @SerializedName("RENEW_REFILL_REQUEST_INDICATOR")
  private String renewRefillRequestIndicator;

  @SerializedName("ACQUIRED_INDICATOR")
  private String acquiredIndicator;

  @SerializedName("READY_FILL_ENROLLMENT_CD")
  private String readyFillEnrollmentCd;

  @SerializedName("CURRENT_FILL_NUMBER")
  private Long currentFillNumber;

  @SerializedName("PRESCRIBED_QUANTITY")
  private Double prescribedQuantity;

  @SerializedName("REFILL_QUANTITY")
  private Double refillQuantity;

  @SerializedName("PRESCRIBED_NUMBER_OF_REFILLS")
  private Long prescribedNumberOfRefills;

  @SerializedName("REFILLS_REMAINING")
  private Long refillsRemaining;

  @SerializedName("QUANTITY_REMAINING")
  private Double quantityRemaining;

  @SerializedName("NUMBER_OF_LABELS_TO_PRINT")
  private Long numberOfLabelsToPrint;

  @SerializedName("PRINT_DRUG_NAME_ON_LABEL")
  private String printDrugNameOnLabel;

  @SerializedName("ORIGINAL_PRESCRIBER_ID")
  private Long originalPrescriberId;

  @SerializedName("FACILITY_ID")
  private String facilityId;

  @SerializedName("EXPANDED_SIG")
  private String expandedSig;

  @SerializedName("LINKAGE_TYPE_CD")
  private String linkageTypeCd;

  @SerializedName("LINKED_TO_RX_NUMBER")
  private String linkedToRxNumber;

  @SerializedName("GENERATED_TO_RX_NUMBER")
  private String generatedToRxNumber;

  @SerializedName("TRANSFER_IN_ORIGINAL_RX_NUMBER")
  private String transferInOriginalRxNumber;

  @SerializedName("TRANSFERRED_IND")
  private String transferredInd;

  @SerializedName("TRANSFER_IN_INDICATOR")
  private String transferInIndicator;

  @SerializedName("TRANSFER_IN_TYPE")
  private String transferInType;

  @SerializedName("TRANSFER_IN_FACILITY_NAME")
  private String transferInFacilityName;

  @SerializedName("TRANSFER_IN_FACILITY_NUMBER")
  private String transferInFacilityNumber;

  @SerializedName("TRANSFER_IN_FACILITY_ADDLINE1")
  private String transferInFacilityAddline1;

  @SerializedName("TRANSFER_IN_FACILITY_ADDLINE2")
  private String transferInFacilityAddline2;

  @SerializedName("TRANSFER_IN_FACILITY_CITY")
  private String transferInFacilityCity;

  @SerializedName("TRANSFER_IN_FACILITY_STATE")
  private String transferInFacilityState;

  @SerializedName("TRANSFER_IN_FACILITY_ZIP")
  private String transferInFacilityZip;

  @SerializedName("TRANSFER_IN_FACILITY_NABP_NUM")
  private String transferInFacilityNabpNum;

  @SerializedName("TRANSFER_IN_FACILITY_DEA_NUM")
  private String transferInFacilityDeaNum;

  @SerializedName("TRANSFER_IN_FACILITY_PH_NUM")
  private String transferInFacilityPhNum;

  @SerializedName("TRANSFER_IN_PHARMACIST_NAME")
  private String transferInPharmacistName;

  @SerializedName("TRANSFER_IN_RPH_LICENSE_NUM")
  private String transferInRphLicenseNum;

  @SerializedName("TRANSFER_OUT_NEW_RX_NUMBER")
  private String transferOutNewRxNumber;

  @SerializedName("TRANSFER_OUT_INDICATOR")
  private String transferOutIndicator;

  @SerializedName("TRANSFER_OUT_TYPE")
  private String transferOutType;

  // Last was here
  @SerializedName("TRANSFER_OUT_FACILITY_NUMBER")
  private String transferOutFacilityNumber;

  @SerializedName("TRANSFER_OUT_FACILITY_NAME")
  private String transferOutFacilityName;

  @SerializedName("TRANSFER_OUT_FACILITY_ADDLINE1")
  private String transferOutFacilityAddline1;

  @SerializedName("TRANSFER_OUT_FACILITY_ADDLINE2")
  private String transferOutFacilityAddline2;

  @SerializedName("TRANSFER_OUT_FACILITY_CITY")
  private String transferOutFacilityCity;

  @SerializedName("TRANSFER_OUT_FACILITY_STATE")
  private String transferOutFacilityState;

  @SerializedName("TRANSFER_OUT_FACILITY_ZIP")
  private String transferOutFacilityZip;

  @SerializedName("TRANSFER_OUT_FACILITY_NABP_NUM")
  private String transferOutFacilityNabpNum;

  @SerializedName("TRANSFER_OUT_FACILITY_DEA_NUM")
  private String transferOutFacilityDeaNum;

  @SerializedName("TRANSFER_OUT_FACILITY_PH_NUM")
  private String transferOutFacilityPhNum;

  @SerializedName("TRANSFER_OUT_PHARMACIST_NAME")
  private String transferOutPharmacistName;

  @SerializedName("TRANSFER_OUT_RPH_LICENSE_NUM")
  private String transferOutRphLicenseNum;

  @SerializedName("TRANSFER_IN_DATE")
  private Date transferInDate;

  @SerializedName("TRANSFER_OUT_DATE")
  private Date transferOutDate;

  @SerializedName("TRANSFER_OUT_FAX_DATE")
  private Date transferOutFaxDate;

  @SerializedName("PRESCRIBER_ADDRESS_ID")
  private Long prescriberAddressId;

  @SerializedName("GENERATED_FROM_RX_NUMBER")
  private String generatedFromRxNumber;

  @SerializedName("IS_DIRTY")
  private String isDirty;

  @SerializedName("IS_CURRENT_VERSION")
  private String isCurrentVersion;

  @SerializedName("RX_VERSION")
  private Long rxVersion;

  @SerializedName("LOCK_INDICATOR")
  private String lockIndicator;

  @SerializedName("GENERATED_FROM_FILE_BUY_IND")
  private String generatedFromFileBuyInd;

  @SerializedName("DRUG_SUBSTITUTED_IND")
  private String drugSubstitutedInd;

  @SerializedName("TRANSFERRED_IN_NUM_OF_REFILL")
  private String transferredInNumOfRefill;

  @SerializedName("TRANSFER_IN_FACILITY_COMP_CODE")
  private String transferInFacilityCompCode;

  @SerializedName("TRANSFER_IN_FACILITY_LIC_NO")
  private String transferInFacilityLicNo;

  @SerializedName("RX_LASTFILL_DATE")
  private Date rxLastfillDate;

  @SerializedName("TRANSFER_OUT_FACILITY_COM_CODE")
  private String transferOutFacilityComCode;

  @SerializedName("TRANSFER_OUT_FACILITY_LIC_NO")
  private String transferOutFacilityLicNo;

  @SerializedName("ORIGINAL_FILL_DATE")
  private Date originalFillDate;

  @SerializedName("LOCAL_PRES_DATE_WRITTEN")
  private Date localPresDateWritten;

  @SerializedName("LOCAL_TRANSFER_IN_DATE")
  private Date localTransferInDate;

  @SerializedName("LOCAL_TRANSFER_IN_DATE_WRITTEN")
  private Date localTransferInDateWritten;

  @SerializedName("LOCAL_TRANSFER_OUT_DATE")
  private Date localTransferOutDate;

  @SerializedName("LOCAL_INACTIVATE_DATE")
  private Date localInactivateDate;

  @SerializedName("SUPERVISING_PRESCRIBER_ID")
  private Long supervisingPrescriberId;

  @SerializedName("ACQUIRED_RX_NUMBER")
  private String acquiredRxNumber;

  @SerializedName("TRANSFERRED_IN_ORIG_FILLS")
  private String transferredInOrigFills;

  @SerializedName("TRANSFERRED_IN_RX_DATE_WRITTEN")
  private Date transferredInRxDateWritten;

  @SerializedName("PRESCRIBER_ORDER_NUMBER")
  private String prescriberOrderNumber;

  @SerializedName("CONTROLLED_SUBSTANCE_ID_QUAL")
  private String controlledSubstanceIdQual;

  @SerializedName("CONTROLLED_SUBSTANCE_ID")
  private String controlledSubstanceId;

  @SerializedName("RX_SERIAL_NUMBER")
  private String rxSerialNumber;

  @SerializedName("READY_FILL_ENROLLMENT_DATE")
  private Date readyFillEnrollmentDate;

  @SerializedName("SCHEDULED_FILL_DATE")
  private Date scheduledFillDate;

  @SerializedName("SCHEDULED_FILL_REASON")
  private String scheduledFillReason;

  @SerializedName("CREDENTIAL_COUNT")
  private Long credentialCount;

  @SerializedName("GEN_SUB_PERFORMED_CODE")
  private Long genSubPerformedCode;

  @SerializedName("DPS_NUMBER")
  private String dpsNumber;

  @SerializedName("DIAGNOSIS_CODE")
  private String diagnosisCode;

  @SerializedName("PROCEDURE_MODIFIER_CODE")
  private String procedureModifierCode;

  @SerializedName("SRD_STATE")
  private String srdState;

  @SerializedName("RX_ORIGIN_CODE")
  private String rxOriginCode;

  @SerializedName("MAX_DAILY_DOSE_VALUE")
  private String maxDailyDoseValue;

  @SerializedName("MAX_DAILY_DOSE_DOSAGE_UNIT")
  private String maxDailyDoseDosageUnit;

  @SerializedName("LINKED_FROM_RX_NUMBER")
  private String linkedFromRxNumber;

  @SerializedName("INACTIVATION_CODE")
  private String inactivationCode;

  @SerializedName("PATIENT_WEIGHT_KG")
  private Double patientWeightKg;

  @SerializedName("PAT_WEIGHT_CAPTURED_DATE")
  private Date patWeightCapturedDate;

  @SerializedName("DRUG_SEARCH_INDICATORS")
  private Long drugSearchIndicators;

  @SerializedName("DO_NOT_FILL_BEFORE_DATE")
  private Date doNotFillBeforeDate;

  @SerializedName("IS_CONTROLLED_SUBSTANCE")
  private String isControlledSubstance;

  @SerializedName("CALCULATED_REFILLS_REMAINING")
  private String calculatedRefillsRemaining;

  @SerializedName("TRANSFER_IN_CVS_PHARM_NAME")
  private String transferInCvsPharmName;

  @SerializedName("IS_EPCS_RX")
  private String isEpcsRx;

  @SerializedName("SUPERVISING_PRES_ADDRESS_ID")
  private Long supervisingPresAddressId;

  @SerializedName("WEB_RF_ENROLLMENT_UPDATED_VIA")
  private Long webRfEnrollmentUpdatedVia;

  @SerializedName("CVS_CUSTOMER_ID")
  private String cvsCustomerId;

  @SerializedName("SIG_CODE_ORIGIN")
  private Long sigCodeOrigin;

  @SerializedName("LOCATION")
  private String location;

  @SerializedName("ISSUE_CONTACT_NUMBER")
  private String issueContactNumber;

  @SerializedName("IS_SIG_AVAILABLE")
  private String isSigAvailable;

  @SerializedName("IS_QUANTITY_AVAILABLE")
  private String isQuantityAvailable;

  @SerializedName("IS_DIAGNOSIS_CODE_AVAILABLE")
  private String isDiagnosisCodeAvailable;

  @SerializedName("IS_DAW_AVAILABLE")
  private String isDawAvailable;

  @SerializedName("IS_HARD_COPY_CHECK_PERFORMED")
  private String isHardCopyCheckPerformed;

  @SerializedName("ISP_INDICATOR")
  private String ispIndicator;

  @SerializedName("ISP_RX_PARTICIPATES_IND")
  private String ispRxParticipatesInd;

  @SerializedName("ISP_METHOD_OF_TRANSITION")
  private Long ispMethodOfTransition;

  @SerializedName("ISP_TRANSITION_DATE")
  private Date ispTransitionDate;

  @SerializedName("ISP_FILL_CODE")
  private String ispFillCode;

  @SerializedName("ISP_TRACKER_CODE")
  private String ispTrackerCode;

  @SerializedName("ENROLLMENT_DECLINE_COUNT")
  private String enrollmentDeclineCount;

  @SerializedName("PATIENT_CONTROL_GROUP")
  private String patientControlGroup;

  @SerializedName("LINKAGE_METHOD")
  private String linkageMethod;

  @SerializedName("RF_ENROLLMENT_CREDENTIALS")
  private String rfEnrollmentCredentials;

  @SerializedName("READY_FILL_EMPLOYEE_ID")
  private String readyFillEmployeeId;

  @SerializedName("READY_FILL_ENROLLMENT_REASON")
  private String readyFillEnrollmentReason;

  @SerializedName("RF_PATIENT_CONF_ATTEMPT_NO")
  private String rfPatientConfAttemptNo;

  @SerializedName("RF_PATIENT_CONF_RESPONSE")
  private String rfPatientConfResponse;

  @SerializedName("RF_PATIENT_CONF_TIMESTAMP")
  private String rfPatientConfTimestamp;

  @SerializedName("PPI_MESSAGE_ID")
  private Long ppiMessageId;

  @SerializedName("PRESCRIBER_ORDER_NUM")
  private String prescriberOrderNum;

  @SerializedName("DRUG_DB_CODE")
  private String drugDbCode;

  @SerializedName("DRUG_DB_CODE_QUALIFIER")
  private String drugDbCodeQualifier;

  @SerializedName("LINK_DATE")
  private Date linkDate;

  @SerializedName("RX_SUB_TYPE")
  private String rxSubType;

  @SerializedName("RX_REASSIGN_INDICATOR")
  private String rxReassignIndicator;

  @SerializedName("SS_ENROLLMENT_IND")
  private String ssEnrollmentInd;

  @SerializedName("READYFILL_DUE_SS_CHANGE")
  private String readyfillDueSsChange;

  @SerializedName("POS_RF_ENROLL_UNENROLLMENT_IND")
  private String posRfEnrollUnenrollmentInd;

  @SerializedName("SS_INELIGIBILITY_REASON")
  private String ssIneligibilityReason;

  @SerializedName("PROACTIVE_PROG_OUTCOME")
  private String proactiveProgOutcome;

  @SerializedName("ASSOCIATED_FROM_RX_NUMBER")
  private String associatedFromRxNumber;

  @SerializedName("IS_PRESCRIBER_NPI_AVAILABLE")
  private String isPrescriberNpiAvailable;

  @SerializedName("PROACTIVE_DISPOSITION_DATE")
  private Date proactiveDispositionDate;

  @SerializedName("EXTENDED_SIG")
  private String extendedSig;

  @SerializedName("EXPANDED_EXTENDED_SIG")
  private String expandedExtendedSig;

  @SerializedName("HC_RESCAN_FLAG")
  private String hcRescanFlag;

  @SerializedName("PROHIBITED_IND")
  private String prohibitedInd;

  public Long getPrescriptionId() {
    return this.prescriptionId;
  }

  public void setPrescriptionId(Long prescriptionId) {
    this.prescriptionId = prescriptionId;
  }

  public Long getAcquiredId() {
    return this.acquiredId;
  }

  public void setAcquiredId(Long acquiredId) {
    this.acquiredId = acquiredId;
  }

  public Long getOrganizationId() {
    return this.organizationId;
  }

  public void setOrganizationId(Long organizationId) {
    this.organizationId = organizationId;
  }

  public Long getPatientAddressId() {
    return this.patientAddressId;
  }

  public void setPatientAddressId(Long patientAddressId) {
    this.patientAddressId = patientAddressId;
  }

  public Long getFacilityNum() {
    return this.facilityNum;
  }

  public void setFacilityNum(Long facilityNum) {
    this.facilityNum = facilityNum;
  }

  public Long getPrescriberId() {
    return this.prescriberId;
  }

  public void setPrescriberId(Long prescriberId) {
    this.prescriberId = prescriberId;
  }

  public Long getPatientId() {
    return this.patientId;
  }

  public void setPatientId(Long patientId) {
    this.patientId = patientId;
  }

  public Date getTransferInDate() {
    return this.transferInDate;
  }

  public void setTransferInDate(Date transferInDate) {
    this.transferInDate = transferInDate;
  }

  public Date getCreatedDate() {
    return this.createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public String getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public Date getLastUpdatedDate() {
    return this.lastUpdatedDate;
  }

  public void setLastUpdatedDate(Date lastUpdatedDate) {
    this.lastUpdatedDate = lastUpdatedDate;
  }

  public String getLastUpdatedBy() {
    return this.lastUpdatedBy;
  }

  public void setLastUpdatedBy(String lastUpdatedBy) {
    this.lastUpdatedBy = lastUpdatedBy;
  }

  public Long getProductNum() {
    return this.productNum;
  }

  public void setProductNum(Long productNum) {
    this.productNum = productNum;
  }

  public Long getImageNum() {
    return this.imageNum;
  }

  public void setImageNum(Long imageNum) {
    this.imageNum = imageNum;
  }

  public String getRxNumber() {
    return this.rxNumber;
  }

  public void setRxNumber(String rxNumber) {
    this.rxNumber = rxNumber;
  }

  public Long getRxType() {
    return this.rxType;
  }

  public void setRxType(Long rxType) {
    this.rxType = rxType;
  }

  public String getSig() {
    return this.sig;
  }

  public void setSig(String sig) {
    this.sig = sig;
  }

  public String getIsCompound() {
    return this.isCompound;
  }

  public void setIsCompound(String isCompound) {
    this.isCompound = isCompound;
  }

  public String getNdcPrescribedDrug() {
    return this.ndcPrescribedDrug;
  }

  public void setNdcPrescribedDrug(String ndcPrescribedDrug) {
    this.ndcPrescribedDrug = ndcPrescribedDrug;
  }

  public Long getRxState() {
    return this.rxState;
  }

  public void setRxState(Long rxState) {
    this.rxState = rxState;
  }

  public Date getInactivateDate() {
    return this.inactivateDate;
  }

  public void setInactivateDate(Date inactivateDate) {
    this.inactivateDate = inactivateDate;
  }

  public String getInactivationReason() {
    return this.inactivationReason;
  }

  public void setInactivationReason(String inactivationReason) {
    this.inactivationReason = inactivationReason;
  }

  public Date getPrescriptionDateWritten() {
    return this.prescriptionDateWritten;
  }

  public void setPrescriptionDateWritten(Date prescriptionDateWritten) {
    this.prescriptionDateWritten = prescriptionDateWritten;
  }

  public Date getPrescriptionExpirationDate() {
    return this.prescriptionExpirationDate;
  }

  public void setPrescriptionExpirationDate(Date prescriptionExpirationDate) {
    this.prescriptionExpirationDate = prescriptionExpirationDate;
  }

  public String getPrnIndicator() {
    return this.prnIndicator;
  }

  public void setPrnIndicator(String prnIndicator) {
    this.prnIndicator = prnIndicator;
  }

  public String getRenewRefillRequestIndicator() {
    return this.renewRefillRequestIndicator;
  }

  public void setRenewRefillRequestIndicator(String renewRefillRequestIndicator) {
    this.renewRefillRequestIndicator = renewRefillRequestIndicator;
  }

  public String getAcquiredIndicator() {
    return this.acquiredIndicator;
  }

  public void setAcquiredIndicator(String acquiredIndicator) {
    this.acquiredIndicator = acquiredIndicator;
  }

  public String getReadyFillEnrollmentCd() {
    return this.readyFillEnrollmentCd;
  }

  public void setReadyFillEnrollmentCd(String readyFillEnrollmentCd) {
    this.readyFillEnrollmentCd = readyFillEnrollmentCd;
  }

  public Long getCurrentFillNumber() {
    return this.currentFillNumber;
  }

  public void setCurrentFillNumber(Long currentFillNumber) {
    this.currentFillNumber = currentFillNumber;
  }

  public Double getPrescribedQuantity() {
    return this.prescribedQuantity;
  }

  public void setPrescribedQuantity(Double prescribedQuantity) {
    this.prescribedQuantity = prescribedQuantity;
  }

  public Double getRefillQuantity() {
    return this.refillQuantity;
  }

  public void setRefillQuantity(Double refillQuantity) {
    this.refillQuantity = refillQuantity;
  }

  public Long getPrescribedNumberOfRefills() {
    return this.prescribedNumberOfRefills;
  }

  public void setPrescribedNumberOfRefills(Long prescribedNumberOfRefills) {
    this.prescribedNumberOfRefills = prescribedNumberOfRefills;
  }

  public Long getRefillsRemaining() {
    return this.refillsRemaining;
  }

  public void setRefillsRemaining(Long refillsRemaining) {
    this.refillsRemaining = refillsRemaining;
  }

  public Double getQuantityRemaining() {
    return this.quantityRemaining;
  }

  public void setQuantityRemaining(Double quantityRemaining) {
    this.quantityRemaining = quantityRemaining;
  }

  public Long getNumberOfLabelsToPrint() {
    return this.numberOfLabelsToPrint;
  }

  public void setNumberOfLabelsToPrint(Long numberOfLabelsToPrint) {
    this.numberOfLabelsToPrint = numberOfLabelsToPrint;
  }

  public String getPrintDrugNameOnLabel() {
    return this.printDrugNameOnLabel;
  }

  public void setPrintDrugNameOnLabel(String printDrugNameOnLabel) {
    this.printDrugNameOnLabel = printDrugNameOnLabel;
  }

  public Long getOriginalPrescriberId() {
    return this.originalPrescriberId;
  }

  public void setOriginalPrescriberId(Long originalPrescriberId) {
    this.originalPrescriberId = originalPrescriberId;
  }

  public String getFacilityId() {
    return this.facilityId;
  }

  public void setFacilityId(String facilityId) {
    this.facilityId = facilityId;
  }

  public String getExpandedSig() {
    return this.expandedSig;
  }

  public void setExpandedSig(String expandedSig) {
    this.expandedSig = expandedSig;
  }

  public String getLinkageTypeCd() {
    return this.linkageTypeCd;
  }

  public void setLinkageTypeCd(String linkageTypeCd) {
    this.linkageTypeCd = linkageTypeCd;
  }

  public String getLinkedToRxNumber() {
    return this.linkedToRxNumber;
  }

  public void setLinkedToRxNumber(String linkedToRxNumber) {
    this.linkedToRxNumber = linkedToRxNumber;
  }

  public String getGeneratedToRxNumber() {
    return this.generatedToRxNumber;
  }

  public void setGeneratedToRxNumber(String generatedToRxNumber) {
    this.generatedToRxNumber = generatedToRxNumber;
  }

  public String getTransferInOriginalRxNumber() {
    return this.transferInOriginalRxNumber;
  }

  public void setTransferInOriginalRxNumber(String transferInOriginalRxNumber) {
    this.transferInOriginalRxNumber = transferInOriginalRxNumber;
  }

  public String getTransferredInd() {
    return this.transferredInd;
  }

  public void setTransferredInd(String transferredInd) {
    this.transferredInd = transferredInd;
  }

  public String getTransferInIndicator() {
    return this.transferInIndicator;
  }

  public void setTransferInIndicator(String transferInIndicator) {
    this.transferInIndicator = transferInIndicator;
  }

  public String getTransferInType() {
    return this.transferInType;
  }

  public void setTransferInType(String transferInType) {
    this.transferInType = transferInType;
  }

  public String getTransferInFacilityName() {
    return this.transferInFacilityName;
  }

  public void setTransferInFacilityName(String transferInFacilityName) {
    this.transferInFacilityName = transferInFacilityName;
  }

  public String getTransferInFacilityNumber() {
    return this.transferInFacilityNumber;
  }

  public void setTransferInFacilityNumber(String transferInFacilityNumber) {
    this.transferInFacilityNumber = transferInFacilityNumber;
  }

  public String getTransferInFacilityAddline1() {
    return this.transferInFacilityAddline1;
  }

  public void setTransferInFacilityAddline1(String transferInFacilityAddline1) {
    this.transferInFacilityAddline1 = transferInFacilityAddline1;
  }

  public String getTransferInFacilityAddline2() {
    return this.transferInFacilityAddline2;
  }

  public void setTransferInFacilityAddline2(String transferInFacilityAddline2) {
    this.transferInFacilityAddline2 = transferInFacilityAddline2;
  }

  public String getTransferInFacilityCity() {
    return this.transferInFacilityCity;
  }

  public void setTransferInFacilityCity(String transferInFacilityCity) {
    this.transferInFacilityCity = transferInFacilityCity;
  }

  public String getTransferInFacilityState() {
    return this.transferInFacilityState;
  }

  public void setTransferInFacilityState(String transferInFacilityState) {
    this.transferInFacilityState = transferInFacilityState;
  }

  public String getTransferInFacilityZip() {
    return this.transferInFacilityZip;
  }

  public void setTransferInFacilityZip(String transferInFacilityZip) {
    this.transferInFacilityZip = transferInFacilityZip;
  }

  public String getTransferInFacilityNabpNum() {
    return this.transferInFacilityNabpNum;
  }

  public void setTransferInFacilityNabpNum(String transferInFacilityNabpNum) {
    this.transferInFacilityNabpNum = transferInFacilityNabpNum;
  }

  public String getTransferInFacilityDeaNum() {
    return this.transferInFacilityDeaNum;
  }

  public void setTransferInFacilityDeaNum(String transferInFacilityDeaNum) {
    this.transferInFacilityDeaNum = transferInFacilityDeaNum;
  }

  public String getTransferInFacilityPhNum() {
    return this.transferInFacilityPhNum;
  }

  public void setTransferInFacilityPhNum(String transferInFacilityPhNum) {
    this.transferInFacilityPhNum = transferInFacilityPhNum;
  }

  public String getTransferInPharmacistName() {
    return this.transferInPharmacistName;
  }

  public void setTransferInPharmacistName(String transferInPharmacistName) {
    this.transferInPharmacistName = transferInPharmacistName;
  }

  public String getTransferInRphLicenseNum() {
    return this.transferInRphLicenseNum;
  }

  public void setTransferInRphLicenseNum(String transferInRphLicenseNum) {
    this.transferInRphLicenseNum = transferInRphLicenseNum;
  }

  public String getTransferOutNewRxNumber() {
    return this.transferOutNewRxNumber;
  }

  public void setTransferOutNewRxNumber(String transferOutNewRxNumber) {
    this.transferOutNewRxNumber = transferOutNewRxNumber;
  }

  public String getTransferOutIndicator() {
    return this.transferOutIndicator;
  }

  public void setTransferOutIndicator(String transferOutIndicator) {
    this.transferOutIndicator = transferOutIndicator;
  }

  public String getTransferOutType() {
    return this.transferOutType;
  }

  public void setTransferOutType(String transferOutType) {
    this.transferOutType = transferOutType;
  }

  public String getTransferOutFacilityNumber() {
    return this.transferOutFacilityNumber;
  }

  public void setTransferOutFacilityNumber(String transferOutFacilityNumber) {
    this.transferOutFacilityNumber = transferOutFacilityNumber;
  }

  public String getTransferOutFacilityName() {
    return this.transferOutFacilityName;
  }

  public void setTransferOutFacilityName(String transferOutFacilityName) {
    this.transferOutFacilityName = transferOutFacilityName;
  }

  public String getTransferOutFacilityAddline1() {
    return this.transferOutFacilityAddline1;
  }

  public void setTransferOutFacilityAddline1(String transferOutFacilityAddline1) {
    this.transferOutFacilityAddline1 = transferOutFacilityAddline1;
  }

  public String getTransferOutFacilityAddline2() {
    return this.transferOutFacilityAddline2;
  }

  public void setTransferOutFacilityAddline2(String transferOutFacilityAddline2) {
    this.transferOutFacilityAddline2 = transferOutFacilityAddline2;
  }

  public String getTransferOutFacilityCity() {
    return this.transferOutFacilityCity;
  }

  public void setTransferOutFacilityCity(String transferOutFacilityCity) {
    this.transferOutFacilityCity = transferOutFacilityCity;
  }

  public String getTransferOutFacilityState() {
    return this.transferOutFacilityState;
  }

  public void setTransferOutFacilityState(String transferOutFacilityState) {
    this.transferOutFacilityState = transferOutFacilityState;
  }

  public String getTransferOutFacilityZip() {
    return this.transferOutFacilityZip;
  }

  public void setTransferOutFacilityZip(String transferOutFacilityZip) {
    this.transferOutFacilityZip = transferOutFacilityZip;
  }

  public String getTransferOutFacilityNabpNum() {
    return this.transferOutFacilityNabpNum;
  }

  public void setTransferOutFacilityNabpNum(String transferOutFacilityNabpNum) {
    this.transferOutFacilityNabpNum = transferOutFacilityNabpNum;
  }

  public String getTransferOutFacilityDeaNum() {
    return this.transferOutFacilityDeaNum;
  }

  public void setTransferOutFacilityDeaNum(String transferOutFacilityDeaNum) {
    this.transferOutFacilityDeaNum = transferOutFacilityDeaNum;
  }

  public String getTransferOutFacilityPhNum() {
    return this.transferOutFacilityPhNum;
  }

  public void setTransferOutFacilityPhNum(String transferOutFacilityPhNum) {
    this.transferOutFacilityPhNum = transferOutFacilityPhNum;
  }

  public String getTransferOutPharmacistName() {
    return this.transferOutPharmacistName;
  }

  public void setTransferOutPharmacistName(String transferOutPharmacistName) {
    this.transferOutPharmacistName = transferOutPharmacistName;
  }

  public String getTransferOutRphLicenseNum() {
    return this.transferOutRphLicenseNum;
  }

  public void setTransferOutRphLicenseNum(String transferOutRphLicenseNum) {
    this.transferOutRphLicenseNum = transferOutRphLicenseNum;
  }

  public Date getTransferOutDate() {
    return this.transferOutDate;
  }

  public void setTransferOutDate(Date transferOutDate) {
    this.transferOutDate = transferOutDate;
  }

  public Date getTransferOutFaxDate() {
    return this.transferOutFaxDate;
  }

  public void setTransferOutFaxDate(Date transferOutFaxDate) {
    this.transferOutFaxDate = transferOutFaxDate;
  }

  public Long getPrescriberAddressId() {
    return this.prescriberAddressId;
  }

  public void setPrescriberAddressId(Long prescriberAddressId) {
    this.prescriberAddressId = prescriberAddressId;
  }

  public String getGeneratedFromRxNumber() {
    return this.generatedFromRxNumber;
  }

  public void setGeneratedFromRxNumber(String generatedFromRxNumber) {
    this.generatedFromRxNumber = generatedFromRxNumber;
  }

  public String getIsDirty() {
    return this.isDirty;
  }

  public void setIsDirty(String isDirty) {
    this.isDirty = isDirty;
  }

  public String getIsCurrentVersion() {
    return this.isCurrentVersion;
  }

  public void setIsCurrentVersion(String isCurrentVersion) {
    this.isCurrentVersion = isCurrentVersion;
  }

  public Long getRxVersion() {
    return this.rxVersion;
  }

  public void setRxVersion(Long rxVersion) {
    this.rxVersion = rxVersion;
  }

  public String getLockIndicator() {
    return this.lockIndicator;
  }

  public void setLockIndicator(String lockIndicator) {
    this.lockIndicator = lockIndicator;
  }

  public String getGeneratedFromFileBuyInd() {
    return this.generatedFromFileBuyInd;
  }

  public void setGeneratedFromFileBuyInd(String generatedFromFileBuyInd) {
    this.generatedFromFileBuyInd = generatedFromFileBuyInd;
  }

  public String getDrugSubstitutedInd() {
    return this.drugSubstitutedInd;
  }

  public void setDrugSubstitutedInd(String drugSubstitutedInd) {
    this.drugSubstitutedInd = drugSubstitutedInd;
  }

  public String getTransferredInNumOfRefill() {
    return this.transferredInNumOfRefill;
  }

  public void setTransferredInNumOfRefill(String transferredInNumOfRefill) {
    this.transferredInNumOfRefill = transferredInNumOfRefill;
  }

  public String getTransferInFacilityCompCode() {
    return this.transferInFacilityCompCode;
  }

  public void setTransferInFacilityCompCode(String transferInFacilityCompCode) {
    this.transferInFacilityCompCode = transferInFacilityCompCode;
  }

  public String getTransferInFacilityLicNo() {
    return this.transferInFacilityLicNo;
  }

  public void setTransferInFacilityLicNo(String transferInFacilityLicNo) {
    this.transferInFacilityLicNo = transferInFacilityLicNo;
  }

  public Date getRxLastfillDate() {
    return this.rxLastfillDate;
  }

  public void setRxLastfillDate(Date rxLastfillDate) {
    this.rxLastfillDate = rxLastfillDate;
  }

  public String getTransferOutFacilityComCode() {
    return this.transferOutFacilityComCode;
  }

  public void setTransferOutFacilityComCode(String transferOutFacilityComCode) {
    this.transferOutFacilityComCode = transferOutFacilityComCode;
  }

  public String getTransferOutFacilityLicNo() {
    return this.transferOutFacilityLicNo;
  }

  public void setTransferOutFacilityLicNo(String transferOutFacilityLicNo) {
    this.transferOutFacilityLicNo = transferOutFacilityLicNo;
  }

  public Date getOriginalFillDate() {
    return this.originalFillDate;
  }

  public void setOriginalFillDate(Date originalFillDate) {
    this.originalFillDate = originalFillDate;
  }

  public Date getLocalPresDateWritten() {
    return this.localPresDateWritten;
  }

  public void setLocalPresDateWritten(Date localPresDateWritten) {
    this.localPresDateWritten = localPresDateWritten;
  }

  public Date getLocalTransferInDate() {
    return this.localTransferInDate;
  }

  public void setLocalTransferInDate(Date localTransferInDate) {
    this.localTransferInDate = localTransferInDate;
  }

  public Date getLocalTransferInDateWritten() {
    return this.localTransferInDateWritten;
  }

  public void setLocalTransferInDateWritten(Date localTransferInDateWritten) {
    this.localTransferInDateWritten = localTransferInDateWritten;
  }

  public Date getLocalTransferOutDate() {
    return this.localTransferOutDate;
  }

  public void setLocalTransferOutDate(Date localTransferOutDate) {
    this.localTransferOutDate = localTransferOutDate;
  }

  public Date getLocalInactivateDate() {
    return this.localInactivateDate;
  }

  public void setLocalInactivateDate(Date localInactivateDate) {
    this.localInactivateDate = localInactivateDate;
  }

  public Long getSupervisingPrescriberId() {
    return this.supervisingPrescriberId;
  }

  public void setSupervisingPrescriberId(Long supervisingPrescriberId) {
    this.supervisingPrescriberId = supervisingPrescriberId;
  }

  public String getAcquiredRxNumber() {
    return this.acquiredRxNumber;
  }

  public void setAcquiredRxNumber(String acquiredRxNumber) {
    this.acquiredRxNumber = acquiredRxNumber;
  }

  public String getTransferredInOrigFills() {
    return this.transferredInOrigFills;
  }

  public void setTransferredInOrigFills(String transferredInOrigFills) {
    this.transferredInOrigFills = transferredInOrigFills;
  }

  public Date getTransferredInRxDateWritten() {
    return this.transferredInRxDateWritten;
  }

  public void setTransferredInRxDateWritten(Date transferredInRxDateWritten) {
    this.transferredInRxDateWritten = transferredInRxDateWritten;
  }

  public String getPrescriberOrderNumber() {
    return this.prescriberOrderNumber;
  }

  public void setPrescriberOrderNumber(String prescriberOrderNumber) {
    this.prescriberOrderNumber = prescriberOrderNumber;
  }

  public String getControlledSubstanceIdQual() {
    return this.controlledSubstanceIdQual;
  }

  public void setControlledSubstanceIdQual(String controlledSubstanceIdQual) {
    this.controlledSubstanceIdQual = controlledSubstanceIdQual;
  }

  public String getControlledSubstanceId() {
    return this.controlledSubstanceId;
  }

  public void setControlledSubstanceId(String controlledSubstanceId) {
    this.controlledSubstanceId = controlledSubstanceId;
  }

  public String getRxSerialNumber() {
    return this.rxSerialNumber;
  }

  public void setRxSerialNumber(String rxSerialNumber) {
    this.rxSerialNumber = rxSerialNumber;
  }

  public Date getReadyFillEnrollmentDate() {
    return this.readyFillEnrollmentDate;
  }

  public void setReadyFillEnrollmentDate(Date readyFillEnrollmentDate) {
    this.readyFillEnrollmentDate = readyFillEnrollmentDate;
  }

  public Date getScheduledFillDate() {
    return this.scheduledFillDate;
  }

  public void setScheduledFillDate(Date scheduledFillDate) {
    this.scheduledFillDate = scheduledFillDate;
  }

  public String getScheduledFillReason() {
    return this.scheduledFillReason;
  }

  public void setScheduledFillReason(String scheduledFillReason) {
    this.scheduledFillReason = scheduledFillReason;
  }

  public Long getCredentialCount() {
    return this.credentialCount;
  }

  public void setCredentialCount(Long credentialCount) {
    this.credentialCount = credentialCount;
  }

  public Long getGenSubPerformedCode() {
    return this.genSubPerformedCode;
  }

  public void setGenSubPerformedCode(Long genSubPerformedCode) {
    this.genSubPerformedCode = genSubPerformedCode;
  }

  public String getDpsNumber() {
    return this.dpsNumber;
  }

  public void setDpsNumber(String dpsNumber) {
    this.dpsNumber = dpsNumber;
  }

  public String getDiagnosisCode() {
    return this.diagnosisCode;
  }

  public void setDiagnosisCode(String diagnosisCode) {
    this.diagnosisCode = diagnosisCode;
  }

  public String getProcedureModifierCode() {
    return this.procedureModifierCode;
  }

  public void setProcedureModifierCode(String procedureModifierCode) {
    this.procedureModifierCode = procedureModifierCode;
  }

  public String getSrdState() {
    return this.srdState;
  }

  public void setSrdState(String srdState) {
    this.srdState = srdState;
  }

  public String getRxOriginCode() {
    return this.rxOriginCode;
  }

  public void setRxOriginCode(String rxOriginCode) {
    this.rxOriginCode = rxOriginCode;
  }

  public String getMaxDailyDoseValue() {
    return this.maxDailyDoseValue;
  }

  public void setMaxDailyDoseValue(String maxDailyDoseValue) {
    this.maxDailyDoseValue = maxDailyDoseValue;
  }

  public String getMaxDailyDoseDosageUnit() {
    return this.maxDailyDoseDosageUnit;
  }

  public void setMaxDailyDoseDosageUnit(String maxDailyDoseDosageUnit) {
    this.maxDailyDoseDosageUnit = maxDailyDoseDosageUnit;
  }

  public String getLinkedFromRxNumber() {
    return this.linkedFromRxNumber;
  }

  public void setLinkedFromRxNumber(String linkedFromRxNumber) {
    this.linkedFromRxNumber = linkedFromRxNumber;
  }

  public String getInactivationCode() {
    return this.inactivationCode;
  }

  public void setInactivationCode(String inactivationCode) {
    this.inactivationCode = inactivationCode;
  }

  public Double getPatientWeightKg() {
    return this.patientWeightKg;
  }

  public void setPatientWeightKg(Double patientWeightKg) {
    this.patientWeightKg = patientWeightKg;
  }

  public Date getPatWeightCapturedDate() {
    return this.patWeightCapturedDate;
  }

  public void setPatWeightCapturedDate(Date patWeightCapturedDate) {
    this.patWeightCapturedDate = patWeightCapturedDate;
  }

  public Long getDrugSearchIndicators() {
    return this.drugSearchIndicators;
  }

  public void setDrugSearchIndicators(Long drugSearchIndicators) {
    this.drugSearchIndicators = drugSearchIndicators;
  }

  public Date getDoNotFillBeforeDate() {
    return this.doNotFillBeforeDate;
  }

  public void setDoNotFillBeforeDate(Date doNotFillBeforeDate) {
    this.doNotFillBeforeDate = doNotFillBeforeDate;
  }

  public String getIsControlledSubstance() {
    return this.isControlledSubstance;
  }

  public void setIsControlledSubstance(String isControlledSubstance) {
    this.isControlledSubstance = isControlledSubstance;
  }

  public String getCalculatedRefillsRemaining() {
    return this.calculatedRefillsRemaining;
  }

  public void setCalculatedRefillsRemaining(String calculatedRefillsRemaining) {
    this.calculatedRefillsRemaining = calculatedRefillsRemaining;
  }

  public String getTransferInCvsPharmName() {
    return this.transferInCvsPharmName;
  }

  public void setTransferInCvsPharmName(String transferInCvsPharmName) {
    this.transferInCvsPharmName = transferInCvsPharmName;
  }

  public String getIsEpcsRx() {
    return this.isEpcsRx;
  }

  public void setIsEpcsRx(String isEpcsRx) {
    this.isEpcsRx = isEpcsRx;
  }

  public Long getSupervisingPresAddressId() {
    return this.supervisingPresAddressId;
  }

  public void setSupervisingPresAddressId(Long supervisingPresAddressId) {
    this.supervisingPresAddressId = supervisingPresAddressId;
  }

  public Long getWebRfEnrollmentUpdatedVia() {
    return this.webRfEnrollmentUpdatedVia;
  }

  public void setWebRfEnrollmentUpdatedVia(Long webRfEnrollmentUpdatedVia) {
    this.webRfEnrollmentUpdatedVia = webRfEnrollmentUpdatedVia;
  }

  public String getCvsCustomerId() {
    return this.cvsCustomerId;
  }

  public void setCvsCustomerId(String cvsCustomerId) {
    this.cvsCustomerId = cvsCustomerId;
  }

  public Long getSigCodeOrigin() {
    return this.sigCodeOrigin;
  }

  public void setSigCodeOrigin(Long sigCodeOrigin) {
    this.sigCodeOrigin = sigCodeOrigin;
  }

  public String getLocation() {
    return this.location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getIssueContactNumber() {
    return this.issueContactNumber;
  }

  public void setIssueContactNumber(String issueContactNumber) {
    this.issueContactNumber = issueContactNumber;
  }

  public String getIsSigAvailable() {
    return this.isSigAvailable;
  }

  public void setIsSigAvailable(String isSigAvailable) {
    this.isSigAvailable = isSigAvailable;
  }

  public String getIsQuantityAvailable() {
    return this.isQuantityAvailable;
  }

  public void setIsQuantityAvailable(String isQuantityAvailable) {
    this.isQuantityAvailable = isQuantityAvailable;
  }

  public String getIsDiagnosisCodeAvailable() {
    return this.isDiagnosisCodeAvailable;
  }

  public void setIsDiagnosisCodeAvailable(String isDiagnosisCodeAvailable) {
    this.isDiagnosisCodeAvailable = isDiagnosisCodeAvailable;
  }

  public String getIsDawAvailable() {
    return this.isDawAvailable;
  }

  public void setIsDawAvailable(String isDawAvailable) {
    this.isDawAvailable = isDawAvailable;
  }

  public String getIsHardCopyCheckPerformed() {
    return this.isHardCopyCheckPerformed;
  }

  public void setIsHardCopyCheckPerformed(String isHardCopyCheckPerformed) {
    this.isHardCopyCheckPerformed = isHardCopyCheckPerformed;
  }

  public String getIspIndicator() {
    return this.ispIndicator;
  }

  public void setIspIndicator(String ispIndicator) {
    this.ispIndicator = ispIndicator;
  }

  public String getIspRxParticipatesInd() {
    return this.ispRxParticipatesInd;
  }

  public void setIspRxParticipatesInd(String ispRxParticipatesInd) {
    this.ispRxParticipatesInd = ispRxParticipatesInd;
  }

  public Long getIspMethodOfTransition() {
    return this.ispMethodOfTransition;
  }

  public void setIspMethodOfTransition(Long ispMethodOfTransition) {
    this.ispMethodOfTransition = ispMethodOfTransition;
  }

  public Date getIspTransitionDate() {
    return this.ispTransitionDate;
  }

  public void setIspTransitionDate(Date ispTransitionDate) {
    this.ispTransitionDate = ispTransitionDate;
  }

  public String getIspFillCode() {
    return this.ispFillCode;
  }

  public void setIspFillCode(String ispFillCode) {
    this.ispFillCode = ispFillCode;
  }

  public String getIspTrackerCode() {
    return this.ispTrackerCode;
  }

  public void setIspTrackerCode(String ispTrackerCode) {
    this.ispTrackerCode = ispTrackerCode;
  }

  public String getEnrollmentDeclineCount() {
    return this.enrollmentDeclineCount;
  }

  public void setEnrollmentDeclineCount(String enrollmentDeclineCount) {
    this.enrollmentDeclineCount = enrollmentDeclineCount;
  }

  public String getPatientControlGroup() {
    return this.patientControlGroup;
  }

  public void setPatientControlGroup(String patientControlGroup) {
    this.patientControlGroup = patientControlGroup;
  }

  public String getLinkageMethod() {
    return this.linkageMethod;
  }

  public void setLinkageMethod(String linkageMethod) {
    this.linkageMethod = linkageMethod;
  }

  public String getRfEnrollmentCredentials() {
    return this.rfEnrollmentCredentials;
  }

  public void setRfEnrollmentCredentials(String rfEnrollmentCredentials) {
    this.rfEnrollmentCredentials = rfEnrollmentCredentials;
  }

  public String getReadyFillEmployeeId() {
    return this.readyFillEmployeeId;
  }

  public void setReadyFillEmployeeId(String readyFillEmployeeId) {
    this.readyFillEmployeeId = readyFillEmployeeId;
  }

  public String getReadyFillEnrollmentReason() {
    return this.readyFillEnrollmentReason;
  }

  public void setReadyFillEnrollmentReason(String readyFillEnrollmentReason) {
    this.readyFillEnrollmentReason = readyFillEnrollmentReason;
  }

  public String getRfPatientConfAttemptNo() {
    return this.rfPatientConfAttemptNo;
  }

  public void setRfPatientConfAttemptNo(String rfPatientConfAttemptNo) {
    this.rfPatientConfAttemptNo = rfPatientConfAttemptNo;
  }

  public String getRfPatientConfResponse() {
    return this.rfPatientConfResponse;
  }

  public void setRfPatientConfResponse(String rfPatientConfResponse) {
    this.rfPatientConfResponse = rfPatientConfResponse;
  }

  public String getRfPatientConfTimestamp() {
    return this.rfPatientConfTimestamp;
  }

  public void setRfPatientConfTimestamp(String rfPatientConfTimestamp) {
    this.rfPatientConfTimestamp = rfPatientConfTimestamp;
  }

  public Long getPpiMessageId() {
    return this.ppiMessageId;
  }

  public void setPpiMessageId(Long ppiMessageId) {
    this.ppiMessageId = ppiMessageId;
  }

  public String getPrescriberOrderNum() {
    return this.prescriberOrderNum;
  }

  public void setPrescriberOrderNum(String prescriberOrderNum) {
    this.prescriberOrderNum = prescriberOrderNum;
  }

  public String getDrugDbCode() {
    return this.drugDbCode;
  }

  public void setDrugDbCode(String drugDbCode) {
    this.drugDbCode = drugDbCode;
  }

  public String getDrugDbCodeQualifier() {
    return this.drugDbCodeQualifier;
  }

  public void setDrugDbCodeQualifier(String drugDbCodeQualifier) {
    this.drugDbCodeQualifier = drugDbCodeQualifier;
  }

  public Date getLinkDate() {
    return this.linkDate;
  }

  public void setLinkDate(Date linkDate) {
    this.linkDate = linkDate;
  }

  public String getRxSubType() {
    return this.rxSubType;
  }

  public void setRxSubType(String rxSubType) {
    this.rxSubType = rxSubType;
  }

  public String getRxReassignIndicator() {
    return this.rxReassignIndicator;
  }

  public void setRxReassignIndicator(String rxReassignIndicator) {
    this.rxReassignIndicator = rxReassignIndicator;
  }

  public String getSsEnrollmentInd() {
    return this.ssEnrollmentInd;
  }

  public void setSsEnrollmentInd(String ssEnrollmentInd) {
    this.ssEnrollmentInd = ssEnrollmentInd;
  }

  public String getReadyfillDueSsChange() {
    return this.readyfillDueSsChange;
  }

  public void setReadyfillDueSsChange(String readyfillDueSsChange) {
    this.readyfillDueSsChange = readyfillDueSsChange;
  }

  public String getPosRfEnrollUnenrollmentInd() {
    return this.posRfEnrollUnenrollmentInd;
  }

  public void setPosRfEnrollUnenrollmentInd(String posRfEnrollUnenrollmentInd) {
    this.posRfEnrollUnenrollmentInd = posRfEnrollUnenrollmentInd;
  }

  public String getSsIneligibilityReason() {
    return this.ssIneligibilityReason;
  }

  public void setSsIneligibilityReason(String ssIneligibilityReason) {
    this.ssIneligibilityReason = ssIneligibilityReason;
  }

  public String getProactiveProgOutcome() {
    return this.proactiveProgOutcome;
  }

  public void setProactiveProgOutcome(String proactiveProgOutcome) {
    this.proactiveProgOutcome = proactiveProgOutcome;
  }

  public String getAssociatedFromRxNumber() {
    return this.associatedFromRxNumber;
  }

  public void setAssociatedFromRxNumber(String associatedFromRxNumber) {
    this.associatedFromRxNumber = associatedFromRxNumber;
  }

  public String getIsPrescriberNpiAvailable() {
    return this.isPrescriberNpiAvailable;
  }

  public void setIsPrescriberNpiAvailable(String isPrescriberNpiAvailable) {
    this.isPrescriberNpiAvailable = isPrescriberNpiAvailable;
  }

  public Date getProactiveDispositionDate() {
    return this.proactiveDispositionDate;
  }

  public void setProactiveDispositionDate(Date proactiveDispositionDate) {
    this.proactiveDispositionDate = proactiveDispositionDate;
  }

  public String getExtendedSig() {
    return this.extendedSig;
  }

  public void setExtendedSig(String extendedSig) {
    this.extendedSig = extendedSig;
  }

  public String getExpandedExtendedSig() {
    return this.expandedExtendedSig;
  }

  public void setExpandedExtendedSig(String expandedExtendedSig) {
    this.expandedExtendedSig = expandedExtendedSig;
  }

  public String getHcRescanFlag() {
    return this.hcRescanFlag;
  }

  public void setHcRescanFlag(String hcRescanFlag) {
    this.hcRescanFlag = hcRescanFlag;
  }

  public String getProhibitedInd() {
    return this.prohibitedInd;
  }

  public void setProhibitedInd(String prohibitedInd) {
    this.prohibitedInd = prohibitedInd;
  }
}
