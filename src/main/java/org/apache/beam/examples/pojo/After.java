package org.apache.beam.examples.pojo;

import java.io.Serializable;

public class After implements Serializable {
  private long prescriptionId;
  private long acquiredId;
  private long organizationId;
  private long patientAddressId;
  private int facilityNum;
  private long prescriberId;
  private long patientId;
  private String createdDate;
  private String createdBy;
  private String lastUpdatedDate;
  private String lastUpdatedBy;
  private int productNum;
  private long imageNum;
  private String rxNumber;
  private int rxType;
  private String sig;
  private String isCompound;
  private String ndcPrescribedDrug;
  private int rxState;
  private String inactivateDate;
  private String inactivationReason;
  private String prescriptionDateWritten;
  private String prescriptionExpirationDate;
  private String prnIndicator;
  private String renewRefillRequestIndicator;
  private String acquiredIndicator;
  private String readyFillEnrollmentCd;
  private int currentFillNumber;
  private int prescribedQuantity;
  private int refillQuantity;
  private int prescribedNumberOfRefills;
  private int refillsRemaining;
  private int quantityRemaining;
  private int numberOfLabelsToPrint;
  private String printDrugNameOnLabel;
  private long originalPrescriberId;
  private String facilityId;
  private String expandedSig;
  private String linkageTypeCd;
  private String linkedToRxNumber;
  private String generatedToRxNumber;
  private String transferInOriginalRxNumber;
  private String transferredInd;
  private String transferInIndicator;
  private String transferInType;
  private String transferInFacilityNumber;
  private String transferInFacilityName;
  private String transferInFacilityAddline1;
  private String transferInFacilityAddline2;
  private String transferInFacilityCity;
  private String transferInFacilityState;
  private String transferInFacilityZip;
  private String transferInFacilityNabpNum;
  private String transferInFacilityDeaNum;
  private String transferInFacilityPhNum;
  private String transferInPharmacistName;
  private String transferInRphLicenseNum;
  private String transferInDate;
  private String transferOutNewRxNumber;
  private String transferOutIndicator;
  private String transferOutType;
  private String transferOutFacilityNumber;
  private String transferOutFacilityName;
  private String transferOutFacilityAddline1;
  private String transferOutFacilityAddline2;
  private String transferOutFacilityCity;
  private String transferOutFacilityState;
  private String transferOutFacilityZip;
  private String transferOutFacilityNabpNum;
  private String transferOutFacilityDeaNum;
  private String transferOutFacilityPhNum;
  private String transferOutPharmacistName;
  private String transferOutRphLicenseNum;
  private String transferOutDate;
  private String transferOutFaxDate;
  private long prescriberAddressId;
  private String generatedFromRxNumber;
  private String isDirty;
  private String isCurrentVersion;
  private int rxVersion;
  private String lockIndicator;
  private String generatedFromFileBuyInd;
  private String drugSubstitutedInd;
  private String transferredInNumOfRefill;
  private String transferInFacilityCompCode;
  private String transferInFacilityLicNo;
  private String rxLastfillDate;
  private String transferOutFacilityComCode;
  private String transferOutFacilityLicNo;
  private String originalFillDate;
  private String localPresDateWritten;
  private String localTransferInDate;
  private String localTransferInDateWritten;
  private String localTransferOutDate;
  private String localInactivateDate;
  private long supervisingPrescriberId;
  private String acquiredRxNumber;
  private String transferredInOrigFills;
  private String transferredInRxDateWritten;
  private String prescriberOrderNumber;
  private String controlledSubstanceIdQual;
  private String controlledSubstanceId;
  private String rxSerialNumber;
  private String readyFillEnrollmentDate;
  private String scheduledFillDate;
  private String scheduledFillReason;
  private int credentialCount;
  private int genSubPerformedCode;
  private String dpsNumber;
  private String diagnosisCode;
  private String procedureModifierCode;
  private String srdState;
  private String rxOriginCode;
  private String maxDailyDoseValue;
  private String maxDailyDoseDosageUnit;
  private String linkedFromRxNumber;
  private String inactivationCode;
  private Double patientWeightKg;
  private String patWeightCapturedDate;
  private int drugSearchIndicators;
  private String doNotFillBeforeDate;
  private String isControlledSubstance;
  private String calculatedRefillsRemaining;
  private String transferInCvsPharmName;
  private String isEpcsRx;
  private long supervisingPresAddressId;
  private int webRfEnrollmentUpdatedVia;
  private String cvsCustomerId;
  private int sigCodeOrigin;
  private String location;
  private String issueContactNumber;
  private String isSigAvailable;
  private String isQuantityAvailable;
  private String isDiagnosisCodeAvailable;
  private String isDawAvailable;
  private String isHardCopyCheckPerformed;
  private String ispIndicator;
  private String ispRxParticipatesInd;
  private int ispMethodOfTransition;
  private String ispTransitionDate;
  private String ispFillCode;
  private String ispTrackerCode;
  private String enrollmentDeclineCount;
  private String patientControlGroup;
  private String linkageMethod;
  private String rfEnrollmentCredentials;
  private String readyFillEmployeeId;
  private String readyFillEnrollmentReason;
  private String rfPatientConfAttemptNo;
  private String rfPatientConfResponse;
  private String rfPatientConfTimestamp;
  private long ppiMessageId;
  private String prescriberOrderNum;
  private String drugDbCode;
  private String drugDbCodeQualifier;
  private String linkDate;
  private String rxSubType;
  private String rxReassignIndicator;
  private String ssEnrollmentInd;
  private String readyfillDueSsChange;
  private String posRfEnrollUnenrollmentInd;
  private String ssIneligibilityReason;
  private String proactiveProgOutcome;
  private String associatedFromRxNumber;
  private String isPrescriberNpiAvailable;
  private String proactiveDispositionDate;
  private String extendedSig;
  private String expandedExtendedSig;
  private String hcRescanFlag;
  private String prohibitedInd;

