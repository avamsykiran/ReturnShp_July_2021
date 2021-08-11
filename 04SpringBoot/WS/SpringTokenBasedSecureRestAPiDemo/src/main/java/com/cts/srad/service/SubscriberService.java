package com.cts.srad.service;

import java.util.List;

import com.cts.srad.entity.Channel;
import com.cts.srad.entity.Subscriber;
import com.cts.srad.entity.Subscription;
import com.cts.srad.exception.D2HException;
import com.cts.srad.model.SubscriptionDetailsForSubscriber;

public interface SubscriberService {
	List<Subscriber> getAll();
	Subscriber getById(Long subId);
	Subscriber add(Subscriber subscriber);
	Subscriber update(Subscriber subscriber) throws D2HException;
	
	Subscription addSubcription(Long subId,Long chId) throws D2HException;
	List<SubscriptionDetailsForSubscriber> getAllSubscriptionsOf(Long subId);
	
	List<Channel> getChannelsNotSubscribedBy(Long subscriberId);
}
