package com.pr_dm.eco.category.controller;

import com.pr_dm.eco.category.entity.Category;
import com.pr_dm.eco.category.service.CategoryService;
import com.pr_dm.eco.response.ApiResult;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/posts")
@Api(tags = "카테고리")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }


    @GetMapping("/api/v1/category/{categoryId}")
    public ApiResult<List<Category>> findByCategoryId(@PathVariable Category categoryId){
        try{
            return ApiResult.succeed(categoryService.findByCategoryId(categoryId));
        } catch (Exception e){
            log.error(e.getMessage());
            return ApiResult.failed(e.getMessage());
        }
    }

}
