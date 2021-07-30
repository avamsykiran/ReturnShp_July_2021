package com.cts.swmd.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.swmd.entity.Channel;
import com.cts.swmd.entity.Subscriber;
import com.cts.swmd.entity.Subscription;
import com.cts.swmd.entity.SubscriptionId;
import com.cts.swmd.exception.D2HException;
import com.cts.swmd.repo.ChannelRepo;
import com.cts.swmd.repo.SubscriberRepo;
import com.cts.swmd.repo.SubscriptionRepo;

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
		// required validations here..
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
	public List<Subscription> getAllSubscriptionsOf(Long subId) {
//		Subscriber s = subscriberRepo.findById(subId).orElse(null);
//		List<Subscription> results=null;
//		
//		if (s != null)
//			results = new ArrayList<>(s.getSubscriptions());
//
//		return results;
		
		return subscriptionRepo.getAllBySubscriber(subId);
	}

	
}
