package com.test.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.admin.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

	Admin findById(String id);

	List<Admin> findBySeqGreaterThanEqual(int seq);

}
