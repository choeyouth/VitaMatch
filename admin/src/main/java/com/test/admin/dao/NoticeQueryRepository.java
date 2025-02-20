package com.test.admin.dao;

import static com.test.admin.entity.QNotice.notice;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.admin.entity.Notice;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class NoticeQueryRepository {
	
	private final JPAQueryFactory jpaQueryFactory;

	public List<Notice> findAllPagenation(int offset, int limit) {
		return jpaQueryFactory.selectFrom(notice)
				.offset(offset)
				.limit(limit)
				.fetch();
	}

}
