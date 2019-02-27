package com.allianz.pa.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.allianz.pa.common.bean.AppParameterInfo;
import com.allianz.pa.common.bean.PartnerInfo;
import com.allianz.pa.common.bean.PlanInfo;
import com.allianz.pa.common.bean.QueryResultObject;
import com.allianz.pa.common.bean.UserInfo;
import com.allianz.pa.common.consant.PolicyConst;
import com.allianz.pa.common.exception.CustomException;
import com.allianz.pa.common.util.Beans;
import com.allianz.pa.common.util.CommonUtils;
import com.allianz.pa.common.util.DateUtils;
import com.allianz.pa.common.util.IDUtil;
import com.allianz.pa.common.util.IDUtil.IDInfo;
import com.allianz.pa.common.util.ResourceUtil;
import com.allianz.pa.common.util.ThirdPartyCommonUtil;
import com.allianz.pa.dao.PrlCommonQuotePolicyAllMapper;
import com.allianz.pa.dto.common.JsonRequest;
import com.allianz.pa.dto.common.JsonRequestHead;
import com.allianz.pa.dto.common.JsonResponse;
import com.allianz.pa.dto.common.JsonResponseBody;
import com.allianz.pa.dto.common.JsonResponseHead;
import com.allianz.pa.dto.common.standard.CompanyInfoVO;
import com.allianz.pa.dto.common.standard.ErrorBean;
import com.allianz.pa.dto.common.standard.InsuredPremium;
import com.allianz.pa.dto.common.standard.UnderwritingDecision;
import com.allianz.pa.dto.request.endorsement.common.EndorsementBody;
import com.allianz.pa.dto.request.endorsement.common.EndorsementInsured;
import com.allianz.pa.dto.request.endorsement.common.EndorsementPlan;
import com.allianz.pa.dto.request.endorsement.common.EndorsementPolicy;
import com.allianz.pa.dto.request.policyconfirm.group.GPConfirmBody;
import com.allianz.pa.entity.PrlCommonQuotePolicyAll;
import com.allianz.pa.entity.PrlThirdpInterfPolData;

public abstract class AbstractPolicyGroupService extends AbstractService{

	private static final Logger log = Logger.getLogger(AbstractPolicyGroupService.class);
	public static final String INIT = "init";
	public static final String EXECUTE = "execute";
	
	@Resource
	private PrlCommonQuotePolicyAllMapper prlCommonQuotePolicyAllMapper;
	
