package com.test.nutri.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.nutri.entity.GoodCombination;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CombinationRepository {

	//private final JPAQueryFactory jPAQueryFactory;

	public List<GoodCombination> findAllSeq() {
		
		return null;
	}
	
	
	
}
