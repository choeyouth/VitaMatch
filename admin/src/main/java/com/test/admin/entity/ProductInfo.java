package com.test.admin.entity;

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
@Table(name = "productInfo")
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	
	private String productImage;
	
	@Column(name = "CompanyName")
	private String companyName;
	private String productName;
	
	@Column(name = "ReportNo")
	private String reportNo;
	private String registrationDate;
	private String expirationDate;
	private String medicationType;
	private String ingestionMethod;
	private String packagingMaterial;
	private String packagingMethod;
	private String preservation;
	private String precautionsForIngestion;
	private String functionalContent;
	private String standardsAndSpecifications;
}
