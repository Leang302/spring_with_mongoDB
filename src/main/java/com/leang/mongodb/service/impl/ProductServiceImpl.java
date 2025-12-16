package com.leang.mongodb.service.impl;

import com.leang.mongodb.model.dto.request.ProductRequest;
import com.leang.mongodb.model.entity.Category;
import com.leang.mongodb.model.entity.Product;
import com.leang.mongodb.repository.ProductRepository;
import com.leang.mongodb.service.CategoryService;
import com.leang.mongodb.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Override
    public Product createProduct(ProductRequest productRequest) {
        Category categoryById = categoryService.getCategoryById(productRequest.getCategoryId());
        return productRepository.save(productRequest.toEntity(categoryById));
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Product> getAllProduct(Integer page, Integer size) {
        return productRepository.findAll(PageRequest.of(page - 1, size)).getContent();
    }

    @Override
    public Product updateProductById(String id, ProductRequest productRequest) {
        Category categoryById = categoryService.getCategoryById(productRequest.getCategoryId());
        Product productById = getProductById(id);
        productById.setName(productRequest.getName());
        productById.setPrice(productRequest.getPrice());
        productById.setAttributes(productRequest.getAttributes());
        productById.setReviews(productRequest.getReviews());
        productById.setCategoryId(productRequest.getCategoryId());
        productById.setCategoryName(categoryById.getName());
        return productRepository.save(productById);
    }

    @Override
    public void deleteProductById(String id) {
        productRepository.delete(getProductById(id));
    }
}
