package com.inditex.zarachallenge.application;

import com.inditex.zarachallenge.domain.Product;

import java.util.List;

public interface ProductSimilarService {
    List<Integer> getSimilarIds(Long productId);
    Product getSimilarId(Long productId);
}
