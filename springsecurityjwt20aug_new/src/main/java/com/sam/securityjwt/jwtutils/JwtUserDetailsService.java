package com.sam.securityjwt.jwtutils;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if("user1".equals(username))
		     return new User("user1",
				"password",
				new ArrayList<>());
	
	else 
	{
		throw new UsernameNotFoundException("user not found with username : " + username);
	}
  }
}