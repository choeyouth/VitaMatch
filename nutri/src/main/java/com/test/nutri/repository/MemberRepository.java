package com.test.nutri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.nutri.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

	boolean existsByUsername(String username);

	Member findByUsername(String username);
	

}