	public List<ErrorBean> errorList = new ArrayList<ErrorBean>();
	@Override
	@Transactional(rollbackFor=Exception.class)
	public Object doBizOperation(JsonRequest jsonRequest) {
		errorList.clear();
		JsonRequestHead requestHead = jsonRequest.getHead();
		String currentType = requestHead.getRequestType();
		EndorsementBody body = (EndorsementBody) jsonRequest.getBody();
		EndorsementPolicy policy = body.getPolicy();
		String agencyPolicyRef = policy.getAgencyPolicyRef();
		String agencyCode = body.getAgency().getAgencyCode();
		String errorMsg = "";
        String errorCode = "";
        Object[] errorParams = null;
        QueryResultObject queryResult = null;
		Long contractId = null;
        boolean isPass = true;
        PrlThirdpInterfPolData polData = null;
        try { 
	        if(PolicyConst.RequestType.REQ_TYPE_ENDORSEMENT_GROUP .equals(currentType)
	        		|| PolicyConst.RequestType.REQ_TYPE_CONFIRM_GROUP.equals(currentType)) {//单核保接口不需要做请求校验
	        	polData = commonService.getPrlThirdpInterfPolDataByPk(agencyPolicyRef, agencyCode);
		        if(Beans.isEmpty(polData) || Beans.isEmpty(polData.getState())){
		        	polData = new PrlThirdpInterfPolData();
		        	polData.setState(PolicyConst.RequestState.waiting.value);
		        	polData.setSignMsg(requestHead.getRemoteHost());
		        	polData.setAgencyCode(agencyCode);
		        	polData.setRequestId(agencyPolicyRef);
		        	try {
		        		commonService.savePrlThirdpInterfPolData(polData);
					} catch (Exception e) {
						log.error("savePrlThirdpInterfPolData error: ", e);
						return ThirdPartyCommonUtil.createErrorResponse(requestHead,PolicyConst.ErrorCode.systemerror.value);
					}
		        }else if(PolicyConst.RequestState.waiting.value.equals(polData.getState())){
		        	return ThirdPartyCommonUtil.createErrorResponse(requestHead,PolicyConst.ErrorCode.systemhandle.value);
		        }else if(PolicyConst.RequestState.success.value.equals(polData.getState())){
		             return commonService.getAllreadySuccessPolicy(requestHead, polData.getContractId());
		        }else{
		        	polData.setState(PolicyConst.RequestState.waiting.value);
		        	polData.setSignMsg(requestHead.getRemoteHost());
		            try{
		            	commonService.updatePrlThirdpInterfPolData(polData);
			        } catch (Exception e) {
			        	log.error("updatePrlThirdpInterfPolData error: ", e);
						return ThirdPartyCommonUtil.createErrorResponse(requestHead,PolicyConst.ErrorCode.systemerror.value);
					}
		        }
	        }
	        //init
	        contractId = (Long)super.findProcessMethod(this, requestHead.getRequestType(), INIT).invoke(this, jsonRequest);
	        if(PolicyConst.RequestType.REQ_TYPE_ENDORSEMENT_GROUP .equals(currentType)
	        		|| PolicyConst.RequestType.REQ_TYPE_CONFIRM_GROUP.equals(currentType)) {
	        	try{
		        	polData.setContractId(contractId);
		        	commonService.updatePrlThirdpInterfPolData(polData);
		        } catch (Exception e) {
		        	log.error("updatePrlThirdpInterfPolData error: ", e);
		        	if (Beans.isNotEmpty(polData)) {
		            	polData.setState(PolicyConst.RequestState.exception.value);
		            	try {
							commonService.updatePrlThirdpInterfPolDataWithCurrentSqlSession(polData);
						} catch (Exception e2) {
							log.error("updatePrlThirdpInterfPolData error: ", e2);
						}
					}
		        	afterFailProcess(requestHead, contractId);
					return ThirdPartyCommonUtil.createErrorResponse(requestHead,PolicyConst.ErrorCode.systemerror.value);
				}
	        }
			Long contractIdExists = commonService.validatePolicyIsExist(requestHead.getUser(), Beans.isEmpty(agencyPolicyRef) ? "" : agencyPolicyRef);
	        if(Beans.isNotEmpty(contractIdExists)){
	        	return getCommonQuotePolicy(contractIdExists);
	        } else {
	        	//确认没有错误信息
	        	if(Beans.isEmpty(errorList)) {
	        		//execute
	        		queryResult = (QueryResultObject)super.findProcessMethod(this, requestHead.getRequestType(), EXECUTE).invoke(this, jsonRequest);
	        	}
	        }
        } catch (Exception e) {
        	e.printStackTrace();
			CustomException ce =null;
            if (e instanceof CustomException) {
                ce = (CustomException)e;
                errorCode = ce.getMessage();
                errorParams =ce.getValue();
                errorMsg = errorCode;
            }
            if (Beans.isNotEmpty(e.getCause()) && e.getCause() instanceof CustomException) {
                ce = (CustomException)e.getCause();
                errorCode = ce.getMessage();
                errorParams =ce.getValue();
                errorMsg = errorCode;
            }
            if (Beans.isEmpty(errorCode)) {
                errorCode = PolicyConst.ErrorCode.systemerror.value;
            }
            if (Beans.isNotEmpty(errorMsg)) {
                log.error("第三方接口出错:" + errorMsg);
            } else {
                log.error("第三方接口出错:" + e.getMessage());
            }
            if (Beans.isNotEmpty(e) && Beans.isNotEmpty(e.getCause())) {
            	log.error(e.getCause());
			}else if (Beans.isNotEmpty(e)) {
                log.error(e);
            }
            isPass = false;
		}
        if(PolicyConst.RequestType.REQ_TYPE_ENDORSEMENT_GROUP .equals(currentType)
        		|| PolicyConst.RequestType.REQ_TYPE_CONFIRM_GROUP.equals(currentType)) {
        	if(Beans.isNotEmpty(errorList)) {
        		isPass = false;
        	}
        	if (isPass) {//成功!
                log.info("第三方接口成功");
                errorCode = PolicyConst.ErrorCode.SUCCESS.value;
                if (Beans.isNotEmpty(polData)) {
                	polData.setState(PolicyConst.RequestState.success.value);
                	try {
    					commonService.updatePrlThirdpInterfPolDataWithCurrentSqlSession(polData);
    				} catch (Exception e) {
    					log.error("updatePrlThirdpInterfPolData error: ", e);
    				}
    			}
            } else {
                if (Beans.isNotEmpty(polData)) {
                	polData.setState(PolicyConst.RequestState.exception.value);
                	try {
    					commonService.updatePrlThirdpInterfPolDataWithCurrentSqlSession(polData);
    				} catch (Exception e) {
    					log.error("updatePrlThirdpInterfPolData error: ", e);
    				}
    			}
                // 投保失败后，删除已经生成的无用数据,批单只能abort
                afterFailProcess(requestHead, contractId);
            }
        }
        JsonResponse jr = ThirdPartyCommonUtil.createErrorResponse(requestHead, errorCode,errorParams);
        JsonResponseHead rshead = new JsonResponseHead();
		rshead.setRequestType(requestHead.getRequestType());
		JsonResponseBody rsbody = new JsonResponseBody();
        if(Beans.isEmpty(errorList)) {//成功则返回对应信息
			rshead.setResponseCode("1");
			rshead.setErrorCode("0000");
			rshead.setErrorMessage("成功");
			rsbody.setTotalPremium(queryResult.getTotalPremium());
			if(Beans.isNotEmpty(queryResult.getInsuredPremiumList())) {
				rsbody.setInsuredPremiumList(queryResult.getInsuredPremiumList());
			}
			if(Beans.isNotEmpty(queryResult.getPolicyStatus()) 
					&& (PolicyConst.RequestType.REQ_TYPE_ENDORSEMENT_GROUP .equals(currentType)
	        		|| PolicyConst.RequestType.REQ_TYPE_CONFIRM_GROUP.equals(currentType))) {
				rsbody.setPolicyStatus(queryResult.getPolicyStatus());
			}
			if (Beans.isNotEmpty(agencyPolicyRef)
					&& (PolicyConst.RequestType.REQ_TYPE_ENDORSEMENT_GROUP .equals(currentType)
	        		|| PolicyConst.RequestType.REQ_TYPE_CONFIRM_GROUP.equals(currentType))) {
				rsbody.setAgencyPolicyRef(agencyPolicyRef);
			}
			if(Beans.isNotEmpty(queryResult.getAdjustmentPremium())) {
				rsbody.setAdjustmentPremium(queryResult.getAdjustmentPremium());
			}
		} else {
			rshead.setResponseCode("0");
			rshead.setErrorCode("F001");
			rshead.setErrorMessage("失败");
			rsbody.setErrorList(errorList);
		}
		jr.setHead(rshead);
		jr.setBody(rsbody);
		return jr;
	}
	
	private void afterFailProcess(final JsonRequestHead head, final Long contractId) {
		if (Beans.isNotEmpty(contractId)) {
			try {
	            new Thread() {
	                public void run() {
	                    try {
	                    	if (PolicyConst.RequestType.REQ_TYPE_ENDORSEMENT_GROUP.equals(head.getRequestType())) {
	                		    commonService.abortOTIEndorsement(contractId);
	                		} else {
	                			commonService.deleteOTIErrorData(contractId);
	                		}
	                    } catch (Exception e) {
	                    	log.error("afterFailProcess fail : ", e);
	                    } 
	                }
	            }.start();
	        } catch (Exception e) {
	        	log.error("afterFailProcess Error: ", e);
	        }
		}
	}
	@Transactional
	public void doBookingSettleForOTI(final Long contractId) {
		try {
            new Thread() {
                public void run() {
                    try {
                        Integer do_result= commonService.doBookingSettleForOTI(contractId);
                        log.info("doBookingSettle: "+ do_result);
                    } catch (Exception e) {
                    	log.error("policyBooking fail : ", e);
                    } 
                }
            }.start();
        } catch (Exception e) {
        	log.error("PolicyConfirm Booking Error: ", e);
        }
	}
	
