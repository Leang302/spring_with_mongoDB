package com.leang.mongodb.service.impl;

import com.leang.mongodb.model.dto.request.CategoryRequest;
import com.leang.mongodb.model.entity.Category;
import com.leang.mongodb.model.entity.Product;
import com.leang.mongodb.repository.CategoryRepository;
import com.leang.mongodb.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    public List<Category> getAllCategories(Integer page, Integer size) {
        return categoryRepository.findAll(PageRequest.of(page - 1, size)).getContent();
    }

    @Override
    public Category getCategoryById(String id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    @Override
    public Category createCategory(CategoryRequest categoryRequest) {
        return categoryRepository.save(categoryRequest.toEntity());
    }

    @Override
    public Category updateCategoryById(String id, CategoryRequest categoryRequest) {
        Category categoryById = getCategoryById(id);
        categoryById.setName(categoryRequest.getName());
        Category save = categoryRepository.save(categoryById);
        Query query = new Query(Criteria.where("category_id").is(id));
        Update update = new Update().set("categoryName", categoryRequest.getName());
        mongoTemplate.updateMulti(query, update, Product.class);
        return save;
    }

    @Override
    public void deleteCategoryById(String id) {
        categoryRepository.delete(getCategoryById(id));
        Query query = new Query(Criteria.where("category_id").is(id));
        Update update = new Update().set("categoryName", "Uncategorized");
        mongoTemplate.updateMulti(query, update, Product.class);

    }


}
