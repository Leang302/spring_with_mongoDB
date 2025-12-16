package com.leang.mongodb.service;

import com.leang.mongodb.model.dto.request.CategoryRequest;
import com.leang.mongodb.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories(Integer page, Integer size);

    Category getCategoryById(String id);

    Category createCategory(CategoryRequest productRequest);

    Category updateCategoryById(String id, CategoryRequest productRequest);

    void deleteCategoryById(String id);
}
