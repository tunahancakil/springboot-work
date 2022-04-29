package com.cakil.spring.interfaces.model;

import com.cakil.spring.interfaces.util.DateTimeUtils;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorMessage {

	private String localDateTime;
	private String message;
	private String path;

	public ErrorMessage(LocalDateTime localDateTime, String message, String path) {
		super();
		this.localDateTime = DateTimeUtils.convertLocalDateTimeToFormattedString(localDateTime);
		this.message = message;
		this.path = path;
	}
}
