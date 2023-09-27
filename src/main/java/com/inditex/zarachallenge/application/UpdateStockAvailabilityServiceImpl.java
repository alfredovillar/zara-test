package com.inditex.zarachallenge.application;

import com.inditex.zarachallenge.application.port.ProductRepository;
import com.inditex.zarachallenge.domain.Product;
import com.inditex.zarachallenge.domain.ProductAvailability;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class UpdateStockAvailabilityServiceImpl implements UpdateStockAvailabilityService {
    @Value("{date}")
    String today;
    private final ProductRepository productRepository;

    public UpdateStockAvailabilityServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void updateAvailability(ProductAvailability productAvailability) {
        Product product=productRepository.getProduct(productAvailability.getSkuId());
        product.getSizes().stream().forEach(
                size-> {
                    if (size.getLastUpdated().isBefore(productAvailability.getUpdated())) {
                        size.setAvailability(productAvailability.getAvailable());
                        size.setLastUpdated(productAvailability.getUpdated());
                    }
                });

        productRepository.updateAvailability(product);
    }

}
