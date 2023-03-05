package com.pr_dm.eco.category.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    /*private String categoryName;


    @Builder
    public Category(String categoryName){
        this.categoryName = categoryName;
    }*/

}
