package com.test.nutri.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.nutri.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	 @Query("SELECT c FROM Category c WHERE c.categoryName = :categoryName")
	 Page<Category> findByCategory(@Param("categoryName") String categoryName, Pageable pageable);
	
}
