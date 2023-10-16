package com.inditex.zarachallenge.application.ports.in;


import com.inditex.zarachallenge.domain.Product;

import java.util.List;

public interface SimilarProductPort {
    List<Integer> getSimilarIds(Long productId);
    Product getSimilarId(Long productId);
}
