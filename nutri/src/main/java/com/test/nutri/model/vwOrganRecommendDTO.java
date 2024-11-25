package com.test.nutri.model;

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
public class vwOrganRecommendDTO {

	private Long seq;
	private Integer organSeq;
	private Integer ingredientSeq;
	private String ingredientName;
	private String functionalContent;
	
}
