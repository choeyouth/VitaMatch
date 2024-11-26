package com.test.nutri.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="member")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seq;
	
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String nickname;
	
	@Column(nullable = false)
	private String dob;
	
	@Column(nullable = false)
	private String gender;
	
	@Column(nullable = false)
	private String telephone;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String status;
	
	@Column(nullable = false)
	private String createTime;
	
	@Column(nullable = false)
	private String updateTime;
	
}
