package com.allianz.pa.entity;

import java.math.BigDecimal;
import java.util.Date;

public class WipPrlPartPlanInsRiskExt extends WipPrlPartPlanInsRiskExtKey {
	private String actionCode;

    private Integer versionNo;

    private Long objectId;

    private String topIndicator;

    private Integer previousVersion;

    private Integer reversingVersion;

    private Long insuredId;

    private String thirdPartId;

    private String thirdPartName;

    private String thirdPartOrderNo;

    private String thirdPartPolicyNo;

    private Date applyDateTime;

    private Date effectiveDateTime;

    private Date policyCreationDate;

    private BigDecimal premium;

    private String locationFrom;

    private String locationTo;

    private String thirdPartInsuredId;

    private BigDecimal sumInsured;

    private Date endDateTime;

    private Date updatedDate;

    private String mallOrderId;

    private String mallPolicyId;

    private String prodCategory;

    private String prodBrand;

    private String prodModel;

    private String prodSize;

    private BigDecimal orderPrice;

    private BigDecimal policyPrice;

    private String equipmentId;

    private Date orderDate;

    private Integer guaranteePeriodMonths;

    private Integer policyPeriodMonths;

    private Integer policyPeriodDays;

    private Integer wholeGtPeriodDays;

    private Integer mainPartGtPeriodDays;

    private Date wholeGtStartDate;

    private Date wholeGtEndDate;

    private Date mainPartGtStartDate;

    private Date mainPartGtEndDate;

    private Date wholeWteStartDate;

    private Date wholeWteEndDate;

    private Date mainPartWteStartDate;

    private Date mainPartWteEndDate;

    private Date wteStartDate;

    private Date wteEndDate;

    private String thirdPartPin;

    private String cityTo;

    private String addressTo;
    
    private String mallSku;
    
    private String mallPolicySku;
    
    private Date alEffectiveDate;
    private Date alEndDate;
    private Integer alPeriodDays;
    private Integer wtePeriodDays;
    private Integer wholeWtePeriodDays;
    private Integer mainPartWtePeriodDays;
    private Date gtStartDate;
    private Date gtEndDate;
    private Date serviceStartDate;
    private Date serviceEndDate;
    //2018-12 add
    private String nameOfClassThree;
    private String licenceNo;
    private String institutionName;


    public String getNameOfClassThree() {
		return nameOfClassThree;
	}

