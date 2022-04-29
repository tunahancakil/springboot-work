package com.cakil.spring.controller;

import com.cakil.spring.exceptions.DatabaseDataIntegrityException;
import com.cakil.spring.exceptions.DatabaseEntityNotFoundException;
import com.cakil.spring.exceptions.DatabaseGeneralException;
import com.cakil.spring.exceptions.SmsException;
import com.cakil.spring.model.ErrorMessage;
import com.cakil.spring.util.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ DatabaseGeneralException.class })
	public ResponseEntity<ErrorMessage> handleDatabaseGeneralExceptions(Exception ex, WebRequest request) {
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		ErrorMessage errorDetails = new ErrorMessage(LocalDateTime.now(), ex.getMessage(), request.getDescription(false).substring(request.getDescription(false).indexOf(Constants.TEXT_SLASH)));
		return new ResponseEntity<ErrorMessage>(errorDetails, httpStatus);
	}

	@ExceptionHandler({ DatabaseDataIntegrityException.class })
	public ResponseEntity<ErrorMessage> handleDatabaseDataIntegrityExceptions(Exception ex, WebRequest request) {
		HttpStatus httpStatus = HttpStatus.CONFLICT;
		ErrorMessage errorDetails = new ErrorMessage(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false).substring(request.getDescription(false).indexOf(Constants.TEXT_SLASH)));
		return new ResponseEntity<ErrorMessage>(errorDetails, httpStatus);
	}

	@ExceptionHandler({ DatabaseEntityNotFoundException.class })
	public ResponseEntity<ErrorMessage> handleDatabaseEntityNotFoundExceptions(Exception ex, WebRequest request) {
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		ErrorMessage errorDetails = new ErrorMessage(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false).substring(request.getDescription(false).indexOf(Constants.TEXT_SLASH)));
		return new ResponseEntity<ErrorMessage>(errorDetails, httpStatus);
	}

	@ExceptionHandler({ SmsException.class })
	public ResponseEntity<ErrorMessage> handleSmsExceptions(Exception ex, WebRequest request) {
		HttpStatus httpStatus = HttpStatus.ALREADY_REPORTED;
		ErrorMessage errorDetails = new ErrorMessage(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false).substring(request.getDescription(false).indexOf(Constants.TEXT_SLASH)));
		return new ResponseEntity<ErrorMessage>(errorDetails, httpStatus);
	}

}