package com.exception;

public class PolicyNotFoundException extends RuntimeException {
	
	private Object fieldValue;

	public Object getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}

	public PolicyNotFoundException(Object fieldValue) {
		super(String.format("Policy not found with ID : %s",fieldValue));
		this.fieldValue = fieldValue;
	}
	

}