package com.allianz.pa.entity;

import java.math.BigDecimal;
import java.util.Date;

public class WipPrlPartPlanJdInsExt extends WipPrlPartPlanJdInsExtKey {
    private String actionCode;

    private Integer versionNo;

    private Long objectId;

    private String topIndicator;

    private Integer previousVersion;

    private Integer reversingVersion;

    private Integer planId;

    private Integer planVersionNo;

    private String idNo;

    private String idType;

    private Date dob;

    private String name;

    private String email;

    private String insuredType;

    private String mobileNo;

    private String sex;

    private String beneficialType;

    private String partInsuredId;

    private BigDecimal premTotal;

    private BigDecimal premA;

    private BigDecimal premH;

    private Date startDate;

    private Date endDate;

    private String policyNo;

    private String jdAccount;
    
    private Integer partnerId;
    
    private Date wteStartDate;
    
    private Date wteEndDate;

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

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Integer getPlanVersionNo() {
        return planVersionNo;
    }

    public void setPlanVersionNo(Integer planVersionNo) {
        this.planVersionNo = planVersionNo;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType == null ? null : idType.trim();
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getInsuredType() {
        return insuredType;
    }

    public void setInsuredType(String insuredType) {
        this.insuredType = insuredType == null ? null : insuredType.trim();
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBeneficialType() {
        return beneficialType;
    }

    public void setBeneficialType(String beneficialType) {
        this.beneficialType = beneficialType == null ? null : beneficialType.trim();
    }

    public String getPartInsuredId() {
        return partInsuredId;
    }

    public void setPartInsuredId(String partInsuredId) {
        this.partInsuredId = partInsuredId == null ? null : partInsuredId.trim();
    }

    public BigDecimal getPremTotal() {
        return premTotal;
    }

    public void setPremTotal(BigDecimal premTotal) {
        this.premTotal = premTotal;
    }

    public BigDecimal getPremA() {
        return premA;
    }

    public void setPremA(BigDecimal premA) {
        this.premA = premA;
    }

    public BigDecimal getPremH() {
        return premH;
    }

    public void setPremH(BigDecimal premH) {
        this.premH = premH;
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

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo == null ? null : policyNo.trim();
    }

    public String getJdAccount() {
        return jdAccount;
    }

    public void setJdAccount(String jdAccount) {
        this.jdAccount = jdAccount == null ? null : jdAccount.trim();
    }

	public Integer getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
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