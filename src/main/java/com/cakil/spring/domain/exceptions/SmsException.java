package com.cakil.spring.domain.exceptions;

public class SmsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SmsException(String msg) {
		super(msg);
	}

}
