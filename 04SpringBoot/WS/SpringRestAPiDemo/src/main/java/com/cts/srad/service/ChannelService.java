package com.cts.srad.service;

import java.util.List;

import com.cts.srad.entity.Channel;

public interface ChannelService {
	List<Channel> getAll();
	Channel getById(Long chId);
	Channel add(Channel channel);
}
