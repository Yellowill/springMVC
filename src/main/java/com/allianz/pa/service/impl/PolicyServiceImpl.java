package com.allianz.pa.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.allianz.pa.common.annotation.RequestType;
import com.allianz.pa.common.bean.BenefitInfo;
import com.allianz.pa.common.bean.PartnerInfo;
import com.allianz.pa.common.bean.PlanInfo;
import com.allianz.pa.common.bean.QueryResultObject;
import com.allianz.pa.common.bean.UserInfo;
import com.allianz.pa.common.consant.PolicyConst;
import com.allianz.pa.common.exception.CustomException;
import com.allianz.pa.common.util.Beans;
import com.allianz.pa.common.util.DateUtils;
import com.allianz.pa.dao.PrlCommonQuotePolicyAllMapper;
import com.allianz.pa.dao.PrlEndorsementInfoMapper;
import com.allianz.pa.dao.WipInterestedPartiesMapper;
import com.allianz.pa.dao.WipIpLinksMapper;
import com.allianz.pa.dao.WipPolicyBasesMapper;
import com.allianz.pa.dao.WipPolicyContractsMapper;
import com.allianz.pa.dao.WipPolicyVersionsMapper;
import com.allianz.pa.dao.WipPrlCenBaseExtMapper;
import com.allianz.pa.dao.WipPrlFirePartitionExtMapper;
import com.allianz.pa.dao.WipPrlIpExtMapper;
import com.allianz.pa.dao.WipPrlPartPlanBenExtMapper;
import com.allianz.pa.dao.WipPrlPartPlanExtMapper;
import com.allianz.pa.dao.WipPrlPartPlanInsRiskExtMapper;
import com.allianz.pa.dao.WipPrlPartPlanJdInsExtMapper;
import com.allianz.pa.dao.WipPrlPolicyContractsExtMapper;
import com.allianz.pa.dto.common.Agency;
import com.allianz.pa.dto.common.JsonRequest;
import com.allianz.pa.dto.common.JsonRequestHead;
import com.allianz.pa.dto.request.endorsement.op.OPEndorsementBody;
import com.allianz.pa.dto.request.endorsement.op.OPEndorsementInsuredRisk;
import com.allianz.pa.dto.request.endorsement.op.OPEndorsementPolicy;
import com.allianz.pa.dto.request.policyconfirm.op.OPConfirmBody;
import com.allianz.pa.dto.request.policyconfirm.op.OPInsured;
import com.allianz.pa.dto.request.policyconfirm.op.OPInsuredRisk;
import com.allianz.pa.dto.request.policyconfirm.op.OPPolicy;
import com.allianz.pa.dto.request.policyconfirm.op.OPPolicyHolder;
import com.allianz.pa.entity.PrlCommonQuotePolicyAll;
import com.allianz.pa.entity.PrlEndorsementInfo;
import com.allianz.pa.entity.WipInterestedParties;
import com.allianz.pa.entity.WipIpLinks;
import com.allianz.pa.entity.WipIpLinksKey;
import com.allianz.pa.entity.WipPolicyBases;
import com.allianz.pa.entity.WipPolicyContracts;
import com.allianz.pa.entity.WipPolicyVersions;
import com.allianz.pa.entity.WipPrlCenBaseExt;
import com.allianz.pa.entity.WipPrlFirePartitionExt;
import com.allianz.pa.entity.WipPrlFirePartitionExtKey;
import com.allianz.pa.entity.WipPrlIpExt;
import com.allianz.pa.entity.WipPrlIpExtKey;
import com.allianz.pa.entity.WipPrlPartPlanBenExt;
import com.allianz.pa.entity.WipPrlPartPlanExt;
import com.allianz.pa.entity.WipPrlPartPlanInsRiskExt;
import com.allianz.pa.entity.WipPrlPartPlanJdInsExt;
import com.allianz.pa.entity.WipPrlPartPlanJdInsExtKey;
import com.allianz.pa.entity.WipPrlPolicyContractsExt;
import com.allianz.pa.service.AbstractPolicyService;
import com.allianz.pa.service.PolicyService;

@Service("policyService")
public class PolicyServiceImpl extends AbstractPolicyService implements PolicyService {
	private static final Logger log = Logger.getLogger(PolicyServiceImpl.class);
	
	@Resource
	private PrlCommonQuotePolicyAllMapper prlCommonQuotePolicyAllMapper;
	
	@Resource
	private WipInterestedPartiesMapper wipInterestedPartiesMapper;
	
	@Resource
	private WipIpLinksMapper wipIpLinksMapper;
	
	@Resource
	private WipPrlIpExtMapper wipPrlIpExtMapper;
	
	@Resource
	private WipPolicyBasesMapper wipPolicyBasesMapper;
	
	@Resource
	private WipPolicyVersionsMapper wipPolicyVersionsMapper;
	
	@Resource
	private WipPrlPolicyContractsExtMapper wipPrlPolicyContractsExtMapper;
	
	@Resource
	private WipPrlFirePartitionExtMapper wipPrlFirePartitionExtMapper;
	
	@Resource
	private WipPrlCenBaseExtMapper  wipPrlCenBaseExtMapper;
	
	@Resource
	private WipPrlPartPlanExtMapper wipPrlPartPlanExtMapper;
	
	@Resource
	private WipPrlPartPlanJdInsExtMapper wipPrlPartPlanJdInsExtMapper;
	
	@Resource
	private WipPrlPartPlanInsRiskExtMapper wipPrlPartPlanInsRiskExtMapper;
	
	@Resource
	private WipPrlPartPlanBenExtMapper  wipPrlPartPlanBenExtMapper;
	
	/*@Resource
	private CommonService commonService;*/
	
	@Resource
	DataSourceTransactionManager transactionManager;
	
	@Resource
	private PrlEndorsementInfoMapper prlEndorsementInfoMapper;
	
	@Resource
	private WipPolicyContractsMapper wipPolicyContractsMapper;
	
