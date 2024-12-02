package com.test.admin.entity;

import java.time.LocalDateTime;

import com.test.admin.dto.NoticeDTO;

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
public class Notice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	
	private String title;
	
	private String content;
	
	private LocalDateTime regDate;
	
	private Long admin_seq;
	
	public NoticeDTO toDTO() {
		return NoticeDTO.builder()
				.seq(this.seq)
				.title(this.title)
				.content(this.content)
				.regDate(this.regDate)
				.admin_seq(this.admin_seq)
				.build();
	}
}
