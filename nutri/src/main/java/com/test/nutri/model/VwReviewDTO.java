package com.test.nutri.model;

import com.test.nutri.entity.VwReview;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VwReviewDTO {
	
	private long seq;
	private String nickname;
	private String createDate;
	private String title;
	private String category;
	private String name;
	private String content;
	private String image;
	
	public static VwReview toEntity(VwReviewDTO dto) {
		
		return VwReview.builder()
				.seq(dto.getSeq())
				.nickname(dto.getNickname())
				.createDate(dto.getCreateDate())
				.title(dto.getTitle())
				.category(dto.getCategory())
				.name(dto.getName())
				.content(dto.getContent())
				.image(dto.getImage())
				.build();
	}
}
