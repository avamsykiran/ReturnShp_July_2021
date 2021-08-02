package com.cts.swmd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.swmd.service.SubscriberService;

@Controller
@RequestMapping("/subscriptions")
public class SubscriptionsController {

	@Autowired
	private SubscriberService subscriberService;
	
	@GetMapping("/{subId}")
	public ModelAndView defaultAction(@PathVariable("subId")long subscriberId) {
		ModelAndView mv = new ModelAndView("subscriptions/home-page","subscriber",subscriberService.getById(subscriberId));
		mv.addObject("subscriptions", subscriberService.getAllSubscriptionsOf(subscriberId));
		return mv;
	}
}
