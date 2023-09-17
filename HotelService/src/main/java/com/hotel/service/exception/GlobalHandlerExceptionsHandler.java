package com.hotel.service.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerExceptionsHandler {

	@ExceptionHandler(HotelNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String,String> handleHotelNotFoundException(HotelNotFoundException ex){
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("error Message",ex.getMessage());
		return errorMap;
	}
}
