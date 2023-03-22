package com.pr_dm.eco.category.entity;

import com.pr_dm.eco.category.dto.CategoryDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
//@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Builder
    public Category(Long categoryId){
        this.categoryId = categoryId;
    }
}
