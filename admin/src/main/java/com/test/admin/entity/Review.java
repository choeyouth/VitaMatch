package com.test.admin.entity;

import java.time.LocalDateTime;

import com.test.admin.dto.NoticeDTO;
import com.test.admin.dto.ReviewDTO;

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
@Table(name = "review")
@AllArgsConstructor
@NoArgsConstructor
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	
	private String title;
	
	private String category;
	
	private String content;
	
	private LocalDateTime regDate;

	@Column(name = "admin_seq")
	private Long memberSeq;
	
	public ReviewDTO toDTO() {
//		return ReviewDTO.builder()
//				.seq(this.seq)
//				.title(this.title)
//				.content(this.content)
//				.regDate(this.regDate)
//				.admin_seq(this.admin_seq)
//				.build();
		return null;
	}
}
