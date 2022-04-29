package com.cakil.spring.exceptions;

public class DatabaseEntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DatabaseEntityNotFoundException(String msg) {
		super(msg);
	}

}
