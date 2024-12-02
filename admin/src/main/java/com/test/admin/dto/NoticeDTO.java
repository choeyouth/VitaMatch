package com.test.admin.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDTO {

	private Long seq;
	
	private String title;
	
	private String content;
	
	private LocalDateTime regDate;
	
	private Long admin_seq;
	
}
