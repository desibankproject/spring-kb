package com.mvc.web.controller.rest.api.exception;

public class EmployeeDoesNotExistException extends RuntimeException {
	private String errorMessage;
	 
	public String getErrorMessage() {
		return errorMessage;
	}
	public EmployeeDoesNotExistException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	public EmployeeDoesNotExistException() {
		super();
	}
}
