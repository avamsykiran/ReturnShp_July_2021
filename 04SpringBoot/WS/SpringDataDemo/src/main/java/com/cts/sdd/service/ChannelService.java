package com.cts.sdd.service;

import java.util.List;

import com.cts.sdd.entity.Channel;

public interface ChannelService {
	List<Channel> getAll();
	Channel getById(Long chId);
	Channel add(Channel channel);
}
