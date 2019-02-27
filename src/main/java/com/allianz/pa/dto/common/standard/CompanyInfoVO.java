package com.allianz.pa.dto.common.standard;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CompanyInfoVO {
	@NotNull(message="0001")
	private String companyName;//投保单位名称
	private String regNumbe;//统一社会信用代码
	private String vatNumber;//税人识别号（专票必填）	15-20位编码
	private String socialSecurityNo;//社保保险登记证号
	@NotNull(message="0001")
	private String industryClassification;//行业分类
	
	@Pattern(regexp="^(01|02|03)$",message="1099")
	@NotNull(message="0001")
	private String invoiceType;//发票类型 	01-专票，02-普票，03-不开票
	private String vatType;//纳税人类型 （专票必填）:	01-个人，02-一般纳税人，03-小规模纳税人， 04-境外客户
	private String vatBankName;//开户银行名称（专票必填）
	private String vatBankAccount;//开户银行账号（专票必填）
	private String vatContactNo;//联系电话（专票必填）
	private String vatAddress;//址（专票必填）
	
	@Pattern(regexp="^(Y|N)$",message="1099")
	private String needEInvoice;//是否需要电子发票 	Y-需要	N-不需要
	private Date licenceStartDate;//营业执照开始日期
	private Date licenceEndDate;//营业执照结算日期
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getRegNumbe() {
		return regNumbe;
	}
	public void setRegNumbe(String regNumbe) {
		this.regNumbe = regNumbe;
	}
	public String getVatNumber() {
		return vatNumber;
	}
	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}
	public String getSocialSecurityNo() {
		return socialSecurityNo;
	}
	public void setSocialSecurityNo(String socialSecurityNo) {
		this.socialSecurityNo = socialSecurityNo;
	}
	public String getIndustryClassification() {
		return industryClassification;
	}
	public void setIndustryClassification(String industryClassification) {
		this.industryClassification = industryClassification;
	}
	public String getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getVatType() {
		return vatType;
	}
	public void setVatType(String vatType) {
		this.vatType = vatType;
	}
	public String getVatBankName() {
		return vatBankName;
	}
	public void setVatBankName(String vatBankName) {
		this.vatBankName = vatBankName;
	}
	public String getVatBankAccount() {
		return vatBankAccount;
	}
	public void setVatBankAccount(String vatBankAccount) {
		this.vatBankAccount = vatBankAccount;
	}
	public String getVatContactNo() {
		return vatContactNo;
	}
	public void setVatContactNo(String vatContactNo) {
		this.vatContactNo = vatContactNo;
	}
	public String getVatAddress() {
		return vatAddress;
	}
	public void setVatAddress(String vatAddress) {
		this.vatAddress = vatAddress;
	}
	public String getNeedEInvoice() {
		return needEInvoice;
	}
	public void setNeedEInvoice(String needEInvoice) {
		this.needEInvoice = needEInvoice;
	}
	public Date getLicenceStartDate() {
		return licenceStartDate;
	}
	public void setLicenceStartDate(Date licenceStartDate) {
		this.licenceStartDate = licenceStartDate;
	}
	public Date getLicenceEndDate() {
		return licenceEndDate;
	}
	public void setLicenceEndDate(Date licenceEndDate) {
		this.licenceEndDate = licenceEndDate;
	}

}
