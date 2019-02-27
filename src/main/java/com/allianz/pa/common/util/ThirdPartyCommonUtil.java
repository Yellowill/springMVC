package com.allianz.pa.common.util;

import com.allianz.pa.common.consant.PolicyConst;
import com.allianz.pa.dto.common.JsonRequestHead;
import com.allianz.pa.dto.common.JsonResponse;
import com.allianz.pa.dto.common.JsonResponseHead;

public class ThirdPartyCommonUtil {
	public static JsonResponse createErrorResponse(JsonRequestHead header,String errorCode, Object... args) {
		JsonResponse response = new JsonResponse();
		JsonResponseHead responseHeader = new JsonResponseHead();
		copyRequestHeader2ResponseHeader(header, responseHeader);
		setErrMsgAndErrCode(responseHeader, errorCode, args);
		response.setBody(null);
		response.setHead(responseHeader);
		return response;
	}

	public static JsonResponseHead copyRequestHeader2ResponseHeader(JsonRequestHead header, JsonResponseHead responseHeader) {
		responseHeader.setRequestType(header.getRequestType());
		responseHeader.setRequestID(header.getRequestId());
		return responseHeader;
	}

	private static void setErrMsgAndErrCode(JsonResponseHead responseHead, String errorCode, Object... args) {
		String errorMsg = errorCode;
		try {
			errorMsg = ResourceUtil.errorCodeMsg(errorCode, args);
		} catch (Exception e) {
			if (Beans.isNotEmpty(args)) {
				errorCode = args[0] + "";
			} else {
				errorCode = PolicyConst.ErrorCode.systemerror.value;
				errorMsg = ResourceUtil.errorCodeMsg(errorCode);
			}
		}
		responseHead.setErrorCode(errorCode);
		responseHead.setErrorMessage(errorMsg);
		if (! PolicyConst.ErrorCode.SUCCESS.value.equals(errorCode)) {// 不成功responseCode为0
			responseHead.setResponseCode(PolicyConst.FALSE);
		} else {// 成功response为1
			responseHead.setResponseCode(PolicyConst.TRUE);
		}
	}
}
