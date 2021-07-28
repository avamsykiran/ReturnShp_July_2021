package com.cts.sdd.service;

import java.util.List;

import com.cts.sdd.entity.Subscriber;
import com.cts.sdd.entity.Subscription;
import com.cts.sdd.exception.D2HException;

public interface SubscriberService {
	List<Subscriber> getAll();
	Subscriber getById(Long subId);
	Subscriber add(Subscriber subscriber);
	
	Subscription addSubcription(Long subId,Long chId) throws D2HException;
	List<Subscription> getAllSubscriptionsOf(Long subId);
}
