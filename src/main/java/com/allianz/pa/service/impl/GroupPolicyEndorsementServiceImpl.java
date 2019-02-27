package com.allianz.pa.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.allianz.pa.common.annotation.RequestType;
import com.allianz.pa.common.bean.PlanInfo;
import com.allianz.pa.common.bean.QueryResultObject;
import com.allianz.pa.common.bean.UserInfo;
import com.allianz.pa.common.consant.PolicyConst;
import com.allianz.pa.common.exception.CustomException;
import com.allianz.pa.common.util.Beans;
import com.allianz.pa.common.util.ResourceUtil;
import com.allianz.pa.dao.PrlEndorsementInfoMapper;
import com.allianz.pa.dao.WipPrlPartInsBenExtMapper;
import com.allianz.pa.dao.WipPrlPartInsEmgExtMapper;
import com.allianz.pa.dao.WipPrlPartPlanInsExtMapper;
import com.allianz.pa.dto.common.JsonRequest;
import com.allianz.pa.dto.common.JsonRequestHead;
import com.allianz.pa.dto.common.standard.BeneficiaryVO;
import com.allianz.pa.dto.common.standard.ContactPersonVO;
import com.allianz.pa.dto.request.endorsement.common.EndorsementBody;
import com.allianz.pa.dto.request.endorsement.common.EndorsementInsured;
import com.allianz.pa.dto.request.endorsement.common.EndorsementPlan;
import com.allianz.pa.dto.request.endorsement.common.EndorsementPolicy;
import com.allianz.pa.entity.PrlEndorsementInfo;
import com.allianz.pa.entity.WipPrlPartInsBenExt;
import com.allianz.pa.entity.WipPrlPartInsEmgExt;
import com.allianz.pa.entity.WipPrlPartPlanInsExt;
import com.allianz.pa.service.AbstractPolicyGroupService;
import com.allianz.pa.service.GroupPolicyEndorsementService;

@Service("groupPolicyEndorsementService")
public class GroupPolicyEndorsementServiceImpl extends AbstractPolicyGroupService implements GroupPolicyEndorsementService {
	private static final Logger log = Logger.getLogger(GroupPolicyEndorsementServiceImpl.class);
	@Resource
	DataSourceTransactionManager transactionManager;
	
	@Resource
	private WipPrlPartInsBenExtMapper wipPrlPartInsBenExtMapper;
	
	@Resource
	private WipPrlPartInsEmgExtMapper wipPrlPartInsEmgExtMapper;
	
	@Resource
	private WipPrlPartPlanInsExtMapper wipPrlPartPlanInsExtMapper;
	
	@Resource
	private PrlEndorsementInfoMapper prlEndorsementInfoMapper;
	
