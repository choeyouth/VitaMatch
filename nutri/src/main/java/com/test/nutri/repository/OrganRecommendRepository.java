package com.test.nutri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.nutri.entity.vwOrganRecommend;

public interface OrganRecommendRepository extends JpaRepository<vwOrganRecommend, Long> {

	@Query("select o from vwOrganRecommend o where o.organSeq = ?1")
	List<vwOrganRecommend> listAll(int organSeq);

	@Query("select o from vwOrganRecommend o where o.organSeq = ?1")
	List<vwOrganRecommend> findAll(String organSeq);

	

}
