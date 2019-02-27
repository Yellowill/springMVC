package com.allianz.pa.service;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.allianz.pa.common.bean.QueryResultObject;
import com.allianz.pa.common.consant.PolicyConst;
import com.allianz.pa.common.exception.CustomException;
import com.allianz.pa.common.util.Beans;
import com.allianz.pa.common.util.ThirdPartyCommonUtil;
import com.allianz.pa.dto.common.JsonRequest;
import com.allianz.pa.dto.common.JsonRequestHead;
import com.allianz.pa.dto.common.JsonResponse;
import com.allianz.pa.dto.common.JsonResponseBody;
import com.allianz.pa.dto.request.endorsement.op.OPEndorsementBody;
import com.allianz.pa.dto.request.policyconfirm.op.OPConfirmBody;
import com.allianz.pa.entity.PrlThirdpInterfPolData;

public abstract class AbstractPolicyService extends AbstractService{
	private static final Logger log = Logger.getLogger(AbstractPolicyService.class);
	public static final String INIT = "init";
	public static final String EXECUTE = "execute";
	
	
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public Object doBizOperation(JsonRequest jsonRequest) {
		JsonRequestHead head = jsonRequest.getHead();
		Long contractId = null;
		QueryResultObject queryResult = null;
        String errorMsg = "";
        String errorCode = "";
        Object[] errorParams = null;
        boolean isPass = true;
        PrlThirdpInterfPolData polData = null;
        String agencyPolicyRef = null;
		try {
			if (PolicyConst.RequestType.REQ_TYPE_POLICYCONFIRM_OP.equals(head.getRequestType())) {
				agencyPolicyRef = ((OPConfirmBody)jsonRequest.getBody()).getPolicy().getAgencyPolicyRef();
			}else if (PolicyConst.RequestType.REQ_TYPE_ENDORSEMENT_RISK_OP.equals(head.getRequestType())) {
				agencyPolicyRef = ((OPEndorsementBody)jsonRequest.getBody()).getPolicy().getAgencyPolicyRef();
			}
			if (Beans.isNotEmpty(agencyPolicyRef)) {
				Long contractIdExists = commonService.validatePolicyIsExist(head.getUser(), agencyPolicyRef);
		        if(Beans.isNotEmpty(contractIdExists)){
		        	return commonService.getAllreadySuccessPolicy(head, contractIdExists);
		        }
			}
			
			polData = commonService.getPrlThirdpInterfPolDataByPk(head.getRequestId(), head.getUser());
	        if(Beans.isEmpty(polData) || Beans.isEmpty(polData.getState())){
	        	polData = new PrlThirdpInterfPolData();
	        	polData.setState(PolicyConst.RequestState.waiting.value);
	        	polData.setSignMsg(head.getRemoteHost());
	        	polData.setAgencyCode(head.getUser());
	        	polData.setRequestId(head.getRequestId());
	        	try {
	        		commonService.savePrlThirdpInterfPolData(polData);
				} catch (Exception e) {
					log.error("savePrlThirdpInterfPolData error: ", e);
					return ThirdPartyCommonUtil.createErrorResponse(head,PolicyConst.ErrorCode.systemerror.value);
				}
	        }else if(PolicyConst.RequestState.waiting.value.equals(polData.getState())){
	        	return ThirdPartyCommonUtil.createErrorResponse(head,PolicyConst.ErrorCode.systemhandle.value);
	        }else if(PolicyConst.RequestState.success.value.equals(polData.getState())){
	             return commonService.getAllreadySuccessPolicy(head, polData.getContractId());
	        }else{
	        	polData.setState(PolicyConst.RequestState.waiting.value);
	        	polData.setSignMsg(head.getRemoteHost());
	            try{
	            	commonService.updatePrlThirdpInterfPolData(polData);
		        } catch (Exception e) {
		        	log.error("updatePrlThirdpInterfPolData error: ", e);
					return ThirdPartyCommonUtil.createErrorResponse(head,PolicyConst.ErrorCode.systemerror.value);
				}
	        }
	        //init
	        contractId = (Long)super.findProcessMethod(this, head.getRequestType(), INIT).invoke(this, jsonRequest);
	        
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
	        	afterFailProcess(head, contractId);
				return ThirdPartyCommonUtil.createErrorResponse(head,PolicyConst.ErrorCode.systemerror.value);
			}
	        //execute
	        queryResult = (QueryResultObject)super.findProcessMethod(this, head.getRequestType(), EXECUTE).invoke(this, jsonRequest, contractId);
		} catch (Exception e) {
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
            //lundy 投保失败后，删除已经生成的无用数据,批单只能abort
            afterFailProcess(head, contractId);
        }
        JsonResponse jr =  ThirdPartyCommonUtil.createErrorResponse(head, errorCode,errorParams);
        if(Beans.isNotEmpty(queryResult)){
        	JsonResponseBody body = new JsonResponseBody();
    		body.setAgencyPolicyRef(queryResult.getPolicyOriginator());
    		body.setPolicyRef(queryResult.getPolicyRef());
    		body.setPolicyStatus(queryResult.getPolicyStatus());
    		body.setTotalPremium(queryResult.getTotalPremium());
    		body.setSumInsured(queryResult.getSumInsured());
    		body.setEffectiveDate(queryResult.getEffectiveDate());
    		body.setExpireDate(queryResult.getExpireDate());
    		jr.setBody(body);
        }
		return jr;
	}
	private void afterFailProcess(final JsonRequestHead head, final Long contractId) {
		if (Beans.isNotEmpty(contractId)) {
			try {
	            new Thread() {
	                public void run() {
	                    try {
	                    	if (PolicyConst.RequestType.REQ_TYPE_ENDORSEMENT_RISK_OP.equals(head.getRequestType())) {
	                		    commonService.abortEndorsement(contractId);
	                		} else {
	                			commonService.deleteErrorData(contractId);
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
	public void doBookingSettle4Others(final Long contractId) {
		try {
            new Thread() {
                public void run() {
                    try {
                        Integer do_result= commonService.doBookingSettle4Others(contractId);
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
}
