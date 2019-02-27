package com.allianz.pa.entity;

public class PrlEndorsementInfoKey {
    private Long contractId;

    private String gpaCode;

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getGpaCode() {
        return gpaCode;
    }

    public void setGpaCode(String gpaCode) {
        this.gpaCode = gpaCode == null ? null : gpaCode.trim();
    }
}