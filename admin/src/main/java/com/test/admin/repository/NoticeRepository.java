package com.test.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.admin.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long>{
	
}
