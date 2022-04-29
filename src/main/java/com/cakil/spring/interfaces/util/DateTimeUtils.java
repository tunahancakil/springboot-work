package com.cakil.spring.interfaces.util;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class DateTimeUtils {

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public static String convertLocalDateTimeToFormattedString(LocalDateTime localDateTime) {
		String formatDateTime = null;
		if (localDateTime != null) {
			formatDateTime = localDateTime.format(formatter);
		}
		return formatDateTime;
	}
}
