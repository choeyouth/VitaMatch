package com.test.nutri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.nutri.entity.VwGenderAgeRecommend;

public interface GenderAgeRecommendRepository extends JpaRepository<VwGenderAgeRecommend, Long> {

	@Query("select ga from VwGenderAgeRecommend ga where ga.genderAgeSeq = ?1	")
	List<VwGenderAgeRecommend> listAll(int genderAgeSeq);

	@Query("select ga from VwGenderAgeRecommend ga where ga.gender = ?1 and ga.age = ?2	")
	List<VwGenderAgeRecommend> findAll(String gender, String age);
	
}
