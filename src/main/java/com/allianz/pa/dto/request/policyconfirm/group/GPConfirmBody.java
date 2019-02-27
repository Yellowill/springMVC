package com.allianz.pa.dto.request.policyconfirm.group;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.allianz.pa.dto.common.standard.CompanyInfoVO;
import com.allianz.pa.dto.common.standard.PolicyHolderVO;
import com.allianz.pa.dto.request.endorsement.common.EndorsementBody;

public class GPConfirmBody  extends EndorsementBody {
	
	@Valid
	@NotNull
	protected PolicyHolderVO policyHolder;
	
	@Valid
	@NotNull
	protected CompanyInfoVO companyInfo;
	
	public PolicyHolderVO getPolicyHolder() {
		return policyHolder;
	}

	public void setPolicyHolder(PolicyHolderVO policyHolder) {
		this.policyHolder = policyHolder;
	}

	public CompanyInfoVO getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(CompanyInfoVO companyInfo) {
		this.companyInfo = companyInfo;
	}

}
