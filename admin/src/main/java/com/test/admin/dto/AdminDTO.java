package com.test.admin.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.test.admin.entity.Admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {

	private Long seq;
	private String id;
	private String pw;
	private String name;
	private LocalDate birthDate;
	private String email;
	
	public AdminDTO(String id, String pw, String name, String birthDate, String email) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
		this.email = email;
	}

	public Admin toEntity() {
		return Admin.builder()
				.id(id)
				.pw(pw)
				.name(name)
				.birthDate(birthDate)
				.email(email)
				.build();
	}
}
