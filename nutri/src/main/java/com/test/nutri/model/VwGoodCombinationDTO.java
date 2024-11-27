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
public class VwGoodCombinationDTO {

	private Long seq;
    private String ingredient_seq;
    private String good;
    private String reason;
    private String link;
    private String ingredientName;
	private String name;
	

	
}
