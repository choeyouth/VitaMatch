package com.test.admin.dto;

import java.time.LocalDateTime;

import com.test.admin.board.BoardDTO;
import com.test.admin.entity.Notice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDTO extends BoardDTO {

	private Long seq;
	
	private String title;
	
	private String content;
	
	private LocalDateTime regDate;
	
	private Long adminSeq;

	@Override
	public Notice toEntity() {
		return Notice.builder()
				.seq(this.seq)
				.title(this.title)
				.content(this.content)
				.regDate(this.regDate)
				.adminSeq(adminSeq)
				.build();
	}
	
}
