package com.test.nutri.model;

import java.time.LocalDateTime;


import com.test.nutri.entity.Answer;
import com.test.nutri.entity.Member;
import com.test.nutri.entity.Question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class answerDTO {

	private Long seq;
	private Long memberSeq;
	private Long questionSeq;
	private String content;
	
	private LocalDateTime regDate;
	private LocalDateTime modDate;

	public Answer toEntity(Member member, Question question) {
		
		return Answer.builder()
				      .seq(this.getSeq())
				      .member(member)
				      .question(question)
				      .content(this.getContent())
				      .regDate(this.getRegDate())
				      .modDate(this.getModDate())
				      .build();
	}
}
