package com.leang.mongodb.controller;

import com.leang.mongodb.model.dto.request.ProductRequest;
import com.leang.mongodb.model.entity.Product;
import com.leang.mongodb.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(@RequestParam Integer page, @RequestParam Integer size) {
        return productService.getAllProduct(page,size);
    }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @PutMapping("{id}")
    public Product updateProductById(@PathVariable String id,@RequestBody ProductRequest productRequest) {
        return productService.updateProductById(id,productRequest);
    }

    @DeleteMapping("{id}")
    public void deleteProductById(@PathVariable String id) {
        productService.deleteProductById(id);
    }
}
