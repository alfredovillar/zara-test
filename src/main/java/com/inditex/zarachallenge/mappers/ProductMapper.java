package com.inditex.zarachallenge.mappers;

import com.inditex.zarachallenge.infrastructure.rest.dto.ProductResponse;
import com.inditex.zarachallenge.domain.Offer;
import com.inditex.zarachallenge.domain.Product;
import com.inditex.zarachallenge.domain.ProductAvailability;
import com.inditex.zarachallenge.domain.Size;
import com.inditex.zarachallenge.infrastructure.repositories.entities.ProductEntity;
import com.inditex.zarachallenge.infrastructure.model.ProductAvailablityEvent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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

    public ProductAvailability toDomain(ProductAvailablityEvent event) {
        return new ProductAvailability(event.getSkuId(), event.isAvailability(), event.getUpdate().toLocalDateTime());
    }

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
