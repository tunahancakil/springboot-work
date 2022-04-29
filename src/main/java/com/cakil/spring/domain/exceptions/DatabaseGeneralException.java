package com.cakil.spring.domain.exceptions;

public class DatabaseGeneralException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DatabaseGeneralException(String msg) {
		super(msg);
	}

}
