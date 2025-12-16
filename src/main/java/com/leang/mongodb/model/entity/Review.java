package com.leang.mongodb.model.entity;

import lombok.Data;

@Data
public class Review {
    private String user;
    private Integer rating;
    private String comment;
}
