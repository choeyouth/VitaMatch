package com.test.nutri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.nutri.entity.ShoppingCartInfo;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCartInfo, Long> {

	@Query("SELECT s FROM ShoppingCartInfo s WHERE s.seq = :seq")
	List<ShoppingCartInfo> findByMemberSeq(@Param("seq") String seq);
	
}