  public long getPrescriptionId() {
    return this.prescriptionId;
  }

  public void setPrescriptionId(long prescriptionId) {
    this.prescriptionId = prescriptionId;
  }

  public long getAcquiredId() {
    return this.acquiredId;
  }

  public void setAcquiredId(long acquiredId) {
    this.acquiredId = acquiredId;
  }

  public long getOrganizationId() {
    return this.organizationId;
  }

  public void setOrganizationId(long organizationId) {
    this.organizationId = organizationId;
  }

  public long getPatientAddressId() {
    return this.patientAddressId;
  }

  public void setPatientAddressId(long patientAddressId) {
    this.patientAddressId = patientAddressId;
  }

  public int getFacilityNum() {
    return this.facilityNum;
  }

  public void setFacilityNum(int facilityNum) {
    this.facilityNum = facilityNum;
  }

  public long getPrescriberId() {
    return this.prescriberId;
  }

  public void setPrescriberId(long prescriberId) {
    this.prescriberId = prescriberId;
  }

  public long getPatientId() {
    return this.patientId;
  }

  public void setPatientId(long patientId) {
    this.patientId = patientId;
  }

  public String getCreatedDate() {
    return this.createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  public String getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getLastUpdatedDate() {
    return this.lastUpdatedDate;
  }

  public void setLastUpdatedDate(String lastUpdatedDate) {
    this.lastUpdatedDate = lastUpdatedDate;
  }

  public String getLastUpdatedBy() {
    return this.lastUpdatedBy;
  }

  public void setLastUpdatedBy(String lastUpdatedBy) {
    this.lastUpdatedBy = lastUpdatedBy;
  }

  public int getProductNum() {
    return this.productNum;
  }

  public void setProductNum(int productNum) {
    this.productNum = productNum;
  }

  public long getImageNum() {
    return this.imageNum;
  }

  public void setImageNum(long imageNum) {
    this.imageNum = imageNum;
  }

  public String getRxNumber() {
    return this.rxNumber;
  }

  public void setRxNumber(String rxNumber) {
    this.rxNumber = rxNumber;
  }

  public int getRxType() {
    return this.rxType;
  }

  public void setRxType(int rxType) {
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

  public int getRxState() {
    return this.rxState;
  }

  public void setRxState(int rxState) {
    this.rxState = rxState;
  }

  public String getInactivateDate() {
    return this.inactivateDate;
  }

  public void setInactivateDate(String inactivateDate) {
    this.inactivateDate = inactivateDate;
  }

  public String getInactivationReason() {
    return this.inactivationReason;
  }

  public void setInactivationReason(String inactivationReason) {
    this.inactivationReason = inactivationReason;
  }

  public String getPrescriptionDateWritten() {
    return this.prescriptionDateWritten;
  }

  public void setPrescriptionDateWritten(String prescriptionDateWritten) {
    this.prescriptionDateWritten = prescriptionDateWritten;
  }

  public String getPrescriptionExpirationDate() {
    return this.prescriptionExpirationDate;
  }

  public void setPrescriptionExpirationDate(String prescriptionExpirationDate) {
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

  public int getCurrentFillNumber() {
    return this.currentFillNumber;
  }

  public void setCurrentFillNumber(int currentFillNumber) {
    this.currentFillNumber = currentFillNumber;
  }

  public int getPrescribedQuantity() {
    return this.prescribedQuantity;
  }

  public void setPrescribedQuantity(int prescribedQuantity) {
    this.prescribedQuantity = prescribedQuantity;
  }

  public int getRefillQuantity() {
    return this.refillQuantity;
  }

  public void setRefillQuantity(int refillQuantity) {
    this.refillQuantity = refillQuantity;
  }

  public int getPrescribedNumberOfRefills() {
    return this.prescribedNumberOfRefills;
  }

  public void setPrescribedNumberOfRefills(int prescribedNumberOfRefills) {
    this.prescribedNumberOfRefills = prescribedNumberOfRefills;
  }

  public int getRefillsRemaining() {
    return this.refillsRemaining;
  }

  public void setRefillsRemaining(int refillsRemaining) {
    this.refillsRemaining = refillsRemaining;
  }

  public int getQuantityRemaining() {
    return this.quantityRemaining;
  }

  public void setQuantityRemaining(int quantityRemaining) {
    this.quantityRemaining = quantityRemaining;
  }

  public int getNumberOfLabelsToPrint() {
    return this.numberOfLabelsToPrint;
  }

  public void setNumberOfLabelsToPrint(int numberOfLabelsToPrint) {
    this.numberOfLabelsToPrint = numberOfLabelsToPrint;
  }

  public String getPrintDrugNameOnLabel() {
    return this.printDrugNameOnLabel;
  }

  public void setPrintDrugNameOnLabel(String printDrugNameOnLabel) {
    this.printDrugNameOnLabel = printDrugNameOnLabel;
  }

  public long getOriginalPrescriberId() {
    return this.originalPrescriberId;
  }

  public void setOriginalPrescriberId(long originalPrescriberId) {
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

  public String getTransferInFacilityNumber() {
    return this.transferInFacilityNumber;
  }

  public void setTransferInFacilityNumber(String transferInFacilityNumber) {
    this.transferInFacilityNumber = transferInFacilityNumber;
  }

  public String getTransferInFacilityName() {
    return this.transferInFacilityName;
  }

  public void setTransferInFacilityName(String transferInFacilityName) {
    this.transferInFacilityName = transferInFacilityName;
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

  public String getTransferInDate() {
    return this.transferInDate;
  }

  public void setTransferInDate(String transferInDate) {
    this.transferInDate = transferInDate;
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

  public String getTransferOutDate() {
    return this.transferOutDate;
  }

  public void setTransferOutDate(String transferOutDate) {
    this.transferOutDate = transferOutDate;
  }

  public String getTransferOutFaxDate() {
    return this.transferOutFaxDate;
  }

  public void setTransferOutFaxDate(String transferOutFaxDate) {
    this.transferOutFaxDate = transferOutFaxDate;
  }

  public long getPrescriberAddressId() {
    return this.prescriberAddressId;
  }

  public void setPrescriberAddressId(long prescriberAddressId) {
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

  public int getRxVersion() {
    return this.rxVersion;
  }

  public void setRxVersion(int rxVersion) {
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

  public String getRxLastfillDate() {
    return this.rxLastfillDate;
  }

  public void setRxLastfillDate(String rxLastfillDate) {
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

  public String getOriginalFillDate() {
    return this.originalFillDate;
  }

  public void setOriginalFillDate(String originalFillDate) {
    this.originalFillDate = originalFillDate;
  }

  public String getLocalPresDateWritten() {
    return this.localPresDateWritten;
  }

  public void setLocalPresDateWritten(String localPresDateWritten) {
    this.localPresDateWritten = localPresDateWritten;
  }

  public String getLocalTransferInDate() {
    return this.localTransferInDate;
  }

  public void setLocalTransferInDate(String localTransferInDate) {
    this.localTransferInDate = localTransferInDate;
  }

  public String getLocalTransferInDateWritten() {
    return this.localTransferInDateWritten;
  }

  public void setLocalTransferInDateWritten(String localTransferInDateWritten) {
    this.localTransferInDateWritten = localTransferInDateWritten;
  }

  public String getLocalTransferOutDate() {
    return this.localTransferOutDate;
  }

  public void setLocalTransferOutDate(String localTransferOutDate) {
    this.localTransferOutDate = localTransferOutDate;
  }

  public String getLocalInactivateDate() {
    return this.localInactivateDate;
  }

  public void setLocalInactivateDate(String localInactivateDate) {
    this.localInactivateDate = localInactivateDate;
  }

  public long getSupervisingPrescriberId() {
    return this.supervisingPrescriberId;
  }

  public void setSupervisingPrescriberId(long supervisingPrescriberId) {
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

  public String getTransferredInRxDateWritten() {
    return this.transferredInRxDateWritten;
  }

  public void setTransferredInRxDateWritten(String transferredInRxDateWritten) {
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

  public String getReadyFillEnrollmentDate() {
    return this.readyFillEnrollmentDate;
  }

  public void setReadyFillEnrollmentDate(String readyFillEnrollmentDate) {
    this.readyFillEnrollmentDate = readyFillEnrollmentDate;
  }

  public String getScheduledFillDate() {
    return this.scheduledFillDate;
  }

  public void setScheduledFillDate(String scheduledFillDate) {
    this.scheduledFillDate = scheduledFillDate;
  }

  public String getScheduledFillReason() {
    return this.scheduledFillReason;
  }

  public void setScheduledFillReason(String scheduledFillReason) {
    this.scheduledFillReason = scheduledFillReason;
  }

  public int getCredentialCount() {
    return this.credentialCount;
  }

  public void setCredentialCount(int credentialCount) {
    this.credentialCount = credentialCount;
  }

  public int getGenSubPerformedCode() {
    return this.genSubPerformedCode;
  }

  public void setGenSubPerformedCode(int genSubPerformedCode) {
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

  public String getPatWeightCapturedDate() {
    return this.patWeightCapturedDate;
  }

  public void setPatWeightCapturedDate(String patWeightCapturedDate) {
    this.patWeightCapturedDate = patWeightCapturedDate;
  }

  public int getDrugSearchIndicators() {
    return this.drugSearchIndicators;
  }

  public void setDrugSearchIndicators(int drugSearchIndicators) {
    this.drugSearchIndicators = drugSearchIndicators;
  }

  public String getDoNotFillBeforeDate() {
    return this.doNotFillBeforeDate;
  }

  public void setDoNotFillBeforeDate(String doNotFillBeforeDate) {
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

  public long getSupervisingPresAddressId() {
    return this.supervisingPresAddressId;
  }

  public void setSupervisingPresAddressId(long supervisingPresAddressId) {
    this.supervisingPresAddressId = supervisingPresAddressId;
  }

  public int getWebRfEnrollmentUpdatedVia() {
    return this.webRfEnrollmentUpdatedVia;
  }

  public void setWebRfEnrollmentUpdatedVia(int webRfEnrollmentUpdatedVia) {
    this.webRfEnrollmentUpdatedVia = webRfEnrollmentUpdatedVia;
  }

  public String getCvsCustomerId() {
    return this.cvsCustomerId;
  }

  public void setCvsCustomerId(String cvsCustomerId) {
    this.cvsCustomerId = cvsCustomerId;
  }

  public int getSigCodeOrigin() {
    return this.sigCodeOrigin;
  }

  public void setSigCodeOrigin(int sigCodeOrigin) {
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

  public int getIspMethodOfTransition() {
    return this.ispMethodOfTransition;
  }

  public void setIspMethodOfTransition(int ispMethodOfTransition) {
    this.ispMethodOfTransition = ispMethodOfTransition;
  }

  public String getIspTransitionDate() {
    return this.ispTransitionDate;
  }

  public void setIspTransitionDate(String ispTransitionDate) {
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

  public long getPpiMessageId() {
    return this.ppiMessageId;
  }

  public void setPpiMessageId(long ppiMessageId) {
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

  public String getLinkDate() {
    return this.linkDate;
  }

  public void setLinkDate(String linkDate) {
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

  public String getProactiveDispositionDate() {
    return this.proactiveDispositionDate;
  }

  public void setProactiveDispositionDate(String proactiveDispositionDate) {
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
