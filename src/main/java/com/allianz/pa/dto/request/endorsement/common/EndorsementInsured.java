package com.allianz.pa.dto.request.endorsement.common;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.allianz.pa.dto.common.standard.BeneficiaryVO;
import com.allianz.pa.dto.common.standard.ContactPersonVO;

public class EndorsementInsured {
//	@Pattern(regexp="^(1|2|3)$",message="1099") 核保的时候为空需要查询结果，出单的时候非空需要校验正确性，所以这里不做校验
//	@NotNull(message="0001")
    private String insuredType;
    
//	@Pattern(regexp="^[0-9]*$",message="0005")
	@NotNull(message="0001")
    private String insuredId;

    private String flightNo;

    private String flightCompany;

    private String flightDepCode;

    private String flightArrCode;

    private String flightDepCity;

    private String flightArrCity;

    private Date flightDepTimePlan;

    private Date flightArrTimePlan;

    @Valid
    private List<BeneficiaryVO> beneficiaryList;

    @Valid
    private List<ContactPersonVO> emergencyContactList;
    
    private String occupation;
    
    private String occupationCode;
    
    @NotNull(message="0001")
    private String insuredName;
    
    @Pattern(regexp="^(1|2|3)$",message="1099")
    @NotNull(message="0001")
    private String idType;
    
    @NotNull(message="0001")
    private String idNumber;
    
    @DateTimeFormat(pattern = "yyyyMMddHHmmss")
    @NotNull(message="0001")
    private Date birthDate;
    
    private String mobile;
    
    private String email;
    
    private String gender;
    
    @Pattern(regexp="^(1|2|3|4)$",message="1099")
    @NotNull(message="0001")
    private String beneficialType;
    
    @Pattern(regexp="^(A|C|D)$",message="1099")
    @NotNull(message="0001")
    private String actionCode;
    
    @DateTimeFormat(pattern = "yyyyMMddHHmmss")
//    @Pattern(regexp="[0-9]{4}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}",message="0002,yyyyMMddHHmmss")
    @NotNull(message="0001")
    private Date startDate;
    
    private Date effectiveDate;

    @DateTimeFormat(pattern = "yyyyMMddHHmmss")
    @NotNull(message="0001")
    private Date endDate;
    
    private Date expireDate;
    
    private String settleCompany;
    
    private String settleCompanyName;
    
    private String rid;
    
    private BigDecimal premium;
    
    private String resideProvince;

    private String resideCity;
    
    private String resideAddress;
    
    @Pattern(regexp="^(06|07)$",message="1099")
    private String policyholderRelation;
    
    private String employeeStaffCode;
    
    @Pattern(regexp="^[0-9]*$",message="1099")
    private String bodyMassIndex;
    
    @Pattern(regexp="^(EA_BA|Ur_BA)$",message="1099")
    private String highestEducation;
    
    @Pattern(regexp="^(LT10|10T20|GT20)$",message="1099")
    private String annualIncome;
    
    @Pattern(regexp="^(LT2|2T4|4T8|GT8)$",message="1099")
    private String dailyAverageAlcohols;
    
    @Pattern(regexp="^(EQ0|LT15|15T25|GT25)$",message="1099")
    private String dailyAverageCigarettes;
    
    @Pattern(regexp="^(Y|N)$",message="1099")
    private String relativesDiagnoseCancerYn;
    
    private String remark1;
    
    private String remark2;
    
    
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

	public String getPolicyholderRelation() {
		return policyholderRelation;
	}

	public void setPolicyholderRelation(String policyholderRelation) {
		this.policyholderRelation = policyholderRelation;
	}

	public String getEmployeeStaffCode() {
		return employeeStaffCode;
	}

	public void setEmployeeStaffCode(String employeeStaffCode) {
		this.employeeStaffCode = employeeStaffCode;
	}

	public String getBodyMassIndex() {
		return bodyMassIndex;
	}

