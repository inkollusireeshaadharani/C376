package com.wileyedge.exceptionhandling;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class MyResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req){
		ExceptionResponse expResp = new ExceptionResponse(
				ex.getMessage(), "Detailed Description of message", new Date());
		return new ResponseEntity<Object>(expResp, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(StudentNotFoundException ex,WebRequest req) {
		ExceptionResponse expResp = new ExceptionResponse(
				ex.getMessage(), "Detailed Description of message", new Date());
		return new ResponseEntity<Object>(expResp, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse expResp = new ExceptionResponse(
				"Validation failed", ex.getBindingResult().toString(), new Date());
		return new ResponseEntity<Object>(expResp, HttpStatus.BAD_REQUEST);
	}
	
	
	
}
