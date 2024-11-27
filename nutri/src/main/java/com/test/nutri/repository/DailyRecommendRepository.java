package com.test.nutri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.nutri.entity.VwDailyRecommend;

public interface DailyRecommendRepository extends JpaRepository<VwDailyRecommend, Long> {

	@Query("select d from VwDailyRecommend d where d.dailySeq = ?1")
	List<VwDailyRecommend> listAll(int dailySeq);

	@Query("select d from VwDailyRecommend d where d.dailySeq = ?1")
	List<VwDailyRecommend> findAll(String dailySeq);
	
}
