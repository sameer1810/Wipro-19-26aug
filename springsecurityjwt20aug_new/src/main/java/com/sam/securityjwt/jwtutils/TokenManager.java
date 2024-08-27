package com.sam.securityjwt.jwtutils;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class TokenManager {

	private static final long TOKEN_VALIDITY = 10*60*60;
	
	@Value("${secret}")
	private String JwTokenSecret;
	
	@SuppressWarnings("/deprecation")
	public String generateToken(UserDetails userDetails) {
		
		Map<String,Object> claims = new HashMap<>();
		
		return Jwts.builder()
				   .setClaims(claims)
				   .setSubject(userDetails.getUsername())
				   .setIssuedAt(new Date(System.currentTimeMillis()))
				   .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY *1000))
				   .signWith(getKey(),SignatureAlgorithm.HS256)
				   .compact();
	}
	
	public Boolean validateJwtToken(String token, UserDetails userDetails) {
		
		final String username = getUsernameFromToken(token);
		final Claims claims = Jwts
				.parser()
				.setSigningKey(getKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
		
		Boolean isTokenExpired = claims.getExpiration().before(new Date());
		
		return (username.equals(userDetails.getUsername())) && !isTokenExpired;
	}
	
	String getUsernameFromToken(String token) {
		final Claims claims = Jwts
				.parser()
				.setSigningKey(getKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
		
		return claims.getSubject();
	}

	private Key getKey() {   
		
		byte[] keyBytes = Decoders.BASE64.decode(JwTokenSecret);
		Key key = Keys.hmacShaKeyFor(keyBytes);
		return key;
	}
}