package com.cts.sbd.service;

import java.time.LocalTime;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
//@Primary
public class WelcomeTextProviderSimpleImpl implements WelcomeTextProvider {

	@Override
	public String getWelcomeText() {
		return "Namaskar! ";
	}
}
