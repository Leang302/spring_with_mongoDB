package com.leang.mongodb.model.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Map;

@Data
@Document(collection = "products")
@Builder
public class Product {
    @Id
    private String id;
    private String name;
    private Double price;
    private Map<String, Object> attributes;
    private List<Review> reviews;
    @Field("category_id")  // Custom field name
    private String categoryId;
}
