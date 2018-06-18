package com.mvc.web.controller.rest.api.exception;

public class ErrorResponse {
	private int errorCode;
	private String message;
	private String requestURI;
	private String status;
	
	public String getRequestURI() {
		return requestURI;
	}
	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ErrorResponse [errorCode=" + errorCode + ", message=" + message + ", requestURI=" + requestURI
				+ ", status=" + status + "]";
	}
	
	
}