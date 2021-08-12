package com.cts.srad.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.cts.srad.entity.D2HUser;

public interface D2HUserService extends UserDetailsService {
	D2HUser add(D2HUser user);
}
