package com.cts.swmd.service;

import java.util.List;

import com.cts.swmd.entity.Channel;
import com.cts.swmd.entity.Subscriber;
import com.cts.swmd.entity.Subscription;
import com.cts.swmd.exception.D2HException;
import com.cts.swmd.model.SubscriptionDetailsForSubscriber;

public interface SubscriberService {
	List<Subscriber> getAll();
	Subscriber getById(Long subId);
	Subscriber add(Subscriber subscriber);
	Subscriber update(Subscriber subscriber) throws D2HException;
	
	Subscription addSubcription(Long subId,Long chId) throws D2HException;
	List<SubscriptionDetailsForSubscriber> getAllSubscriptionsOf(Long subId);
	
	List<Channel> getChannelsNotSubscribedBy(Long subscriberId);
}
