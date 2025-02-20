package com.test.admin.board;

import lombok.Data;

@Data
public abstract class BoardDTO<T extends Board> {

	private Long seq;

    public abstract T toEntity();
}
