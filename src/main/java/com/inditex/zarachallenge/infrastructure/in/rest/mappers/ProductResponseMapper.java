package com.inditex.zarachallenge.infrastructure.in.rest.mappers;

import com.inditex.zarachallenge.domain.Product;
import com.inditex.zarachallenge.infrastructure.in.rest.dto.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductResponseMapper {
    public ProductResponse toDto(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId() + "");
        response.setName(product.getName());
        if (!product.getOffers().isEmpty())
            response.setPrice(product.getOffers().get(0).getPrice());
        if (!product.getSizes().isEmpty())
            response.setAvailability(product.getSizes().get(0).isAvailability());
        return response;
    }
}
