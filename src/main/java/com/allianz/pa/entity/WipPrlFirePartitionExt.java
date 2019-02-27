package com.allianz.pa.entity;

import java.math.BigDecimal;
import java.util.Date;

public class WipPrlFirePartitionExt extends WipPrlFirePartitionExtKey {
    private String actionCode;

    private Integer versionNo;

    private Long objectId;

    private String topIndicator;

    private Integer previousVersion;

    private Integer reversingVersion;

    private Long locationId;

    private String locationDesc;

    private String floorFlatNo;

    private String occuDesc;

    private String abcCode;

    private String constructionClass;

    private String earthquakeZone;

    private String typhoonZone;

    private String locTypeCode;

    private BigDecimal deductibleAmount;

    private String feaCode;

    private String riskType;

    private String biRequired;

    private BigDecimal constructionLoading;

    private String eqCoverRequired;

    private BigDecimal earthquakeLoading;

    private BigDecimal typhoonLoading;

    private BigDecimal locationLoading;

    private Short deductibleDays;

    private String useTariffRate;

    private Short exsDiscount;

    private Short ftpRate;

    private Short grossFloorAreaSr;

    private Short pml;

    private Short stkMinpremPct;

    private Short stkDepositPct;

    private Short flatPremium;

    private String floodCoverReqd;

    private BigDecimal floodLoading;

    private BigDecimal floodLimit;

    private BigDecimal deductibleDiscount;

    private BigDecimal feaDiscount;

    private BigDecimal riskpointDiscount;

    private BigDecimal finalRate;

    private BigDecimal totalSumInsured;

    private BigDecimal baseRate;

    private String natureOfRisk;

    private String tyCoverRequired;

    private BigDecimal earthquakeLimit;

    private BigDecimal typhoonLimit;

    private String name;

    private String description;

    private String remark;

    private String vesselName;

    private String licenseNo;

    private String vesselType;

    private String construction;

    private String yearBuilt;

    private String dimension;

    private String horsePower;

    private String maximumSpeed;

    private String engineMade;

    private String mooringPlace;

    private String occupation;

    private String occupationDesc;

    private String occupationClass;

    private String identityNo;

    private String nationality;

    private Date dob;

    private Integer age;

    private String maritalStatus;

    private String gender;

    private String address;

    private String plan;

    private Integer groupSize;

    private String contractNo;

    private Long projectBlockCode;

    private String location;

    private String engineNo;

    private String occupationClassDesc;

    private BigDecimal riskpointDiscountAmt;

    private BigDecimal locationLoadingAmt;

    private String applyMinPrem;

    private String applyDepositPrem;

    private String premPrintFlag;

    private String indemnityPrintFlag;

    private String flatPremiumRemark;

    private String riskPrintFlag;

    private String applyTotalSi;

    private String groupPrintFlag;

    private String modifyFlag;

    private Short gaiiLossFreeRate;

