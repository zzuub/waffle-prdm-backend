package com.pr_dm.eco.category.dto;

import com.pr_dm.eco.category.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequestDto {
    private Long categoryId;


    /*public CategoryResponse toCategoryResponse(){
        return new CategoryResponse(this.categoryId, this.categoryName);
    }*/


}
