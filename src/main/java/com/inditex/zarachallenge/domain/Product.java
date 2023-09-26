package com.inditex.zarachallenge.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private List<Offer> offers;
    private List<Size> sizes;
     public Product(Integer id) {
         this.id=id;
     }
}
