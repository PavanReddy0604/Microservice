package com.user.service.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String,String> handleUserNotFoundException(UserNotFoundException ex) {
		 Map<String,String> errorMap=new HashMap<>();
		errorMap.put("error message",ex.getMessage() );
	return errorMap;
	}
}
