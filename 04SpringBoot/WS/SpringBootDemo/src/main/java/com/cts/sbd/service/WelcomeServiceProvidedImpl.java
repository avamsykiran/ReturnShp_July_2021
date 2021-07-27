package com.cts.sbd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ws3")
public class WelcomeServiceProvidedImpl implements WelcomeService {

	@Autowired
	//@Qualifier("welcomeTextProviderSimpleImpl")
	@Qualifier("welcomeTextProviderTimeBasedImpl")
	private WelcomeTextProvider provider;
	
	@Override
	public String greetUser(String userName) {
		// TODO Auto-generated method stub
		return provider.getWelcomeText() +" " +userName;
	}

}
