package com.inditex.zarachallenge.application.ports.out;

import com.inditex.zarachallenge.domain.Product;
import com.inditex.zarachallenge.application.ports.in.ProductAvailability;

import java.util.List;

public interface ProductRepository {
    List<Integer> getSimilarIdsByProduct(Long productId);
    Product getSimilarIdByProduct(Long productId);

    void updateAvailability(ProductAvailability availability);
}
