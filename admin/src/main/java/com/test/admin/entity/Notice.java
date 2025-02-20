package com.test.admin.entity;

import java.time.LocalDateTime;

import com.test.admin.board.Board;
import com.test.admin.dto.NoticeDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@Builder
@Table(name = "noticePost")
@AllArgsConstructor
@NoArgsConstructor
public class Notice extends Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	
	private String title;
	
	private String content;
	
	private LocalDateTime regDate;
	
	@Column(name = "admin_seq")
	private Long adminSeq;

	@Override
	public NoticeDTO toDTO() {
		return NoticeDTO.builder()
				.seq(this.seq)
				.title(this.title)
				.content(this.content)
				.regDate(this.regDate)
				.adminSeq(this.adminSeq)
				.build();
	}
}
