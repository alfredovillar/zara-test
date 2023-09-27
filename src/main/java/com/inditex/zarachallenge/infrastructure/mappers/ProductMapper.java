package com.inditex.zarachallenge.infrastructure.mappers;

import com.inditex.zarachallenge.domain.Offer;
import com.inditex.zarachallenge.domain.Product;
import com.inditex.zarachallenge.domain.ProductAvailability;
import com.inditex.zarachallenge.domain.Size;
import com.inditex.zarachallenge.infrastructure.entities.OfferEntity;
import com.inditex.zarachallenge.infrastructure.entities.ProductEntity;
import com.inditex.zarachallenge.infrastructure.entities.SizeEntity;
import com.inditex.zarachallenge.infrastructure.model.ProductAvailablityEvent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    return new ProductAvailability(event.getSkuId(),event.isAvailability(),event.getUpdate().toLocalDateTime());
    }
    public ProductEntity toEntity(Product product) {
        List<OfferEntity> offers=new ArrayList<>();
        List<SizeEntity> sizes=new ArrayList<>();
        if(!product.getOffers().isEmpty()) {
            offers=product.getOffers().stream()
                    .map(offer->new OfferEntity(offer.getId(),offer.getValidFrom(),offer.getPrice(),product.getId()))
                    .toList();
        }
        if(!product.getSizes().isEmpty()) {
            sizes=product.getSizes().stream()
                    .map(size->new SizeEntity(size.getId(),size.getSize(),
                            size.isAvailability(),size.getLastUpdated(),product.getId()))
                    .toList();
        }
        ProductEntity entity=new ProductEntity();
        entity.setId(product.getId());
        entity.setName(product.getName());
        entity.setOffers(offers);
        entity.setSizes(sizes);
        return entity;
    }
}
