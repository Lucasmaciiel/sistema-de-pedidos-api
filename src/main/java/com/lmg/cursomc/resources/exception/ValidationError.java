package com.lmg.cursomc.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private static final long serialVersionUID = -315805251265059071L;

	private List<fieldMessage>  errors = new ArrayList<>();
	
	public ValidationError(Integer status, String msn, Long timeStamp) {
		super(status, msn, timeStamp);
	}

	public List<fieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		errors.add(new fieldMessage(fieldName, message));
	}
	
	

}
