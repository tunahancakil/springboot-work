package com.cakil.spring.application;

import com.cakil.spring.application.service.Loggable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController implements Loggable {
	public ResponseEntity<Object> buildOKResponseEntity(Object object) {
		return new ResponseEntity<Object>(object, HttpStatus.OK);
	}

}
