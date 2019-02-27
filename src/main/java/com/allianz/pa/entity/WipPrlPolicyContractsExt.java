package com.allianz.pa.entity;

import java.math.BigDecimal;
import java.util.Date;

public class WipPrlPolicyContractsExt {
    private Long contractId;

    private String actionCode;

    private Date contractDate;

    private Date quoteExpiryDate;

    private String masterFlag;

    private String businessType;

    private Long piParContract;

    private String renewable;

    private String businessClass;

    private Date quoteSentDate;

    private Integer policyPeriod;

    private Long prevQuoteContract;

    private String uwUsername;

    private Integer childSeqNo;

    private String prevPolicyRef;

    private Integer preRnPolver;

    private Long previousContract;

    private String policyOriginator;

    private String masterQuoteRef;

    private Integer previousVersionNo;

    private String previousSource;

    private Long previousGroupId;

    private String riType;

    private String renewalQuoteFlag;

    private String premRateWordings;

    private String poiFlagUndo;

    private String poiTextUndo;

    private Short renewalPeriod;

    private String coverNoteRef;

    private String pprPrintOnSch;

    private Short policySchSeqNo;

    private String certClause;

    private Short backDays;

    private BigDecimal groupId;

    private Date prevStartDate;

    private Date prevEndDate;

    private String groupMasterPolicy;

    private String reminderTo;

    private String reminderAllianzCc;

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

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public Date getQuoteExpiryDate() {
        return quoteExpiryDate;
    }

    public void setQuoteExpiryDate(Date quoteExpiryDate) {
        this.quoteExpiryDate = quoteExpiryDate;
    }

    public String getMasterFlag() {
        return masterFlag;
    }

