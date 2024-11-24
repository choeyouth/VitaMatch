package com.test.nutri.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.nutri.entity.GoodCombination;

public interface GoodCombinationRepository extends JpaRepository<GoodCombination, Long>{

	

}
