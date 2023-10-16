package com.inditex.zarachallenge.infrastructure.in.kafka.mappers;

import com.inditex.zarachallenge.domain.ProductAvailability;
import com.inditex.zarachallenge.infrastructure.in.kafka.events.ProductAvailablityEvent;

public class ProductAvailabilityMapper {
    public ProductAvailability toDomain(ProductAvailablityEvent event) {
        return new ProductAvailability(event.getSkuId(), event.isAvailability(), event.getUpdate().toLocalDateTime());
    }
}
