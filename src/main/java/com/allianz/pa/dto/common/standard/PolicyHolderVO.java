package com.allianz.pa.dto.common.standard;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class PolicyHolderVO {
	@NotNull(message="0001")
	private String policyHolderType;	//I-个人，C-企业或者机构
	@NotNull(message="0001")
	private String policyHolderName;	//名称
	private String phIdType;		//证件类型  1-身份证,	2-护照,	3-其他
	private String phIdNumber;	//证件号码，如果为个人则必填
	private Date phBirthDate;		//出生日期，如果为个人则必填
	private String phTelephone;	//联系电话
	private String phAddress;		//具体联系地址
	private String phPostCode;	//邮政编码
	private String phEmail;		//电子邮件
	
	
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
	public String getPhIdType() {
		return phIdType;
	}
	public void setPhIdType(String phIdType) {
		this.phIdType = phIdType;
	}
	public String getPhIdNumber() {
		return phIdNumber;
	}
	public void setPhIdNumber(String phIdNumber) {
		this.phIdNumber = phIdNumber;
	}
	public Date getPhBirthDate() {
		return phBirthDate;
	}
	public void setPhBirthDate(Date phBirthDate) {
		this.phBirthDate = phBirthDate;
	}
	public String getPhTelephone() {
		return phTelephone;
	}
	public void setPhTelephone(String phTelephone) {
		this.phTelephone = phTelephone;
	}
	public String getPhAddress() {
		return phAddress;
	}
	public void setPhAddress(String phAddress) {
		this.phAddress = phAddress;
	}
	public String getPhPostCode() {
		return phPostCode;
	}
	public void setPhPostCode(String phPostCode) {
		this.phPostCode = phPostCode;
	}
	public String getPhEmail() {
		return phEmail;
	}
	public void setPhEmail(String phEmail) {
		this.phEmail = phEmail;
	}

}
