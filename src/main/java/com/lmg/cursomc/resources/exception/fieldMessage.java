package com.lmg.cursomc.resources.exception;

import java.io.Serializable;

public class fieldMessage implements Serializable{

	private static final long serialVersionUID = 1L;

	private String fieldName;
	private String message;

	public fieldMessage() {

	}

	public fieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
