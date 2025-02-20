package com.test.admin.board;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository<T extends Board> extends JpaRepository<T, Long>{
	
}
