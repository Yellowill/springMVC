package com.allianz.pa.dto.common;

public class JsonResponse {
	private JsonResponseHead head;
	
	private JsonResponseBody body;

	public JsonResponseHead getHead() {
		return head;
	}

	public void setHead(JsonResponseHead head) {
		this.head = head;
	}

	public JsonResponseBody getBody() {
		return body;
	}

	public void setBody(JsonResponseBody body) {
		this.body = body;
	}
	

}
