package com.test.nutri.entity;

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
@Table(name = "shoppingCartInfo")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShoppingCartInfo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long seq;
	
	@Column(name = "productImage")
	private String productImage;
	
	@Column(name = "CompanyName")
	private String CompanyName;
	
	@Column(name = "productName")
	private String productName;
	
	@Column(name = "price")
	private String price;
}