	/**
	 * 批单核保和批单出单时需要调用，投保出单不需要
	 * @param jsonRequest
	 */
	protected void initGPEndorsement(JsonRequest jsonRequest) {
		JsonRequestHead requestHead = jsonRequest.getHead();
		EndorsementBody body = (EndorsementBody) jsonRequest.getBody();
		EndorsementPolicy policy = body.getPolicy();
		String policyRef = policy.getPolicyRef();
        String agencyPolicyRef = policy.getAgencyPolicyRef();
        //公共校验
        if(Beans.isEmpty(policy.getPolicyRef())) {
    		setErrorInfo(errorList,"0001",ResourceUtil.errorCodeMsg("0001","policyRef"));
        }
        if(requestHead.getRequestType().equals(PolicyConst.RequestType.REQ_TYPE_ENDORSEMENT_GROUP)) {//批单出单时必填
        	if(Beans.isEmpty(agencyPolicyRef)) {
        		setErrorInfo(errorList,"0001",ResourceUtil.errorCodeMsg("0001","agencyPolicyRef"));
        	}
        	if(Beans.isEmpty(policy.getIssueFlag())) {
        		setErrorInfo(errorList,"0001",ResourceUtil.errorCodeMsg("0001","issueFlag"));
        	}
        }
		//MaxVersionPolicyNo校验
		String endorsePolicyRef = commonService.getMaxVersionPolicyNo(policyRef);
		if(StringUtils.isNotEmpty(endorsePolicyRef)) {
			policy.setPolicyRef(endorsePolicyRef);
		} else {
			log.info("保单查找批单号码为空");
			setErrorInfo(errorList,"5047",ResourceUtil.errorCodeMsg("5047"));
		}
		body.setPolicy(policy);
		
		//lundy 2015-06-16 对批量出单用户和中联保用户特殊处理-----(原逻辑代码批注)
        String zlbUser = commonService.getAppParameter(PolicyConst.APP_IG_EPOLICY,"zlb.username").getValue();
        if(Beans.isNotEmpty(requestHead.getUser()) && requestHead.getUser().equalsIgnoreCase(zlbUser) ){
            requestHead.setUser(body.getAgency().getAgencyCode());
        }
	}
	/**
	 * 投保校验
	 * @param jsonRequest
	 */
	protected void initGPOP(JsonRequest jsonRequest) {
		JsonRequestHead requestHead = jsonRequest.getHead();
		GPConfirmBody body = (GPConfirmBody) jsonRequest.getBody();
		EndorsementPolicy policy = body.getPolicy();
		String currentType = requestHead.getRequestType();
        String agencyPolicyRef = policy.getAgencyPolicyRef();
        CompanyInfoVO company = body.getCompanyInfo();
		//regNumber|vatNumber|socialSecurityNo不能全为空
		if(Beans.isEmpty(company.getRegNumbe()) && Beans.isEmpty(company.getVatNumber())
				&& Beans.isEmpty(company.getSocialSecurityNo())) {
			setErrorInfo(errorList,"1206",ResourceUtil.errorCodeMsg("1206","regNumber|vatNumber|socialSecurityNo"));
		}
        //公共校验
        if(Beans.isEmpty(policy.getIssueDate())) {
    		setErrorInfo(errorList,"0001",ResourceUtil.errorCodeMsg("0001","issueDate"));
        }
        if(Beans.isEmpty(policy.getEffectiveDate())) {
    		setErrorInfo(errorList,"0001",ResourceUtil.errorCodeMsg("0001","effectiveDate"));
        }
        if(Beans.isEmpty(policy.getExpireDate())) {
    		setErrorInfo(errorList,"0001",ResourceUtil.errorCodeMsg("0001","expireDate"));
        }
        if(Beans.isEmpty(policy.getGroupSize())) {
    		setErrorInfo(errorList,"0001",ResourceUtil.errorCodeMsg("0001","groupSize"));
        }
        //投保出单时必填
        if(PolicyConst.RequestType.REQ_TYPE_CONFIRM_GROUP.equals(currentType)) {
        	if(Beans.isEmpty(agencyPolicyRef)) {
        		setErrorInfo(errorList,"0001",ResourceUtil.errorCodeMsg("0001","agencyPolicyRef"));
        	}
        	if(Beans.isEmpty(policy.getIssueFlag())) {
        		setErrorInfo(errorList,"0001",ResourceUtil.errorCodeMsg("0001","issueFlag"));
        	}
        }
	}
	/**
	 * 保费计算
	 * @param jsonRequest
	 * @param contractId
	 */
	public QueryResultObject calculateTotalPreium(JsonRequest jsonRequest, Long contractId) {
		JsonRequestHead requestHead = jsonRequest.getHead();
		EndorsementBody body = (EndorsementBody) jsonRequest.getBody();
		EndorsementPolicy policy = body.getPolicy();
		UserInfo user = commonService.getUserInfo(requestHead.getUser());
		 PartnerInfo agencyInfo = commonService.getAgencyInfo(body.getAgency().getAgencyCode());
		List<EndorsementPlan> planList = body.getPlanList();
		QueryResultObject resObject = new QueryResultObject();
		//存储保费(key,value)
		HashMap<String,BigDecimal> calPremSql2InsPremHM = new HashMap<String,BigDecimal>();
		Map<String, Object> inParam =  new HashMap<String, Object>();
		PlanInfo planObj = null;
        BigDecimal insPrem = new BigDecimal(0);
        BigDecimal basePrem = new BigDecimal(0);
        BigDecimal factorRate = new BigDecimal(1);
        inParam.put("contractId", contractId);
		String sql = "";
		String calMethod = "";
		String insuredType = "";
		String payCount = "";
		String key = null;
        int yearDays = 365;
        int daysBetween = 0;
        double monthsBetween = 0.0;
        BigDecimal totalPremium = new BigDecimal(0);
        List<InsuredPremium> insuredPremiumList = new ArrayList<InsuredPremium>();
    	StringBuffer sBuffer = new StringBuffer();
    	List<String> actonACList = new ArrayList<String>();
		for (EndorsementPlan endorsementPlan : planList) {
			inParam.put("planCode", endorsementPlan.getPlanCode());
			if(Beans.isNotEmpty(contractId)) {
				planObj = commonService.getPlanInfoByContractId(inParam);
			} else {
				 planObj = commonService.getAssignedPlanInfoByPlanCode(user.getUserCode(), agencyInfo.getPartId(), user.getBranchCode(), endorsementPlan.getPlanCode(), new java.sql.Date(policy.getEffectiveDate().getTime()));
			}
			List<EndorsementInsured> insuredList= endorsementPlan.getInsuredList();
			for (EndorsementInsured insured : insuredList) {
				 if(insured.getActionCode().equals(PolicyConst.DELETE_FLAG)) {//如何为D状态则不计算保费
					 continue;
			     }
				daysBetween = DateUtils.betweenDays(insured.getStartDate(), insured.getEndDate());
				monthsBetween = DateUtils.betweenMonths(insured.getStartDate(), insured.getEndDate());
				calMethod = planObj.getCalMethod();
				insuredType = Beans.isEmpty(insured.getInsuredType())? "" : insured.getInsuredType();
				payCount = Beans.isEmpty(planObj.getPayCount())? "" : planObj.getPayCount();
				sBuffer.setLength(0);
				sBuffer.append("SELECT NVL(round(base_prem,2),0) base_prem ");
				sBuffer.append(" FROM prl_eopus_plan_ben_rate a ");
				sBuffer.append(" WHERE a.plan_type = '");
				sBuffer.append(planObj.getPlanType() + "'");
				if(Beans.isNotEmpty(insuredType)) {
					sBuffer.append(" AND a.insured_type = "+ insuredType);
				}
				if(Beans.isNotEmpty(calMethod)) {
					sBuffer.append(" AND a.cal_method = '"+ calMethod + "'");
				}
				sBuffer.append(" AND a.plan_id = '" + planObj.getPlanId() + "'");
				sBuffer.append(" AND a.plan_version_no = '" + planObj.getVersionNo() + "'");
				if(Beans.isNotEmpty(payCount)) {
					sBuffer.append(" AND a.installment_number = '"+ payCount + "'");
				}
		        if(PolicyConst.PremiumCalMethod.Period.value.equals(calMethod)){
		        	sBuffer.append(" AND").append(daysBetween).append(" BETWEEN a.days_from AND a.days_to ");
		            sql = sBuffer.toString();
		            //\\s+可以替换掉关键字之间的所有空白字符
		            key = sql.replaceAll("\\s+", "");
		            if(calPremSql2InsPremHM.containsKey(key)){
		                insPrem = calPremSql2InsPremHM.get(key);
		            }else{
		                insPrem = commonService.commonQueryCount(sql);
		                calPremSql2InsPremHM.put(key, insPrem);
		            }
		            if(Beans.isEmpty(insPrem)){
		            	setErrorInfo(errorList,"1404",ResourceUtil.errorCodeMsg("1404",insured.getInsuredName()));
		            }
		        }else{
		        	sql = sBuffer.toString();
		            key = sql.replaceAll("\\s+", "");
		            if(calPremSql2InsPremHM.containsKey(key)){
		                basePrem = calPremSql2InsPremHM.get(key);
		            }else{
		                basePrem = commonService.commonQueryCount(sql);
		                calPremSql2InsPremHM.put(key, basePrem);
		            }
		            if(PolicyConst.PremiumCalMethod.Month.value.equals(calMethod)){
		                insPrem = basePrem.multiply(new BigDecimal(monthsBetween));
		            }else if(PolicyConst.PremiumCalMethod.Day.value.equals(calMethod)){
		                insPrem = basePrem.multiply(new BigDecimal(daysBetween));
		            }else if(PolicyConst.PremiumCalMethod.Year.value.equals(calMethod) || PolicyConst.PremiumCalMethod.Rate.value.equals(calMethod)){
		                if(DateUtils.isLeapYear(insured.getStartDate(), insured.getEndDate())){
		                    yearDays = 366;
		                }
		                if(PolicyConst.PremiumCalMethod.Year.value.equals(calMethod) && yearDays == daysBetween){
		                    insPrem = basePrem;
		                }else{
		                    insPrem = basePrem.divide(new BigDecimal(Long.toString(yearDays)),10,RoundingMode.HALF_UP).multiply(new BigDecimal(daysBetween));
		                }
					} else if (PolicyConst.PremiumCalMethod.Term.value.equals(calMethod)
							|| PolicyConst.PremiumCalMethod.NewYear.value.equals(calMethod)) {
						sql = "SELECT value " + "  FROM prl_eopus_factors " + " WHERE factor_type = '" + planObj.getProductCode() + "'"
								+ "   AND number_from <= " + daysBetween + " AND " + daysBetween +" <= number_to ";
						key = sql.replaceAll("\\s+", "");
						if (calPremSql2InsPremHM.containsKey(key)) {
							factorRate = calPremSql2InsPremHM.get(key);
						} else {
							factorRate = commonService.commonQueryCount(sql);
							// this.fetchResult(sql,planObj.getProductCode(),daysBetween,daysBetween);
							calPremSql2InsPremHM.put(key, factorRate);
						}
						if (Beans.isEmpty(factorRate)) {
							setErrorInfo(errorList,"1404",ResourceUtil.errorCodeMsg("1404",insured.getInsuredName()));
						}
						insPrem = basePrem.multiply(factorRate);
					} else {
						insPrem = basePrem;
					}
		        }
		        //保费写回存放，方便入库
		        insured.setPremium(insPrem);
		        //获取ID集合用来计算总保费
		        actonACList.add(insured.getInsuredId());
		        totalPremium = totalPremium.add(insPrem.setScale(2, BigDecimal.ROUND_HALF_UP));
		        InsuredPremium insPremium = new InsuredPremium();
		        insPremium.setInsuredName(insured.getInsuredName());
		        insPremium.setInsuredId(insured.getInsuredId());
		        insPremium.setPremium(insPrem.setScale(2, BigDecimal.ROUND_HALF_UP));
		        insPremium.setInsuredType(insuredType);
		        insuredPremiumList.add(insPremium);
			}
		}
		inParam.put("ids", actonACList);
		//查询总保费
		BigDecimal checkTotalPremium = commonService.getCheckTotalPremium(inParam);
		resObject.setTotalPremium(totalPremium.add(checkTotalPremium));//仅核保的时候使用
		resObject.setInsuredPremiumList(insuredPremiumList);
		return resObject;
	}

