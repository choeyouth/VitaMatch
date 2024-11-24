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
public class GoodCombinationDTO {

	private Long seq;
	private String good;
	private String reason;
	private String link;
	private String ingredient_seq;
	
	
}
