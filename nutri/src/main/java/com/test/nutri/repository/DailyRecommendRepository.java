package com.test.nutri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.nutri.entity.vwDailyRecommend;

public interface DailyRecommendRepository extends JpaRepository<vwDailyRecommend, Long> {

	@Query("select d from vwDailyRecommend d where d.dailySeq = ?1")
	List<vwDailyRecommend> listAll(int dailySeq);

}
