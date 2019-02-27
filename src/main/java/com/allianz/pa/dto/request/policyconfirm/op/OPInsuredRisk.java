package com.allianz.pa.dto.request.policyconfirm.op;

import java.math.BigDecimal;
import java.util.Date;

public class OPInsuredRisk {
	//京东商家ID
	private String thirdPartId;
	//京东商家店铺名称
    private String thirdPartName;
    //京东订单号
    private String thirdPartOrderNo;
    //京东保单号
    private String thirdPartPolicyNo;
    //投保时间
    private Date applyDateTime;
    //保单生效时间
    private Date effectiveDateTime;
    //保单创建时间
    private Date policyCreationDate;
    //保费金额
    private BigDecimal premium;
    //商品出发地
    private String locationFrom;
    //商品收货地/客户收货省份
    private String locationTo;
    //京东买方用户名
    private String thirdPartInsuredId;
    //保额
    private BigDecimal sumInsured;
    //终保时间
    private Date endDateTime;
    //数据修改时间
    private Date updatedDate;
    //主商品订单号
    private String mallOrderId;
    //服务商品订单号
    private String mallPolicyId;
    //类目
    private String prodCategory;
    //品牌
    private String prodBrand;
    //型号
    private String prodModel;
    //屏幕尺寸
    private String prodSize;
    //主京东价
    private BigDecimal orderPrice;
    //服务商品价格
    private BigDecimal policyPrice;
    //IMEI/设备标识
    private String equipmentId;
    //订单日期
    private Date orderDate;
    //质保期限
    private Integer guaranteePeriodMonths;
    //保险期限(月)
    private Integer policyPeriodMonths;
    //保险期限（天）
    private Integer policyPeriodDays;
    //整机质保天数
    private Integer wholeGtPeriodDays;
    //主要零部件质保天数
    private Integer mainPartGtPeriodDays;
    //整机质保起期
    private Date wholeGtStartDate;
    //整机质保止期
    private Date wholeGtEndDate;
    //主要零部件质保起期
    private Date mainPartGtStartDate;
    //主要零部件质保止期
    private Date mainPartGtEndDate;
    //整机延保起期
    private Date wholeWteStartDate;
    //整机延保止期
    private Date wholeWteEndDate;
    //主要零部件延保起期
    private Date mainPartWteStartDate;
    //主要零部件延保止期
    private Date mainPartWteEndDate;
    //延保起期
    private Date wteStartDate;
    //延保止期
    private Date wteEndDate;
    //京东PIN
    private String thirdPartPin;
    //客户收货城市
    private String cityTo;
    //客户收货区、县、镇
    private String addressTo;
    
    private String mallSku;
    
    private String mallPolicySku;

    //意外责任起期	
    private Date alEffectiveDate;
    //意外责任止期
    private Date alEndDate;
    //意外责任保险期限（天）
    private Integer alPeriodDays;
    //延保责任保险期限（天）
    private Integer wtePeriodDays;
    //整机延保责任保险期限（天）
    private Integer wholeWtePeriodDays;
    //主要零部件延保责任保险期限（天）
    private Integer mainPartWtePeriodDays;
    //质保起期
    private Date gtStartDate;
    //质保止期
    private Date gtEndDate;
    //服务销售时间
    private Date serviceStartDate;
    //服务完成时间
    private Date serviceEndDate;
    
    //三级类目名称
    private String nameOfClassThree;
    //营业执照号
    private String licenceNo;
    //企业名称
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
	public String getThirdPartId() {
		return thirdPartId;
	}
	public void setThirdPartId(String thirdPartId) {
		this.thirdPartId = thirdPartId;
	}
	public String getThirdPartName() {
		return thirdPartName;
	}
	public void setThirdPartName(String thirdPartName) {
		this.thirdPartName = thirdPartName;
	}
	public String getThirdPartOrderNo() {
		return thirdPartOrderNo;
	}
	public void setThirdPartOrderNo(String thirdPartOrderNo) {
		this.thirdPartOrderNo = thirdPartOrderNo;
	}
	public String getThirdPartPolicyNo() {
		return thirdPartPolicyNo;
	}
	public void setThirdPartPolicyNo(String thirdPartPolicyNo) {
		this.thirdPartPolicyNo = thirdPartPolicyNo;
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
		this.locationFrom = locationFrom;
	}
	public String getLocationTo() {
		return locationTo;
	}
	public void setLocationTo(String locationTo) {
		this.locationTo = locationTo;
	}
	public String getThirdPartInsuredId() {
		return thirdPartInsuredId;
	}
	public void setThirdPartInsuredId(String thirdPartInsuredId) {
		this.thirdPartInsuredId = thirdPartInsuredId;
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
		this.mallOrderId = mallOrderId;
	}
	public String getMallPolicyId() {
		return mallPolicyId;
	}
	public void setMallPolicyId(String mallPolicyId) {
		this.mallPolicyId = mallPolicyId;
	}
	public String getProdCategory() {
		return prodCategory;
	}
	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}
	public String getProdBrand() {
		return prodBrand;
	}
	public void setProdBrand(String prodBrand) {
		this.prodBrand = prodBrand;
	}
	public String getProdModel() {
		return prodModel;
	}
	public void setProdModel(String prodModel) {
		this.prodModel = prodModel;
	}
	public String getProdSize() {
		return prodSize;
	}
	public void setProdSize(String prodSize) {
		this.prodSize = prodSize;
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
		this.equipmentId = equipmentId;
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
		this.thirdPartPin = thirdPartPin;
	}
	public String getCityTo() {
		return cityTo;
	}
	public void setCityTo(String cityTo) {
		this.cityTo = cityTo;
	}
	public String getAddressTo() {
		return addressTo;
	}
	public void setAddressTo(String addressTo) {
		this.addressTo = addressTo;
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
