package com.pr_dm.eco.category.service;

import com.pr_dm.eco.category.dto.CategoryDto;
import com.pr_dm.eco.category.dto.CategoryRequestDto;
import com.pr_dm.eco.category.entity.Category;
import com.pr_dm.eco.category.mapper.CategoryMapper;
import com.pr_dm.eco.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public CategoryDto findByCategory(Long categoryId){
        Category category = this.categoryRepository.findById(categoryId).orElseThrow();
        return CategoryMapper.toCategoryDto(category);
    }


/*    @Transactional
    public List<Category> findAllCategory(){
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Category findById(Long categoryId){
        return categoryRepository.findById(categoryId).orElse(new Category());
    }*/
/*

    @Transactional(readOnly = true)
    public List<CategoryDto> findAllCategory(){
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList.stream().map(Category::toDto).collect(Collectors.toList());
    }
*/




}
