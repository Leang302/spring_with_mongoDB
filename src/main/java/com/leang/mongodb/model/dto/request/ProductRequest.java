package com.leang.mongodb.model.dto.request;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.leang.mongodb.model.entity.Category;
import com.leang.mongodb.model.entity.Product;
import com.leang.mongodb.model.entity.Review;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ProductRequest {
    private String name;
    private Double price;
    private String categoryId;
    private Map<String, Object> attributes = new HashMap<>();
    private List<Review> reviews;


    @JsonAnySetter
    public void setAttributes(String key, Object value) {
        attributes.put(key, value);
    }

    public Product toEntity(Category categoryById) {
        return Product.builder()
                .name(name)
                .price(price)
                .categoryId(categoryId)
                .categoryName(categoryById.getName())
                .attributes(attributes)
                .reviews(reviews)
                .build();
    }
}
