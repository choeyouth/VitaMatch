package com.test.nutri.model;

import java.time.LocalDateTime;

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
public class QuestionDTO {

	private Long seq;
	private Integer memberSeq;
	private String title;
	private String content;
	private Boolean isSolved;
	private LocalDateTime regDate;
	private LocalDateTime modDate;
	
	public Question toEntity(Member member) {
		
		return Question.builder()
				      .seq(this.getSeq())
				      .member(member)
				      .title(this.getTitle())
				      .content(this.getContent())
				      .isSolved(this.getIsSolved()) 
				      .build();
	}
}
