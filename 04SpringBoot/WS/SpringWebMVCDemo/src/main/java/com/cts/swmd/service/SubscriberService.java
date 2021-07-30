package com.cts.swmd.service;

import java.util.List;

import com.cts.swmd.entity.Subscriber;
import com.cts.swmd.entity.Subscription;
import com.cts.swmd.exception.D2HException;

public interface SubscriberService {
	List<Subscriber> getAll();
	Subscriber getById(Long subId);
	Subscriber add(Subscriber subscriber);
	
	Subscription addSubcription(Long subId,Long chId) throws D2HException;
	List<Subscription> getAllSubscriptionsOf(Long subId);
}