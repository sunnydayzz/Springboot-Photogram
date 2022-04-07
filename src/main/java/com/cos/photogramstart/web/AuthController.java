package com.cos.photogramstart.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

	@GetMapping("/auth/signin")
	public String signin() {
		return "/auth/signin";
	}
	
	@GetMapping("/auth/signup")
	public String signupForm() {
		return "/auth/signup";
	}
	
	@PostMapping("/auth/signup") // signup.jsp action에서 post로 호출
	public String signup() {
		return "/auth/signin";
	}
}
