package com.cakil.spring.controller;

import com.cakil.spring.service.Loggable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController implements Loggable {
	public ResponseEntity<Object> buildOKResponseEntity(Object object) {
		return new ResponseEntity<Object>(object, HttpStatus.OK);
	}

}
