package com.cos.photogramstart.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String username;
	private String password;
	
	private String name;
	private String website;
	private String bio;
	private String email;
	private String phone;
	private String gender;;
	
	private String profileImageUrl;
	private String role;
	
	private LocalDateTime createDate;
	
	@PrePersist // db 인서트 직전에 실행되도록
	public void createDate() {
		this.createDate = LocalDateTime.now();
	}
	
	
}
