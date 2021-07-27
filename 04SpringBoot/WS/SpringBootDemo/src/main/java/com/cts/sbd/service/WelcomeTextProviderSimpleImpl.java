package com.cts.sbd.service;

import org.springframework.stereotype.Service;

@Service
//@Primary
public class WelcomeTextProviderSimpleImpl implements WelcomeTextProvider {

	@Override
	public String getWelcomeText() {
		return "Namaskar! ";
	}
}
