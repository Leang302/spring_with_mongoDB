package com.leang.mongodb.service;

import com.leang.mongodb.model.dto.request.ProductRequest;
import com.leang.mongodb.model.entity.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductRequest productRequest);

    Product getProductById(String id);

    List<Product> getAllProduct(Integer page, Integer size);

    Product updateProductById(String id, ProductRequest productRequest);

    void deleteProductById(String id);
}