    private Short gaiiLossFreeAmt;

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

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getLocationDesc() {
        return locationDesc;
    }

    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc == null ? null : locationDesc.trim();
    }

    public String getFloorFlatNo() {
        return floorFlatNo;
    }

    public void setFloorFlatNo(String floorFlatNo) {
        this.floorFlatNo = floorFlatNo == null ? null : floorFlatNo.trim();
    }

    public String getOccuDesc() {
        return occuDesc;
    }

    public void setOccuDesc(String occuDesc) {
        this.occuDesc = occuDesc == null ? null : occuDesc.trim();
    }

    public String getAbcCode() {
        return abcCode;
    }

    public void setAbcCode(String abcCode) {
        this.abcCode = abcCode == null ? null : abcCode.trim();
    }

    public String getConstructionClass() {
        return constructionClass;
    }

    public void setConstructionClass(String constructionClass) {
        this.constructionClass = constructionClass == null ? null : constructionClass.trim();
    }

    public String getEarthquakeZone() {
        return earthquakeZone;
    }

    public void setEarthquakeZone(String earthquakeZone) {
        this.earthquakeZone = earthquakeZone == null ? null : earthquakeZone.trim();
    }

    public String getTyphoonZone() {
        return typhoonZone;
    }

    public void setTyphoonZone(String typhoonZone) {
        this.typhoonZone = typhoonZone == null ? null : typhoonZone.trim();
    }

    public String getLocTypeCode() {
        return locTypeCode;
    }

    public void setLocTypeCode(String locTypeCode) {
        this.locTypeCode = locTypeCode == null ? null : locTypeCode.trim();
    }

    public BigDecimal getDeductibleAmount() {
        return deductibleAmount;
    }

    public void setDeductibleAmount(BigDecimal deductibleAmount) {
        this.deductibleAmount = deductibleAmount;
    }

    public String getFeaCode() {
        return feaCode;
    }

    public void setFeaCode(String feaCode) {
        this.feaCode = feaCode == null ? null : feaCode.trim();
    }

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType == null ? null : riskType.trim();
    }

    public String getBiRequired() {
        return biRequired;
    }

    public void setBiRequired(String biRequired) {
        this.biRequired = biRequired == null ? null : biRequired.trim();
    }

    public BigDecimal getConstructionLoading() {
        return constructionLoading;
    }

    public void setConstructionLoading(BigDecimal constructionLoading) {
        this.constructionLoading = constructionLoading;
    }

    public String getEqCoverRequired() {
        return eqCoverRequired;
    }

    public void setEqCoverRequired(String eqCoverRequired) {
        this.eqCoverRequired = eqCoverRequired == null ? null : eqCoverRequired.trim();
    }

    public BigDecimal getEarthquakeLoading() {
        return earthquakeLoading;
    }

    public void setEarthquakeLoading(BigDecimal earthquakeLoading) {
        this.earthquakeLoading = earthquakeLoading;
    }

    public BigDecimal getTyphoonLoading() {
        return typhoonLoading;
    }

    public void setTyphoonLoading(BigDecimal typhoonLoading) {
        this.typhoonLoading = typhoonLoading;
    }

    public BigDecimal getLocationLoading() {
        return locationLoading;
    }

    public void setLocationLoading(BigDecimal locationLoading) {
        this.locationLoading = locationLoading;
    }

    public Short getDeductibleDays() {
        return deductibleDays;
    }

    public void setDeductibleDays(Short deductibleDays) {
        this.deductibleDays = deductibleDays;
    }

    public String getUseTariffRate() {
        return useTariffRate;
    }

    public void setUseTariffRate(String useTariffRate) {
        this.useTariffRate = useTariffRate == null ? null : useTariffRate.trim();
    }

    public Short getExsDiscount() {
        return exsDiscount;
    }

    public void setExsDiscount(Short exsDiscount) {
        this.exsDiscount = exsDiscount;
    }

    public Short getFtpRate() {
        return ftpRate;
    }

    public void setFtpRate(Short ftpRate) {
        this.ftpRate = ftpRate;
    }

    public Short getGrossFloorAreaSr() {
        return grossFloorAreaSr;
    }

    public void setGrossFloorAreaSr(Short grossFloorAreaSr) {
        this.grossFloorAreaSr = grossFloorAreaSr;
    }

    public Short getPml() {
        return pml;
    }

    public void setPml(Short pml) {
        this.pml = pml;
    }

    public Short getStkMinpremPct() {
        return stkMinpremPct;
    }

    public void setStkMinpremPct(Short stkMinpremPct) {
        this.stkMinpremPct = stkMinpremPct;
    }

    public Short getStkDepositPct() {
        return stkDepositPct;
    }

    public void setStkDepositPct(Short stkDepositPct) {
        this.stkDepositPct = stkDepositPct;
    }

    public Short getFlatPremium() {
        return flatPremium;
    }

    public void setFlatPremium(Short flatPremium) {
        this.flatPremium = flatPremium;
    }

    public String getFloodCoverReqd() {
        return floodCoverReqd;
    }

    public void setFloodCoverReqd(String floodCoverReqd) {
        this.floodCoverReqd = floodCoverReqd == null ? null : floodCoverReqd.trim();
    }

    public BigDecimal getFloodLoading() {
        return floodLoading;
    }

    public void setFloodLoading(BigDecimal floodLoading) {
        this.floodLoading = floodLoading;
    }

    public BigDecimal getFloodLimit() {
        return floodLimit;
    }

    public void setFloodLimit(BigDecimal floodLimit) {
        this.floodLimit = floodLimit;
    }

    public BigDecimal getDeductibleDiscount() {
        return deductibleDiscount;
    }

    public void setDeductibleDiscount(BigDecimal deductibleDiscount) {
        this.deductibleDiscount = deductibleDiscount;
    }

    public BigDecimal getFeaDiscount() {
        return feaDiscount;
    }

    public void setFeaDiscount(BigDecimal feaDiscount) {
        this.feaDiscount = feaDiscount;
    }

    public BigDecimal getRiskpointDiscount() {
        return riskpointDiscount;
    }

    public void setRiskpointDiscount(BigDecimal riskpointDiscount) {
        this.riskpointDiscount = riskpointDiscount;
    }

    public BigDecimal getFinalRate() {
        return finalRate;
    }

    public void setFinalRate(BigDecimal finalRate) {
        this.finalRate = finalRate;
    }

    public BigDecimal getTotalSumInsured() {
        return totalSumInsured;
    }

    public void setTotalSumInsured(BigDecimal totalSumInsured) {
        this.totalSumInsured = totalSumInsured;
    }

    public BigDecimal getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(BigDecimal baseRate) {
        this.baseRate = baseRate;
    }

    public String getNatureOfRisk() {
        return natureOfRisk;
    }

    public void setNatureOfRisk(String natureOfRisk) {
        this.natureOfRisk = natureOfRisk == null ? null : natureOfRisk.trim();
    }

    public String getTyCoverRequired() {
        return tyCoverRequired;
    }

    public void setTyCoverRequired(String tyCoverRequired) {
        this.tyCoverRequired = tyCoverRequired == null ? null : tyCoverRequired.trim();
    }

    public BigDecimal getEarthquakeLimit() {
        return earthquakeLimit;
    }

    public void setEarthquakeLimit(BigDecimal earthquakeLimit) {
        this.earthquakeLimit = earthquakeLimit;
    }

    public BigDecimal getTyphoonLimit() {
        return typhoonLimit;
    }

    public void setTyphoonLimit(BigDecimal typhoonLimit) {
        this.typhoonLimit = typhoonLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName == null ? null : vesselName.trim();
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo == null ? null : licenseNo.trim();
    }

    public String getVesselType() {
        return vesselType;
    }

    public void setVesselType(String vesselType) {
        this.vesselType = vesselType == null ? null : vesselType.trim();
    }

    public String getConstruction() {
        return construction;
    }

    public void setConstruction(String construction) {
        this.construction = construction == null ? null : construction.trim();
    }

    public String getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(String yearBuilt) {
        this.yearBuilt = yearBuilt == null ? null : yearBuilt.trim();
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension == null ? null : dimension.trim();
    }

    public String getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(String horsePower) {
        this.horsePower = horsePower == null ? null : horsePower.trim();
    }

    public String getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(String maximumSpeed) {
        this.maximumSpeed = maximumSpeed == null ? null : maximumSpeed.trim();
    }

    public String getEngineMade() {
        return engineMade;
    }

    public void setEngineMade(String engineMade) {
        this.engineMade = engineMade == null ? null : engineMade.trim();
    }

    public String getMooringPlace() {
        return mooringPlace;
    }

    public void setMooringPlace(String mooringPlace) {
        this.mooringPlace = mooringPlace == null ? null : mooringPlace.trim();
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation == null ? null : occupation.trim();
    }

    public String getOccupationDesc() {
        return occupationDesc;
    }

    public void setOccupationDesc(String occupationDesc) {
        this.occupationDesc = occupationDesc == null ? null : occupationDesc.trim();
    }

    public String getOccupationClass() {
        return occupationClass;
    }

    public void setOccupationClass(String occupationClass) {
        this.occupationClass = occupationClass == null ? null : occupationClass.trim();
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo == null ? null : identityNo.trim();
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus == null ? null : maritalStatus.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan == null ? null : plan.trim();
    }

    public Integer getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(Integer groupSize) {
        this.groupSize = groupSize;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public Long getProjectBlockCode() {
        return projectBlockCode;
    }

    public void setProjectBlockCode(Long projectBlockCode) {
        this.projectBlockCode = projectBlockCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo == null ? null : engineNo.trim();
    }

    public String getOccupationClassDesc() {
        return occupationClassDesc;
    }

    public void setOccupationClassDesc(String occupationClassDesc) {
        this.occupationClassDesc = occupationClassDesc == null ? null : occupationClassDesc.trim();
    }

    public BigDecimal getRiskpointDiscountAmt() {
        return riskpointDiscountAmt;
    }

    public void setRiskpointDiscountAmt(BigDecimal riskpointDiscountAmt) {
        this.riskpointDiscountAmt = riskpointDiscountAmt;
    }

    public BigDecimal getLocationLoadingAmt() {
        return locationLoadingAmt;
    }

    public void setLocationLoadingAmt(BigDecimal locationLoadingAmt) {
        this.locationLoadingAmt = locationLoadingAmt;
    }

    public String getApplyMinPrem() {
        return applyMinPrem;
    }

    public void setApplyMinPrem(String applyMinPrem) {
        this.applyMinPrem = applyMinPrem == null ? null : applyMinPrem.trim();
    }

    public String getApplyDepositPrem() {
        return applyDepositPrem;
    }

    public void setApplyDepositPrem(String applyDepositPrem) {
        this.applyDepositPrem = applyDepositPrem == null ? null : applyDepositPrem.trim();
    }

    public String getPremPrintFlag() {
        return premPrintFlag;
    }

    public void setPremPrintFlag(String premPrintFlag) {
        this.premPrintFlag = premPrintFlag == null ? null : premPrintFlag.trim();
    }

    public String getIndemnityPrintFlag() {
        return indemnityPrintFlag;
    }

    public void setIndemnityPrintFlag(String indemnityPrintFlag) {
        this.indemnityPrintFlag = indemnityPrintFlag == null ? null : indemnityPrintFlag.trim();
    }

    public String getFlatPremiumRemark() {
        return flatPremiumRemark;
    }

    public void setFlatPremiumRemark(String flatPremiumRemark) {
        this.flatPremiumRemark = flatPremiumRemark == null ? null : flatPremiumRemark.trim();
    }

    public String getRiskPrintFlag() {
        return riskPrintFlag;
    }

    public void setRiskPrintFlag(String riskPrintFlag) {
        this.riskPrintFlag = riskPrintFlag == null ? null : riskPrintFlag.trim();
    }

    public String getApplyTotalSi() {
        return applyTotalSi;
    }

    public void setApplyTotalSi(String applyTotalSi) {
        this.applyTotalSi = applyTotalSi == null ? null : applyTotalSi.trim();
    }

    public String getGroupPrintFlag() {
        return groupPrintFlag;
    }

    public void setGroupPrintFlag(String groupPrintFlag) {
        this.groupPrintFlag = groupPrintFlag == null ? null : groupPrintFlag.trim();
    }

    public String getModifyFlag() {
        return modifyFlag;
    }

    public void setModifyFlag(String modifyFlag) {
        this.modifyFlag = modifyFlag == null ? null : modifyFlag.trim();
    }

    public Short getGaiiLossFreeRate() {
        return gaiiLossFreeRate;
    }

    public void setGaiiLossFreeRate(Short gaiiLossFreeRate) {
        this.gaiiLossFreeRate = gaiiLossFreeRate;
    }

    public Short getGaiiLossFreeAmt() {
        return gaiiLossFreeAmt;
    }

    public void setGaiiLossFreeAmt(Short gaiiLossFreeAmt) {
        this.gaiiLossFreeAmt = gaiiLossFreeAmt;
    }
}