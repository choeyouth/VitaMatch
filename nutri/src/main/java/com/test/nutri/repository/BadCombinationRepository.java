package com.test.nutri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.nutri.entity.VwBadCombination;

public interface BadCombinationRepository extends JpaRepository<VwBadCombination, Long> {

	List<VwBadCombination> findByIngredientSeq(String ingredientSeq);

	@Query("select v from VwBadCombination v")
	List<VwBadCombination> listAll();

}
