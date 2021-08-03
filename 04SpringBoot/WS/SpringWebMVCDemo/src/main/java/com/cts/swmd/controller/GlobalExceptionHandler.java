package com.cts.swmd.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.cts.swmd.exception.D2HException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(D2HException.class)
	public ModelAndView handleD2HException(D2HException exp) {
		return new ModelAndView("err-page","err",exp.getMessage());
	}
}
