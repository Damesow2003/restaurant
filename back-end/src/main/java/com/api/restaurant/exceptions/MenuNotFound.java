package com.api.restaurant.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MenuNotFound extends RuntimeException{
	public MenuNotFound(String s){
		super(s);
	}
}
