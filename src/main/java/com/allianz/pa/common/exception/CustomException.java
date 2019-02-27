package com.allianz.pa.common.exception;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomException(String s) {
		super(s);
	}

	public CustomException(String key, Object... value) {
		super(key);
		this.value = value;
	}

	private Object[] value;

	public void setValue(Object[] value) {
		this.value = value;
	}

	public Object[] getValue() {
		return value;
	}
}
