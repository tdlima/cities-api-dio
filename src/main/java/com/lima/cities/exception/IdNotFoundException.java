package com.lima.cities.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdNotFoundException extends Exception {
	
	public IdNotFoundException(Long id) {
		super("The id "+id+" was not found!");
	}

}
