package com.cts.swmd.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.cts.swmd.entity.Channel;
import com.cts.swmd.entity.Subscriber;
import com.cts.swmd.exception.D2HException;
import com.cts.swmd.model.SubscriptionDetailsForSubscriber;
import com.cts.swmd.service.SubscriberService;

@Controller
@RequestMapping("/subscriptions")
public class SubscriptionsController {

	@Autowired
	private SubscriberService subscriberService;

	@GetMapping({"","/","/{subId}"})
	public ModelAndView defaultAction(@PathVariable(name = "subId",required = false)Long subscriberId,HttpSession session) throws D2HException {
		Subscriber subscriber= null;
		if(subscriberId!=null) {
			subscriber=subscriberService.getById(subscriberId);
			session.setAttribute("subscriber", subscriber);
		}else {
			subscriber=(Subscriber) session.getAttribute("subscriber");
		}
		
		if(subscriber==null)
			throw new D2HException("Sorry! We did not recieve enough resources to answer your request or the session might have expired");
		
		ModelAndView mv = new ModelAndView("subscriptions/home-page");
		mv.addObject("subscriber",subscriber);
		mv.addObject("subscriptions",subscriberService.getAllSubscriptionsOf(subscriber.getSubscriberId()));
		mv.addObject("unSubscribedChannels",subscriberService.getChannelsNotSubscribedBy(subscriber.getSubscriberId()));
		return mv;
	}
	
	@GetMapping("/addSubscription")
	public String doAddSubscription(@RequestParam("chid")Long channelId,
			@SessionAttribute(required = false) Subscriber subscriber) throws D2HException {
	
		if(subscriber==null)
			throw new D2HException("Sorry! We did not recieve enough resources to answer your request or the session might have expired");
	
		subscriberService.addSubcription(subscriber.getSubscriberId(), channelId);
		
		return "redirect:/subscriptions";
	}
	
}
