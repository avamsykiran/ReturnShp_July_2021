package com.cts.swmd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.swmd.entity.Channel;
import com.cts.swmd.repo.ChannelRepo;

@Service
public class ChannelServiceImpl implements ChannelService {
	
	@Autowired
	private ChannelRepo chRepo;

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

}
