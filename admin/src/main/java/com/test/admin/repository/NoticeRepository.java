package com.test.admin.repository;

import org.springframework.stereotype.Repository;

import com.test.admin.board.BoardRepository;
import com.test.admin.entity.Notice;

@Repository
public interface NoticeRepository extends BoardRepository<Notice> {
	
}
