package com.cts.sdd.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.sdd.service.ChannelService;
import com.cts.sdd.service.SubscriberService;

@Component
public class D2HApplicationStater {
	
	@Autowired
	private ChannelService chService;
	
	@Autowired
	private SubscriberService subService;

	public void start() {
		System.out.println("D2H Application");
		
		
	}
}
