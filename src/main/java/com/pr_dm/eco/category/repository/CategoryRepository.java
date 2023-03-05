package com.pr_dm.eco.category.repository;

import com.pr_dm.eco.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByCategoryId(Category categoryId);

}
