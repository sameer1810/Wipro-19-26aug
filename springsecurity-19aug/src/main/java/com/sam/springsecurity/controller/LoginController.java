package com.sam.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin.html";
	}

	@GetMapping("/mylogin")
	public String login() {
		return "login.html";
	}

}