	//相关信息确认
	protected void validateInsuredInfo(JsonRequest jsonRequest) {
    	AppParameterInfo nameRegExBean = commonService.getAppParameter(PolicyConst.APPNAME, PolicyConst.AppAarameterKey.RegExName.value);
		JsonRequestHead requestHead = jsonRequest.getHead();
		String currentType = requestHead.getRequestType();
		EndorsementBody body = (EndorsementBody) jsonRequest.getBody();
		List<String> planCodeList = new ArrayList<String>(); 
		Map<String,Object> inParam = new HashMap<String,Object>();
		if(PolicyConst.RequestType.REQ_TYPE_POLICYCHECK_GROUP.equals(currentType)
				|| PolicyConst.RequestType.REQ_TYPE_ENDORSEMENT_GROUP.equals(currentType)) {//批单
			QueryResultObject prePolicy = commonService.getPolicyInfoByRef(body.getPolicy().getPolicyRef());
			inParam.put("contractId", prePolicy.getContractId());
		}
        List<String> actonAList = new ArrayList<String>();
        List<String> actonCDList = new ArrayList<String>();
    	List<EndorsementPlan> planList = body.getPlanList();
    	Map<String,Object> occupationMap = new HashMap<String, Object>();
		IDInfo idInfo = null;
		StringBuffer querySqlbuff =  new StringBuffer("select count(1) from prl_city_ref t where t.country_code = 'CN' ");
		int insurdTotoalSize = (Beans.isNotEmpty(body.getPolicy().getGroupSize())) ? body.getPolicy().getGroupSize() : 0;
		for(EndorsementPlan plan : planList) {
			inParam.put("planCode", plan.getPlanCode());
			String productCode = null;
			if(PolicyConst.RequestType.REQ_TYPE_POLICYCHECK_GROUP.equals(currentType)
					|| PolicyConst.RequestType.REQ_TYPE_ENDORSEMENT_GROUP.equals(currentType)) {//TODO 批单
				//计划代码是否存在该保单；是否存在该计划代码
				PlanInfo planVo = commonService.getPlanInfoByContractId(inParam);
				inParam.put("planId", "");
				if(Beans.isNotEmpty(planVo)) {
					productCode = planVo.getProductCode();
					inParam.put("planId",planVo.getPlanId());
				} else {
					setErrorInfo(errorList,"1067",ResourceUtil.errorCodeMsg("1067"));
				}
			}
			int insuredsNum = (Beans.isNotEmpty(plan.getInsuredList())) ? plan.getInsuredList().size() : 0;
            if(PolicyConst.RequestType.REQ_TYPE_CONFIRMCHECK_GROUP.equals(currentType)
            		|| PolicyConst.RequestType.REQ_TYPE_CONFIRM_GROUP.equals(currentType)){//TODO 出单
                planCodeList.add(plan.getPlanCode());
                insurdTotoalSize = insurdTotoalSize - insuredsNum;
            }
			log.info("validate plan-insureds start...PlanCode=" + plan.getPlanCode() + ", insureds num=" + insuredsNum);
			Map<String,String> insuredIdValidateMap=new HashMap<String,String>();
			Map<String,String> idNoValidateMap=new HashMap<String,String>();
			Map<String,String> insuredTypeValidateMap=new HashMap<String,String>();
			Integer[] ages = getAgeScopeOfPlan(plan.getPlanCode());
            //被保人信息校验
            for (EndorsementInsured insured : plan.getInsuredList()) {
            	if(PolicyConst.RequestType.REQ_TYPE_POLICYCHECK_GROUP.equals(currentType)
    					|| PolicyConst.RequestType.REQ_TYPE_ENDORSEMENT_GROUP.equals(currentType)) {//批单
            		//新增必填校验字段--计划PRODUCT_CODE字段为543/545/530校验职业信息(职业信息)
                	if(Beans.isNotEmpty(productCode) 
                			&& (productCode.equals("543") || productCode.equals("543") || productCode.equals("543"))) {
                		if(Beans.isEmpty(insured.getOccupationCode())) {
                			setErrorInfo(errorList,"0001",ResourceUtil.errorCodeMsg("0001","occupationCode【被保人：" + insured.getInsuredName() + "】"));
                		} else {
                			if(Beans.isEmpty(occupationMap.get(insured.getOccupationCode()))) {
                    			Map<String,Object> occupationRes = commonService.getOccupationByCode(insured.getOccupationCode());
                    			if(Beans.isEmpty(occupationRes)) {
                    				setErrorInfo(errorList,"0006",ResourceUtil.errorCodeMsg("0006","occupationCode【被保人：" + insured.getInsuredName() + "】"));
                    			}
                    			occupationMap.put(insured.getOccupationCode(), occupationRes);
                    		}
                		}
                	}
            	}
            	//省份城市校验
            	if(Beans.isNotEmpty(insured.getResideProvince()) || Beans.isNotEmpty(insured.getResideCity())) {
            		if(Beans.isNotEmpty(insured.getResideProvince())) {
            			querySqlbuff.append(" and province_code = '").append(insured.getResideProvince()).append("'");
            		}
            		if(Beans.isNotEmpty(insured.getResideCity())) {
            			querySqlbuff.append(" and city_code = '").append(insured.getResideCity()).append("'");
            		}
            		if(commonService.commonQueryCount(querySqlbuff.toString()).intValue() < 1) {
        				setErrorInfo(errorList,"0006",ResourceUtil.errorCodeMsg("0006","resideProvince或resideCity【被保人：" + insured.getInsuredName() + "】"));
            		};
            	}
                if(Beans.isNotEmpty(insured.getEmail()) && !Beans.checkEmail(insured.getEmail())){
                	setErrorInfo(errorList,"1117",ResourceUtil.errorCodeMsg("1117",insured.getInsuredName(),insured.getEmail()));
                }
                if(!Beans.checkWithRegEx(nameRegExBean.getValue(), insured.getInsuredName())){
                	setErrorInfo(errorList,"1118",ResourceUtil.errorCodeMsg("1117",insured.getInsuredName()));
                }
              	Integer currentAge = DateUtils.getAge(insured.getBirthDate(),insured.getStartDate());
              	 if(!validateDob(currentAge,ages)){
                     log.debug("当前年龄:"+currentAge+",超出了计划的年龄限制："+ages[0]+" 到 "+ages[1]+"岁。");   
                     setErrorInfo(errorList,"2003",ResourceUtil.errorCodeMsg("2003",insured.getInsuredName(),ages[0],ages[1]));
                 }
              	 //被保人类型校验
            	String insType = insuredTypeValidateMap.get(productCode + currentAge);
            	if (Beans.isEmpty(insType)) {
            		inParam.put("age",currentAge);
            		//查询type
            		insType = commonService.getInsuredType(inParam);
                    insuredTypeValidateMap.put(productCode + currentAge, insType);
            	}
            	if(requestHead.getRequestType().equals(PolicyConst.RequestType.REQ_TYPE_ENDORSEMENT_GROUP)) {
            		//出单
            		if(Beans.isEmpty(insured.getInsuredType())) {
            			setErrorInfo(errorList,"1099",ResourceUtil.errorCodeMsg("1099",insured.getInsuredName()));
            		} else {
            			if(!insured.getInsuredType().equals(insType)) {
            				setErrorInfo(errorList,"1024",ResourceUtil.errorCodeMsg("1024",insured.getInsuredName()));
            			}
            		}
            	}
            	insured.setInsuredType(insType);
                if (Beans.isNotEmpty(insuredIdValidateMap.get(insured.getInsuredId()))) {
                    log.info("被保险人id:"+insured.getInsuredId()+" 重复!");
                    setErrorInfo(errorList,"1083",ResourceUtil.errorCodeMsg("1083",insured.getInsuredName()));
                }
                if(PolicyConst.RequestType.REQ_TYPE_CONFIRMCHECK_GROUP.equals(currentType)
                		|| PolicyConst.RequestType.REQ_TYPE_CONFIRM_GROUP.equals(currentType)){//出单
                    if(Beans.isNotEmpty(idNoValidateMap.get(insured.getIdNumber()))){
                        log.info("被保险人证件号码:"+insured.getIdNumber()+" 重复!");
                        setErrorInfo(errorList,"5021",ResourceUtil.errorCodeMsg("5021"));
                    }
                    idNoValidateMap.put(insured.getIdNumber(), insured.getIdNumber());
                }
                insuredIdValidateMap.put(insured.getInsuredId(), insured.getInsuredId());
                if(PolicyConst.IdType.IDENTITY.equals(insured.getIdType())){
                    idInfo = new IDUtil().IDCardValidate(insured.getIdNumber());
                    if(Beans.isEmpty(idInfo.getErrMsg())){//身份证号码合法
                        if(!DateUtils.dateTo0String(insured.getBirthDate()).equals(idInfo.getBirthday())){//身份证号码中的出生日期和传过来的出生日期不一致
                            log.info("birthday in idCard: "+idInfo.getBirthday());
                            setErrorInfo(errorList,"1328",ResourceUtil.errorCodeMsg("1328",insured.getInsuredName(),insured.getIdNumber()));
                        }
                    }else{
                        log.info("idCard validate errMsg: "+idInfo.getErrMsg());
                        setErrorInfo(errorList,"1327",ResourceUtil.errorCodeMsg("1327",insured.getInsuredName(),insured.getIdNumber()));
                    }
                }
                if(PolicyConst.ADDED_FLAG.equals(insured.getActionCode())) {//团险-A
                	actonAList.add(insured.getInsuredId());
                } else if (PolicyConst.CHANGE_FLAG.equals(insured.getActionCode()) 
                		|| PolicyConst.DELETE_FLAG.equals(insured.getActionCode())) {//团险-C 团险-D
                	actonCDList.add(insured.getInsuredId());
                }
            }
            if(PolicyConst.RequestType.REQ_TYPE_POLICYCHECK_GROUP.equals(currentType)
					|| PolicyConst.RequestType.REQ_TYPE_ENDORSEMENT_GROUP.equals(currentType)) {//批单
            	 //与已经出单的InsuredId比较
        		if(Beans.isNotEmpty(actonAList)) {//校验进行A操作的是否有重复ID
        			inParam.put("ids", CommonUtils.splitList(actonAList, 999));
        			List<String> aList = commonService.getACheckId(inParam);
        			if(Beans.isNotEmpty(aList)) {
        				setErrorInfo(errorList,"1204",ResourceUtil.errorCodeMsg("1204",StringUtils.join(aList,",")));
        			}
        		}
        		if(Beans.isNotEmpty(actonCDList)) {//校验进行CD操作的是否有重复ID
        			inParam.put("ids", CommonUtils.splitList(actonCDList, 999));
        			inParam.put("sqlTable", getSplitIdStr(actonCDList));
        			List<String> cdList = commonService.getCDCheckId(inParam);
        			if(Beans.isNotEmpty(cdList)) {
        				setErrorInfo(errorList,"1205",ResourceUtil.errorCodeMsg("1205",StringUtils.join(cdList,",")));
        			}
        		}
            }
    		log.info("validate plan-insureds end...PlanCode= " + plan.getPlanCode());
		}
		 if(PolicyConst.RequestType.REQ_TYPE_CONFIRMCHECK_GROUP.equals(currentType)
         		|| PolicyConst.RequestType.REQ_TYPE_CONFIRM_GROUP.equals(currentType)){//出单
			StringBuffer strbuff = new StringBuffer(); 
			strbuff.append("SELECT count(distinct pep.product_code) ct");
			strbuff.append(" FROM prl_eopus_plans pep ");
			strbuff.append(" where ");
			strbuff.append(CommonUtils.getSqlStrByList(planCodeList, "pep.plan_code", true));
			strbuff.append(" and pep.version_no = ");
			strbuff.append(" (SELECT max(p.version_no) FROM prl_eopus_plans p where p.plan_id = pep.plan_id)");
			if(commonService.commonQueryCount(strbuff.toString()).intValue() != 1) {
				setErrorInfo(errorList,"1356",ResourceUtil.errorCodeMsg("1356"));
			}
         	body.getPolicy().setPlanCode(planCodeList.get(0));
         	
            if(0 != insurdTotoalSize){
            	setErrorInfo(errorList,"1019",ResourceUtil.errorCodeMsg("1019"));
            }
         }
		  //当前为申报核保
		if (PolicyConst.RequestType.REQ_TYPE_POLICYCHECK_GROUP.equals(currentType)
				|| PolicyConst.RequestType.REQ_TYPE_ENDORSEMENT_GROUP.equals(currentType)) {
            for (EndorsementPlan plan : body.getPlanList()) {
                List<EndorsementInsured> insureds = plan.getInsuredList();
                String idNo ="";
                for(int i = 0; i<insureds.size()-1; i++){
                    if(!PolicyConst.DELETE_FLAG.equals(insureds.get(i).getActionCode())){
                        idNo =  insureds.get(i).getIdNumber();
                        Date sDate = insureds.get(i).getStartDate();
                        Date eDate = insureds.get(i).getEndDate();
                        //行数据都跟其他行数据相比较，如果身份证号相同，则比较保险区间（这里使用冒泡法）
                        for(int j = i+1; j<insureds.size(); j++){
                            if(!PolicyConst.DELETE_FLAG.equals(insureds.get(i).getActionCode()) && insureds.get(j).getIdNumber().equals(idNo)){
                                if(sDate.compareTo(insureds.get(j).getEndDate())<=0 && insureds.get(j).getStartDate().compareTo(eDate)<=0){
                                    log.info("被保险人id_no:" + idNo + " 重复!");
                                    setErrorInfo(errorList,"5045",ResourceUtil.errorCodeMsg("5045"));
                                }
                            }    
                        }
                    }
                    
                }
                long BigEffectDate = 0;
                long BigEndDate = 0;
                //获取保单时间查询prl_common_quote_policy_all
                QueryResultObject policyBase = commonService.getPolicyInfoByRef(body.getPolicy().getPolicyRef());
                for (EndorsementInsured insured : plan.getInsuredList()) {
                    if (Beans.isNotEmpty(policyBase.getEffectiveDate())) {
                        BigEffectDate = policyBase.getEffectiveDate().getTime();
                    } else {
                        //大保单区间起保日期为空，请查看
                    	setErrorInfo(errorList,"5043",ResourceUtil.errorCodeMsg("5043"));
                    }
                    if (Beans.isNotEmpty(policyBase.getExpireDate())) {
                        BigEndDate = policyBase.getExpireDate().getTime();
                    } else {
                        //大保单区间终保日期为空，请查看
                    	setErrorInfo(errorList,"5044",ResourceUtil.errorCodeMsg("5044"));
                    }
                    long insureEffectiveDate = insured.getStartDate().getTime();
                    long insureEndDate = insured.getEndDate().getTime();

                    if (BigEffectDate > insureEffectiveDate) {
                        //批单起保日期和终保日期需在大保单区间内
                    	setErrorInfo(errorList,"5041",ResourceUtil.errorCodeMsg("5041"));
                    }
                    if (BigEndDate < insureEndDate) {
                        //批单起保日期和终保日期需在大保单区间内
                    	setErrorInfo(errorList,"5042",ResourceUtil.errorCodeMsg("5042"));
                    }
                }
            }
        }
	} 
	
