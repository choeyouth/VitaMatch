package com.test.nutri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.nutri.entity.VwGoodCombination;

public interface GoodCombinationRepository extends JpaRepository<VwGoodCombination, Long>{

	List<VwGoodCombination> findByIngredientSeq(String ingredientSeq);

	@Query("select v from VwGoodCombination v")
	List<VwGoodCombination> listAll();

}
