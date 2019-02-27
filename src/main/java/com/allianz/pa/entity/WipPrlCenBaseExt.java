package com.allianz.pa.entity;

import java.math.BigDecimal;
import java.util.Date;

public class WipPrlCenBaseExt {
    private Long contractId;

    private String actionCode;

    private Integer versionNo;

    private String topIndicator;

    private Integer previousVersion;

    private Integer reversingVersion;

    private String businessUnit;

    private String calculationPeriod;

    private BigDecimal installmentPremium;

    private BigDecimal totalPrem;

    private String tempReceipt;

    private String cancelRemarks;

    private BigDecimal exchRate;

    private String globalProgram;

    private String sourceOfBusiness;

    private String subProduct;

    private String memo;

    private Date exchDate;

    private Short noOfCopies;

    private BigDecimal tax;

    private String paymentTerms;

    private BigDecimal taxRate;

    private BigDecimal taxAmount;

    private BigDecimal stampRate;

    private BigDecimal stampAmount;

    private BigDecimal directDiscRate;

    private BigDecimal discountAmount;

    private Long renewalNo;

    private Long extVersionNo;

    private Long intVersionNo;

    private Short rciShare;

    private String gpaCode;

    private String customerName;

    private BigDecimal adjTaxAmt;

    private BigDecimal adjStampAmt;

    private String policyType;

    private String drcrNo;

    private Date constStartDate;

    private Date constEndDate;

    private Date maintStartDate;

    private Date maintEndDate;

    private String inceptionTime;

    private String expiryTime;

    private String policySubType;

    private Short constructionPeriod;

    private String constPeriodText;

    private Integer maintenancePeriod;

    private String maintPeriodUnit;

    private String maintPeriodText;

    private String compRenewal;

    private String replacingCovernoteNo;

    private String constPeriodUnit;

    private String referTo;

    private String referComments;

    private String referText;

    private String commOvInd;

    private String contractualRate;

    private String renewalRemarksInternal;

    private String renewalRemarks;

    private String renewable;

    private Short cnlNoticeDays;

    private String policyFormCode;

    private String jacketCode;

    private String domicile;

    private String offshoreOnshore;

    private String holdCover;

    private Date holdCoverDate;

    private Long sectionId;

    private String annualPolicy;

    private Long formType;

    private String maintPeriodFlag;

    private String icb;

    private String icbDef;

    private String applicationNo;

    private String staffCode;

    private String offshoreOnshoreTax;

    private String basisOfValuation;

    private String policyLimit;

    private String disputeSolution;

    private String phMailingAddr;

    private String annualRate;

    private String clauseWording;

    private String nps;

    private String clauseWording2;

    private String clauseWording3;

    private String poiFlag;

    private String poiText;

    private String handlerUsername;

    private String sumInsuredDesc;

    private String indemnityPeriod;

    private String showPremiumFlag;

    private String nonBinding;

    private String salesTeam;

    private String businessSource;

    private String gaiiQuoteNo;

    private String fixExch;

