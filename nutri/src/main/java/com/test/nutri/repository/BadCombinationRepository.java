package com.test.nutri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.nutri.entity.BadCombination;

public interface BadCombinationRepository extends JpaRepository<BadCombination, Long> {

}
