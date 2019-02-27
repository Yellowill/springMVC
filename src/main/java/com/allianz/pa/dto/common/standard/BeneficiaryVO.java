package com.allianz.pa.dto.common.standard;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BeneficiaryVO {
    public BeneficiaryVO() {
        super();
    }
    
    @NotNull(message="0001")
    private String beneficiaryName;
    
    @Pattern(regexp="^(1|2|3)$",message="1099")
    private String idType;
    
    private String idNumber;
    
    @Pattern(regexp="^(1|2|3|4)$",message="1099")
    @NotNull(message="0001")
    private String relationship;
    
//    @Pattern(regexp="^100$|^(\\d|[1-9]\\d)(\\.\\d+)*$",message="1099") 正则不能校验数字类型
    @NotNull(message="0001")
    private BigDecimal percentage;
    
    private String mobile;
    
    private String email;

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }
}
