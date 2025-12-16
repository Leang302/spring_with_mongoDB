package com.leang.mongodb.model.dto.request;

import com.leang.mongodb.model.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {
    private String name;

    public Category toEntity() {
        return Category.builder()
                .name(name)
                .build();
    }
}
