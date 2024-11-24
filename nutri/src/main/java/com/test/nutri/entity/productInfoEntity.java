package com.test.nutri.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class productInfoEntity {

    @Id
    private Long seq;
    
    private String productImage;
    private String companyName;
    private String productName;
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
