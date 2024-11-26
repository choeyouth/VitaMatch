package com.test.nutri.repository;

import com.test.nutri.entity.productInfo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInfoRepository extends JpaRepository<productInfo, Long> {

	//Optional<productInfo> findByproductName(String productName);
	
	Optional<productInfo> findByseq(Long seq);
	
}
