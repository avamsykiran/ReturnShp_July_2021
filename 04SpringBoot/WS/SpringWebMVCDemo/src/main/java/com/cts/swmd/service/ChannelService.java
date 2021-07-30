package com.cts.swmd.service;

import java.util.List;

import com.cts.swmd.entity.Channel;

public interface ChannelService {
	List<Channel> getAll();
	Channel getById(Long chId);
	Channel add(Channel channel);
}
