package com.inditex.zarachallenge.application;

import com.inditex.zarachallenge.domain.Product;
import com.inditex.zarachallenge.infrastructure.ProductRepository;
import com.inditex.zarachallenge.infrastructure.entities.ProductEntity;
import com.inditex.zarachallenge.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ProductSimilarServiceImpl implements ProductSimilarService {
@Autowired
    ProductRepository productRepository;
@Autowired
ProductMapper mapper;
    @Override
    public List<Integer> getSimilarIds(String productId) {
        RestTemplate restTemplate=new RestTemplate();
        final String uri="http://localhost:3005/product/{productId}/similarids";
        ResponseEntity<List> list=restTemplate.getForEntity(uri, List.class,productId);
        return list.getBody();
    }

    @Override
    public Product getSimilarId(Integer productId) {
        ProductEntity product=productRepository.findById(productId)
                .orElseThrow(()->new ProductNotFoundException("Product not found exception"));

        return mapper.toDomain(product);
    }
}
