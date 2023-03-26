package com.pr_dm.eco.category.controller;


import com.pr_dm.eco.category.dto.CategoryDto;
import com.pr_dm.eco.category.service.CategoryService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
@Api(tags = "카테고리")
public class CategoryController {
    private final CategoryService categoryService;


    @GetMapping("/api/v1/category")
    public CategoryDto findCategory(@PathVariable Long categoryId){
        return categoryService.findByCategory(categoryId);
    }


   /* @GetMapping("/api/v1/category/{categoryId}")
    public ApiResult<List<Category>> findByCategoryId(@PathVariable Category categoryId){
        try{
            return ApiResult.succeed(categoryService.findById(categoryId));
        } catch (Exception e){
            log.error(e.getMessage());
            return ApiResult.failed(e.getMessage());
        }
    }*/
}
