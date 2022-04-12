package com.cos.photogramstart.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가
	
	private Long id;
	
	@Column(length = 20, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String name;
	private String website;
	private String bio;
	
	@Column(nullable = false)
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