    public static boolean validateDob(Integer age,Integer[] ages) {
        if(Beans.isNotEmpty(ages[0])){
            if(age.compareTo(ages[0])<0){//到起保日期都未到最小年龄，不允许承保
                return false;
            }
        }
        if(Beans.isNotEmpty(ages[1])){
            if(age.compareTo(ages[1]+1)>=0){//到起保日期已超过最大年龄，不允许承保
                return false;
            }
        }
        return true;
     }
	private Integer[] getAgeScopeOfPlan(String planCode) {
        Integer[] ages = new Integer[3];
        Map<String, Object> qrb = commonService.getAgeScopeOfPlan(planCode);
        //s.age_from,s.age_to,pegp.renewable_max_age
        if(Beans.isNotEmpty(qrb)){
            ages[0] = (Integer) (Beans.isEmpty(qrb.get("AGE_FROM")) ? null :  Integer.parseInt(qrb.get("AGE_FROM").toString()));
            ages[1] = (Integer) (Beans.isEmpty(qrb.get("AGE_TO")) ? null : Integer.parseInt(qrb.get("AGE_TO").toString()));
            ages[2] = (Integer) (Beans.isEmpty(qrb.get("MAX_AGE")) ? null : Integer.parseInt(qrb.get("MAX_AGE").toString()));
            if (Beans.isNotEmpty(ages[1]) && ages[1] == 0)
                ages[1] = null;
        } 
        return ages;
	}
	/**
	 * String拼接成(select 2 as id from dual union select 4 as id from dual union)
	 * @param strList
	 * @return
	 */
	private String getSplitIdStr(List<String> strList) {
		StringBuffer returnStr = new StringBuffer();
		if(Beans.isNotEmpty(strList)) {
			for (int i = 0,len = strList.size(); i < len; i++) {
				String idStr = strList.get(i);
				returnStr.append(" select '");
				returnStr.append(idStr);
				returnStr.append("' as id from dual");
				if(i < len-1) {
					returnStr.append(" union");
				}
			}
		}
		return returnStr.toString();
	}
	//迁移方法
	protected QueryResultObject getCommonQuotePolicy (long contractId) {
		QueryResultObject resObject = new QueryResultObject();
		//根据contractId查询
    	PrlCommonQuotePolicyAll prlCommonQuotePolicyAll = prlCommonQuotePolicyAllMapper.selectByContractId(contractId);
        if(Beans.isEmpty(prlCommonQuotePolicyAll)){
        	setErrorInfo(errorList,"1029",ResourceUtil.errorCodeMsg("1029"));
        }
        resObject.setPolicyRef(prlCommonQuotePolicyAll.getPolicyRef());
        resObject.setPolicyStatus(prlCommonQuotePolicyAll.getContractStatus());
        resObject.setPolicyOriginator(commonService.getPolicyOriginator(contractId).toString());
        //状态校验
        if(PolicyConst.PolicyStatus.Endorsement.value.equals(resObject.getPolicyStatus())
        		|| PolicyConst.PolicyStatus.EndorsementToBeCheck.value.equals(resObject.getPolicyStatus())){
            return resObject;
        }
        if(!PolicyConst.PolicyStatus.WIPPolicy.value.equals(prlCommonQuotePolicyAll.getContractStatus())){
            if(Beans.isNotEmpty(prlCommonQuotePolicyAll.getPremium())){
            	resObject.setTotalPremium(prlCommonQuotePolicyAll.getPremium());
            }
            setInsuredPremium(resObject,contractId);
        }
		return resObject;
	}
		
