package com.test.nutri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.nutri.entity.vwGenderAgeRecommend;

public interface GenderAgeRecommendRepository extends JpaRepository<vwGenderAgeRecommend, Long>{

	@Query("select ga from vwGenderAgeRecommend ga where ga.genderAgeSeq = ?1	")
	List<vwGenderAgeRecommend> listAll(int genderAgeSeq);

	@Query("select ga from vwGenderAgeRecommend ga where ga.gender = ?1 and ga.age = ?2	")
	List<vwGenderAgeRecommend> findAll(String gender, String age);

}