    private String abroadDriveYn;

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode == null ? null : actionCode.trim();
    }

    public Integer getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(Integer versionNo) {
        this.versionNo = versionNo;
    }

    public String getTopIndicator() {
        return topIndicator;
    }

    public void setTopIndicator(String topIndicator) {
        this.topIndicator = topIndicator == null ? null : topIndicator.trim();
    }

    public Integer getPreviousVersion() {
        return previousVersion;
    }

    public void setPreviousVersion(Integer previousVersion) {
        this.previousVersion = previousVersion;
    }

    public Integer getReversingVersion() {
        return reversingVersion;
    }

    public void setReversingVersion(Integer reversingVersion) {
        this.reversingVersion = reversingVersion;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit == null ? null : businessUnit.trim();
    }

    public String getCalculationPeriod() {
        return calculationPeriod;
    }

    public void setCalculationPeriod(String calculationPeriod) {
        this.calculationPeriod = calculationPeriod == null ? null : calculationPeriod.trim();
    }

    public BigDecimal getInstallmentPremium() {
        return installmentPremium;
    }

    public void setInstallmentPremium(BigDecimal installmentPremium) {
        this.installmentPremium = installmentPremium;
    }

    public BigDecimal getTotalPrem() {
        return totalPrem;
    }

    public void setTotalPrem(BigDecimal totalPrem) {
        this.totalPrem = totalPrem;
    }

    public String getTempReceipt() {
        return tempReceipt;
    }

    public void setTempReceipt(String tempReceipt) {
        this.tempReceipt = tempReceipt == null ? null : tempReceipt.trim();
    }

    public String getCancelRemarks() {
        return cancelRemarks;
    }

    public void setCancelRemarks(String cancelRemarks) {
        this.cancelRemarks = cancelRemarks == null ? null : cancelRemarks.trim();
    }

    public BigDecimal getExchRate() {
        return exchRate;
    }

    public void setExchRate(BigDecimal exchRate) {
        this.exchRate = exchRate;
    }

    public String getGlobalProgram() {
        return globalProgram;
    }

    public void setGlobalProgram(String globalProgram) {
        this.globalProgram = globalProgram == null ? null : globalProgram.trim();
    }

    public String getSourceOfBusiness() {
        return sourceOfBusiness;
    }

    public void setSourceOfBusiness(String sourceOfBusiness) {
        this.sourceOfBusiness = sourceOfBusiness == null ? null : sourceOfBusiness.trim();
    }

    public String getSubProduct() {
        return subProduct;
    }

    public void setSubProduct(String subProduct) {
        this.subProduct = subProduct == null ? null : subProduct.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Date getExchDate() {
        return exchDate;
    }

    public void setExchDate(Date exchDate) {
        this.exchDate = exchDate;
    }

    public Short getNoOfCopies() {
        return noOfCopies;
    }

    public void setNoOfCopies(Short noOfCopies) {
        this.noOfCopies = noOfCopies;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms == null ? null : paymentTerms.trim();
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getStampRate() {
        return stampRate;
    }

    public void setStampRate(BigDecimal stampRate) {
        this.stampRate = stampRate;
    }

    public BigDecimal getStampAmount() {
        return stampAmount;
    }

    public void setStampAmount(BigDecimal stampAmount) {
        this.stampAmount = stampAmount;
    }

    public BigDecimal getDirectDiscRate() {
        return directDiscRate;
    }

    public void setDirectDiscRate(BigDecimal directDiscRate) {
        this.directDiscRate = directDiscRate;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Long getRenewalNo() {
        return renewalNo;
    }

    public void setRenewalNo(Long renewalNo) {
        this.renewalNo = renewalNo;
    }

    public Long getExtVersionNo() {
        return extVersionNo;
    }

    public void setExtVersionNo(Long extVersionNo) {
        this.extVersionNo = extVersionNo;
    }

    public Long getIntVersionNo() {
        return intVersionNo;
    }

    public void setIntVersionNo(Long intVersionNo) {
        this.intVersionNo = intVersionNo;
    }

    public Short getRciShare() {
        return rciShare;
    }

    public void setRciShare(Short rciShare) {
        this.rciShare = rciShare;
    }

    public String getGpaCode() {
        return gpaCode;
    }

    public void setGpaCode(String gpaCode) {
        this.gpaCode = gpaCode == null ? null : gpaCode.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public BigDecimal getAdjTaxAmt() {
        return adjTaxAmt;
    }

    public void setAdjTaxAmt(BigDecimal adjTaxAmt) {
        this.adjTaxAmt = adjTaxAmt;
    }

    public BigDecimal getAdjStampAmt() {
        return adjStampAmt;
    }

    public void setAdjStampAmt(BigDecimal adjStampAmt) {
        this.adjStampAmt = adjStampAmt;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType == null ? null : policyType.trim();
    }

    public String getDrcrNo() {
        return drcrNo;
    }

    public void setDrcrNo(String drcrNo) {
        this.drcrNo = drcrNo == null ? null : drcrNo.trim();
    }

    public Date getConstStartDate() {
        return constStartDate;
    }

    public void setConstStartDate(Date constStartDate) {
        this.constStartDate = constStartDate;
    }

    public Date getConstEndDate() {
        return constEndDate;
    }

    public void setConstEndDate(Date constEndDate) {
        this.constEndDate = constEndDate;
    }

    public Date getMaintStartDate() {
        return maintStartDate;
    }

    public void setMaintStartDate(Date maintStartDate) {
        this.maintStartDate = maintStartDate;
    }

    public Date getMaintEndDate() {
        return maintEndDate;
    }

    public void setMaintEndDate(Date maintEndDate) {
        this.maintEndDate = maintEndDate;
    }

    public String getInceptionTime() {
        return inceptionTime;
    }

    public void setInceptionTime(String inceptionTime) {
        this.inceptionTime = inceptionTime == null ? null : inceptionTime.trim();
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime == null ? null : expiryTime.trim();
    }

    public String getPolicySubType() {
        return policySubType;
    }

    public void setPolicySubType(String policySubType) {
        this.policySubType = policySubType == null ? null : policySubType.trim();
    }

    public Short getConstructionPeriod() {
        return constructionPeriod;
    }

    public void setConstructionPeriod(Short constructionPeriod) {
        this.constructionPeriod = constructionPeriod;
    }

    public String getConstPeriodText() {
        return constPeriodText;
    }

    public void setConstPeriodText(String constPeriodText) {
        this.constPeriodText = constPeriodText == null ? null : constPeriodText.trim();
    }

    public Integer getMaintenancePeriod() {
        return maintenancePeriod;
    }

    public void setMaintenancePeriod(Integer maintenancePeriod) {
        this.maintenancePeriod = maintenancePeriod;
    }

    public String getMaintPeriodUnit() {
        return maintPeriodUnit;
    }

    public void setMaintPeriodUnit(String maintPeriodUnit) {
        this.maintPeriodUnit = maintPeriodUnit == null ? null : maintPeriodUnit.trim();
    }

    public String getMaintPeriodText() {
        return maintPeriodText;
    }

    public void setMaintPeriodText(String maintPeriodText) {
        this.maintPeriodText = maintPeriodText == null ? null : maintPeriodText.trim();
    }

    public String getCompRenewal() {
        return compRenewal;
    }

    public void setCompRenewal(String compRenewal) {
        this.compRenewal = compRenewal == null ? null : compRenewal.trim();
    }

    public String getReplacingCovernoteNo() {
        return replacingCovernoteNo;
    }

    public void setReplacingCovernoteNo(String replacingCovernoteNo) {
        this.replacingCovernoteNo = replacingCovernoteNo == null ? null : replacingCovernoteNo.trim();
    }

    public String getConstPeriodUnit() {
        return constPeriodUnit;
    }

    public void setConstPeriodUnit(String constPeriodUnit) {
        this.constPeriodUnit = constPeriodUnit == null ? null : constPeriodUnit.trim();
    }

    public String getReferTo() {
        return referTo;
    }

    public void setReferTo(String referTo) {
        this.referTo = referTo == null ? null : referTo.trim();
    }

    public String getReferComments() {
        return referComments;
    }

    public void setReferComments(String referComments) {
        this.referComments = referComments == null ? null : referComments.trim();
    }

    public String getReferText() {
        return referText;
    }

    public void setReferText(String referText) {
        this.referText = referText == null ? null : referText.trim();
    }

    public String getCommOvInd() {
        return commOvInd;
    }

    public void setCommOvInd(String commOvInd) {
        this.commOvInd = commOvInd == null ? null : commOvInd.trim();
    }

    public String getContractualRate() {
        return contractualRate;
    }

    public void setContractualRate(String contractualRate) {
        this.contractualRate = contractualRate == null ? null : contractualRate.trim();
    }

    public String getRenewalRemarksInternal() {
        return renewalRemarksInternal;
    }

    public void setRenewalRemarksInternal(String renewalRemarksInternal) {
        this.renewalRemarksInternal = renewalRemarksInternal == null ? null : renewalRemarksInternal.trim();
    }

    public String getRenewalRemarks() {
        return renewalRemarks;
    }

    public void setRenewalRemarks(String renewalRemarks) {
        this.renewalRemarks = renewalRemarks == null ? null : renewalRemarks.trim();
    }

    public String getRenewable() {
        return renewable;
    }

    public void setRenewable(String renewable) {
        this.renewable = renewable == null ? null : renewable.trim();
    }

    public Short getCnlNoticeDays() {
        return cnlNoticeDays;
    }

    public void setCnlNoticeDays(Short cnlNoticeDays) {
        this.cnlNoticeDays = cnlNoticeDays;
    }

    public String getPolicyFormCode() {
        return policyFormCode;
    }

    public void setPolicyFormCode(String policyFormCode) {
        this.policyFormCode = policyFormCode == null ? null : policyFormCode.trim();
    }

    public String getJacketCode() {
        return jacketCode;
    }

    public void setJacketCode(String jacketCode) {
        this.jacketCode = jacketCode == null ? null : jacketCode.trim();
    }

    public String getDomicile() {
        return domicile;
    }

    public void setDomicile(String domicile) {
        this.domicile = domicile == null ? null : domicile.trim();
    }

    public String getOffshoreOnshore() {
        return offshoreOnshore;
    }

    public void setOffshoreOnshore(String offshoreOnshore) {
        this.offshoreOnshore = offshoreOnshore == null ? null : offshoreOnshore.trim();
    }

    public String getHoldCover() {
        return holdCover;
    }

    public void setHoldCover(String holdCover) {
        this.holdCover = holdCover == null ? null : holdCover.trim();
    }

    public Date getHoldCoverDate() {
        return holdCoverDate;
    }

    public void setHoldCoverDate(Date holdCoverDate) {
        this.holdCoverDate = holdCoverDate;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public String getAnnualPolicy() {
        return annualPolicy;
    }

    public void setAnnualPolicy(String annualPolicy) {
        this.annualPolicy = annualPolicy == null ? null : annualPolicy.trim();
    }

    public Long getFormType() {
        return formType;
    }

    public void setFormType(Long formType) {
        this.formType = formType;
    }

    public String getMaintPeriodFlag() {
        return maintPeriodFlag;
    }

    public void setMaintPeriodFlag(String maintPeriodFlag) {
        this.maintPeriodFlag = maintPeriodFlag == null ? null : maintPeriodFlag.trim();
    }

    public String getIcb() {
        return icb;
    }

    public void setIcb(String icb) {
        this.icb = icb == null ? null : icb.trim();
    }

    public String getIcbDef() {
        return icbDef;
    }

    public void setIcbDef(String icbDef) {
        this.icbDef = icbDef == null ? null : icbDef.trim();
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo == null ? null : applicationNo.trim();
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode == null ? null : staffCode.trim();
    }

    public String getOffshoreOnshoreTax() {
        return offshoreOnshoreTax;
    }

    public void setOffshoreOnshoreTax(String offshoreOnshoreTax) {
        this.offshoreOnshoreTax = offshoreOnshoreTax == null ? null : offshoreOnshoreTax.trim();
    }

    public String getBasisOfValuation() {
        return basisOfValuation;
    }

    public void setBasisOfValuation(String basisOfValuation) {
        this.basisOfValuation = basisOfValuation == null ? null : basisOfValuation.trim();
    }

    public String getPolicyLimit() {
        return policyLimit;
    }

    public void setPolicyLimit(String policyLimit) {
        this.policyLimit = policyLimit == null ? null : policyLimit.trim();
    }

    public String getDisputeSolution() {
        return disputeSolution;
    }

    public void setDisputeSolution(String disputeSolution) {
        this.disputeSolution = disputeSolution == null ? null : disputeSolution.trim();
    }

    public String getPhMailingAddr() {
        return phMailingAddr;
    }

    public void setPhMailingAddr(String phMailingAddr) {
        this.phMailingAddr = phMailingAddr == null ? null : phMailingAddr.trim();
    }

    public String getAnnualRate() {
        return annualRate;
    }

    public void setAnnualRate(String annualRate) {
        this.annualRate = annualRate == null ? null : annualRate.trim();
    }

    public String getClauseWording() {
        return clauseWording;
    }

    public void setClauseWording(String clauseWording) {
        this.clauseWording = clauseWording == null ? null : clauseWording.trim();
    }

    public String getNps() {
        return nps;
    }

    public void setNps(String nps) {
        this.nps = nps == null ? null : nps.trim();
    }

    public String getClauseWording2() {
        return clauseWording2;
    }

    public void setClauseWording2(String clauseWording2) {
        this.clauseWording2 = clauseWording2 == null ? null : clauseWording2.trim();
    }

    public String getClauseWording3() {
        return clauseWording3;
    }

    public void setClauseWording3(String clauseWording3) {
        this.clauseWording3 = clauseWording3 == null ? null : clauseWording3.trim();
    }

    public String getPoiFlag() {
        return poiFlag;
    }

    public void setPoiFlag(String poiFlag) {
        this.poiFlag = poiFlag == null ? null : poiFlag.trim();
    }

    public String getPoiText() {
        return poiText;
    }

    public void setPoiText(String poiText) {
        this.poiText = poiText == null ? null : poiText.trim();
    }

    public String getHandlerUsername() {
        return handlerUsername;
    }

    public void setHandlerUsername(String handlerUsername) {
        this.handlerUsername = handlerUsername == null ? null : handlerUsername.trim();
    }

    public String getSumInsuredDesc() {
        return sumInsuredDesc;
    }

    public void setSumInsuredDesc(String sumInsuredDesc) {
        this.sumInsuredDesc = sumInsuredDesc == null ? null : sumInsuredDesc.trim();
    }

    public String getIndemnityPeriod() {
        return indemnityPeriod;
    }

    public void setIndemnityPeriod(String indemnityPeriod) {
        this.indemnityPeriod = indemnityPeriod == null ? null : indemnityPeriod.trim();
    }

    public String getShowPremiumFlag() {
        return showPremiumFlag;
    }

    public void setShowPremiumFlag(String showPremiumFlag) {
        this.showPremiumFlag = showPremiumFlag == null ? null : showPremiumFlag.trim();
    }

    public String getNonBinding() {
        return nonBinding;
    }

    public void setNonBinding(String nonBinding) {
        this.nonBinding = nonBinding == null ? null : nonBinding.trim();
    }

    public String getSalesTeam() {
        return salesTeam;
    }

    public void setSalesTeam(String salesTeam) {
        this.salesTeam = salesTeam == null ? null : salesTeam.trim();
    }

    public String getBusinessSource() {
        return businessSource;
    }

    public void setBusinessSource(String businessSource) {
        this.businessSource = businessSource == null ? null : businessSource.trim();
    }

    public String getGaiiQuoteNo() {
        return gaiiQuoteNo;
    }

    public void setGaiiQuoteNo(String gaiiQuoteNo) {
        this.gaiiQuoteNo = gaiiQuoteNo == null ? null : gaiiQuoteNo.trim();
    }

    public String getFixExch() {
        return fixExch;
    }

    public void setFixExch(String fixExch) {
        this.fixExch = fixExch == null ? null : fixExch.trim();
    }

    public String getAbroadDriveYn() {
        return abroadDriveYn;
    }

    public void setAbroadDriveYn(String abroadDriveYn) {
        this.abroadDriveYn = abroadDriveYn == null ? null : abroadDriveYn.trim();
    }
}