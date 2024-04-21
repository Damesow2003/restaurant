package com.api.restaurant.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ImpossibleAjouterMenu extends RuntimeException{
	public ImpossibleAjouterMenu(String s) {
		super(s);
	}
}
