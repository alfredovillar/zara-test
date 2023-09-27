package com.inditex.zarachallenge.infrastructure;

import com.inditex.zarachallenge.application.ProductNotFoundException;
import com.inditex.zarachallenge.application.port.ProductRepository;
import com.inditex.zarachallenge.domain.Product;
import com.inditex.zarachallenge.infrastructure.entities.ProductEntity;
import com.inditex.zarachallenge.infrastructure.mappers.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final JpaProductRepository  jpaProductRepository;
    private final ProductApiRestRepository productApiRestRepository;
    private final ProductMapper mapper;
    public ProductRepositoryImpl(JpaProductRepository jpaProductRepository, ProductApiRestRepository productApiRestRepository, ProductMapper mapper) {
        this.jpaProductRepository = jpaProductRepository;
        this.productApiRestRepository = productApiRestRepository;
        this.mapper = mapper;
    }
    @Override
    public List<Integer> getSimilarIdsByProduct(Integer productId) {
        return productApiRestRepository.getSimilarIdsByProduct(productId);
    }

    @Override
    public Product getSimilarIdByProduct(Integer productId) {
        ProductEntity product= jpaProductRepository.findById(productId)
                .orElseThrow(()->new ProductNotFoundException("Product not found exception"));
        return mapper.toDomain(product);
    }
    @Override
    public Product getProductAvailable(Integer productId) {
        ProductEntity product= jpaProductRepository.findById(productId)
                .orElseThrow(()->new ProductNotFoundException("Product not found exception"));
        return mapper.toDomain(product);
    }
}
