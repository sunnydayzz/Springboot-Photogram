package com.cos.photogramstart.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // DI
@Controller
public class AuthController {
	
	private static final Logger log = LoggerFactory.getLogger(AuthController.class);
	
	private final AuthService authService; // di

	// 생성자로 DI
//	public AuthController(AuthService authService) {
//		this.authService = authService;
//	}
	
	@GetMapping("/auth/signin")
	public String signin() {
		return "/auth/signin";
	}
	
	@GetMapping("/auth/signup")
	public String signupForm() {
		return "/auth/signup";
	}
	
	@PostMapping("/auth/signup") // signup.jsp action에서 post로 호출
	public String signup(@Valid SignupDto signupDto, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
				
				System.out.println(error.getDefaultMessage());
			}
			
			throw new CustomValidationException("유효성 검사 실패함", errorMap);
		
		} else {
			User user = signupDto.toEntity();
			log.info(user.toString());
			
			User userEntity = authService.회원가입(user);
			System.out.println(userEntity); // db 입력내용 확인
			
			return "/auth/signin";
		}
	}
}
