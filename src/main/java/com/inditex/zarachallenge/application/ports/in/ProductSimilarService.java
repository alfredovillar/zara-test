package com.inditex.zarachallenge.application.ports.in;

import com.inditex.zarachallenge.infrastructure.rest.dto.ProductResponse;

import java.util.List;

public interface ProductSimilarService {
    List<Integer> getSimilarIds(Long productId);
    ProductResponse getSimilarId(Long productId);
}
