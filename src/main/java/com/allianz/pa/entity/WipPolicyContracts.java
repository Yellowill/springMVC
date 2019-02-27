package com.allianz.pa.entity;

import java.util.Date;

public class WipPolicyContracts{
    private Long contractId;

    private Short productId;

    private String contractStatus;

    private String conversionStatus;

    private String contractLanguage;

    private String contractCurrency;

    private Date dateProcessedTo;

    private Date nextActivityDate;

    private String processStatus;

    private String directAssumed;

    private Date datePremiumsPaidTo;

    private Date datePremiumsBilledTo;

    private Date datePremiumsDueTo;

    private String endOfTermAction;

    private String geographicScope;

    private Date entryDate;

    private Date inceptionDate;

    private Short accumulatedTermPremium;

    private String accumulatedTermPremiumSwf;

    private Short amountPaid;

    private String amountPaidSwf;

    private Date amountPaidDate;

    private Date nextAnniversaryDate;

    private Short suspenseBalance;

    private String suspenseBalanceSwf;

    private String luaValue1;

    private String luaValue2;

    private String luaValue3;
    
    private WipInterestedParties wipInterestedParties4PRP;
    
    private WipInterestedParties wipInterestedParties4AGN;
    
    private WipInterestedParties WipInterestedParties4INS;
    
    private WipPolicyBases wipPolicyBases;
    
    private WipPrlPolicyContractsExt  wipPrlPolicyContractsExt;
    
    private WipPolicyVersions  wipPolicyVersions;

	
	public WipPolicyBases getWipPolicyBases() {
		return wipPolicyBases;
	}

	public void setWipPolicyBases(WipPolicyBases wipPolicyBases) {
		this.wipPolicyBases = wipPolicyBases;
	}

	public WipPrlPolicyContractsExt getWipPrlPolicyContractsExt() {
		return wipPrlPolicyContractsExt;
	}

	public void setWipPrlPolicyContractsExt(
			WipPrlPolicyContractsExt wipPrlPolicyContractsExt) {
		this.wipPrlPolicyContractsExt = wipPrlPolicyContractsExt;
	}

	public WipPolicyVersions getWipPolicyVersions() {
		return wipPolicyVersions;
	}

	public void setWipPolicyVersions(WipPolicyVersions wipPolicyVersions) {
		this.wipPolicyVersions = wipPolicyVersions;
	}

	public WipInterestedParties getWipInterestedParties4PRP() {
		return wipInterestedParties4PRP;
	}

	public void setWipInterestedParties4PRP(
			WipInterestedParties wipInterestedParties4PRP) {
		this.wipInterestedParties4PRP = wipInterestedParties4PRP;
	}

	public WipInterestedParties getWipInterestedParties4AGN() {
		return wipInterestedParties4AGN;
	}

	public void setWipInterestedParties4AGN(
			WipInterestedParties wipInterestedParties4AGN) {
		this.wipInterestedParties4AGN = wipInterestedParties4AGN;
	}

	public WipInterestedParties getWipInterestedParties4INS() {
		return WipInterestedParties4INS;
	}

	public void setWipInterestedParties4INS(
			WipInterestedParties wipInterestedParties4INS) {
		WipInterestedParties4INS = wipInterestedParties4INS;
	}

	public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Short getProductId() {
        return productId;
    }

    public void setProductId(Short productId) {
        this.productId = productId;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus == null ? null : contractStatus.trim();
    }

    public String getConversionStatus() {
        return conversionStatus;
    }

    public void setConversionStatus(String conversionStatus) {
        this.conversionStatus = conversionStatus == null ? null : conversionStatus.trim();
    }

    public String getContractLanguage() {
        return contractLanguage;
    }

    public void setContractLanguage(String contractLanguage) {
        this.contractLanguage = contractLanguage == null ? null : contractLanguage.trim();
    }

    public String getContractCurrency() {
        return contractCurrency;
    }

    public void setContractCurrency(String contractCurrency) {
        this.contractCurrency = contractCurrency == null ? null : contractCurrency.trim();
    }

    public Date getDateProcessedTo() {
        return dateProcessedTo;
    }

    public void setDateProcessedTo(Date dateProcessedTo) {
        this.dateProcessedTo = dateProcessedTo;
    }

