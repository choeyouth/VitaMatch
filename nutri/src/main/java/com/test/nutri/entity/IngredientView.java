package com.test.nutri.entity;

import com.test.nutri.model.IngredientViewDTO;

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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "ingredient_view") 
public class IngredientView {

    @Id
    @Column(name = "content_seq") // View에서 Primary Key 역할을 하는 컬럼
    private int contentSeq;

    @Column(name = "ingredient_seq")
    private int ingredientSeq;

    @Column(name = "ingredient_name")
    private String ingredientName;

    @Column(name = "ingredient_category")
    private int ingredientCategory;

    @Column(name = "functionalContent")
    private String functionalContent;

    @Column(name = "dailyIntake")
    private String dailyIntake;

    @Column(name = "precautionsForIngestion")
    private String precautionsForIngestion;

  
    public IngredientViewDTO toDTO() {
        return new IngredientViewDTO(
            ingredientSeq,
            ingredientName,
            ingredientCategory,
            contentSeq,
            functionalContent,
            dailyIntake,
            precautionsForIngestion
        );
    }
}
