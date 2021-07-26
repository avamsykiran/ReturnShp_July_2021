package com.cts.sbd.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("ws2")
@Scope("prototype")
public class WelcomeServiceArgumentedImpl implements WelcomeService {

	@Value("${welcome.text:Namasthey}")
	private String welcomeText;
	
	@Override
	public String greetUser(String userName) {
		return welcomeText + " " + userName;
	}

	public String getWelcomeText() {
		return welcomeText;
	}

	public void setWelcomeText(String welcomeText) {
		this.welcomeText = welcomeText;
	}
	
	

}
