package com.cts.sdd.service;

import java.util.List;

import com.cts.sdd.entity.Subscriber;
import com.cts.sdd.entity.Subscription;

public interface SubscriberService {
	List<Subscriber> getAll();
	Subscriber getById(Long subId);
	Subscriber add(Subscriber subscriber);
	
	Subscription addSubcription(Long subId,Long chId);
	List<Subscription> getAllSubscriptionsOf(Long subId);
}
