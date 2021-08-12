package com.cts.srad.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.srad.entity.D2HUser;
import com.cts.srad.repo.D2HUserRepo;

@Service
public class D2HUserServiceImpl implements D2HUserService{

	@Autowired
	private D2HUserRepo userRepo;
	
	@Autowired
	private PasswordEncoder pwdEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		
		D2HUser user = userRepo.findByEmailId(emailId);
		
		if(user==null)
			throw new UsernameNotFoundException("No such user found");
		
		List<GrantedAuthority> authroities = Arrays.asList(new GrantedAuthority[] {
				new SimpleGrantedAuthority(user.getRole().toString())
		}); 
		
		return new User(user.getEmailId(), user.getPassword(), authroities);
	}

	@Override
	public D2HUser add(D2HUser user) {
		user.setPassword(pwdEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

}
