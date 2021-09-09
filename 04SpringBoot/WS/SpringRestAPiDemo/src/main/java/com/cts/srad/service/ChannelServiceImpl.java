package com.cts.srad.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.srad.entity.Channel;
import com.cts.srad.exception.D2HException;
import com.cts.srad.model.SubscriptionDetails;
import com.cts.srad.repo.ChannelRepo;
import com.cts.srad.repo.SubscriptionRepo;

@Service
public class ChannelServiceImpl implements ChannelService {
	
	@Autowired
	private ChannelRepo chRepo;
	
	@Autowired
	private SubscriptionRepo subpRepo;

	@Override
	public List<Channel> getAll() {
		return chRepo.findAll();
	}

	@Override
	public Channel getById(Long chId) {
		return chRepo.findById(chId).orElse(null);
	}

	@Transactional
	@Override
	public Channel add(Channel channel) {
		//do the relevant validations....!
		return chRepo.save(channel);
	}

	@Override
	public Channel update(Channel channel) throws D2HException {
		if(!chRepo.existsById(channel.getChannelId()))
			throw new D2HException("No such channel to update");
		return chRepo.save(channel);
	}

	@Override
	public void delete(Long chId) throws D2HException {
		if(!chRepo.existsById(chId))
			throw new D2HException("No such channel to update");
		chRepo.deleteById(chId);
	}

	@Override
	public List<SubscriptionDetails> getAllSubscriptionsOf(Long channelId) {
		return subpRepo.getAllSubscriberNamesByChannel(channelId);
	}

}
