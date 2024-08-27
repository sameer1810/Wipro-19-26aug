package com.sam.securityjwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sam.securityjwt.jwtutils.JwtAuthenticationEntryPoint;
import com.sam.securityjwt.jwtutils.JwtFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Autowired
	private JwtAuthenticationEntryPoint authenticationEntryPoint;
	
	@Autowired
	private JwtFilter filter;
	
	@Bean
	protected PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
	
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 
		return http
				 .csrf(AbstractHttpConfigurer::disable)
				 .authorizeHttpRequests( request ->request.requestMatchers("/login").permitAll()
				          .anyRequest().authenticated())
                 .exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint))
                 .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                 .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                 .build();
	}
	
	@Bean
	AuthenticationManager customerAuthenticationManager() {
		return authentication -> new UsernamePasswordAuthenticationToken("user1", "password");
		
	}

}
