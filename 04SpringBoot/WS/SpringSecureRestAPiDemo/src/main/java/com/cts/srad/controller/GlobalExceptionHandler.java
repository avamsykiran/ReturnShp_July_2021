package com.cts.srad.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.cts.srad.exception.D2HException;
import com.cts.srad.model.ErrorWrapper;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	Logger logger;
	
	public GlobalExceptionHandler() {
		logger = LoggerFactory.getLogger(this.getClass());
	}
	
	@ExceptionHandler(D2HException.class)
	public ResponseEntity<ErrorWrapper> handleD2HException(D2HException exp) {
		logger.error(exp.getMessage());
		return new ResponseEntity<>(new ErrorWrapper(exp.getMessage()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorWrapper> handleUnhandledException(Exception exp) {
		logger.error(exp.getMessage());
		return new ResponseEntity<>(
				new ErrorWrapper("We regeret the inconvinince, something went wrong on server"),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
