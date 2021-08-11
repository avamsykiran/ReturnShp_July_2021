package com.cts.srad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.cts.srad.entity.Subscriber;
import com.cts.srad.entity.Subscription;
import com.cts.srad.exception.D2HException;
import com.cts.srad.service.SubscriberService;

@Controller
@RequestMapping("/subscriptions")
public class SubscriptionsController {

	@Autowired
	private SubscriberService subscriberService;
		
	@PostMapping
	public ResponseEntity<Subscription> doAddSubscription(@RequestBody Subscription subscription) throws D2HException {
	
		subscription = subscriberService.addSubcription(subscription.getSubpId().getSubscriber().getSubscriberId(),
				subscription.getSubpId().getChannel().getChannelId());
		
		return new ResponseEntity<Subscription>(subscription,HttpStatus.OK);
	}
	
}
