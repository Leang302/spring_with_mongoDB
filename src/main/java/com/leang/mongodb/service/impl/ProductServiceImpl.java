package com.leang.mongodb.service.impl;

import com.leang.mongodb.model.dto.request.ProductRequest;
import com.leang.mongodb.model.entity.Product;
import com.leang.mongodb.repository.ProductRepository;
import com.leang.mongodb.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product createProduct(ProductRequest productRequest) {
        return productRepository.save(productRequest.toEntity());
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
        Product productById = getProductById(id);
        productById.setName(productRequest.getName());
        productById.setPrice(productRequest.getPrice());
        productById.setAttributes(productRequest.getAttributes());
        productById.setReviews(productRequest.getReviews());
        return productRepository.save(productById);
    }

    @Override
    public void deleteProductById(String id) {
        productRepository.delete(getProductById(id));
    }
}
