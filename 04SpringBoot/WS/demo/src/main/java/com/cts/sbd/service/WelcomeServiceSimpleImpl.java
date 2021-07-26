package com.cts.sbd.service;

import org.springframework.stereotype.Service;

@Service("ws1")
public class WelcomeServiceSimpleImpl implements WelcomeService {

	@Override
	public String greetUser(String userName) {
		return "Hello "+userName;
	}

}
