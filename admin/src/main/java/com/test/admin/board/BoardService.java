package com.test.admin.board;

import java.util.Optional;

import org.springframework.data.domain.Page;

public interface BoardService<T extends Board, D extends BoardDTO> {

	Page<D> getList(int page, int size);
	Optional<D> get(Long seq);
	D create(D dto);
	D update(D dto);
	void delete(Long seq);
}
