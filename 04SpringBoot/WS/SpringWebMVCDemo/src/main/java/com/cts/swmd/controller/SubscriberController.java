package com.cts.swmd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.swmd.entity.Channel;
import com.cts.swmd.entity.Subscriber;
import com.cts.swmd.service.SubscriberService;

@Controller
@RequestMapping("/subscribers")
public class SubscriberController {

	@Autowired
	private SubscriberService subscriberService;
	
	@GetMapping
	public ModelAndView defaultHandler() {
		return new ModelAndView("subscribers/home-page","subscribers",subscriberService.getAll());
	}
	
	@GetMapping("/add")
	public ModelAndView subscriberAddFormAction() {
		return new ModelAndView("subscribers/subscriber-form-page","subscriber",new Subscriber());
	}
	
	@PostMapping("/add")
	public ModelAndView subscriberAddFormSubmitionAction(
			@Valid @ModelAttribute("subscriber")Subscriber subscriber,BindingResult result
			) {
		ModelAndView mv=null;
		
		if(result.hasErrors()) {
			mv=new ModelAndView("subscribers/subscriber-form-page","subscriber",subscriber);
		}else {
			subscriberService.add(subscriber);
			mv = new ModelAndView("redirect:/subscribers");
		}
		
		return mv;
	}
}
