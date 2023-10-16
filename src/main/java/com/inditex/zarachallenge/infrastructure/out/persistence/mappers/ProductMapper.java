package com.inditex.zarachallenge.infrastructure.out.persistence.mappers;

import com.inditex.zarachallenge.infrastructure.in.rest.dto.ProductResponse;
import com.inditex.zarachallenge.domain.Offer;
import com.inditex.zarachallenge.domain.Product;
import com.inditex.zarachallenge.domain.Size;
import com.inditex.zarachallenge.infrastructure.out.persistence.entities.ProductEntity;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {
    public Product toDomain(ProductEntity entity) {
        List<Offer> offers = new ArrayList<>();
        List<Size> sizes = new ArrayList<>();
        if (!entity.getOffers().isEmpty()) {
            offers = entity.getOffers().stream()
                    .map(offer -> new Offer(offer.getId(), offer.getValidFrom(), offer.getPrice()))
                    .toList();
        }
        if (!entity.getSizes().isEmpty()) {
            sizes = entity.getSizes().stream()
                    .map(size -> new Size(size.getId(), size.getSize(),
                            size.getAvailability(), size.getLastUpdated()))
                    .toList();
        }
        Product product = new Product(entity.getId());
        product.setName(entity.getName());
        product.setOffers(offers);
        product.setSizes(sizes);
        return product;
    }
}
