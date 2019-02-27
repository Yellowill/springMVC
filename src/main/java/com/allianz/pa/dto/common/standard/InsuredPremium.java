package com.allianz.pa.dto.common.standard;

import java.math.BigDecimal;
import java.util.List;

public class InsuredPremium {

    private String insuredId;
    
    private String insuredName;
    
    private BigDecimal premium;
    
    private String insuredType;
    
    private String insId;
    
    List<UnderwritingDecision> underwritingDecisions;

	public String getInsuredId() {
		return insuredId;
	}

	public void setInsuredId(String insuredId) {
		this.insuredId = insuredId;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public BigDecimal getPremium() {
		return premium;
	}

	public void setPremium(BigDecimal premium) {
		this.premium = premium;
	}

	public String getInsuredType() {
		return insuredType;
	}

	public void setInsuredType(String insuredType) {
		this.insuredType = insuredType;
	}

	public String getInsId() {
		return insId;
	}

	public void setInsId(String insId) {
		this.insId = insId;
	}

	public List<UnderwritingDecision> getUnderwritingDecisions() {
		return underwritingDecisions;
	}

	public void setUnderwritingDecisions(List<UnderwritingDecision> underwritingDecisions) {
		this.underwritingDecisions = underwritingDecisions;
	}
    
}
