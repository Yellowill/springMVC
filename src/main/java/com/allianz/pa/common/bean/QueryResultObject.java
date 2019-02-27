package com.allianz.pa.common.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.allianz.pa.dto.common.standard.InsuredPremium;
import com.allianz.pa.dto.common.standard.UnderwritingDecision;

import oracle.sql.CLOB;

public class QueryResultObject {
	private Long contractId;

	private Long sequenceValue;

	private Integer versionNo;

	private String policyHolderType;

	private String policyHolderName;

	private String policyHolderIdType;

	private String policyHolderIdNumber;

	private Date policyHolderBirthDate;

	private String policyHolderPhoneNo;

	private String policyHolderAddress;

	private String policyHolderPostCode;

	private String policyHolderEmail;

	private String reqFaPiao;

	private String policyRef;

	private String planCode;

	private Date issueDate;

	private Date effectiveDate;

	private Date expireDate;

	private String destination;

	private String groupSize;

	private String remark;

	private String premiumCalType;

	private BigDecimal totalPremium;

	private Integer policyStatus;

	private String insuredId;

	private String insuredType;

	private String insuredName;

	private String idType;

	private String idNumber;

	private Date birthDate;

	private String mobile;

	private String email;

	private String gender;

	private String premium;

	private String beneficialType;

	private String contactName;

	private String beneficiaryName;

	private String relationShip;

	private String percentage;

	private Integer iseffective;

	private CLOB clob;

	private String country;

	private String province;

	private String city;

	private String subcity;

	private String area;

	private String street;

	private String postcode;

	private String branchCode;

	private String planId;

	private String planStatus;

	private String planName;

	private String typeOfPlan;

	private String planVersion;

	private String planType;

	private String premCalMethod;

	private String currency;

	private String deductible;

	private String benefitCode;

	private String benefitName;

	private BigDecimal sumInsured;

	private String subLimit;

	private String deductibleDays;

	private String maxPaymentDays;

	private String dailyPaymentAmt;

	private String salesName;

	private String salesLicenseNo;

	private BigDecimal basicPrem;

	private String startDay;

	private String endDay;

	private String remarkID;

	private String remarkNameZHS;

	private String agencyCode;

	private String policyOriginator;

	private String occupationClass;

	private String groupPlanCode;

	private String groupPlanName;

	private String minAge;

	private String maxAge;

	private String insuredAndPolicyholderRelation;
	
	private Date endorseEffectiveDate;
	
    private List<InsuredPremium> insuredPremiumList;
    
    private List<UnderwritingDecision> underwritingDecisionList;
    
    private BigDecimal count;
    
    private BigDecimal age;
    
    private BigDecimal adjustmentPremium;

	public BigDecimal getAdjustmentPremium() {
		return adjustmentPremium;
	}

	public void setAdjustmentPremium(BigDecimal adjustmentPremium) {
		this.adjustmentPremium = adjustmentPremium;
	}

	public BigDecimal getCount() {
		return count;
	}

	public void setCount(BigDecimal count) {
		this.count = count;
	}

	public BigDecimal getAge() {
		return age;
	}

	public void setAge(BigDecimal age) {
		this.age = age;
	}

	public List<InsuredPremium> getInsuredPremiumList() {
		return insuredPremiumList;
	}

	public void setInsuredPremiumList(List<InsuredPremium> insuredPremiumList) {
		this.insuredPremiumList = insuredPremiumList;
	}

	public List<UnderwritingDecision> getUnderwritingDecisionList() {
		return underwritingDecisionList;
	}

