package com.allianz.pa.entity;

public class WipPrlPartInsEmgExtKey {
    private Long contractId;

    private Integer partitionNo;

    private Long emgId;

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Integer getPartitionNo() {
        return partitionNo;
    }

    public void setPartitionNo(Integer partitionNo) {
        this.partitionNo = partitionNo;
    }

    public Long getEmgId() {
        return emgId;
    }

    public void setEmgId(Long emgId) {
        this.emgId = emgId;
    }
}