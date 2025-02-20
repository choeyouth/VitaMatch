package com.test.nutri.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "question")
@AllArgsConstructor
@NoArgsConstructor
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	private String title;
	private String content;
	private LocalDateTime regDate;
	private LocalDateTime modDate;
	private Boolean isSolved;
	
	//자식 > 부모 참조
	//@ManyToOne(fetch = LAZY)
	@ManyToOne
	@JoinColumn(name="member_seq") 
	private Member member;
	
}



