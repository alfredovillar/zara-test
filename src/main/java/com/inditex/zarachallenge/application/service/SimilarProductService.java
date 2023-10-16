package com.inditex.zarachallenge.application.service;

import com.inditex.zarachallenge.application.ports.out.ProductRepository;
import com.inditex.zarachallenge.application.ports.in.SimilarProductPort;
import com.inditex.zarachallenge.domain.Offer;
import com.inditex.zarachallenge.domain.Product;
import com.inditex.zarachallenge.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class SimilarProductService implements SimilarProductPort {
    private final ProductRepository productRepository;
    @Value("${date}")
    String today;



    public SimilarProductService(ProductRepository productRepository, ProductMapper mapper) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Integer> getSimilarIds(Long productId) {
        return productRepository.getSimilarIdsByProduct(productId);
    }

    @Override
    public Product getSimilarId(Long productId) {
        LocalDateTime now = LocalDateTime.parse(today, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX"));
        Product product = productRepository.getSimilarIdByProduct(productId);
        List<Offer> offers = product.getOffers().stream().filter(offer -> offer.getValidFrom().isAfter(now)).toList();
        product.setOffers(offers);
        return product;
    }
}
