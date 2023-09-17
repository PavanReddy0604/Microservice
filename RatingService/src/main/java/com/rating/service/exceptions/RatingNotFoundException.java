package com.rating.service.exceptions;

public class RatingNotFoundException extends RuntimeException{
	public RatingNotFoundException(String message) {
		super(message);
	}

}