	//@Transactional(rollbackFor=Exception.class)
	@RequestType(AbstractPolicyService.EXECUTE+PolicyConst.RequestType.REQ_TYPE_POLICYCONFIRM_OP)
	public QueryResultObject executeJDPolicyConfirm(JsonRequest jsonRequest,Long contractId) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW); // 事物隔离级别，开启新事务，这样会比较安全些。
		TransactionStatus status = transactionManager.getTransaction(def); // 获得事务状态
		QueryResultObject qro= null;
		log.info("executeJDPolicyConfirm start.." );
		Map<String, Object> map = new HashMap<String, Object>();
		PartnerInfo customInfoINS = null;
		try{
		//取得各个JSON对象
		JsonRequestHead head = jsonRequest.getHead();
		OPConfirmBody body = (OPConfirmBody)jsonRequest.getBody();
		Agency agency = body.getAgency();
		OPPolicy policy = body.getPolicy();
		OPPolicyHolder policyHolder = body.getPolicyHolder();
		List<OPInsured> insureds = body.getInsuredList();
/*		Long contractIdExists = commonService.validatePolicyIsExist(head.getUser(), policy.getAgencyPolicyRef());
        if(Beans.isNotEmpty(contractIdExists)){
        	return commonService.getSuccessPolicy(contractIdExists);
        }*/
		
        //查询配置信息
		UserInfo user = body.getUser();
		if (Beans.isEmpty(user)) {
			user = commonService.getUserInfo(head.getUser());
			body.setUser(user);
		}
		PartnerInfo agencyInfo = body.getAgencyInfo();
		if (Beans.isEmpty(agencyInfo)) {
			agencyInfo = commonService.getAgencyInfo(agency.getAgencyCode());
			body.setAgencyInfo(agencyInfo);
		}		
		if (Beans.isEmpty(agencyInfo) || Beans.isEmpty(agencyInfo.getPartId())) {
			throw new CustomException("1125");
		}
		String staffCode = Beans.isEmpty(user.getStaffCode()) ? body.getAgency().getStaffCode() : user.getStaffCode(); 
		if (Beans.isEmpty(staffCode)) {
			staffCode = agencyInfo.getStaffCode();
		}
		PartnerInfo tpaInfo = commonService.getTPAInfo(agencyInfo.getPartId());
		PlanInfo planInfo = body.getPlanInfo();
		if (Beans.isEmpty(planInfo)) {
			planInfo = commonService.getAssignedPlanInfoByPlanCode(user.getUserCode(), agencyInfo.getPartId(), user.getBranchCode(), policy.getPlanCode(), new java.sql.Date(policy.getEffectiveDate().getTime()));
			body.setPlanInfo(planInfo);
		}		
		String productCode = planInfo.getProductCode();
		if (Beans.isEmpty(planInfo) || Beans.isEmpty(planInfo.getPlanId())) {
			throw new CustomException("1007");
		}
		//查询保单合同信息，祖先
		log.info("WipPolicyContracts..");
        WipPolicyContracts wipPolicyContracts = wipPolicyContractsMapper.getWipPolicyContracts(contractId);
        wipPolicyContracts.setContractCurrency(planInfo.getContractCurrency());
        //设置渠道信息
        //AGN-WipInterestedParties
        log.info("wipInterestedParties4AGN..");
        WipInterestedParties wipInterestedParties4AGN = wipPolicyContracts.getWipInterestedParties4AGN();
        wipInterestedParties4AGN.setPartnerId(user.getPartnerId());
        wipInterestedParties4AGN.setCustomerNameText(agencyInfo.getNameZhs());
        wipInterestedPartiesMapper.updateByPrimaryKeySelective(wipInterestedParties4AGN);
        //AGN-WipPrlIpExt
        log.info("wipPrlIpExt4AGN..");
        WipPrlIpExtKey wipPrlIpExtKey= new WipPrlIpExtKey();
        wipPrlIpExtKey.setContractId(contractId);
        wipPrlIpExtKey.setIpNo(PolicyConst.RoleTypeInt.AGN_IPNO.value);
        WipPrlIpExt wipPrlIpExt4AGN = wipPrlIpExtMapper.selectByPrimaryKey(wipPrlIpExtKey);
        wipPrlIpExt4AGN.setHandlerRef(Beans.isEmpty(agency.getSubAccount())? user.getUserCode() :agency.getSubAccount());
        QueryResultObject agencySalesInfo =commonService.getAgencySalesInfo(user.getPartnerId(), contractId);
        if(Beans.isNotEmpty(agencySalesInfo)){
        	wipPrlIpExt4AGN.setDspOccupation(agencySalesInfo.getSalesName());
        	wipPrlIpExt4AGN.setOccupation(agencySalesInfo.getSalesLicenseNo());
        }
        wipPrlIpExtMapper.updateByPrimaryKeySelective(wipPrlIpExt4AGN);
        //AGN-WipIpLinks
        log.info("wipIpLinks4AGN..");
        WipIpLinksKey wipIpLinksKey= new WipIpLinksKey();
        wipIpLinksKey.setContractId(contractId);
        wipIpLinksKey.setIpLinkNo(PolicyConst.RoleTypeInt.AGN_IPNO.value);
        wipIpLinksKey.setIpNo(PolicyConst.RoleTypeInt.AGN_IPNO.value);
        WipIpLinks wipIpLinks4AGN= wipIpLinksMapper.selectByPrimaryKey(wipIpLinksKey);
        map.clear();
        map.put("p_agent_id", wipInterestedParties4AGN.getPartnerId());
		map.put("p_plan_id", planInfo.getPlanId());
		map.put("p_start_date", new java.sql.Date(policy.getEffectiveDate().getTime()));
		map.put("p_comm_rate", null);
		map.put("p_int_id", user.getPartnerId());
		map.put("p_error_code", null);
        commonService.getCommissionRate(map);
        if (!PolicyConst.ErrorCode.SUCCESS.value.equals(map.get("p_error_code"))) { 
            log.info("交互失败..");
            throw new CustomException(map.get("p_error_code").toString());
        }
        if(Beans.isNotEmpty(map.get("p_comm_rate"))){
        	wipIpLinks4AGN.setInterestAmount(new BigDecimal(map.get("p_comm_rate").toString()));
        	wipIpLinks4AGN.setInterestReference(map.get("p_int_id").toString());
        }
        wipIpLinksMapper.updateByPrimaryKeySelective(wipIpLinks4AGN);
        
        //設置投保人信息
        log.info("wipInterestedParties4PRP..");
        WipInterestedParties wipInterestedParties4PRP = new WipInterestedParties();
        wipInterestedParties4PRP.setContractId(contractId);
        wipInterestedParties4PRP.setIpNo(PolicyConst.RoleTypeInt.PRP_IPNO.value);
        wipInterestedParties4PRP.setActionCode(PolicyConst.ADDED_FLAG);
        
        log.info("wipPrlIpExt4PRP..");
        WipPrlIpExt wipPrlIpExt4PRP = new WipPrlIpExt();
        wipPrlIpExt4PRP.setContractId(contractId);
        wipPrlIpExt4PRP.setIpNo(PolicyConst.RoleTypeInt.PRP_IPNO.value);
        wipPrlIpExt4PRP.setActionCode(PolicyConst.ADDED_FLAG);
        if(PolicyConst.PolicyHolderType.ENTERPRISE.equals(policyHolder.getClientRef()) && Beans.isNotEmpty(policyHolder.getPartnerRef())){
        	PartnerInfo customInfoPRP = commonService.getCustomerInfo(policyHolder.getPartnerRef());
            if(Beans.isEmpty(customInfoPRP)){
                throw new CustomException("1106");
            }
            wipPrlIpExt4PRP.setLongName(customInfoPRP.getNameZhs());
            wipPrlIpExt4PRP.setClientRef(PolicyConst.PolicyHolderType.ENTERPRISE);
            wipPrlIpExt4PRP.setRoleTypeId(Beans.isNotEmpty(customInfoPRP.getIdType())? Integer.parseInt(customInfoPRP.getIdType()) : null);
            wipPrlIpExt4PRP.setPolicyNo(customInfoPRP.getIdNo());
            if(Beans.isNotEmpty(policyHolder.getHotlineTelNo())){
            	wipPrlIpExt4PRP.setHotlineTelNo(policyHolder.getHotlineTelNo());
            }else {
            	wipPrlIpExt4PRP.setHotlineTelNo(customInfoPRP.getPhoneNo());
			}
            
            wipInterestedParties4PRP.setPartnerId(customInfoPRP.getPartId());
        }else{
            Beans.copy(wipPrlIpExt4PRP, policyHolder);
            if(Beans.isNotEmpty(policyHolder.getBirthDate())){
            	wipPrlIpExt4PRP.setHandlerRef(DateUtils.format4yyyyMMdd(policyHolder.getBirthDate()));
            }
        	if(Beans.isNotEmpty(tpaInfo) && Beans.isNotEmpty(tpaInfo.getPartId())){
        		wipInterestedParties4PRP.setPartnerId(tpaInfo.getPartId());
        	}
        }
        wipInterestedPartiesMapper.insertSelective(wipInterestedParties4PRP);
        wipPrlIpExtMapper.insertSelective(wipPrlIpExt4PRP);
        
        log.info("wipIpLinks4PRP..");
        WipIpLinks wipIpLinks4PRP = new WipIpLinks();
        wipIpLinks4PRP.setContractId(contractId);
        wipIpLinks4PRP.setIpLinkNo(PolicyConst.RoleTypeInt.PRP_IPNO.value);
        wipIpLinks4PRP.setIpNo(PolicyConst.RoleTypeInt.PRP_IPNO.value);
        wipIpLinks4PRP.setLinkType("BSE");
        wipIpLinks4PRP.setRoleType(PolicyConst.RoleTypeStr.PRP.value);
        wipIpLinks4PRP.setActionCode(PolicyConst.ADDED_FLAG);
        wipIpLinksMapper.insertSelective(wipIpLinks4PRP);
        
        //設置第一個被保險人信息
        log.info("wipPrlIpExt4PHI..");
        WipInterestedParties wipInterestedParties4PHI = new WipInterestedParties();
        wipInterestedParties4PHI.setContractId(contractId);
        wipInterestedParties4PHI.setIpNo(PolicyConst.RoleTypeInt.PHI_IPNO.value);
        wipInterestedParties4PHI.setActionCode(PolicyConst.ADDED_FLAG);
        
        WipPrlIpExt wipPrlIpExt4PHI = new WipPrlIpExt();
        wipPrlIpExt4PHI.setContractId(contractId);
        wipPrlIpExt4PHI.setIpNo(PolicyConst.RoleTypeInt.PHI_IPNO.value);
        wipPrlIpExt4PHI.setActionCode(PolicyConst.ADDED_FLAG);
        
        if(PolicyConst.PolicyHolderType.ENTERPRISE.equals(insureds.get(0).getInsuredType()) && Beans.isNotEmpty(insureds.get(0).getPartnerRef())){
        	customInfoINS= commonService.getCustomerInfo(insureds.get(0).getPartnerRef());
            if(Beans.isEmpty(customInfoINS)){
                throw new CustomException("2004");
            }
            wipPrlIpExt4PHI.setLongName(Beans.isEmpty(insureds.get(0).getName())? customInfoINS.getNameZhs() : insureds.get(0).getName());
            wipPrlIpExt4PHI.setClientRef(PolicyConst.PolicyHolderType.ENTERPRISE);
            wipPrlIpExt4PHI.setRoleTypeId(Beans.isNotEmpty(customInfoINS.getIdType())? Integer.parseInt(customInfoINS.getIdType()): null);
            wipPrlIpExt4PHI.setPolicyNo(customInfoINS.getIdNo());
            if(Beans.isNotEmpty(insureds.get(0).getMobileNo())){
            	wipPrlIpExt4PHI.setHotlineTelNo(insureds.get(0).getMobileNo());
            }else {
            	wipPrlIpExt4PHI.setHotlineTelNo(customInfoINS.getPhoneNo());
			}
            
            wipInterestedParties4PHI.setPartnerId(customInfoINS.getPartId());
        }else{
            wipPrlIpExt4PHI.setLongName(insureds.get(0).getName());
            wipPrlIpExt4PHI.setInsuredBusiness(insureds.get(0).getName());
            wipPrlIpExt4PHI.setClientRef(insureds.get(0).getInsuredType());
            wipPrlIpExt4PHI.setHandlerRef(Beans.isNotEmpty(insureds.get(0).getDob())?DateUtils.format4yyyyMMdd(insureds.get(0).getDob()) :null);
            wipPrlIpExt4PHI.setHotlineTelNo(insureds.get(0).getMobileNo());
            wipPrlIpExt4PHI.setPolicyNo(insureds.get(0).getIdNo());
            wipPrlIpExt4PHI.setRoleTypeId(insureds.get(0).getIdType());
            wipPrlIpExt4PHI.setRemark(insureds.get(0).getEmail());
        	if(Beans.isNotEmpty(tpaInfo) && Beans.isNotEmpty(tpaInfo.getPartId())){
        		wipInterestedParties4PHI.setPartnerId(tpaInfo.getPartId());
        	}
        }
        wipInterestedPartiesMapper.insertSelective(wipInterestedParties4PHI);
        wipPrlIpExtMapper.insertSelective(wipPrlIpExt4PHI);
        
        log.info("wipIpLinks4PHI..");
        WipIpLinks wipIpLinks4PHI = new WipIpLinks();
        wipIpLinks4PHI.setContractId(contractId);
        wipIpLinks4PHI.setIpLinkNo(PolicyConst.RoleTypeInt.PHI_IPNO.value);
        wipIpLinks4PHI.setIpNo(PolicyConst.RoleTypeInt.PHI_IPNO.value);
        wipIpLinks4PHI.setLinkType("BSE");
        wipIpLinks4PHI.setRoleType(PolicyConst.RoleTypeStr.PHI.value);
        wipIpLinks4PHI.setActionCode(PolicyConst.ADDED_FLAG);
        wipIpLinksMapper.insertSelective(wipIpLinks4PHI);
        
        //設置保單信息
        //WipPolicyBases
        log.info("WipPolicyBases..");
        WipPolicyBases wipPolicyBases = wipPolicyContracts.getWipPolicyBases();
        wipPolicyBases.setCompanyOrgUnit(Integer.parseInt(user.getBranchCode()));
        wipPolicyBases.setTermStartDate(policy.getEffectiveDate());
        wipPolicyBases.setTermEndDate(policy.getExpireDate());
        wipPolicyBases.setBookingFrequency(Beans.isNotEmpty(policy.getInstallmentNumber()) ? PolicyConst.YES : PolicyConst.NO);
        wipPolicyBasesMapper.updateByPrimaryKeySelective(wipPolicyBases);
        //WipPolicyVersions
        log.info("WipPolicyVersions..");
        WipPolicyVersions wipPolicyVersions = wipPolicyContracts.getWipPolicyVersions();
        wipPolicyVersions.setBusinessStartDate(wipPolicyBases.getTermStartDate());
        wipPolicyVersionsMapper.updateByPrimaryKeySelective(wipPolicyVersions);
        //WipPrlPolicyContractsExt
        log.info("WipPrlPolicyContractsExt..");
        WipPrlPolicyContractsExt wipPrlPolicyContractsExt =wipPolicyContracts.getWipPrlPolicyContractsExt();
        wipPrlPolicyContractsExt.setPolicyOriginator(policy.getAgencyPolicyRef());
        wipPrlPolicyContractsExtMapper.updateByPrimaryKeySelective(wipPrlPolicyContractsExt);
        //WipPrlFirePartitionExt
        log.info("wipPrlFirePartitionExt..");
        WipPrlFirePartitionExtKey wipPrlFirePartitionExtKey = new WipPrlFirePartitionExtKey();
        wipPrlFirePartitionExtKey.setContractId(contractId);
        wipPrlFirePartitionExtKey.setPartitionNo(PolicyConst.PartitionNo);
        WipPrlFirePartitionExt wipPrlFirePartitionExt = wipPrlFirePartitionExtMapper.selectByPrimaryKey(wipPrlFirePartitionExtKey);
        wipPrlFirePartitionExt.setGroupSize(insureds.size());
        wipPrlFirePartitionExtMapper.updateByPrimaryKeySelective(wipPrlFirePartitionExt);
        //WipPrlCenBaseExt
        log.info("WipPrlCenBaseExt..");
        WipPrlCenBaseExt wipPrlCenBaseExt=wipPrlCenBaseExtMapper.selectByPrimaryKey(contractId); 
        wipPrlCenBaseExt.setPolicyType("3");
        if (PolicyConst.PolicyHolderType.ENTERPRISE.equals(wipPrlIpExt4PRP.getClientRef())) {
        	wipPrlCenBaseExt.setPolicyType("2");
		}
        wipPrlCenBaseExt.setStaffCode(staffCode);
        wipPrlCenBaseExt.setBusinessSource(agencyInfo.getBusinessSource());
        wipPrlCenBaseExt.setBusinessUnit(agencyInfo.getBusinessUnit());
        wipPrlCenBaseExt.setClauseWording(policy.getRemark());
        if(Beans.isNotEmpty(body.getPreiumSettle())){
        	wipPrlCenBaseExt.setGpaCode(body.getPreiumSettle().getPayementType());
        	wipPrlCenBaseExt.setRenewalRemarksInternal(body.getPreiumSettle().getAccountCode());
        }
        wipPrlCenBaseExt.setMaintStartDate(policy.getIssueDate());
        wipPrlCenBaseExt.setNps(Beans.isEmpty(policy.getDestination())?planInfo.getDestination() : policy.getDestination());
        wipPrlCenBaseExt.setAbroadDriveYn(policy.getAbroadDriveYn());
        wipPrlCenBaseExt.setNonBinding(policyHolder.getReqElecFaPiao());
        wipPrlCenBaseExt.setReferText(policy.getGroupNo());
        wipPrlCenBaseExt.setPoiFlag(policy.getRenewalType());
        wipPrlCenBaseExt.setPoiText(policy.getCustomPolicyType());
        wipPrlCenBaseExt.setMaintenancePeriod(Beans.isNotEmpty(policy.getInstallmentNumber()) ? Integer.parseInt(policy.getInstallmentNumber()) : null);
        wipPrlCenBaseExt.setReferComments(PolicyConst.referCommentsMap.get(user.getBranchCode().substring(0, 1)));
        if(PolicyConst.PremiumCalMethod.Year.value.equals(planInfo.getCalMethod())){
        	wipPrlCenBaseExt.setRenewable(PolicyConst.YES);
        }
        BigDecimal exch_rate=commonService.getExchRate(planInfo.getContractCurrency(), wipPolicyBases.getTermStartDate());
        wipPrlCenBaseExt.setExchRate(exch_rate);
        wipPrlCenBaseExtMapper.updateByPrimaryKeySelective(wipPrlCenBaseExt);
        
        //prl_common_quote_policy_all
        log.info("PrlCommonQuotePolicyAll..");
        PrlCommonQuotePolicyAll prlCommonQuotePolicyAll = prlCommonQuotePolicyAllMapper.selectByContractId(contractId);
        prlCommonQuotePolicyAll.setInsuredName(wipPrlIpExt4PRP.getLongName());
        prlCommonQuotePolicyAll.setBranchCode(wipPolicyBases.getCompanyOrgUnit().toString());
        prlCommonQuotePolicyAll.setSalesCode(wipPrlCenBaseExt.getStaffCode());
        prlCommonQuotePolicyAll.setApplicationDate(policy.getApplicationDate());
        if(Beans.isEmpty(prlCommonQuotePolicyAll.getApplicationDate()) && Beans.isEmpty(prlCommonQuotePolicyAll.getIssueDate())){
        	prlCommonQuotePolicyAll.setApplicationDate(new Date());
        }
        prlCommonQuotePolicyAll.setSalesChannel(wipInterestedParties4AGN.getPartnerId().toString());
        prlCommonQuotePolicyAll.setTermStartDate(wipPolicyBases.getTermStartDate());
        prlCommonQuotePolicyAll.setTermEndDate(wipPolicyBases.getTermEndDate());
        prlCommonQuotePolicyAll.setContractCurrency(planInfo.getContractCurrency());
        prlCommonQuotePolicyAllMapper.updateByContractIdSelective(prlCommonQuotePolicyAll);
        //設置計劃信息
        log.info("WipPrlPartPlanExt..");
        WipPrlPartPlanExt wipPrlPartPlanExt = new WipPrlPartPlanExt();
        wipPrlPartPlanExt.setContractId(contractId);
        wipPrlPartPlanExt.setPartitionNo(PolicyConst.PartitionNo);
        wipPrlPartPlanExt.setActionCode(PolicyConst.ADDED_FLAG);
        wipPrlPartPlanExt.setPlanId(planInfo.getPlanId());
        wipPrlPartPlanExt.setPlanVersionNo(planInfo.getVersionNo());
        wipPrlPartPlanExt.setEffectiveDate(policy.getEffectiveDate());
        wipPrlPartPlanExt.setStartDate(policy.getEffectiveDate());
        wipPrlPartPlanExt.setEndDate(policy.getExpireDate());
        wipPrlPartPlanExtMapper.insertSelective(wipPrlPartPlanExt);
        //設置被保險人信息及標的信息
        log.info("WipPrlPartPlanJdInsExt..");
        WipPrlPartPlanJdInsExt wipPrlPartPlanJdInsExt = null;
        WipPrlPartPlanInsRiskExt wipPrlPartPlanInsRiskExt = null;
        long insuredId = 0;
        BigDecimal totalPreium = BigDecimal.ZERO;
        BigDecimal totalSumInsured = BigDecimal.ZERO;
        for(OPInsured insured : insureds){
        	insuredId = commonService.getSequenceValue(PolicyConst.SequenceList.INS_INSURED_ID.value);
        	wipPrlPartPlanJdInsExt = new WipPrlPartPlanJdInsExt();
        	wipPrlPartPlanJdInsExt.setContractId(contractId);
        	wipPrlPartPlanJdInsExt.setInsuredId(insuredId);
        	wipPrlPartPlanJdInsExt.setPartitionNo(PolicyConst.PartitionNo);
        	wipPrlPartPlanJdInsExt.setActionCode(PolicyConst.ADDED_FLAG);
        	wipPrlPartPlanJdInsExt.setPlanId(wipPrlPartPlanExt.getPlanId());
        	wipPrlPartPlanJdInsExt.setPlanVersionNo(wipPrlPartPlanExt.getPlanVersionNo());
        	wipPrlPartPlanJdInsExt.setStartDate(policy.getEffectiveDate());
        	wipPrlPartPlanJdInsExt.setEndDate(policy.getExpireDate());
        	wipPrlPartPlanJdInsExt.setWteStartDate(insured.getWteStartDate());
        	wipPrlPartPlanJdInsExt.setWteEndDate(insured.getWteEndDate());
        	if(PolicyConst.PolicyHolderType.ENTERPRISE.equals(insured.getInsuredType()) && Beans.isNotEmpty(insured.getPartnerRef())){
            	customInfoINS= commonService.getCustomerInfo(insured.getPartnerRef());
                if(Beans.isEmpty(customInfoINS)){
                    throw new CustomException("2004");
                }
                wipPrlPartPlanJdInsExt.setName(Beans.isEmpty(insured.getName())? customInfoINS.getNameZhs() : insured.getName());
                wipPrlPartPlanJdInsExt.setInsuredType(PolicyConst.PolicyHolderType.ENTERPRISE);
                wipPrlPartPlanJdInsExt.setIdType(customInfoINS.getIdType());
                wipPrlPartPlanJdInsExt.setIdNo(customInfoINS.getIdNo());
                if(Beans.isNotEmpty(insured.getMobileNo())){
                	wipPrlPartPlanJdInsExt.setMobileNo(insured.getMobileNo());
                }else {
                	wipPrlPartPlanJdInsExt.setMobileNo(customInfoINS.getPhoneNo());
    			}
                wipPrlPartPlanJdInsExt.setPartnerId(customInfoINS.getPartId());
        	}else{
	        	Beans.copy(wipPrlPartPlanJdInsExt, insured);
	        	wipPrlPartPlanJdInsExt.setIdType(Beans.isNotEmpty(insured.getIdType())? insured.getIdType().toString() : null);
	        	if(!PolicyConst.SubProduct.DamageWarrantyLiability.value.equals(productCode) && !PolicyConst.SubProduct.ExtendedWarrantyLiability.value.equals(productCode) && !PolicyConst.SubProduct.ReturnShipmentCostInsurance.value.equals(productCode) && Beans.isEmpty(insured.getBeneficialType())){
	        		wipPrlPartPlanJdInsExt.setBeneficialType(PolicyConst.BeneficialType.LEGAL);
	        	}
        	}
        	
        	BigDecimal insPreium = BigDecimal.ZERO;
        	if(Beans.isNotEmpty(insured.getInsuredRiskList())){
        		for(OPInsuredRisk insuredRisk :insured.getInsuredRiskList()){
        			wipPrlPartPlanInsRiskExt = new WipPrlPartPlanInsRiskExt();
        			wipPrlPartPlanInsRiskExt.setContractId(contractId);
        			wipPrlPartPlanInsRiskExt.setPartitionNo(PolicyConst.PartitionNo);
        			wipPrlPartPlanInsRiskExt.setActionCode(PolicyConst.ADDED_FLAG);
        			wipPrlPartPlanInsRiskExt.setInsuredId(insuredId);
        			Beans.copy(wipPrlPartPlanInsRiskExt, insuredRisk);
        			insPreium = insPreium.add(insuredRisk.getPremium()).setScale(2, RoundingMode.HALF_UP);
        			totalPreium = totalPreium.add(insuredRisk.getPremium()).setScale(2, RoundingMode.HALF_UP);
        			totalSumInsured = totalSumInsured.add(insuredRisk.getSumInsured()).setScale(2, RoundingMode.HALF_UP);
        			wipPrlPartPlanInsRiskExtMapper.insertSelective(wipPrlPartPlanInsRiskExt);
        		}
        	}
        	wipPrlPartPlanJdInsExt.setPremTotal(insPreium);
        	wipPrlPartPlanJdInsExt.setPremA(insPreium.multiply(new BigDecimal(planInfo.getAccidentPerc())).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP));
        	wipPrlPartPlanJdInsExt.setPremH(insPreium.subtract(wipPrlPartPlanJdInsExt.getPremA()));
        	wipPrlPartPlanJdInsExtMapper.insertSelective(wipPrlPartPlanJdInsExt);
        }
        //設置保障利益信息。 WipPrlPartPlanBenExt
        log.info("WipPrlPartPlanBenExt..");
        List<BenefitInfo> benefits = commonService.getPlanBenefitInfo(wipPrlPartPlanExt.getPlanId(), wipPrlPartPlanExt.getPlanVersionNo());
        if(Beans.isNotEmpty(benefits)){
        	for(BenefitInfo benefitInfo :benefits){
	        	WipPrlPartPlanBenExt wipPrlPartPlanBenExt = new WipPrlPartPlanBenExt();
	            wipPrlPartPlanBenExt.setActionCode(PolicyConst.ADDED_FLAG);
	            wipPrlPartPlanBenExt.setContractId(contractId);
	            wipPrlPartPlanBenExt.setPartitionNo(PolicyConst.PartitionNo);
	            wipPrlPartPlanBenExt.setPlanId(wipPrlPartPlanExt.getPlanId());
	            wipPrlPartPlanBenExt.setPlanVersionNo(wipPrlPartPlanExt.getPlanVersionNo());
	            Beans.copy(wipPrlPartPlanBenExt, benefitInfo);
	            wipPrlPartPlanBenExt.setSumInsured(totalSumInsured);
	            if(Beans.isNotEmpty(benefitInfo.getPolicySi()) && PolicyConst.ONE==benefitInfo.getPolicySi()){
	            	wipPrlPartPlanBenExt.setPolicySi(totalSumInsured);
	            }
	            wipPrlPartPlanBenExtMapper.insertSelective(wipPrlPartPlanBenExt);
        	}
        }
        qro= preIssuePolicy(jsonRequest, contractId,status);
		}catch (Exception e) {
			transactionManager.rollback(status);
			log.error(e);
			if (e instanceof CustomException ) {
				throw (CustomException)e;
			}else {
				throw new CustomException(PolicyConst.ErrorCode.systemerror.value);
			}
		}
        return qro;
	}
	@Transactional
	public QueryResultObject preIssuePolicy(JsonRequest jsonRequest,Long contractId,TransactionStatus status) {
		JsonRequestHead head = jsonRequest.getHead();
		BigDecimal adjustPremium = null;
		log.info("preIssuePolicy start..." );
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("p_contract_id", contractId);
        map.put("p_userid", head.getUser());
        map.put("p_policy_ref", null);
        map.put("p_cbc_flag", null);
        map.put("p_adjust_prem", null);
        map.put("p_error_message", null);
        map.put("p_fix_cbc", null);
        map.put("p_old_contract_id", null);
        map.put("p_result", null);
        commonService.preIssuePolicy4Others(map);
        log.info("preIssuePolicy end : " + map.get("p_result")+" , "+map.get("p_error_message")+" , "+map.get("p_policy_ref")+" , "+map.get("p_adjust_prem")+" , "+map.get("p_cbc_flag"));
        String cbcFlag = String.valueOf(map.get("p_cbc_flag"));
        if (Beans.isNotEmpty(map.get("p_result")) && PolicyConst.FunctionResult.success.value.equals(map.get("p_result").toString())) {
        	adjustPremium = (BigDecimal)map.get("p_adjust_prem");
        	 if (PolicyConst.CBCFlag.noCBC.value.equals(cbcFlag)) {
        		map.clear();
     	        map.put("p_contract_id", contractId);
     	        map.put("p_userid", head.getUser());
     	        map.put("p_adjust_prem", adjustPremium);
     	        map.put("p_error_message", null);
     	        map.put("p_booking_settle_flag", PolicyConst.NO);
     	        map.put("p_result", null);
     	        log.info("issuePolicy start..."); 
     	        commonService.issuePolicy4Others(map);
     	        log.info("issuePolicy end : " + map.get("p_result")+" , "+map.get("p_error_message"));
				transactionManager.commit(status);
     	        if(Beans.isNotEmpty(map.get("p_result")) && PolicyConst.FunctionResult.success.value.equals(map.get("p_result").toString())) {
     	        	super.doBookingSettle4Others(contractId);
     	        }else{
     	        	throw new CustomException("1037");
     	        }
        	 }else if (PolicyConst.CBCFlag.CBC.value.equals(cbcFlag)) {
        		 
        	 }else{
                 throw new CustomException("1039");
             }
        }else{
            throw new CustomException("1002");
        }
        return commonService.getSuccessPolicy(contractId);
		
	}
	@RequestType(AbstractPolicyService.INIT+PolicyConst.RequestType.REQ_TYPE_POLICYCONFIRM_OP)
	//@Transactional(rollbackFor=Exception.class)
	public Object initJDPolicyConfirm(JsonRequest jsonRequest) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW); // 事物隔离级别，开启新事务，这样会比较安全些。
		TransactionStatus status = transactionManager.getTransaction(def); // 获得事务状态
		String result =null;
		Map<String, Object> map = new HashMap<String, Object>();
		try{
		
		//取得各个JSON对象
		JsonRequestHead head = jsonRequest.getHead();
		OPConfirmBody body = (OPConfirmBody)jsonRequest.getBody();
		Agency agency = body.getAgency();
		OPPolicy policy = body.getPolicy();
		//OPPolicyHolder policyHolder = body.getPolicyHolder();
		//List<OPInsured> insureds = body.getInsuredList();
		
/*		Long contractIdExists = commonService.validatePolicyIsExist(head.getUser(), policy.getAgencyPolicyRef());
        if(Beans.isNotEmpty(contractIdExists)){
        	return contractIdExists;
        }*/
        
        if (policy.getEffectiveDate().before(new Date()) && !commonService.getBackDateFlag(head.getUser())) {
        	throw new CustomException("1018");
		}
		//查询配置信息
		UserInfo user = commonService.getUserInfo(head.getUser());
		PartnerInfo agencyInfo = commonService.getAgencyInfo(agency.getAgencyCode());
		if (Beans.isEmpty(agencyInfo) || Beans.isEmpty(agencyInfo.getPartId())) {
			throw new CustomException("1125");
		}
		PlanInfo planInfo = commonService.getAssignedPlanInfoByPlanCode(user.getUserCode(), agencyInfo.getPartId(), user.getBranchCode(), policy.getPlanCode(), new java.sql.Date(policy.getEffectiveDate().getTime()));
		if (Beans.isEmpty(planInfo) || Beans.isEmpty(planInfo.getPlanId())) {
			throw new CustomException("1007");
		}
		body.setAgencyInfo(agencyInfo);
		body.setPlanInfo(planInfo);
		body.setUser(user);
		
		//validate json 
		this.validateJson(jsonRequest);
		
		//调用NewBusiness，生成contract_id
		log.info("initJDPolicyConfirm newBusiness..");
		String staffCode = Beans.isEmpty(user.getStaffCode()) ? body.getAgency().getStaffCode() : user.getStaffCode(); 
		if (Beans.isEmpty(staffCode)) {
			staffCode = agencyInfo.getStaffCode();
		}		
		map.put("p_contract_id", null);
		map.put("p_result", null);
		map.put("p_username", user.getUserCode());
		map.put("p_term_start_date", null);
		map.put("p_agency_id", user.getPartnerId());
		map.put("p_phi_id", null);
		map.put("p_staff_code", staffCode);
		map.put("p_business_source", agencyInfo.getBusinessSource());//businessSource
        map.put("p_branch_code", user.getBranchCode());
        map.put("p_business_unit", agencyInfo.getBusinessUnit());//businessUnit
        map.put("p_product_code", planInfo.getProductCode());
        map.put("p_application_type", null);
        commonService.newBusiness(map);
        log.info("initJDPolicyConfirm newBusiness end, p_contract_id," + map.get("p_contract_id") + " ,p_result" + map.get("p_result"));

        transactionManager.commit(status);
		} catch (Exception e) {
			transactionManager.rollback(status);
			log.error(e);
			if (e instanceof CustomException ) {
				throw (CustomException)e;
			}else {
				throw new CustomException(PolicyConst.ErrorCode.systemerror.value);
			}
		}
        result =String.valueOf(map.get("p_result"));
        if(null != result && PolicyConst.FunctionResult.success.value.equals(result)){
        	return map.get("p_contract_id");
        }else if(null != result && PolicyConst.FunctionResult.error2.value.equals(result)){
            throw new CustomException("t0codeerr");
        }else if(null != result && PolicyConst.FunctionResult.error3.value.equals(result)){
            throw new CustomException("t2codeerr");
        }else {
            throw new CustomException("1041");
        }
	}
	
	@RequestType(AbstractPolicyService.INIT+PolicyConst.RequestType.REQ_TYPE_ENDORSEMENT_RISK_OP)
	//@Transactional
	public Object initJDRiskEndorsement(JsonRequest jsonRequest) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW); // 事物隔离级别，开启新事务，这样会比较安全些。
		TransactionStatus status = transactionManager.getTransaction(def); // 获得事务状态
		Long contractId = null;
		try{
		//取得各个JSON对象
		//JsonRequestHead head = jsonRequest.getHead();
		OPEndorsementBody body = (OPEndorsementBody)jsonRequest.getBody();
		//OPEndorsementPolicy policy = body.getPolicy();
		List<OPEndorsementInsuredRisk> insuredRiskList = body.getInsuredRiskList();
        if(Beans.isEmpty(insuredRiskList)){
        	throw new CustomException("7002");
        }
		contractId = commonService.invokeUpdate4OP(jsonRequest);
		
		transactionManager.commit(status);
		} catch (Exception e) {
			transactionManager.rollback(status);
			log.error(e);
			if (e instanceof CustomException ) {
				throw (CustomException)e;
			}else {
				throw new CustomException(PolicyConst.ErrorCode.systemerror.value);
			}
		}
		return contractId;
	}
	
	@RequestType(AbstractPolicyService.EXECUTE+PolicyConst.RequestType.REQ_TYPE_ENDORSEMENT_RISK_OP)
	//@Transactional
	public QueryResultObject executeJDRiskEndorsement(JsonRequest jsonRequest,Long contractId) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW); // 事物隔离级别，开启新事务，这样会比较安全些。
		TransactionStatus status = transactionManager.getTransaction(def); // 获得事务状态
		QueryResultObject qro= null;
		try{
		//取得各个JSON对象
		JsonRequestHead head = jsonRequest.getHead();
		OPEndorsementBody body = (OPEndorsementBody)jsonRequest.getBody();
		OPEndorsementPolicy policy = body.getPolicy();
		List<OPEndorsementInsuredRisk> insuredRiskList = body.getInsuredRiskList();
		
		WipPrlPartPlanBenExt wipPrlPartPlanBenExt = wipPrlPartPlanBenExtMapper.selectByContractId(contractId).get(0);
        WipPrlPartPlanInsRiskExt wipPrlPartPlanInsRiskExt = null;
        HashMap<Long, BigDecimal> ins_adjPremium_HM = new HashMap<Long, BigDecimal>();
        BigDecimal totalSumInsured = wipPrlPartPlanBenExt.getSumInsured();
        BigDecimal adjPreium = BigDecimal.ZERO;

		for(OPEndorsementInsuredRisk insuredRisk :insuredRiskList){
			wipPrlPartPlanInsRiskExt = wipPrlPartPlanInsRiskExtMapper.selectByBusinessPK(contractId, insuredRisk.getThirdPartPolicyNo());
			if (PolicyConst.DELETE_FLAG.equals(insuredRisk.getActionCode())) {
    			if (Beans.isEmpty(wipPrlPartPlanInsRiskExt)) {
    				throw new CustomException("7003", insuredRisk.getThirdPartPolicyNo());
				}
				adjPreium = wipPrlPartPlanInsRiskExt.getPremium().multiply(new BigDecimal("-1"));
				totalSumInsured = totalSumInsured.subtract(wipPrlPartPlanInsRiskExt.getSumInsured());
				wipPrlPartPlanInsRiskExt.setActionCode(PolicyConst.DELETE_FLAG);
			}else {
				throw new CustomException("1095");
			}
			if (!ins_adjPremium_HM.containsKey(wipPrlPartPlanInsRiskExt.getInsuredId())) {
				ins_adjPremium_HM.put(wipPrlPartPlanInsRiskExt.getInsuredId(), adjPreium);
			}else {
				ins_adjPremium_HM.put(wipPrlPartPlanInsRiskExt.getInsuredId(), ins_adjPremium_HM.get(wipPrlPartPlanInsRiskExt.getInsuredId()).add(adjPreium));
			}
			wipPrlPartPlanInsRiskExtMapper.updateByPrimaryKeySelective(wipPrlPartPlanInsRiskExt);
		}
		if(wipPrlPartPlanBenExt.getSumInsured().compareTo(totalSumInsured) != 0){
	        wipPrlPartPlanBenExt.setSumInsured(totalSumInsured);
	        wipPrlPartPlanBenExt.setPolicySi(totalSumInsured);
	        wipPrlPartPlanBenExt.setActionCode(PolicyConst.CHANGE_FLAG);
	        wipPrlPartPlanBenExtMapper.updateByPrimaryKeySelective(wipPrlPartPlanBenExt);
	        
			WipPrlFirePartitionExtKey wipPrlFirePartitionExtKey = new WipPrlFirePartitionExtKey();
	        wipPrlFirePartitionExtKey.setContractId(contractId);
	        wipPrlFirePartitionExtKey.setPartitionNo(PolicyConst.PartitionNo);
	        WipPrlFirePartitionExt wipPrlFirePartitionExt = wipPrlFirePartitionExtMapper.selectByPrimaryKey(wipPrlFirePartitionExtKey);
	        wipPrlFirePartitionExt.setTotalSumInsured(totalSumInsured);
	        wipPrlFirePartitionExt.setActionCode(PolicyConst.CHANGE_FLAG);
	        wipPrlFirePartitionExtMapper.updateByPrimaryKeySelective(wipPrlFirePartitionExt);
		}
        
		PlanInfo planInfo = commonService.getPlanInfoByPlanIdAndVersionNo(wipPrlPartPlanBenExt.getPlanId(), wipPrlPartPlanBenExt.getPlanVersionNo());
		
        WipPrlPartPlanJdInsExtKey wipPrlPartPlanJdInsExtKey = null;
        WipPrlPartPlanJdInsExt wipPrlPartPlanJdInsExt = null;
        if (Beans.isNotEmpty(ins_adjPremium_HM)) {
        	Set<Map.Entry<Long, BigDecimal>> ins_adjPremium_set = ins_adjPremium_HM.entrySet();
            for(Map.Entry<Long, BigDecimal> map: ins_adjPremium_set){
            	wipPrlPartPlanJdInsExtKey = new WipPrlPartPlanJdInsExtKey();
            	wipPrlPartPlanJdInsExtKey.setContractId(contractId);
            	wipPrlPartPlanJdInsExtKey.setPartitionNo(PolicyConst.PartitionNo);
            	wipPrlPartPlanJdInsExtKey.setInsuredId(map.getKey());
            	wipPrlPartPlanJdInsExt = wipPrlPartPlanJdInsExtMapper.selectByPrimaryKey(wipPrlPartPlanJdInsExtKey);
            	if (BigDecimal.ZERO.compareTo(map.getValue()) != 0) {
                	wipPrlPartPlanJdInsExt.setPremTotal(wipPrlPartPlanJdInsExt.getPremTotal().add(map.getValue()));
                	wipPrlPartPlanJdInsExt.setPremA(wipPrlPartPlanJdInsExt.getPremTotal().multiply(new BigDecimal(planInfo.getAccidentPerc())).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP));
    	        	wipPrlPartPlanJdInsExt.setPremH(wipPrlPartPlanJdInsExt.getPremTotal().subtract(wipPrlPartPlanJdInsExt.getPremA()));
    	        	wipPrlPartPlanJdInsExt.setActionCode(PolicyConst.CHANGE_FLAG);
    	        	wipPrlPartPlanJdInsExtMapper.updateByPrimaryKeySelective(wipPrlPartPlanJdInsExt);
				}
            }
		}
        
        PrlEndorsementInfo prlEndorsementInfo = new PrlEndorsementInfo();
        prlEndorsementInfo.setContractId(contractId);
        prlEndorsementInfo.setGpaCode(policy.getEndorsementType());
        prlEndorsementInfo.setEndorDate(policy.getEndorseEffectiveDate());
        prlEndorsementInfo.setChangeDesc(policy.getChangeDesc());
        prlEndorsementInfoMapper.insertSelective(prlEndorsementInfo);
        qro=  preIssuePolicy(jsonRequest, contractId,status);
        
		}catch(Exception e){
			e.printStackTrace();
			transactionManager.rollback(status);
			log.error(e);
			if (e instanceof CustomException ) {
				throw (CustomException)e;
			}else {
				throw new CustomException(PolicyConst.ErrorCode.systemerror.value);
			}
		}
        return qro;
	}
	
	private  void validateJson(JsonRequest jsonRequest) {
		//JsonRequestHead head = jsonRequest.getHead();
		OPConfirmBody body = (OPConfirmBody)jsonRequest.getBody();
		//Agency agency = body.getAgency();
		//OPPolicy policy = body.getPolicy();
		//OPPolicyHolder policyHolder = body.getPolicyHolder();
		List<OPInsured> insureds = body.getInsuredList();
		
		if (PolicyConst.SubProduct.ExtendedWarrantyLiability.value.equals(body.getPlanInfo().getProductCode())){
			if (Beans.isNotEmpty(insureds)) {
				for (OPInsured insured : insureds) {
					if (Beans.isEmpty(insured.getWteStartDate()) || Beans.isEmpty(insured.getWteEndDate())) {
						throw new CustomException("7001", insured.getName());
					}
				}
			}
		}
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void testTX() {
		PrlCommonQuotePolicyAll prlCommonQuotePolicyAll = new PrlCommonQuotePolicyAll();
        prlCommonQuotePolicyAll.setInsuredName("TEST");
        prlCommonQuotePolicyAll.setBranchCode("201");
        prlCommonQuotePolicyAll.setSalesCode("TEST");
        if(Beans.isEmpty(prlCommonQuotePolicyAll.getApplicationDate()) && Beans.isEmpty(prlCommonQuotePolicyAll.getIssueDate())){
        	prlCommonQuotePolicyAll.setApplicationDate(new Date());
        }
        prlCommonQuotePolicyAll.setSalesChannel("1743");
        prlCommonQuotePolicyAll.setContractCurrency("rm");
        prlCommonQuotePolicyAllMapper.insertSelective(prlCommonQuotePolicyAll);
        
		/*PrlCommonQuotePolicyAll prlCommonQuotePolicyAll2 = new PrlCommonQuotePolicyAll();
		prlCommonQuotePolicyAll2.setInsuredName("TEST");
        prlCommonQuotePolicyAll2.setBranchCode("201");
        prlCommonQuotePolicyAll2.setSalesCode("TEST");
        if(Beans.isEmpty(prlCommonQuotePolicyAll.getApplicationDate()) && Beans.isEmpty(prlCommonQuotePolicyAll.getIssueDate())){
        	prlCommonQuotePolicyAll2.setApplicationDate(new Date());
        }
        prlCommonQuotePolicyAll2.setSalesChannel("1743");
        prlCommonQuotePolicyAll2.setContractCurrency("RMRMBRMBRMBB");
        prlCommonQuotePolicyAllMapper.insertSelective(prlCommonQuotePolicyAll2);*/
        
        WipPolicyContracts wipPolicyContracts = new WipPolicyContracts();
        wipPolicyContracts.setContractId(99l);
        wipPolicyContracts.setContractCurrency("RMRMBRMBRMBB");
        wipPolicyContractsMapper.insert(wipPolicyContracts);
	}
}
