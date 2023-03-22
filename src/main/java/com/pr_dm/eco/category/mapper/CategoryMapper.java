package com.pr_dm.eco.category.mapper;

import com.pr_dm.eco.category.dto.CategoryDto;
import com.pr_dm.eco.category.dto.CategoryRequestDto;
import com.pr_dm.eco.category.entity.Category;

public class CategoryMapper {
    public static Category toCategoryDto(CategoryRequestDto categoryRequestDto) {
        return Category.builder()
                .categoryId(categoryRequestDto.getCategoryId())
                .build();
    }

    public static CategoryDto toCategoryDto(Category categoryRequestDto){
        return CategoryDto.builder()
                .categoryId(categoryRequestDto.getCategoryId())
                .build();
    }
}
