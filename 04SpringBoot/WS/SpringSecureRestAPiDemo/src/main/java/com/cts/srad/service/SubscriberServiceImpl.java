package com.cts.srad.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.srad.entity.Channel;
import com.cts.srad.entity.Subscriber;
import com.cts.srad.entity.Subscription;
import com.cts.srad.entity.SubscriptionId;
import com.cts.srad.exception.D2HException;
import com.cts.srad.model.SubscriptionDetailsForSubscriber;
import com.cts.srad.repo.ChannelRepo;
import com.cts.srad.repo.SubscriberRepo;
import com.cts.srad.repo.SubscriptionRepo;

@Service
public class SubscriberServiceImpl implements SubscriberService {

	@Autowired
	private SubscriberRepo subscriberRepo;

	@Autowired
	private SubscriptionRepo subscriptionRepo;
	
	@Autowired
	private ChannelRepo channelRepo;

	@Override
	public List<Subscriber> getAll() {
		return subscriberRepo.findAll();
	}

	@Override
	public Subscriber getById(Long subId) {
		return subscriberRepo.findById(subId).orElse(null);
	}

	@Transactional
	@Override
	public Subscriber add(Subscriber subscriber) {
		return subscriberRepo.save(subscriber);
	}

	@Transactional
	@Override
	public Subscriber update(Subscriber subscriber) throws D2HException {
		if(!subscriberRepo.existsById(subscriber.getSubscriberId()))
			throw new D2HException("No such subcriber record found to update");
		return subscriberRepo.save(subscriber);
	}
	
	@Transactional
	@Override
	public Subscription addSubcription(Long subId, Long chId) throws D2HException {
		Subscriber s = subscriberRepo.findById(subId).orElse(null);
		Channel c = channelRepo.findById(chId).orElse(null);

		if (s == null)
			throw new D2HException("No such subscriber");

		if (c == null)
			throw new D2HException("No such channel");

		SubscriptionId spid = new SubscriptionId(s, c);

		if (subscriptionRepo.existsById(spid))
			throw new D2HException("The given subscriber already subscribed the given channel");

		return subscriptionRepo.save(new Subscription(spid, LocalDate.now()));

	}

	@Override
	public List<SubscriptionDetailsForSubscriber> getAllSubscriptionsOf(Long subId) {
		return subscriptionRepo.getAllChannelNamesBySubscriber(subId);
	}

	@Override
	public List<Channel> getChannelsNotSubscribedBy(Long subscriberId) {
		return channelRepo.getChannelsNotSubscribedBy(subscriberId);
	}	
}
