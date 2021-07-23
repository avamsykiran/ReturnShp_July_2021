package com.cts.scd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ws3")
public class WelcomeServiceProvidedImpl implements WelcomeService {

	@Autowired
	private WelcomeTextProvider provider;
	
	@Override
	public String greetUser(String userName) {
		// TODO Auto-generated method stub
		return provider.getWelcomeText() +" " +userName;
	}

}
