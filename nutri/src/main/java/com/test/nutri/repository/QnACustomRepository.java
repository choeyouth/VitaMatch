package com.test.nutri.repository;


import java.util.List;

import static com.test.nutri.entity.QAnswer.answer;
import static com.test.nutri.entity.QMember.member;
import static com.test.nutri.entity.QQuestion.question;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.nutri.entity.Answer;
import com.test.nutri.entity.Question;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class QnACustomRepository {
	
	private final JPAQueryFactory jpaQueryFactory;

	public List<Question> findAll() {
		return jpaQueryFactory
				.selectFrom(question)
				.fetch();
	}

	public Question findQuestionBySeq(Long seq) {
		return jpaQueryFactory
				.selectFrom(question)
				.where(question.seq.eq(seq))
				.fetchOne();
	}

	public List<Answer> findAnswerByQuestionSeq(Long seq) {
		return jpaQueryFactory
				.selectFrom(answer) // 자식에게 부모 객체 존재함 N(answer):1(question) 
	            .join(answer.question, question)  // Answer와 Question을 조인
	            .where(question.seq.eq(seq))  // Question의 seq로 조건 설정
	            .fetch(); 
	}

	
}