	public void setBodyMassIndex(String bodyMassIndex) {
		this.bodyMassIndex = bodyMassIndex;
	}

	public String getHighestEducation() {
		return highestEducation;
	}

	public void setHighestEducation(String highestEducation) {
		this.highestEducation = highestEducation;
	}

	public String getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(String annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getDailyAverageAlcohols() {
		return dailyAverageAlcohols;
	}

	public void setDailyAverageAlcohols(String dailyAverageAlcohols) {
		this.dailyAverageAlcohols = dailyAverageAlcohols;
	}

	public String getDailyAverageCigarettes() {
		return dailyAverageCigarettes;
	}

	public void setDailyAverageCigarettes(String dailyAverageCigarettes) {
		this.dailyAverageCigarettes = dailyAverageCigarettes;
	}

	public String getRelativesDiagnoseCancerYn() {
		return relativesDiagnoseCancerYn;
	}

	public void setRelativesDiagnoseCancerYn(String relativesDiagnoseCancerYn) {
		this.relativesDiagnoseCancerYn = relativesDiagnoseCancerYn;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public BigDecimal getPremium() {
		return premium;
	}

	public void setPremium(BigDecimal premium) {
		this.premium = premium;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getOccupationCode() {
		return occupationCode;
	}

	public void setOccupationCode(String occupationCode) {
		this.occupationCode = occupationCode;
	}

	public List<BeneficiaryVO> getBeneficiaryList() {
		return beneficiaryList;
	}

	public void setBeneficiaryList(List<BeneficiaryVO> beneficiaryList) {
		this.beneficiaryList = beneficiaryList;
	}

	public List<ContactPersonVO> getEmergencyContactList() {
		return emergencyContactList;
	}

	public void setEmergencyContactList(List<ContactPersonVO> emergencyContactList) {
		this.emergencyContactList = emergencyContactList;
	}

	public String getInsuredType() {
		return insuredType;
	}

	public void setInsuredType(String insuredType) {
		this.insuredType = insuredType;
	}

	public String getInsuredId() {
		return insuredId;
	}

	public void setInsuredId(String insuredId) {
		this.insuredId = insuredId;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getFlightCompany() {
		return flightCompany;
	}

	public void setFlightCompany(String flightCompany) {
		this.flightCompany = flightCompany;
	}

	public String getFlightDepCode() {
		return flightDepCode;
	}

	public void setFlightDepCode(String flightDepCode) {
		this.flightDepCode = flightDepCode;
	}

	public String getFlightArrCode() {
		return flightArrCode;
	}

	public void setFlightArrCode(String flightArrCode) {
		this.flightArrCode = flightArrCode;
	}

	public String getFlightDepCity() {
		return flightDepCity;
	}

	public void setFlightDepCity(String flightDepCity) {
		this.flightDepCity = flightDepCity;
	}

	public String getFlightArrCity() {
		return flightArrCity;
	}

	public void setFlightArrCity(String flightArrCity) {
		this.flightArrCity = flightArrCity;
	}

	public Date getFlightDepTimePlan() {
		return flightDepTimePlan;
	}

	public void setFlightDepTimePlan(Date flightDepTimePlan) {
		this.flightDepTimePlan = flightDepTimePlan;
	}

	public Date getFlightArrTimePlan() {
		return flightArrTimePlan;
	}

	public void setFlightArrTimePlan(Date flightArrTimePlan) {
		this.flightArrTimePlan = flightArrTimePlan;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
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

	public String getBeneficialType() {
		return beneficialType;
	}

	public void setBeneficialType(String beneficialType) {
		this.beneficialType = beneficialType;
	}

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
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

	public String getSettleCompany() {
		return settleCompany;
	}

	public void setSettleCompany(String settleCompany) {
		this.settleCompany = settleCompany;
	}

	
	public String getSettleCompanyName() {
		return settleCompanyName;
	}

	public void setSettleCompanyName(String settleCompanyName) {
		this.settleCompanyName = settleCompanyName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
    
}
