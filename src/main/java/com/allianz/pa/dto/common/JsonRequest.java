package com.allianz.pa.dto.common;

import javax.validation.Valid;

public class JsonRequest {
	private JsonRequestHead head;

	@Valid
	private JsonRequestBody body;

	public JsonRequestHead getHead() {
		return head;
	}

	public void setHead(JsonRequestHead head) {
		this.head = head;
	}

	public JsonRequestBody getBody() {
		return body;
	}

	public void setBody(JsonRequestBody body) {
		this.body = body;
	}
}
