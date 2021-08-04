package com.cts.swmd.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.swmd.entity.Channel;
import com.cts.swmd.entity.Gender;
import com.cts.swmd.entity.Subscriber;
import com.cts.swmd.exception.D2HException;
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
	
	@ModelAttribute(name = "genders")
	public List<Gender> genders(){
		return Arrays.asList(Gender.values());
	}
	
	@GetMapping("/add")
	public ModelAndView subscriberAddFormAction() {
		return new ModelAndView("subscribers/subscriber-form-page","subscriber",new Subscriber());
	}

	@GetMapping("/edit/{subId}")
	public ModelAndView subscriberEditFormAction(@PathVariable("subId")long subId) {
		return new ModelAndView("subscribers/subscriber-form-page","subscriber",subscriberService.getById(subId));
	}
	
	@PostMapping({"/add","/edit/{subId}"})
	public ModelAndView subscriberSaveAction(
			@Valid @ModelAttribute("subscriber")Subscriber subscriber,BindingResult result,
			@PathVariable(name="subId",required = false) Long subId
			) throws D2HException {
		ModelAndView mv=null;
		
		if(result.hasErrors()) {
			mv=new ModelAndView("subscribers/subscriber-form-page","subscriber",subscriber);
		}else {
			if(subId==null)
				subscriberService.add(subscriber);
			else
				subscriberService.update(subscriber);
			mv = new ModelAndView("redirect:/subscribers");
		}
		
		return mv;
	}
	
	
}
