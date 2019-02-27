package com.allianz.pa.dto.common.standard;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ContactPersonVO {
    public ContactPersonVO() {
        super();
    }
    
    @NotNull(message="0001")
    protected String contactName;
    
    @Pattern(regexp="^(1|2|3)$",message="1099")
    protected String idType;
    
    protected String idNumber;
    
    protected String mobile;
    
    protected String email;
    
    private String contactAddress;

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
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

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
    
}
