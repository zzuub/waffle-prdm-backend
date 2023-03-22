package com.pr_dm.eco.category.dto;

import com.pr_dm.eco.category.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {
    private Long categoryId;
    //private String categoryName;


    public CategoryDto(Category category){
        this.categoryId = category.getCategoryId();
    }


}
