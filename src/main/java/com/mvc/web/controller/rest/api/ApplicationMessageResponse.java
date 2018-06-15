package com.mvc.web.controller.rest.api;

public class ApplicationMessageResponse {
	private String status;
	private String message;
	private String exception;
	private String uri;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public String toString() {
		return "ApplicationMessageResponse [status=" + status + ", message=" + message + ", exception=" + exception
				+ ", uri=" + uri + "]";
	}

}
