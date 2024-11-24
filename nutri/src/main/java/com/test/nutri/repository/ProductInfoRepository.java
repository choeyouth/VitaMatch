package com.test.nutri.repository;

import com.test.nutri.entity.productInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInfoRepository extends JpaRepository<productInfoEntity, Long> {
    // seq를 기준으로 데이터를 가져오는 메서드 정의
	productInfoEntity findBySeq(Long seq);
}
