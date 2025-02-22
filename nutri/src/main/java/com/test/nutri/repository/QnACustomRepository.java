package com.test.nutri.repository;


import static com.test.nutri.entity.QAnswer.answer;
import static com.test.nutri.entity.QMember.member;
import static com.test.nutri.entity.QQuestion.question;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.dsl.BooleanExpression;
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
	            .join(answer.question, question).fetchJoin() // Answer와 Question을 조인
	            .join(answer.member, member).fetchJoin() // N+1 문제 해결 
	            .where(question.seq.eq(seq))  // Question의 seq로 조건 설정
	            .fetch(); 
	}

	
	@Transactional
	@CacheEvict(value = "qnaCache", allEntries = true)
	public long updateQuestion(QuestionDTO dto) {
		return jpaQueryFactory
				.update(question)
				.where(question.seq.eq(dto.getSeq()))
				.set(question.title, dto.getTitle())
				.set(question.content, dto.getContent())
				.execute();
	}

	@Transactional
	@CacheEvict(value = "qnaCache", allEntries = true)
	public long solvedQuestion(Long seq) {
		return jpaQueryFactory
				.update(question)
				.where(question.seq.eq(seq))
				.set(question.isSolved, true)
				.execute();
	}

	@Transactional
	@CacheEvict(value = "qnaCache", allEntries = true)
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

	@Cacheable(value = "qnaCache", key = "#offset + '-' + #limit + '-' + #keyword")
	public List<Question> findAllPagenationByKeyword(Long offset, int limit, String keyword) {
		
		BooleanExpression condition = keywordCondition(keyword);
		
		return jpaQueryFactory
				.selectFrom(question)
				.where(condition)
				.orderBy(question.seq.desc())
				.offset(offset)
				.limit(limit)
				.fetch();
	}
	
	
	public Long count(String keyword) {
		
		BooleanExpression condition = keywordCondition(keyword);
		
		Long result = jpaQueryFactory
	            .select(question.count())  // count()로 데이터 개수만 반환
	            .from(question)
	            .where(condition)
	            .fetchOne();
		
		return result != null ? result : 0L;
	}
	
	private BooleanExpression keywordCondition(String keyword) {
		
		if (keyword != null && !keyword.trim().isEmpty()) {
	        return question.title.contains(keyword)
	                .or(question.content.contains(keyword));
	    }
	    
	    return null;
	}


	
}
