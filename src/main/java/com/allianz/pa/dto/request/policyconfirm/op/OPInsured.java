package com.allianz.pa.dto.request.policyconfirm.op;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OPInsured {
    @JsonProperty("insuredId")
    private String partInsuredId;  
    
    @JsonProperty("insuredName")
    private String name;
    
    @JsonProperty("insuredType")
    private String insuredType;
    
    @JsonProperty("insuredIdType")
    private Integer idType;
    
    @JsonProperty("insuredIdNumber")
    private String idNo;
    
    @JsonProperty("insuredBirthDate")
    private Date dob;
    
    @JsonProperty("insuredMobile")
    private String mobileNo;
    
    @JsonProperty("insuredEmail")
    private String email;
    
    @JsonProperty("insuredGender")
    private String sex;
    
    @JsonProperty("beneficialType")
    private String beneficialType;
    
    private String occupationCode;
    
    //被保险人与投保人关系
    private String withPolicyholderRelation;
    
    private String resideProvince;
    
    private String resideCity;
    
    private String resideAddress;
    
    private String jdAccount;
    
    @JsonProperty("insuredCode")
    private String partnerRef;
    
    private Date wteStartDate;
    
    private Date wteEndDate;
    
    private List<OPInsuredRisk> insuredRiskList;

	public String getPartInsuredId() {
		return partInsuredId;
	}

	public void setPartInsuredId(String partInsuredId) {
		this.partInsuredId = partInsuredId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInsuredType() {
		return insuredType;
	}

	public void setInsuredType(String insuredType) {
		this.insuredType = insuredType;
	}

	public Integer getIdType() {
		return idType;
	}

	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBeneficialType() {
		return beneficialType;
	}

	public void setBeneficialType(String beneficialType) {
		this.beneficialType = beneficialType;
	}

	public String getOccupationCode() {
		return occupationCode;
	}

	public void setOccupationCode(String occupationCode) {
		this.occupationCode = occupationCode;
	}

	public String getWithPolicyholderRelation() {
		return withPolicyholderRelation;
	}

	public void setWithPolicyholderRelation(String withPolicyholderRelation) {
		this.withPolicyholderRelation = withPolicyholderRelation;
	}

	public String getResideProvince() {
		return resideProvince;
	}

	public void setResideProvince(String resideProvince) {
		this.resideProvince = resideProvince;
	}

	public String getResideCity() {
		return resideCity;
	}

	public void setResideCity(String resideCity) {
		this.resideCity = resideCity;
	}

	public String getResideAddress() {
		return resideAddress;
	}

	public void setResideAddress(String resideAddress) {
		this.resideAddress = resideAddress;
	}

	public String getJdAccount() {
		return jdAccount;
	}

	public void setJdAccount(String jdAccount) {
		this.jdAccount = jdAccount;
	}

	public List<OPInsuredRisk> getInsuredRiskList() {
		return insuredRiskList;
	}

	public void setInsuredRiskList(List<OPInsuredRisk> insuredRiskList) {
		this.insuredRiskList = insuredRiskList;
	}

	public String getPartnerRef() {
		return partnerRef;
	}

	public void setPartnerRef(String partnerRef) {
		this.partnerRef = partnerRef;
	}

	public Date getWteStartDate() {
		return wteStartDate;
	}

	public void setWteStartDate(Date wteStartDate) {
		this.wteStartDate = wteStartDate;
	}

	public Date getWteEndDate() {
		return wteEndDate;
	}

	public void setWteEndDate(Date wteEndDate) {
		this.wteEndDate = wteEndDate;
	}

}
