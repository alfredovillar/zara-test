package com.inditex.zarachallenge.infrastructure.rest.dto;

import lombok.Data;

@Data
public class ProductResponse {
    private String id;
    private String name;
    private Double price;
    private boolean availability;
}