    public Date getNextActivityDate() {
        return nextActivityDate;
    }

    public void setNextActivityDate(Date nextActivityDate) {
        this.nextActivityDate = nextActivityDate;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus == null ? null : processStatus.trim();
    }

    public String getDirectAssumed() {
        return directAssumed;
    }

    public void setDirectAssumed(String directAssumed) {
        this.directAssumed = directAssumed == null ? null : directAssumed.trim();
    }

    public Date getDatePremiumsPaidTo() {
        return datePremiumsPaidTo;
    }

    public void setDatePremiumsPaidTo(Date datePremiumsPaidTo) {
        this.datePremiumsPaidTo = datePremiumsPaidTo;
    }

    public Date getDatePremiumsBilledTo() {
        return datePremiumsBilledTo;
    }

    public void setDatePremiumsBilledTo(Date datePremiumsBilledTo) {
        this.datePremiumsBilledTo = datePremiumsBilledTo;
    }

    public Date getDatePremiumsDueTo() {
        return datePremiumsDueTo;
    }

    public void setDatePremiumsDueTo(Date datePremiumsDueTo) {
        this.datePremiumsDueTo = datePremiumsDueTo;
    }

    public String getEndOfTermAction() {
        return endOfTermAction;
    }

    public void setEndOfTermAction(String endOfTermAction) {
        this.endOfTermAction = endOfTermAction == null ? null : endOfTermAction.trim();
    }

    public String getGeographicScope() {
        return geographicScope;
    }

    public void setGeographicScope(String geographicScope) {
        this.geographicScope = geographicScope == null ? null : geographicScope.trim();
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getInceptionDate() {
        return inceptionDate;
    }

    public void setInceptionDate(Date inceptionDate) {
        this.inceptionDate = inceptionDate;
    }

    public Short getAccumulatedTermPremium() {
        return accumulatedTermPremium;
    }

    public void setAccumulatedTermPremium(Short accumulatedTermPremium) {
        this.accumulatedTermPremium = accumulatedTermPremium;
    }

    public String getAccumulatedTermPremiumSwf() {
        return accumulatedTermPremiumSwf;
    }

    public void setAccumulatedTermPremiumSwf(String accumulatedTermPremiumSwf) {
        this.accumulatedTermPremiumSwf = accumulatedTermPremiumSwf == null ? null : accumulatedTermPremiumSwf.trim();
    }

    public Short getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Short amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getAmountPaidSwf() {
        return amountPaidSwf;
    }

    public void setAmountPaidSwf(String amountPaidSwf) {
        this.amountPaidSwf = amountPaidSwf == null ? null : amountPaidSwf.trim();
    }

    public Date getAmountPaidDate() {
        return amountPaidDate;
    }

    public void setAmountPaidDate(Date amountPaidDate) {
        this.amountPaidDate = amountPaidDate;
    }

    public Date getNextAnniversaryDate() {
        return nextAnniversaryDate;
    }

    public void setNextAnniversaryDate(Date nextAnniversaryDate) {
        this.nextAnniversaryDate = nextAnniversaryDate;
    }

    public Short getSuspenseBalance() {
        return suspenseBalance;
    }

    public void setSuspenseBalance(Short suspenseBalance) {
        this.suspenseBalance = suspenseBalance;
    }

    public String getSuspenseBalanceSwf() {
        return suspenseBalanceSwf;
    }

    public void setSuspenseBalanceSwf(String suspenseBalanceSwf) {
        this.suspenseBalanceSwf = suspenseBalanceSwf == null ? null : suspenseBalanceSwf.trim();
    }

    public String getLuaValue1() {
        return luaValue1;
    }

    public void setLuaValue1(String luaValue1) {
        this.luaValue1 = luaValue1 == null ? null : luaValue1.trim();
    }

    public String getLuaValue2() {
        return luaValue2;
    }

    public void setLuaValue2(String luaValue2) {
        this.luaValue2 = luaValue2 == null ? null : luaValue2.trim();
    }

    public String getLuaValue3() {
        return luaValue3;
    }

    public void setLuaValue3(String luaValue3) {
        this.luaValue3 = luaValue3 == null ? null : luaValue3.trim();
    }
}