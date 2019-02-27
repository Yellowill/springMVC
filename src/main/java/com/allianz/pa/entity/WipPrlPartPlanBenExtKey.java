package com.allianz.pa.entity;

public class WipPrlPartPlanBenExtKey {
    private Long contractId;

    private Integer partitionNo;

    private Integer benefitId;

    private Integer planId;

    private Integer planVersionNo;

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

	public Integer getBenefitId() {
		return benefitId;
	}

	public void setBenefitId(Integer benefitId) {
		this.benefitId = benefitId;
	}

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public Integer getPlanVersionNo() {
		return planVersionNo;
	}

	public void setPlanVersionNo(Integer planVersionNo) {
		this.planVersionNo = planVersionNo;
	}

}