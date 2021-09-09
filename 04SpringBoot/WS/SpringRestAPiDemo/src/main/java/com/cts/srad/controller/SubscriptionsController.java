package com.cts.srad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.srad.entity.Subscription;
import com.cts.srad.exception.D2HException;
import com.cts.srad.service.SubscriberService;

@RestController
@CrossOrigin
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