	//保单详情
	private void setInsuredPremium(QueryResultObject resObject, long contractId) {
		List<InsuredPremium> insuredPremiums = commonService.getInsuredListByContractId(contractId);
		Map<String, Object> inParam = new HashMap<String, Object>();
		inParam.put("contractId", contractId);
        if(Beans.isNotEmpty(insuredPremiums)){
            for(InsuredPremium ip : insuredPremiums){
            	inParam.put("insId", ip.getInsId());
                List<UnderwritingDecision> underwritingDecisionlist = commonService.getUnderwritingDecisionList(inParam);
                if(Beans.isNotEmpty(underwritingDecisionlist)) {
                    ip.setUnderwritingDecisions(underwritingDecisionlist);
                }
            }
        }
        resObject.setInsuredPremiumList(insuredPremiums);
	}
	protected void validatePolicy(UserInfo user, JsonRequest jsonRequest) {
		EndorsementBody body = (EndorsementBody) jsonRequest.getBody();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//根据保单ID查询到对应信息from-->prl_common_quote_policy_all
		QueryResultObject prePolicy = commonService.getPolicyInfoByRef(body.getPolicy().getPolicyRef());
//		String effectDate=DateUtils.dateToString(prePolicy.getEffectiveDate(), "yyyy-MM-dd HH:mm:ss");
		
		//validateForThird 5499行逻辑
		Object contractStatus="";
		if(Beans.isNotEmpty(prePolicy)) {
			contractStatus = prePolicy.getPolicyStatus();
		}
		String countSql = "select count(1) from ocp_policy_bases a where a.contract_id= " + prePolicy.getContractId();
		int result = commonService.commonQueryCount(countSql).intValue();
		if(PolicyConst.PolicyStatus.Endorsement.equals(contractStatus) || 
				(PolicyConst.PolicyStatus.WaitForPay.equals(contractStatus) && result > 0)) {
            log.info("==批改==");
        }else{
            log.info("==非批改==");
            // 批单提示 ADF参照逻辑2899行
        }
		//黑名单校验
		AppParameterInfo appParameterInfo = commonService.getAppParameter(PolicyConst.APP_IG_EPOLICY, "B2C.User");
		String appParamByCond = appParameterInfo.getValue();
        if(!jsonRequest.getHead().getUser().equals(appParamByCond)){
            String blacklist = commonService.getBlacklistByPolicy(prePolicy.getContractId());
            if(Beans.isNotEmpty(blacklist) && !PolicyConst.PATHSEPARTOR.equals(blacklist)){
                String[] strArr = blacklist.split(PolicyConst.PATHSEPARTOR);
                setErrorInfo(errorList,"4444",ResourceUtil.errorCodeMsg("4444",strArr[0]+strArr[1]));
            }
        }
	}
	/**
	 * 渠道校验
	 * @param agencyCode
	 */
	protected void validateAgency(String agencyCode) {
        String sql="SELECT count(1) " + 
        "         FROM prl_dmt_agents_ext pt, " + 
        "                cp_partners cp  " + 
        "        WHERE pt.part_id = cp.part_id " + 
        "          AND cp.partner_ref ='"+agencyCode+"'";
        int count1 = commonService.commonQueryCount(sql).intValue();
        if(count1 == 0){
        	setErrorInfo(errorList,"1009",ResourceUtil.errorCodeMsg("1009"));
        }
        sql="SELECT count(1) " + 
        "      FROM cp_partners a, prl_cp_partners_ext b " + 
        "    WHERE a.part_id = b.part_id " + 
        "       AND b.gst_registration_number = '"+agencyCode+"'";
        count1 = commonService.commonQueryCount(sql).intValue();
        if(count1 == 0){
        	setErrorInfo(errorList,"1022",ResourceUtil.errorCodeMsg("1022"));
        }
	}
	//校验机构
	protected void validateInstitution(String userCode) {
        //!isAllianzPlatUser&&!isAllianzUWUser
		if (!isAllianzPlatUser(userCode) && !isAllianzUWUser(userCode)) {
			String sql = "SELECT branch_code  " 
					+ " FROM PRL_EXT_USER_EXTN " 
					+ " WHERE user_code = '" + userCode + "'"
					+ " AND partner_role = 'AGN' ";
			int count = commonService.commonQueryCount(sql).intValue();
			if (count == 0) {
				setErrorInfo(errorList,"1014",ResourceUtil.errorCodeMsg("1404"));
			}
		}
	}
	
