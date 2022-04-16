package com.cos.photogramstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity // security 활성화
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		
		http.csrf().disable(); // csrf 비활성화
		
		http.authorizeRequests()
		.antMatchers("/", "/user/**", "/image/***", "/subscribe/**", "/comment/**").authenticated()
		.and()
		.formLogin()
		.loginPage("/auth/signin") // get 요청 처리
		.loginProcessingUrl("/auth/signin") // post 요청 처리
		.defaultSuccessUrl("/");
	}
}
