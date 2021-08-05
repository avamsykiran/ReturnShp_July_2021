package com.cts.srad.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.cts.srad.exception.D2HException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	Logger logger;
	
	public GlobalExceptionHandler() {
		logger = LoggerFactory.getLogger(this.getClass());
	}
	
	@ExceptionHandler(D2HException.class)
	public ResponseEntity<String> handleD2HException(D2HException exp) {
		logger.error(exp.getMessage());
		return new ResponseEntity<String>(exp.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleUnhandledException(Exception exp) {
		logger.error(exp.getMessage());
		return new ResponseEntity<String>("We regeret the inconvinince, something went wrong on server",
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