	public void setNameOfClassThree(String nameOfClassThree) {
		this.nameOfClassThree = nameOfClassThree;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
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

    public Long getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(Long insuredId) {
        this.insuredId = insuredId;
    }

    public String getThirdPartId() {
        return thirdPartId;
    }

    public void setThirdPartId(String thirdPartId) {
        this.thirdPartId = thirdPartId == null ? null : thirdPartId.trim();
    }

    public String getThirdPartName() {
        return thirdPartName;
    }

    public void setThirdPartName(String thirdPartName) {
        this.thirdPartName = thirdPartName == null ? null : thirdPartName.trim();
    }

    public String getThirdPartOrderNo() {
        return thirdPartOrderNo;
    }

    public void setThirdPartOrderNo(String thirdPartOrderNo) {
        this.thirdPartOrderNo = thirdPartOrderNo == null ? null : thirdPartOrderNo.trim();
    }

    public String getThirdPartPolicyNo() {
        return thirdPartPolicyNo;
    }

    public void setThirdPartPolicyNo(String thirdPartPolicyNo) {
        this.thirdPartPolicyNo = thirdPartPolicyNo == null ? null : thirdPartPolicyNo.trim();
    }

    public Date getApplyDateTime() {
        return applyDateTime;
    }

    public void setApplyDateTime(Date applyDateTime) {
        this.applyDateTime = applyDateTime;
    }

    public Date getEffectiveDateTime() {
        return effectiveDateTime;
    }

    public void setEffectiveDateTime(Date effectiveDateTime) {
        this.effectiveDateTime = effectiveDateTime;
    }

    public Date getPolicyCreationDate() {
        return policyCreationDate;
    }

    public void setPolicyCreationDate(Date policyCreationDate) {
        this.policyCreationDate = policyCreationDate;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public String getLocationFrom() {
        return locationFrom;
    }

    public void setLocationFrom(String locationFrom) {
        this.locationFrom = locationFrom == null ? null : locationFrom.trim();
    }

    public String getLocationTo() {
        return locationTo;
    }

    public void setLocationTo(String locationTo) {
        this.locationTo = locationTo == null ? null : locationTo.trim();
    }

    public String getThirdPartInsuredId() {
        return thirdPartInsuredId;
    }

    public void setThirdPartInsuredId(String thirdPartInsuredId) {
        this.thirdPartInsuredId = thirdPartInsuredId == null ? null : thirdPartInsuredId.trim();
    }

    public BigDecimal getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(BigDecimal sumInsured) {
        this.sumInsured = sumInsured;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getMallOrderId() {
        return mallOrderId;
    }

    public void setMallOrderId(String mallOrderId) {
        this.mallOrderId = mallOrderId == null ? null : mallOrderId.trim();
    }

    public String getMallPolicyId() {
        return mallPolicyId;
    }

    public void setMallPolicyId(String mallPolicyId) {
        this.mallPolicyId = mallPolicyId == null ? null : mallPolicyId.trim();
    }

    public String getProdCategory() {
        return prodCategory;
    }

    public void setProdCategory(String prodCategory) {
        this.prodCategory = prodCategory == null ? null : prodCategory.trim();
    }

    public String getProdBrand() {
        return prodBrand;
    }

    public void setProdBrand(String prodBrand) {
        this.prodBrand = prodBrand == null ? null : prodBrand.trim();
    }

    public String getProdModel() {
        return prodModel;
    }

    public void setProdModel(String prodModel) {
        this.prodModel = prodModel == null ? null : prodModel.trim();
    }

    public String getProdSize() {
        return prodSize;
    }

    public void setProdSize(String prodSize) {
        this.prodSize = prodSize == null ? null : prodSize.trim();
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public BigDecimal getPolicyPrice() {
        return policyPrice;
    }

    public void setPolicyPrice(BigDecimal policyPrice) {
        this.policyPrice = policyPrice;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId == null ? null : equipmentId.trim();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getGuaranteePeriodMonths() {
        return guaranteePeriodMonths;
    }

    public void setGuaranteePeriodMonths(Integer guaranteePeriodMonths) {
        this.guaranteePeriodMonths = guaranteePeriodMonths;
    }

    public Integer getPolicyPeriodMonths() {
        return policyPeriodMonths;
    }

    public void setPolicyPeriodMonths(Integer policyPeriodMonths) {
        this.policyPeriodMonths = policyPeriodMonths;
    }

    public Integer getPolicyPeriodDays() {
        return policyPeriodDays;
    }

    public void setPolicyPeriodDays(Integer policyPeriodDays) {
        this.policyPeriodDays = policyPeriodDays;
    }

    public Integer getWholeGtPeriodDays() {
        return wholeGtPeriodDays;
    }

    public void setWholeGtPeriodDays(Integer wholeGtPeriodDays) {
        this.wholeGtPeriodDays = wholeGtPeriodDays;
    }

    public Integer getMainPartGtPeriodDays() {
        return mainPartGtPeriodDays;
    }

    public void setMainPartGtPeriodDays(Integer mainPartGtPeriodDays) {
        this.mainPartGtPeriodDays = mainPartGtPeriodDays;
    }

    public Date getWholeGtStartDate() {
        return wholeGtStartDate;
    }

    public void setWholeGtStartDate(Date wholeGtStartDate) {
        this.wholeGtStartDate = wholeGtStartDate;
    }

    public Date getWholeGtEndDate() {
        return wholeGtEndDate;
    }

    public void setWholeGtEndDate(Date wholeGtEndDate) {
        this.wholeGtEndDate = wholeGtEndDate;
    }

    public Date getMainPartGtStartDate() {
        return mainPartGtStartDate;
    }

    public void setMainPartGtStartDate(Date mainPartGtStartDate) {
        this.mainPartGtStartDate = mainPartGtStartDate;
    }

    public Date getMainPartGtEndDate() {
        return mainPartGtEndDate;
    }

    public void setMainPartGtEndDate(Date mainPartGtEndDate) {
        this.mainPartGtEndDate = mainPartGtEndDate;
    }

    public Date getWholeWteStartDate() {
        return wholeWteStartDate;
    }

    public void setWholeWteStartDate(Date wholeWteStartDate) {
        this.wholeWteStartDate = wholeWteStartDate;
    }

    public Date getWholeWteEndDate() {
        return wholeWteEndDate;
    }

    public void setWholeWteEndDate(Date wholeWteEndDate) {
        this.wholeWteEndDate = wholeWteEndDate;
    }

    public Date getMainPartWteStartDate() {
        return mainPartWteStartDate;
    }

    public void setMainPartWteStartDate(Date mainPartWteStartDate) {
        this.mainPartWteStartDate = mainPartWteStartDate;
    }

    public Date getMainPartWteEndDate() {
        return mainPartWteEndDate;
    }

    public void setMainPartWteEndDate(Date mainPartWteEndDate) {
        this.mainPartWteEndDate = mainPartWteEndDate;
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

    public String getThirdPartPin() {
        return thirdPartPin;
    }

    public void setThirdPartPin(String thirdPartPin) {
        this.thirdPartPin = thirdPartPin == null ? null : thirdPartPin.trim();
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo == null ? null : cityTo.trim();
    }

    public String getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(String addressTo) {
        this.addressTo = addressTo == null ? null : addressTo.trim();
    }

	public String getMallSku() {
		return mallSku;
	}

	public void setMallSku(String mallSku) {
		this.mallSku = mallSku;
	}

	public String getMallPolicySku() {
		return mallPolicySku;
	}

	public void setMallPolicySku(String mallPolicySku) {
		this.mallPolicySku = mallPolicySku;
	}

	public Date getAlEffectiveDate() {
		return alEffectiveDate;
	}

	public void setAlEffectiveDate(Date alEffectiveDate) {
		this.alEffectiveDate = alEffectiveDate;
	}

	public Date getAlEndDate() {
		return alEndDate;
	}

	public void setAlEndDate(Date alEndDate) {
		this.alEndDate = alEndDate;
	}

	public Integer getAlPeriodDays() {
		return alPeriodDays;
	}

	public void setAlPeriodDays(Integer alPeriodDays) {
		this.alPeriodDays = alPeriodDays;
	}

	public Integer getWtePeriodDays() {
		return wtePeriodDays;
	}

	public void setWtePeriodDays(Integer wtePeriodDays) {
		this.wtePeriodDays = wtePeriodDays;
	}

	public Integer getWholeWtePeriodDays() {
		return wholeWtePeriodDays;
	}

	public void setWholeWtePeriodDays(Integer wholeWtePeriodDays) {
		this.wholeWtePeriodDays = wholeWtePeriodDays;
	}

	public Integer getMainPartWtePeriodDays() {
		return mainPartWtePeriodDays;
	}

	public void setMainPartWtePeriodDays(Integer mainPartWtePeriodDays) {
		this.mainPartWtePeriodDays = mainPartWtePeriodDays;
	}

	public Date getGtStartDate() {
		return gtStartDate;
	}

	public void setGtStartDate(Date gtStartDate) {
		this.gtStartDate = gtStartDate;
	}

	public Date getGtEndDate() {
		return gtEndDate;
	}

	public void setGtEndDate(Date gtEndDate) {
		this.gtEndDate = gtEndDate;
	}

	public Date getServiceStartDate() {
		return serviceStartDate;
	}

	public void setServiceStartDate(Date serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}

	public Date getServiceEndDate() {
		return serviceEndDate;
	}

	public void setServiceEndDate(Date serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}
}