package com.test.nutri.repository;

import static com.test.nutri.entity.QMember.member;
import static com.test.nutri.entity.QQuestion.question;
import static com.test.nutri.entity.QAnswer.answer;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class QnACustomRepository {
	
	private final JPAQueryFactory jpaQueryFactory;
	
}
