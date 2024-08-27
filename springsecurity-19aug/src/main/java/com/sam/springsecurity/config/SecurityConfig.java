package com.sam.springsecurity.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@SuppressWarnings("deprecation")
	@Bean 
	public InMemoryUserDetailsManager userDetailsService() {
		
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withDefaultPasswordEncoder()
               .username("user1")
               .password("password1")
               .roles("USER")
               .build());
		return manager;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
			.authorizeHttpRequests((authz) -> authz
		    .requestMatchers("/admin").hasRole("ADMIN")
		    .requestMatchers("/mylogin").permitAll()
		    .requestMatchers("/welcome").permitAll()
		    .anyRequest().authenticated()
		    );
		
		http.formLogin();
		http.httpBasic();
		
		return http.build();
	}

    @Bean
    public static PasswordEncoder passwordEncoder() {
	     return new BCryptPasswordEncoder();
    }
}