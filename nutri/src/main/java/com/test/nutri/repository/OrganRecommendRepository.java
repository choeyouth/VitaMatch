package com.test.nutri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.nutri.entity.VwOrganRecommend;

public interface OrganRecommendRepository extends JpaRepository<VwOrganRecommend, Long> {

	@Query("select o from VwOrganRecommend o where o.organSeq = ?1")
	List<VwOrganRecommend> listAll(int organSeq);

	@Query("select o from VwOrganRecommend o where o.organSeq = ?1")
	List<VwOrganRecommend> findAll(String organSeq);

	
}
