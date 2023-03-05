package com.pr_dm.eco.category.dto;

import com.pr_dm.eco.category.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long categoryId;
    //private String categoryName;


    public Category toEntity() {
        return Category.builder()
                .categoryId(categoryId)
                //.categoryName(categoryName)
                .build();
    }
}
