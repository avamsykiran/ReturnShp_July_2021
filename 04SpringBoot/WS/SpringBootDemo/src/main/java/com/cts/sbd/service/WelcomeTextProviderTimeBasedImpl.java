package com.cts.sbd.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service
public class WelcomeTextProviderTimeBasedImpl implements WelcomeTextProvider {

	@Override
	public String getWelcomeText() {
		String welcomeText="Good Evening";
		
		int h = LocalTime.now().getHour();
		
		if(h>=3 && h<12)
			welcomeText="Good Morning";
		else if(h>=12 && h<=16)
			welcomeText="Good Noon";
		
		return welcomeText;
	}

}
