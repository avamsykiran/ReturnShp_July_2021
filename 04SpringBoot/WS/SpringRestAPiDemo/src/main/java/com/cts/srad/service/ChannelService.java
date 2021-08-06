package com.cts.srad.service;

import java.util.List;

import com.cts.srad.entity.Channel;
import com.cts.srad.exception.D2HException;

public interface ChannelService {
	List<Channel> getAll();
	Channel getById(Long chId);
	Channel add(Channel channel);
	Channel update(Channel channel) throws D2HException;
	void delete(Long chId)throws D2HException;
}
