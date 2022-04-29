package com.cakil.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Loggable {
	default Logger getLogger() {
		return LoggerFactory.getLogger(this.getClass().getName());
	}
}
