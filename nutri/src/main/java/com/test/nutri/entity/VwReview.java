package com.test.nutri.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="vwReview")
@AllArgsConstructor
@NoArgsConstructor
public class VwReview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//데이터베이스 기본키 자동 생성
	private long seq;
	
	private String nickname;
	private String createDate;
	private String title;
	private String category;
	private String name;
	private String content;
	private String image;
	private String score;

}

