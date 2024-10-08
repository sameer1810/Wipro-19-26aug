package com.sam.securityjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sam.securityjwt.jwtutils.JwtUserDetailsService;
import com.sam.securityjwt.jwtutils.TokenManager;
import com.sam.securityjwt.model.JwtRequest;
import com.sam.securityjwt.model.JwtResponse;

@RestController
@CrossOrigin
public class JwtController {
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	@Autowired
    private TokenManager tokenManager;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<JwtResponse> createToken(@RequestBody JwtRequest request) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED" + e );
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_DISABLED" + e );
	    }
		final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
		final String jwtToken = tokenManager.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(jwtToken));
  }
}
