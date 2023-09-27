package com.inditex.zarachallenge.infrastructure;

import com.inditex.zarachallenge.domain.Product;

import java.util.List;

public interface ProductRepository {
    List<Integer> getSimilarIdsByProduct(Integer productId);
    Product getSimilarIdByProduct(Integer productId);
}
