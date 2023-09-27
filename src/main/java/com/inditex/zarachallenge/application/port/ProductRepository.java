package com.inditex.zarachallenge.application.port;

import com.inditex.zarachallenge.domain.Product;
import com.inditex.zarachallenge.domain.ProductAvailability;

import java.util.List;

public interface ProductRepository {
    List<Integer> getSimilarIdsByProduct(Long productId);
    Product getSimilarIdByProduct(Long productId);
    Product getProduct(Long productId);
    void updateAvailability(Product product);
}