    public void setMasterFlag(String masterFlag) {
        this.masterFlag = masterFlag == null ? null : masterFlag.trim();
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public Long getPiParContract() {
        return piParContract;
    }

    public void setPiParContract(Long piParContract) {
        this.piParContract = piParContract;
    }

    public String getRenewable() {
        return renewable;
    }

    public void setRenewable(String renewable) {
        this.renewable = renewable == null ? null : renewable.trim();
    }

    public String getBusinessClass() {
        return businessClass;
    }

    public void setBusinessClass(String businessClass) {
        this.businessClass = businessClass == null ? null : businessClass.trim();
    }

    public Date getQuoteSentDate() {
        return quoteSentDate;
    }

    public void setQuoteSentDate(Date quoteSentDate) {
        this.quoteSentDate = quoteSentDate;
    }

    public Integer getPolicyPeriod() {
        return policyPeriod;
    }

    public void setPolicyPeriod(Integer policyPeriod) {
        this.policyPeriod = policyPeriod;
    }

    public Long getPrevQuoteContract() {
        return prevQuoteContract;
    }

    public void setPrevQuoteContract(Long prevQuoteContract) {
        this.prevQuoteContract = prevQuoteContract;
    }

    public String getUwUsername() {
        return uwUsername;
    }

    public void setUwUsername(String uwUsername) {
        this.uwUsername = uwUsername == null ? null : uwUsername.trim();
    }

    public Integer getChildSeqNo() {
        return childSeqNo;
    }

    public void setChildSeqNo(Integer childSeqNo) {
        this.childSeqNo = childSeqNo;
    }

    public String getPrevPolicyRef() {
        return prevPolicyRef;
    }

    public void setPrevPolicyRef(String prevPolicyRef) {
        this.prevPolicyRef = prevPolicyRef == null ? null : prevPolicyRef.trim();
    }

    public Integer getPreRnPolver() {
        return preRnPolver;
    }

    public void setPreRnPolver(Integer preRnPolver) {
        this.preRnPolver = preRnPolver;
    }

    public Long getPreviousContract() {
        return previousContract;
    }

    public void setPreviousContract(Long previousContract) {
        this.previousContract = previousContract;
    }

    public String getPolicyOriginator() {
        return policyOriginator;
    }

    public void setPolicyOriginator(String policyOriginator) {
        this.policyOriginator = policyOriginator == null ? null : policyOriginator.trim();
    }

    public String getMasterQuoteRef() {
        return masterQuoteRef;
    }

    public void setMasterQuoteRef(String masterQuoteRef) {
        this.masterQuoteRef = masterQuoteRef == null ? null : masterQuoteRef.trim();
    }

    public Integer getPreviousVersionNo() {
        return previousVersionNo;
    }

    public void setPreviousVersionNo(Integer previousVersionNo) {
        this.previousVersionNo = previousVersionNo;
    }

    public String getPreviousSource() {
        return previousSource;
    }

    public void setPreviousSource(String previousSource) {
        this.previousSource = previousSource == null ? null : previousSource.trim();
    }

    public Long getPreviousGroupId() {
        return previousGroupId;
    }

    public void setPreviousGroupId(Long previousGroupId) {
        this.previousGroupId = previousGroupId;
    }

    public String getRiType() {
        return riType;
    }

    public void setRiType(String riType) {
        this.riType = riType == null ? null : riType.trim();
    }

    public String getRenewalQuoteFlag() {
        return renewalQuoteFlag;
    }

    public void setRenewalQuoteFlag(String renewalQuoteFlag) {
        this.renewalQuoteFlag = renewalQuoteFlag == null ? null : renewalQuoteFlag.trim();
    }

    public String getPremRateWordings() {
        return premRateWordings;
    }

    public void setPremRateWordings(String premRateWordings) {
        this.premRateWordings = premRateWordings == null ? null : premRateWordings.trim();
    }

    public String getPoiFlagUndo() {
        return poiFlagUndo;
    }

    public void setPoiFlagUndo(String poiFlagUndo) {
        this.poiFlagUndo = poiFlagUndo == null ? null : poiFlagUndo.trim();
    }

    public String getPoiTextUndo() {
        return poiTextUndo;
    }

    public void setPoiTextUndo(String poiTextUndo) {
        this.poiTextUndo = poiTextUndo == null ? null : poiTextUndo.trim();
    }

    public Short getRenewalPeriod() {
        return renewalPeriod;
    }

    public void setRenewalPeriod(Short renewalPeriod) {
        this.renewalPeriod = renewalPeriod;
    }

    public String getCoverNoteRef() {
        return coverNoteRef;
    }

    public void setCoverNoteRef(String coverNoteRef) {
        this.coverNoteRef = coverNoteRef == null ? null : coverNoteRef.trim();
    }

    public String getPprPrintOnSch() {
        return pprPrintOnSch;
    }

    public void setPprPrintOnSch(String pprPrintOnSch) {
        this.pprPrintOnSch = pprPrintOnSch == null ? null : pprPrintOnSch.trim();
    }

    public Short getPolicySchSeqNo() {
        return policySchSeqNo;
    }

    public void setPolicySchSeqNo(Short policySchSeqNo) {
        this.policySchSeqNo = policySchSeqNo;
    }

    public String getCertClause() {
        return certClause;
    }

    public void setCertClause(String certClause) {
        this.certClause = certClause == null ? null : certClause.trim();
    }

    public Short getBackDays() {
        return backDays;
    }

    public void setBackDays(Short backDays) {
        this.backDays = backDays;
    }

    public BigDecimal getGroupId() {
        return groupId;
    }

    public void setGroupId(BigDecimal groupId) {
        this.groupId = groupId;
    }

    public Date getPrevStartDate() {
        return prevStartDate;
    }

    public void setPrevStartDate(Date prevStartDate) {
        this.prevStartDate = prevStartDate;
    }

    public Date getPrevEndDate() {
        return prevEndDate;
    }

    public void setPrevEndDate(Date prevEndDate) {
        this.prevEndDate = prevEndDate;
    }

    public String getGroupMasterPolicy() {
        return groupMasterPolicy;
    }

    public void setGroupMasterPolicy(String groupMasterPolicy) {
        this.groupMasterPolicy = groupMasterPolicy == null ? null : groupMasterPolicy.trim();
    }

    public String getReminderTo() {
        return reminderTo;
    }

    public void setReminderTo(String reminderTo) {
        this.reminderTo = reminderTo == null ? null : reminderTo.trim();
    }

    public String getReminderAllianzCc() {
        return reminderAllianzCc;
    }

    public void setReminderAllianzCc(String reminderAllianzCc) {
        this.reminderAllianzCc = reminderAllianzCc == null ? null : reminderAllianzCc.trim();
    }
}