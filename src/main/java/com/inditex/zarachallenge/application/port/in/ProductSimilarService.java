package com.inditex.zarachallenge.application.port.in;

import com.inditex.zarachallenge.controller.dto.ProductResponse;
import com.inditex.zarachallenge.domain.Product;

import java.util.List;

public interface ProductSimilarService {
    List<Integer> getSimilarIds(Long productId);
    ProductResponse getSimilarId(Long productId);
}
