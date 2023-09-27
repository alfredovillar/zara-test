package com.inditex.zarachallenge.application.port;

import com.inditex.zarachallenge.domain.Product;
import com.inditex.zarachallenge.domain.ProductAvailability;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository {
    List<Integer> getSimilarIdsByProduct(Long productId);
    Product getSimilarIdByProduct(Long productId);

    void updateAvailability(ProductAvailability availability);
}
