package com.test.nutri.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.nutri.entity.Category;
import com.test.nutri.entity.HealthCategory;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	 @Query("SELECT c FROM Category c WHERE c.categoryName = :categoryName")
	 Page<Category> findByCategory(@Param("categoryName") String categoryName, Pageable pageable);

	 @Query("SELECT a From HealthCategory a WHERE a.health = :health")
	 Page<HealthCategory> findByHealth(@Param("health") String category, Pageable pageable);
	
}
