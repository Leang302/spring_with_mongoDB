package com.leang.mongodb.controller;

import com.leang.mongodb.model.dto.request.CategoryRequest;
import com.leang.mongodb.model.entity.Category;
import com.leang.mongodb.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories(@RequestParam Integer page, @RequestParam Integer size) {
        return categoryService.getAllCategories(page,size);
    }

    @GetMapping("{id}")
    public Category getCategoryById(@PathVariable String id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public Category createCategory(@RequestBody CategoryRequest productRequest) {
        return categoryService.createCategory(productRequest);
    }

    @PutMapping("{id}")
    public Category updateCategoryById(@PathVariable String id,@RequestBody CategoryRequest productRequest) {
        return categoryService.updateCategoryById(id,productRequest);
    }

    @DeleteMapping("{id}")
    public void deleteCategoryById(@PathVariable String id) {
        categoryService.deleteCategoryById(id);
    }
}
