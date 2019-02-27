package com.allianz.pa.entity;

public class WipPrlPartPlanFlightsKey {
    private Long contractId;

    private Integer partitionNo;

    private Short flightId;

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

    public Short getFlightId() {
        return flightId;
    }

    public void setFlightId(Short flightId) {
        this.flightId = flightId;
    }
}