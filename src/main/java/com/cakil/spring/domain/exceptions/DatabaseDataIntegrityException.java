package com.cakil.spring.domain.exceptions;

public class DatabaseDataIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DatabaseDataIntegrityException(String msg) {
		super(msg);
	}

}