	@RequestType(AbstractPolicyGroupService.INIT+PolicyConst.RequestType.REQ_TYPE_ENDORSEMENT_GROUP)
	public Object initEndorForThird(JsonRequest jsonRequest) {
		initGPEndorsement(jsonRequest);
		JsonRequestHead requestHead = jsonRequest.getHead();
		EndorsementBody body = (EndorsementBody) jsonRequest.getBody();
		UserInfo user = commonService.getUserInfo(requestHead.getUser());
    	//团险批改校验
    	validateInsuredInfo(jsonRequest);
    	//非团险校验(包含黑名单校验)
    	validatePolicy(user,jsonRequest);
    	//校验渠道
    	validateAgency(body.getAgency().getAgencyCode());
    	//校验机构
    	validateInstitution(user.getUserCode());
    	//校验存在错误则不继续进行之后操作
    	if(Beans.isNotEmpty(errorList)) {
    		return null;
    	}
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW); // 事物隔离级别，开启新事务，这样会比较安全些。
		TransactionStatus status = transactionManager.getTransaction(def); // 获得事务状态
		Long contractId = null;
		try{
        log.info("初始化OTI policy主表..");
		contractId = commonService.invokeUpdateOTI(jsonRequest);
		
		transactionManager.commit(status);
		} catch (Exception e) {
			e.printStackTrace();
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
	
	@RequestType(AbstractPolicyGroupService.EXECUTE+PolicyConst.RequestType.REQ_TYPE_ENDORSEMENT_GROUP)
	public QueryResultObject executeOTIEndorsement(JsonRequest jsonRequest) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW); // 事物隔离级别，开启新事务，这样会比较安全些。
		TransactionStatus status = transactionManager.getTransaction(def); // 获得事务状态
		EndorsementBody body = (EndorsementBody) jsonRequest.getBody();
		List<EndorsementPlan> planList = body.getPlanList();
		QueryResultObject prePolicy = commonService.getPolicyInfoByRef(body.getPolicy().getPolicyRef());
		Long contractId = prePolicy.getContractId();
		Integer versionNo = prePolicy.getVersionNo();
		Map<String, Object> planParam =  new HashMap<String, Object>();
		planParam.put("contractId", contractId);
		//计算保费
		QueryResultObject resObject =calculateTotalPreium(jsonRequest,contractId);
		PlanInfo planObj = null;
        BigDecimal insPremAccident = null;
        BigDecimal insPremHealth = null;
        List<WipPrlPartPlanInsExt> wipInsAddList = new ArrayList<WipPrlPartPlanInsExt>();
        List<WipPrlPartPlanInsExt> wipInsUpdateList = new ArrayList<WipPrlPartPlanInsExt>();
        List<WipPrlPartInsBenExt> beneficiaryBigList = new ArrayList<WipPrlPartInsBenExt>();
        List<WipPrlPartInsEmgExt> emergencyContactBigList = new ArrayList<WipPrlPartInsEmgExt>();
        long insuredId = 0;
        long benId = 0;
        long emgId = 0;
		for (EndorsementPlan endorsementPlan : planList) {
			planParam.put("planCode", endorsementPlan.getPlanCode());
			planObj = commonService.getPlanInfoByContractId(planParam);
			List<EndorsementInsured> insuredList= endorsementPlan.getInsuredList();
			for (EndorsementInsured insured : insuredList) {
				insuredId = commonService.getSequenceValue(PolicyConst.SequenceList.OTI_INS_INSURED_ID.value);
				WipPrlPartPlanInsExt wipIns = new WipPrlPartPlanInsExt();
				wipIns.setInsuredId(insuredId);
				wipIns.setContractId(contractId);
				wipIns.setVersionNo(versionNo);
				wipIns.setPlanId(planObj.getPlanId().shortValue());
				wipIns.setPartitionNo(planObj.getPartitionNo());
				wipIns.setPlanVersionNo(planObj.getVersionNo().shortValue());
				wipIns.setStartDate(insured.getStartDate());
				wipIns.setEndDate(insured.getEndDate());
				wipIns.setActionCode(insured.getActionCode());
	            wipIns.setBeneficialType(insured.getBeneficialType());
	            wipIns.setDob(insured.getBirthDate() == null ? null : new Timestamp(insured.getBirthDate().getTime()));
	            wipIns.setEmail(insured.getEmail());
	            wipIns.setIdNo(insured.getIdNumber());
	            wipIns.setIdType(insured.getIdType());
	            wipIns.setInsuredType(insured.getInsuredType());
	            wipIns.setMobileNo(insured.getMobile());
	            wipIns.setName(insured.getInsuredName());
	            wipIns.setSex(insured.getGender());
	            wipIns.setSettleCompany(insured.getSettleCompany());
	            //传入的InsuredId对应表里面的PartInsuredId
	            wipIns.setPartInsuredId(insured.getInsuredId());
	            //职业 for b2c joe 2015-5-4
	            wipIns.setTravelCode(insured.getOccupationCode());
	            //保费相关数据更新
	            wipIns.setPremTotal(insured.getPremium().shortValue());
                insPremAccident = insured.getPremium().multiply(new BigDecimal(planObj.getAccidentPerc())).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
                insPremHealth = insured.getPremium().subtract(insPremAccident);
                wipIns.setPremA(insPremAccident.shortValue());
                wipIns.setPremH(insPremHealth.shortValue());
                if(PolicyConst.ADDED_FLAG.equals(insured.getActionCode())) {
                	wipInsAddList.add(wipIns);
                } else {
                	wipInsUpdateList.add(wipIns);
                }
                List<BeneficiaryVO> beneficiaryList = insured.getBeneficiaryList();
                if(Beans.isNotEmpty(beneficiaryList)){
	                for (BeneficiaryVO beneficiaryVO : beneficiaryList) {
	                	WipPrlPartInsBenExt benExt = new WipPrlPartInsBenExt();
	                	benId = commonService.getSequenceValue(PolicyConst.SequenceList.OTI_INS_INSURED_BEN_ID.value);
	                	benExt.setBenId(benId);
	                	benExt.setInsuredId(insuredId);
	                	benExt.setContractId(contractId);
	                	benExt.setActionCode(PolicyConst.ADDED_FLAG);
	                	benExt.setName(beneficiaryVO.getBeneficiaryName());
	                	benExt.setIdType(beneficiaryVO.getIdType());
	                	benExt.setIdNo(beneficiaryVO.getIdNumber());
	                	benExt.setMobileNo(beneficiaryVO.getMobile());
	                	benExt.setRelation(beneficiaryVO.getRelationship());
	                	benExt.setPercent(beneficiaryVO.getPercentage().shortValue());
	                	benExt.setEmail(beneficiaryVO.getEmail());
	                	benExt.setPartitionNo(planObj.getPartitionNo());
	                	beneficiaryBigList.add(benExt);
					}
                }
                List<ContactPersonVO> emergencyContactList = insured.getEmergencyContactList();
                if(Beans.isNotEmpty(emergencyContactList)){
	                for (ContactPersonVO contactPersonVO : emergencyContactList) {
	                	WipPrlPartInsEmgExt emgExt = new WipPrlPartInsEmgExt();
	                	emgId = commonService.getSequenceValue(PolicyConst.SequenceList.OTI_INS_INSURED_EMG_ID.value);
	                	emgExt.setEmgId(emgId);
	                	emgExt.setInsuredId(insuredId);
	                	emgExt.setContractId(contractId);
	                	emgExt.setActionCode(PolicyConst.ADDED_FLAG);
	                	emgExt.setName(contactPersonVO.getContactName());
	                	emgExt.setIdType(contactPersonVO.getIdType());
	                	emgExt.setIdNo(contactPersonVO.getIdNumber());
	                	emgExt.setEmail(contactPersonVO.getEmail());
	                	emgExt.setMobileNo(contactPersonVO.getMobile());
	                	emgExt.setContactAddress(contactPersonVO.getContactAddress());
	                	emgExt.setPartitionNo(planObj.getPartitionNo());
	                	emergencyContactBigList.add(emgExt);
					}
                }
			}
		}
		//相关数据入值到wip表
		try{
			//数据批量入值wipInsAddList、wipInsUpdateList
			if(Beans.isNotEmpty(wipInsAddList)) {
				wipPrlPartPlanInsExtMapper.insertByBatch(wipInsAddList);
			}
			if(Beans.isNotEmpty(wipInsUpdateList)) {
				wipPrlPartPlanInsExtMapper.updateByBatchSelective(wipInsUpdateList);
			}
		
			if(Beans.isNotEmpty(beneficiaryBigList)) {
				//受益人入值
				wipPrlPartInsBenExtMapper.insertByBatch(beneficiaryBigList);
			}
			
			if(Beans.isNotEmpty(emergencyContactBigList)) {
				//紧急联系人入值
				wipPrlPartInsEmgExtMapper.insertByBatch(emergencyContactBigList);
			}
			
			PrlEndorsementInfo prlEndorsementInfo = new PrlEndorsementInfo();
	        prlEndorsementInfo.setContractId(contractId);
	        prlEndorsementInfo.setGpaCode(body.getPolicy().getEndorsementType());
	        prlEndorsementInfo.setEndorDate(body.getPolicy().getEndorseEffectiveDate());
	        prlEndorsementInfo.setChangeDesc(PolicyConst.CHANGE_DESC); //暂时没有传入
	        prlEndorsementInfoMapper.insertSelective(prlEndorsementInfo);
			resObject = preIssuePolicy(jsonRequest, contractId,status);
		} catch (Exception e) {
			transactionManager.rollback(status);
			log.error(e);
			if (e instanceof CustomException ) {
				throw (CustomException)e;
			}else {
				throw new CustomException(PolicyConst.ErrorCode.systemerror.value);
			}
		}
		return resObject;
	}
	
	@Transactional
	public QueryResultObject preIssuePolicy(JsonRequest jsonRequest,Long contractId,TransactionStatus status) {
		JsonRequestHead head = jsonRequest.getHead();
		EndorsementBody body = (EndorsementBody) jsonRequest.getBody();
		EndorsementPolicy policy = body.getPolicy();
		String issueFlag = policy.getIssueFlag();
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
        commonService.preIssuePolicyForOTI(map);
        log.info("preIssuePolicy end : " + map.get("p_result")+" , "+map.get("p_error_message")+" , "+map.get("p_policy_ref")+" , "+map.get("p_adjust_prem")+" , "+map.get("p_cbc_flag"));
        if("N".equals(issueFlag)) {//N-否  （选择“否”，则批单成功后需要通过调激活接口将保单激活）--入值完毕查询标志判断是否出单（调用对应存储过程）
        	return commonService.getSuccessPolicy(contractId);
        }
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
     	        commonService.issuePolicyForOTI(map);
     	        log.info("issuePolicy end : " + map.get("p_result")+" , "+map.get("p_error_message"));
				transactionManager.commit(status);
     	        if(Beans.isNotEmpty(map.get("p_result")) && PolicyConst.FunctionResult.success.value.equals(map.get("p_result").toString())) {
     	        	super.doBookingSettleForOTI(contractId);
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

	//----------add-start----------
	
	
	
	
	//----------add-end------------
}
