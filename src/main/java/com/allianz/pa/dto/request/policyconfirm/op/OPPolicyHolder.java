package com.allianz.pa.dto.request.policyconfirm.op;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OPPolicyHolder {
    @JsonProperty("policyHolderType")
    private String clientRef;
    
    @JsonProperty("policyHolderName")
    private String longName;
    
    @JsonProperty("policyHolderIdType")
    private Integer roleTypeId;
    
    @JsonProperty("policyHolderIdNumber")
    private String policyNo;
    
    @JsonProperty("policyHolderBirthDate")
    private Date birthDate;
    
    @JsonProperty("policyHolderTelephone")
    private String hotlineTelNo;
    
    @JsonProperty("policyHolderAddress")
    private String overrideAddress;
    
    @JsonProperty("policyHolderPostCode")
    private String periodOfInsurance;
    
    @JsonProperty("policyHolderEmail")
    private String remark;
    
    @JsonProperty("reqElecFaPiao")
    private String reqElecFaPiao;
    
    @JsonProperty("invoiceTitle")
    private String insuredBusiness;
    
    @JsonProperty("policyHolderCode")
    private String partnerRef;

	public String getClientRef() {
		return clientRef;
	}

	public void setClientRef(String clientRef) {
		this.clientRef = clientRef;
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public Integer getRoleTypeId() {
		return roleTypeId;
	}

	public void setRoleTypeId(Integer roleTypeId) {
		this.roleTypeId = roleTypeId;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getHotlineTelNo() {
		return hotlineTelNo;
	}

	public void setHotlineTelNo(String hotlineTelNo) {
		this.hotlineTelNo = hotlineTelNo;
	}

	public String getOverrideAddress() {
		return overrideAddress;
	}

	public void setOverrideAddress(String overrideAddress) {
		this.overrideAddress = overrideAddress;
	}

	public String getPeriodOfInsurance() {
		return periodOfInsurance;
	}

	public void setPeriodOfInsurance(String periodOfInsurance) {
		this.periodOfInsurance = periodOfInsurance;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getReqElecFaPiao() {
		return reqElecFaPiao;
	}

	public void setReqElecFaPiao(String reqElecFaPiao) {
		this.reqElecFaPiao = reqElecFaPiao;
	}

	public String getInsuredBusiness() {
		return insuredBusiness;
	}

	public void setInsuredBusiness(String insuredBusiness) {
		this.insuredBusiness = insuredBusiness;
	}

	public String getPartnerRef() {
		return partnerRef;
	}

	public void setPartnerRef(String partnerRef) {
		this.partnerRef = partnerRef;
	}
}
