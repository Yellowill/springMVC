package com.allianz.pa.entity;

import java.util.Date;

public class PrlThirdpInterfPolData extends PrlThirdpInterfPolDataKey {
    private Long contractId;

    private String insuredBeneficialtype;

    private String emergencyContactName;

    private String emergencyMobile;

    private String sex;

    private String relationship;

    private String benefName;

    private String remark;

    private String state;

    private String insuredSex;

    private String merchantAcctId;

    private String gatewayVersion;

    private Short signType;

    private String orderId;

    private Date orderTime;

    private Short orderAmount;

    private String dealId;

    private Short requestResult;

    private String signMsg;

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getInsuredBeneficialtype() {
        return insuredBeneficialtype;
    }

    public void setInsuredBeneficialtype(String insuredBeneficialtype) {
        this.insuredBeneficialtype = insuredBeneficialtype == null ? null : insuredBeneficialtype.trim();
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName == null ? null : emergencyContactName.trim();
    }

    public String getEmergencyMobile() {
        return emergencyMobile;
    }

    public void setEmergencyMobile(String emergencyMobile) {
        this.emergencyMobile = emergencyMobile == null ? null : emergencyMobile.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship == null ? null : relationship.trim();
    }

    public String getBenefName() {
        return benefName;
    }

    public void setBenefName(String benefName) {
        this.benefName = benefName == null ? null : benefName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getInsuredSex() {
        return insuredSex;
    }

    public void setInsuredSex(String insuredSex) {
        this.insuredSex = insuredSex == null ? null : insuredSex.trim();
    }

    public String getMerchantAcctId() {
        return merchantAcctId;
    }

    public void setMerchantAcctId(String merchantAcctId) {
        this.merchantAcctId = merchantAcctId == null ? null : merchantAcctId.trim();
    }

    public String getGatewayVersion() {
        return gatewayVersion;
    }

    public void setGatewayVersion(String gatewayVersion) {
        this.gatewayVersion = gatewayVersion == null ? null : gatewayVersion.trim();
    }

    public Short getSignType() {
        return signType;
    }

    public void setSignType(Short signType) {
        this.signType = signType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Short getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Short orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId == null ? null : dealId.trim();
    }

    public Short getRequestResult() {
        return requestResult;
    }

    public void setRequestResult(Short requestResult) {
        this.requestResult = requestResult;
    }

    public String getSignMsg() {
        return signMsg;
    }

    public void setSignMsg(String signMsg) {
        this.signMsg = signMsg == null ? null : signMsg.trim();
    }
}