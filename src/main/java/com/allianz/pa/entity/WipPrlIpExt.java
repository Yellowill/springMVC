package com.allianz.pa.entity;

public class WipPrlIpExt extends WipPrlIpExtKey {
	private String actionCode;

    private Integer versionNo;

    private Long objectId;

    private String topIndicator;

    private Integer previousVersion;

    private Integer reversingVersion;

    private Short hfeePct;

    private Short hfeeAmt;

    private String longName;

    private String insuredBusiness;

    private Short hfeeGstPct;

    private Short hfeeGstAmt;

    private Short hfeeGstRate;

    private Integer roleTypeId;

    private String dspOccupation;

    private String occupation;

    private String clientRef;

    private String handlerRef;

    private String overrideAddress;

    private String hotlineTelNo;

    private String periodOfInsurance;

    private String policyNo;

    private String arrangedByUs;

    private String limit;

    private String deductible;

    private Short premium;

    private String clauses;

    private String remark;

    private String insuredOverwriteFlag;

    private String showCommFlag;

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

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
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

    public Short getHfeePct() {
        return hfeePct;
    }

    public void setHfeePct(Short hfeePct) {
        this.hfeePct = hfeePct;
    }

    public Short getHfeeAmt() {
        return hfeeAmt;
    }

    public void setHfeeAmt(Short hfeeAmt) {
        this.hfeeAmt = hfeeAmt;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName == null ? null : longName.trim();
    }

    public String getInsuredBusiness() {
        return insuredBusiness;
    }

    public void setInsuredBusiness(String insuredBusiness) {
        this.insuredBusiness = insuredBusiness == null ? null : insuredBusiness.trim();
    }

    public Short getHfeeGstPct() {
        return hfeeGstPct;
    }

    public void setHfeeGstPct(Short hfeeGstPct) {
        this.hfeeGstPct = hfeeGstPct;
    }

    public Short getHfeeGstAmt() {
        return hfeeGstAmt;
    }

    public void setHfeeGstAmt(Short hfeeGstAmt) {
        this.hfeeGstAmt = hfeeGstAmt;
    }

    public Short getHfeeGstRate() {
        return hfeeGstRate;
    }

    public void setHfeeGstRate(Short hfeeGstRate) {
        this.hfeeGstRate = hfeeGstRate;
    }

    public Integer getRoleTypeId() {
        return roleTypeId;
    }

    public void setRoleTypeId(Integer roleTypeId) {
        this.roleTypeId = roleTypeId;
    }

    public String getDspOccupation() {
        return dspOccupation;
    }

    public void setDspOccupation(String dspOccupation) {
        this.dspOccupation = dspOccupation == null ? null : dspOccupation.trim();
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation == null ? null : occupation.trim();
    }

    public String getClientRef() {
        return clientRef;
    }

    public void setClientRef(String clientRef) {
        this.clientRef = clientRef == null ? null : clientRef.trim();
    }

    public String getHandlerRef() {
        return handlerRef;
    }

    public void setHandlerRef(String handlerRef) {
        this.handlerRef = handlerRef == null ? null : handlerRef.trim();
    }

    public String getOverrideAddress() {
        return overrideAddress;
    }

    public void setOverrideAddress(String overrideAddress) {
        this.overrideAddress = overrideAddress == null ? null : overrideAddress.trim();
    }

    public String getHotlineTelNo() {
        return hotlineTelNo;
    }

    public void setHotlineTelNo(String hotlineTelNo) {
        this.hotlineTelNo = hotlineTelNo == null ? null : hotlineTelNo.trim();
    }

    public String getPeriodOfInsurance() {
        return periodOfInsurance;
    }

    public void setPeriodOfInsurance(String periodOfInsurance) {
        this.periodOfInsurance = periodOfInsurance == null ? null : periodOfInsurance.trim();
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo == null ? null : policyNo.trim();
    }

    public String getArrangedByUs() {
        return arrangedByUs;
    }

    public void setArrangedByUs(String arrangedByUs) {
        this.arrangedByUs = arrangedByUs == null ? null : arrangedByUs.trim();
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit == null ? null : limit.trim();
    }

    public String getDeductible() {
        return deductible;
    }

    public void setDeductible(String deductible) {
        this.deductible = deductible == null ? null : deductible.trim();
    }

    public Short getPremium() {
        return premium;
    }

    public void setPremium(Short premium) {
        this.premium = premium;
    }

    public String getClauses() {
        return clauses;
    }

    public void setClauses(String clauses) {
        this.clauses = clauses == null ? null : clauses.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getInsuredOverwriteFlag() {
        return insuredOverwriteFlag;
    }

    public void setInsuredOverwriteFlag(String insuredOverwriteFlag) {
        this.insuredOverwriteFlag = insuredOverwriteFlag == null ? null : insuredOverwriteFlag.trim();
    }

    public String getShowCommFlag() {
        return showCommFlag;
    }

    public void setShowCommFlag(String showCommFlag) {
        this.showCommFlag = showCommFlag == null ? null : showCommFlag.trim();
    }
}