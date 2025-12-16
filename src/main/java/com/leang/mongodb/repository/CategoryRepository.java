package com.leang.mongodb.repository;

import com.leang.mongodb.model.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category,String> {
}
