package com.pr_dm.eco.category.service;

import com.pr_dm.eco.category.dto.CategoryRequestDto;
import com.pr_dm.eco.category.entity.Category;
import com.pr_dm.eco.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {
    private final CategoryRepository categoryRepository;

    //카테고리 목록
    @Transactional(readOnly = true)
    public List<Category> findByCategoryId(Category categoryId){
        return categoryRepository.findByCategoryId(categoryId);
    }


    /*//카테고리 추가
    @Transactional
    public void addCategory(CategoryRequestDto categoryRequestDto){
        validateDuplicateCategoryName(CategoryRequestDto.getCategoryName());
        Category category = new Category();
        category.setCategoryName(CategoryRequestDto.getCategoryName());
        categoryRepository.save(category);
    }

    private void validateDuplicateCategoryName(String categoryName) {
        categoryRepository.findByCategoryName(categoryName)
                .ifPresent(m-> {
                    throw new IllegalStateException("이미 존재하는 카테고리 입니다.");
                });
    }*/

}
