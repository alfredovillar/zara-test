package com.inditex.zarachallenge.application;

import com.inditex.zarachallenge.domain.Product;

import java.util.List;

public interface ProductSimilarService {
    List<Integer> getSimilarIds(Integer productId);
    Product getSimilarId(Integer productId);
}
