package com.rating.service.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RatingNotFoundException.class)
	public Map<String,String> RatingNotFoundExceptionHandler(RatingNotFoundException ex){
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("error message", ex.getMessage());
		return errorMap;
	}

}
