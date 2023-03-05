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


    @Transactional(readOnly = true)
    public List<Category> findByCategoryId(Category categoryId){
        return categoryRepository.findByCategoryId(categoryId);
    }


}
