package com.test.nutri.repository;


import static com.test.nutri.entity.QAnswer.answer;
import static com.test.nutri.entity.QQuestion.question;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.nutri.entity.Answer;
import com.test.nutri.entity.Question;
import com.test.nutri.model.AnswerDTO;
import com.test.nutri.model.QuestionDTO;

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

	
	@Transactional
	public long updateQuestion(QuestionDTO dto) {
		return jpaQueryFactory
				.update(question)
				.where(question.seq.eq(dto.getSeq()))
				.set(question.title, dto.getTitle())
				.set(question.content, dto.getContent())
				.execute();
	}

	@Transactional
	public long solvedQuestion(Long seq) {
		return jpaQueryFactory
				.update(question)
				.where(question.seq.eq(seq))
				.set(question.isSolved, true)
				.execute();
	}

	@Transactional
	public void delQuestionBySeq(Long seq) {
		jpaQueryFactory
				.delete(answer)
				.where(answer.question.seq.eq(seq))
				.execute();
		
		jpaQueryFactory
				.delete(question)
				.where(question.seq.eq(seq))
				.execute();
	}

	public Answer findAnswerBySeq(Long seq) {
		return jpaQueryFactory
				.selectFrom(answer)
				.where(answer.seq.eq(seq))
				.fetchOne();
	}

	@Transactional
	public long updateAnswer(AnswerDTO dto) {
		return jpaQueryFactory
				.update(answer)
				.where(answer.seq.eq(dto.getSeq()))
				.set(answer.content, dto.getContent())
				.execute();
	}

	@Transactional
	public void delAnswerBySeq(Long seq) {
		jpaQueryFactory
				.delete(answer)
				.where(answer.seq.eq(seq))
				.execute();
	}


	
}
