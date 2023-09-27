package com.inditex.zarachallenge.application;

import com.inditex.zarachallenge.domain.Product;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductSimilarServiceImpl implements ProductSimilarService {
private final ProductRepository productRepository;


    public ProductSimilarServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Integer> getSimilarIds(Integer productId) {
       return productRepository.getSimilarIdsByProduct(productId);
    }

    @Override
    public Product getSimilarId(Integer productId) {
       return productRepository.getSimilarIdByProduct(productId);
    }
}
