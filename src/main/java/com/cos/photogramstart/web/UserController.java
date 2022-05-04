package com.cos.photogramstart.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.photogramstart.config.auth.PrincipalDetails;

@Controller
public class UserController {

	@GetMapping("/user/{id}")
	public String popular(@PathVariable int id) {
		
		return "user/profile";
	}
	
	// 회원정보 변경
	@GetMapping("/user/{id}/update")
	public String update(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		
		// 1. 추천 : @AuthenticationPrincipal으로 세션정보 읽기
		System.out.println("세션정보 :" + principalDetails.getUser());
		
		// 2. 세션에서 직접 읽기
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		PrincipalDetails mPrincipalDetails = (PrincipalDetails) auth.getPrincipal();
		System.out.println("직접 찾은 세션 정보: " + mPrincipalDetails.getUser());
		
		return "user/update";
	}
}
