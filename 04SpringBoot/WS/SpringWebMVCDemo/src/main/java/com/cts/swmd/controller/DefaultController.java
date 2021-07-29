package com.cts.swmd.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {
	
	@Value("${application.name:MySpringWeb}")
	private String brandName;

	@RequestMapping({"","/","/home"})
	public ModelAndView defaultAction() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/header")
	public ModelAndView headerAction() {
		return new ModelAndView("header","brandName",brandName);
	}
	
	@RequestMapping("/footer")
	public ModelAndView footerAction() {
		return new ModelAndView("footer");
	}
}
