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
@Table(name = "answer")
@AllArgsConstructor
@NoArgsConstructor
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	private String content;
	private LocalDateTime regDate;
	private LocalDateTime modDate;
	
	//자식 > 부모 참조
	@ManyToOne
	@JoinColumn(name="member_seq") 
	private Member member;
	
	//자식 > 부모 참조
	@ManyToOne
	@JoinColumn(name="question_seq") 
	private Question question;
	
	
}



