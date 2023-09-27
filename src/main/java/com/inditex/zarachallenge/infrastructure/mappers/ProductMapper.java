package com.inditex.zarachallenge.infrastructure.mappers;

import com.inditex.zarachallenge.domain.Offer;
import com.inditex.zarachallenge.domain.Product;
import com.inditex.zarachallenge.domain.ProductAvailability;
import com.inditex.zarachallenge.domain.Size;
import com.inditex.zarachallenge.infrastructure.entities.ProductEntity;
import com.inditex.zarachallenge.infrastructure.model.ProductAvailablityEvent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ProductMapper {
    public Product toDomain(ProductEntity entity) {
        List<Offer> offers=new ArrayList<>();
        List<Size> sizes=new ArrayList<>();
        if(!entity.getOffers().isEmpty()) {
            offers=entity.getOffers().stream()
                    .map(offer->new Offer(offer.getId(),offer.getValidFrom(),offer.getPrice()))
                    .toList();
        }
        if(!entity.getSizes().isEmpty()) {
            sizes=entity.getSizes().stream()
                    .map(size->new Size(size.getId(),size.getSize(),
                            size.getAvailability(),size.getLastUpdated()))
                    .toList();
        }
        Product product=new Product(entity.getId());
        product.setName(entity.getName());
        product.setOffers(offers);
        product.setSizes(sizes);
        return product;
    }
    public ProductAvailability toDomain(ProductAvailablityEvent event) {
    return new ProductAvailability(event.getSkuId(),event.isAvailability(),event.getUpdate());
    }
}
