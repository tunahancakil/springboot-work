package com.cakil.spring.exceptions;

public class DatabaseDataIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DatabaseDataIntegrityException(String msg) {
		super(msg);
	}

}
