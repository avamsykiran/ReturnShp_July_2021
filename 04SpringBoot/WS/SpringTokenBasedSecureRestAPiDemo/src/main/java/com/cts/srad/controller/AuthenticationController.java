package com.cts.srad.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.srad.entity.D2HUser;
import com.cts.srad.entity.D2HUserRole;
import com.cts.srad.entity.Subscriber;
import com.cts.srad.exception.D2HException;
import com.cts.srad.model.JwtToken;
import com.cts.srad.security.JwtTokenUtil;
import com.cts.srad.service.D2HUserService;
import com.cts.srad.service.SubscriberService;

@RestController
@CrossOrigin
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private D2HUserService userDetailsService;
	
	@Autowired
	private SubscriberService subscriberService;
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<JwtToken> createAuthenticationToken(@RequestBody D2HUser user) throws D2HException {
		System.out.println(user);
		authenticate(user.getEmailId(), user.getPassword());
		return ResponseEntity
				.ok(new JwtToken(jwtTokenUtil.generateToken(userDetailsService.loadUserByUsername(user.getEmailId()))));
	}

	private void authenticate(String email, String password) throws D2HException {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (DisabledException e) {
			throw new D2HException("USER_DISABLED");
		} catch (BadCredentialsException e) {
			throw new D2HException("INVALID_CREDENTIALS " + e.getMessage());
		}
	}

	/*
	 * public ResponseEntity<D2HUser> saveUser(@RequestBody D2HUser user) throws
	 * Exception { return ResponseEntity.ok(userDetailsService.add(user)); }
	 */

	@PostMapping(value = "/register")
	public ResponseEntity<Subscriber> registerSubscriber(Subscriber subscriber, BindingResult result)
			throws D2HException {
		
		if (result.hasErrors()) {
			throw new D2HException(result.getAllErrors().stream().map(err -> err.getDefaultMessage())
					.reduce((m1, m2) -> m1 + ";" + m2).orElse("invalid record"));
		} 
		
		return new ResponseEntity<Subscriber>(subscriberService.add(subscriber), HttpStatus.CREATED);
		
	}
}
