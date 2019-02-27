package com.allianz.pa.entity;

import java.util.Date;

public class WipPolicyBases {
    private Long contractId;

    private String actionCode;

    private Integer versionNo;

    private Long companyId;

    private String policyRef;

    private String topIndicator;

    private Integer previousVersion;

    private Integer reversingVersion;

    private Date termStartDate;

    private Date termEndDate;

    private String billTypeMethodOfPayment;

    private String coinsuranceLeadFollower;

    private Integer companyOrgUnit;

    private Long agentRole;

    private String frequencyPaymentPlan;

    private String companyFund;

    private Long groupId;

    private String otherCompanyReference;

    private Long producerRole;

    private String taxStatus;

    private String accountNo;

    private String geographicScope;

    private String bookingFrequency;

    private String manualReinsInd;

    private String manualCoinsInd;

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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getPolicyRef() {
        return policyRef;
    }

    public void setPolicyRef(String policyRef) {
        this.policyRef = policyRef == null ? null : policyRef.trim();
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

    public Date getTermStartDate() {
        return termStartDate;
    }

    public void setTermStartDate(Date termStartDate) {
        this.termStartDate = termStartDate;
    }

    public Date getTermEndDate() {
        return termEndDate;
    }

    public void setTermEndDate(Date termEndDate) {
        this.termEndDate = termEndDate;
    }

    public String getBillTypeMethodOfPayment() {
        return billTypeMethodOfPayment;
    }

    public void setBillTypeMethodOfPayment(String billTypeMethodOfPayment) {
        this.billTypeMethodOfPayment = billTypeMethodOfPayment == null ? null : billTypeMethodOfPayment.trim();
    }

    public String getCoinsuranceLeadFollower() {
        return coinsuranceLeadFollower;
    }

    public void setCoinsuranceLeadFollower(String coinsuranceLeadFollower) {
        this.coinsuranceLeadFollower = coinsuranceLeadFollower == null ? null : coinsuranceLeadFollower.trim();
    }

    public Integer getCompanyOrgUnit() {
        return companyOrgUnit;
    }

    public void setCompanyOrgUnit(Integer companyOrgUnit) {
        this.companyOrgUnit = companyOrgUnit;
    }

    public Long getAgentRole() {
        return agentRole;
    }

    public void setAgentRole(Long agentRole) {
        this.agentRole = agentRole;
    }

    public String getFrequencyPaymentPlan() {
        return frequencyPaymentPlan;
    }

    public void setFrequencyPaymentPlan(String frequencyPaymentPlan) {
        this.frequencyPaymentPlan = frequencyPaymentPlan == null ? null : frequencyPaymentPlan.trim();
    }

    public String getCompanyFund() {
        return companyFund;
    }

    public void setCompanyFund(String companyFund) {
        this.companyFund = companyFund == null ? null : companyFund.trim();
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getOtherCompanyReference() {
        return otherCompanyReference;
    }

    public void setOtherCompanyReference(String otherCompanyReference) {
        this.otherCompanyReference = otherCompanyReference == null ? null : otherCompanyReference.trim();
    }

    public Long getProducerRole() {
        return producerRole;
    }

    public void setProducerRole(Long producerRole) {
        this.producerRole = producerRole;
    }

    public String getTaxStatus() {
        return taxStatus;
    }

    public void setTaxStatus(String taxStatus) {
        this.taxStatus = taxStatus == null ? null : taxStatus.trim();
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    public String getGeographicScope() {
        return geographicScope;
    }

    public void setGeographicScope(String geographicScope) {
        this.geographicScope = geographicScope == null ? null : geographicScope.trim();
    }

    public String getBookingFrequency() {
        return bookingFrequency;
    }

    public void setBookingFrequency(String bookingFrequency) {
        this.bookingFrequency = bookingFrequency == null ? null : bookingFrequency.trim();
    }

    public String getManualReinsInd() {
        return manualReinsInd;
    }

    public void setManualReinsInd(String manualReinsInd) {
        this.manualReinsInd = manualReinsInd == null ? null : manualReinsInd.trim();
    }

    public String getManualCoinsInd() {
        return manualCoinsInd;
    }

    public void setManualCoinsInd(String manualCoinsInd) {
        this.manualCoinsInd = manualCoinsInd == null ? null : manualCoinsInd.trim();
    }
}