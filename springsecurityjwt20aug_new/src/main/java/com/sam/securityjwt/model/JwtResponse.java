package com.sam.securityjwt.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = 2169469908959994123L;

	private final String token;
	
	public JwtResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}
	
	
}
