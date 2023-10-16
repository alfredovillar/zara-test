package com.inditex.zarachallenge.infrastructure.out.persistence;

import com.inditex.zarachallenge.application.ProductNotFoundException;
import com.inditex.zarachallenge.application.ports.out.ProductRepository;
import com.inditex.zarachallenge.domain.Product;
import com.inditex.zarachallenge.application.ports.in.ProductAvailability;
import com.inditex.zarachallenge.infrastructure.out.persistence.entities.ProductEntity;
import com.inditex.zarachallenge.infrastructure.out.persistence.mappers.ProductMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryAdapter implements ProductRepository {
    private final JpaProductRepository jpaProductRepository;
    private final RestApiClientProductRepository restApiClientProductRepository;
    private final ProductMapper mapper;
    public ProductRepositoryAdapter(JpaProductRepository jpaProductRepository, RestApiClientProductRepository restApiClientProductRepository, ProductMapper mapper) {
        this.jpaProductRepository = jpaProductRepository;
        this.restApiClientProductRepository = restApiClientProductRepository;
        this.mapper = mapper;
    }
    @Override
    public List<Integer> getSimilarIdsByProduct(Long productId) {
        return restApiClientProductRepository.getSimilarIdsByProduct(productId);
    }

    @Override
    public Product getSimilarIdByProduct(Long productId) {
        ProductEntity product= jpaProductRepository.findById(productId)
                .orElseThrow(()->new ProductNotFoundException("Product not found exception"));
        return mapper.toDomain(product);
    }
@Transactional
    public void updateAvailability(ProductAvailability productAvailability) {
      jpaProductRepository.updateProductAvailability(productAvailability.getAvailable(),productAvailability.getSkuId(),productAvailability.getUpdated());

    }
}
