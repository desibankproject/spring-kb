package com.mvc.web.controller.rest.api.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 
 * @author VC1
 *  This is called global exception handler for rest API
 *
 */
@ControllerAdvice
public class ExceptionControllerAdvice {
	
/*	@ExceptionHandler(EmployeeDoesNotExistException.class)
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody 	public ErrorResponse exceptionHandlerForEmmployee(HttpServletRequest request,EmployeeDoesNotExistException ex) {
		ErrorResponse error = new ErrorResponse();
		error.setRequestURI(request.getRequestURI());
		error.setStatus("fail");
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(ex.getMessage());
		return error;
	}*/
	
	@ExceptionHandler(EmployeeDoesNotExistException.class)
	public ResponseEntity<ErrorResponse> exceptionHandlerForEmmployee(HttpServletRequest request,EmployeeDoesNotExistException ex) {
		ErrorResponse error = new ErrorResponse();
		error.setRequestURI(request.getRequestURI());
		error.setStatus("fail");
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
 
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ex.printStackTrace();
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage("Please contact your administrator");
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
}