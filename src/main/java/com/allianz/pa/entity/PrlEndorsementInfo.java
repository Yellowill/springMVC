package com.allianz.pa.entity;

import java.util.Date;

public class PrlEndorsementInfo extends PrlEndorsementInfoKey {
    private Date endorDate;

    private String changeDesc;

    private String partnerRef;

    private String insuredName;

    private String accBankNo;

    private String accBank;

    public Date getEndorDate() {
        return endorDate;
    }

    public void setEndorDate(Date endorDate) {
        this.endorDate = endorDate;
    }

    public String getChangeDesc() {
        return changeDesc;
    }

    public void setChangeDesc(String changeDesc) {
        this.changeDesc = changeDesc == null ? null : changeDesc.trim();
    }

    public String getPartnerRef() {
        return partnerRef;
    }

    public void setPartnerRef(String partnerRef) {
        this.partnerRef = partnerRef == null ? null : partnerRef.trim();
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName == null ? null : insuredName.trim();
    }

    public String getAccBankNo() {
        return accBankNo;
    }

    public void setAccBankNo(String accBankNo) {
        this.accBankNo = accBankNo == null ? null : accBankNo.trim();
    }

    public String getAccBank() {
        return accBank;
    }

    public void setAccBank(String accBank) {
        this.accBank = accBank == null ? null : accBank.trim();
    }
}