	private boolean isAllianzPlatUser(String userCode){
		 //isAllianzPlatUser
		String sql = "SELECT count(1) " + 
				" FROM prpl_app_parameter pap " + 
				" where pap.app_name = '" + PolicyConst.APPNAME + "'" +
				" and pap.key = '" + PolicyConst.AppAarameterKey.AllianzAccountPolicyCancel + "'" +
				" and pap.status = 1 " + 
				" and pap.value like '%' ||'" + userCode +"'|| '%' " ;
		int count = commonService.commonQueryCount(sql).intValue();
		if(count > 0) {
			return true;
		}
		return false;
	}
	
	private boolean isAllianzUWUser(String userCode){
		 //isAllianzUWUser
       String sql ="SELECT count(1) FROM PRL_EXT_USER_EXTN WHERE user_code = '" + userCode + "' AND partner_role = 'UW' " ;
       int count = commonService.commonQueryCount(sql).intValue();
       if(count > 0) {
			return true;
		}
       return false;
	}
    /**
     * 设置错误信息(收集并返回)
     */
    protected void setErrorInfo(List<ErrorBean> errorList, String errorCode, String errorMessage) {
    	ErrorBean errorBean = new ErrorBean();
    	errorBean.setErrorCode(errorCode);
    	errorBean.setErrorMessage(errorMessage);
    	errorList.add(errorBean);
    }
}
