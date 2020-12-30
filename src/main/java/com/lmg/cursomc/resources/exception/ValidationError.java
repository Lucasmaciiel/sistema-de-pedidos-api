package com.lmg.cursomc.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private static final long serialVersionUID = -315805251265059071L;

	private List<FieldMessage>  errors = new ArrayList<>();
	
	public ValidationError(Integer status, String msn, Long timeStamp) {
		super(status, msn, timeStamp);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}
	
	

}
