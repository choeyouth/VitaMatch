package com.test.nutri.entity;

import com.test.nutri.model.ProductInfoDTO;

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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="productInfo")
public class ProductInfo {

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
    
    public ProductInfoDTO toDTO() {
        return ProductInfoDTO.builder()
                .seq(this.seq)
                .productImage(this.productImage)
                .companyName(this.companyName)
                .productName(this.productName)
                .reportNo(this.reportNo)
                .registrationDate(this.registrationDate)
                .expirationDate(this.expirationDate)
                .medicationType(this.medicationType)
                .ingestionMethod(this.ingestionMethod)
                .packagingMaterial(this.packagingMaterial)
                .packagingMethod(this.packagingMethod)
                .preservation(this.preservation)
                .precautionsForIngestion(this.precautionsForIngestion)
                .functionalContent(this.functionalContent)
                .standardsAndSpecifications(this.standardsAndSpecifications)
                .build();
    }
    
}
