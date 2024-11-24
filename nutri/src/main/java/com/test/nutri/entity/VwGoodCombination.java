package com.test.nutri.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="vwGoodCombination") //테이블명 동일
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VwGoodCombination {

	@Id
	private Long seq;
	
	private String good;
	private String reason;
	private String link;
	private String ingredientName;
	private String name;
	
	@Column(name = "ingredient_seq")
	private String ingredientSeq;
	
	
	
	
	
}