	public void setUnderwritingDecisionList(List<UnderwritingDecision> underwritingDecisionList) {
		this.underwritingDecisionList = underwritingDecisionList;
	}

	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public Integer getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}

	public String getPolicyHolderType() {
		return policyHolderType;
	}

	public void setPolicyHolderType(String policyHolderType) {
		this.policyHolderType = policyHolderType;
	}

	public String getPolicyHolderName() {
		return policyHolderName;
	}

	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}

	public String getPolicyHolderIdType() {
		return policyHolderIdType;
	}

	public void setPolicyHolderIdType(String policyHolderIdType) {
		this.policyHolderIdType = policyHolderIdType;
	}

	public String getPolicyHolderIdNumber() {
		return policyHolderIdNumber;
	}

	public void setPolicyHolderIdNumber(String policyHolderIdNumber) {
		this.policyHolderIdNumber = policyHolderIdNumber;
	}

	public Date getPolicyHolderBirthDate() {
		return policyHolderBirthDate;
	}

	public void setPolicyHolderBirthDate(Date policyHolderBirthDate) {
		this.policyHolderBirthDate = policyHolderBirthDate;
	}

	public String getPolicyHolderPhoneNo() {
		return policyHolderPhoneNo;
	}

	public void setPolicyHolderPhoneNo(String policyHolderPhoneNo) {
		this.policyHolderPhoneNo = policyHolderPhoneNo;
	}

	public String getPolicyHolderAddress() {
		return policyHolderAddress;
	}

	public void setPolicyHolderAddress(String policyHolderAddress) {
		this.policyHolderAddress = policyHolderAddress;
	}

	public String getPolicyHolderPostCode() {
		return policyHolderPostCode;
	}

	public void setPolicyHolderPostCode(String policyHolderPostCode) {
		this.policyHolderPostCode = policyHolderPostCode;
	}

	public String getPolicyHolderEmail() {
		return policyHolderEmail;
	}

	public void setPolicyHolderEmail(String policyHolderEmail) {
		this.policyHolderEmail = policyHolderEmail;
	}

	public String getReqFaPiao() {
		return reqFaPiao;
	}

	public void setReqFaPiao(String reqFaPiao) {
		this.reqFaPiao = reqFaPiao;
	}

	public String getPolicyRef() {
		return policyRef;
	}

	public void setPolicyRef(String policyRef) {
		this.policyRef = policyRef;
	}

	public String getPlanCode() {
		return planCode;
	}

	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getGroupSize() {
		return groupSize;
	}

	public void setGroupSize(String groupSize) {
		this.groupSize = groupSize;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPremiumCalType() {
		return premiumCalType;
	}

	public void setPremiumCalType(String premiumCalType) {
		this.premiumCalType = premiumCalType;
	}

	public BigDecimal getTotalPremium() {
		return totalPremium;
	}

	public void setTotalPremium(BigDecimal totalPremium) {
		this.totalPremium = totalPremium;
	}

	public Integer getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(Integer policyStatus) {
		this.policyStatus = policyStatus;
	}

	public String getInsuredId() {
		return insuredId;
	}

	public void setInsuredId(String insuredId) {
		this.insuredId = insuredId;
	}

	public String getInsuredType() {
		return insuredType;
	}

	public void setInsuredType(String insuredType) {
		this.insuredType = insuredType;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPremium() {
		return premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	public String getBeneficialType() {
		return beneficialType;
	}

	public void setBeneficialType(String beneficialType) {
		this.beneficialType = beneficialType;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getRelationShip() {
		return relationShip;
	}

	public void setRelationShip(String relationShip) {
		this.relationShip = relationShip;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public Integer getIseffective() {
		return iseffective;
	}

	public void setIseffective(Integer iseffective) {
		this.iseffective = iseffective;
	}

	public CLOB getClob() {
		return clob;
	}

	public void setClob(CLOB clob) {
		this.clob = clob;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSubcity() {
		return subcity;
	}

	public void setSubcity(String subcity) {
		this.subcity = subcity;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getTypeOfPlan() {
		return typeOfPlan;
	}

	public void setTypeOfPlan(String typeOfPlan) {
		this.typeOfPlan = typeOfPlan;
	}

	public String getPlanVersion() {
		return planVersion;
	}

	public void setPlanVersion(String planVersion) {
		this.planVersion = planVersion;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getPremCalMethod() {
		return premCalMethod;
	}

	public void setPremCalMethod(String premCalMethod) {
		this.premCalMethod = premCalMethod;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDeductible() {
		return deductible;
	}

	public void setDeductible(String deductible) {
		this.deductible = deductible;
	}

	public String getBenefitCode() {
		return benefitCode;
	}

	public void setBenefitCode(String benefitCode) {
		this.benefitCode = benefitCode;
	}

	public String getBenefitName() {
		return benefitName;
	}

	public void setBenefitName(String benefitName) {
		this.benefitName = benefitName;
	}

	public BigDecimal getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(BigDecimal sumInsured) {
		this.sumInsured = sumInsured;
	}

	public String getSubLimit() {
		return subLimit;
	}

	public void setSubLimit(String subLimit) {
		this.subLimit = subLimit;
	}

	public String getDeductibleDays() {
		return deductibleDays;
	}

	public void setDeductibleDays(String deductibleDays) {
		this.deductibleDays = deductibleDays;
	}

	public String getMaxPaymentDays() {
		return maxPaymentDays;
	}

	public void setMaxPaymentDays(String maxPaymentDays) {
		this.maxPaymentDays = maxPaymentDays;
	}

	public String getDailyPaymentAmt() {
		return dailyPaymentAmt;
	}

	public void setDailyPaymentAmt(String dailyPaymentAmt) {
		this.dailyPaymentAmt = dailyPaymentAmt;
	}

	public String getSalesName() {
		return salesName;
	}

	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}

	public String getSalesLicenseNo() {
		return salesLicenseNo;
	}

	public void setSalesLicenseNo(String salesLicenseNo) {
		this.salesLicenseNo = salesLicenseNo;
	}

	public BigDecimal getBasicPrem() {
		return basicPrem;
	}

	public void setBasicPrem(BigDecimal basicPrem) {
		this.basicPrem = basicPrem;
	}

	public String getStartDay() {
		return startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public String getRemarkID() {
		return remarkID;
	}

	public void setRemarkID(String remarkID) {
		this.remarkID = remarkID;
	}

	public String getRemarkNameZHS() {
		return remarkNameZHS;
	}

	public void setRemarkNameZHS(String remarkNameZHS) {
		this.remarkNameZHS = remarkNameZHS;
	}

	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}

	public String getPolicyOriginator() {
		return policyOriginator;
	}

	public void setPolicyOriginator(String policyOriginator) {
		this.policyOriginator = policyOriginator;
	}

	public String getOccupationClass() {
		return occupationClass;
	}

	public void setOccupationClass(String occupationClass) {
		this.occupationClass = occupationClass;
	}

	public String getGroupPlanCode() {
		return groupPlanCode;
	}

	public void setGroupPlanCode(String groupPlanCode) {
		this.groupPlanCode = groupPlanCode;
	}

	public String getGroupPlanName() {
		return groupPlanName;
	}

	public void setGroupPlanName(String groupPlanName) {
		this.groupPlanName = groupPlanName;
	}

	public String getMinAge() {
		return minAge;
	}

	public void setMinAge(String minAge) {
		this.minAge = minAge;
	}

	public String getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(String maxAge) {
		this.maxAge = maxAge;
	}

	public String getInsuredAndPolicyholderRelation() {
		return insuredAndPolicyholderRelation;
	}

	public void setInsuredAndPolicyholderRelation(
			String insuredAndPolicyholderRelation) {
		this.insuredAndPolicyholderRelation = insuredAndPolicyholderRelation;
	}

	public Long getSequenceValue() {
		return sequenceValue;
	}

	public void setSequenceValue(Long sequenceValue) {
		this.sequenceValue = sequenceValue;
	}

	public Date getEndorseEffectiveDate() {
		return endorseEffectiveDate;
	}

	public void setEndorseEffectiveDate(Date endorseEffectiveDate) {
		this.endorseEffectiveDate = endorseEffectiveDate;
	}

}
