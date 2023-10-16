package com.inditex.zarachallenge.application.service;

import com.inditex.zarachallenge.application.ports.out.ProductRepository;
import com.inditex.zarachallenge.application.ports.in.UpdateStockAvailabilityPort;
import com.inditex.zarachallenge.application.ports.in.ProductAvailability;
import org.springframework.stereotype.Service;


@Service
public class UpdateStockAvailabilityService implements UpdateStockAvailabilityPort {

    private final ProductRepository productRepository;

    public UpdateStockAvailabilityService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void updateAvailability(ProductAvailability productAvailability) {

            productRepository.updateAvailability(productAvailability);


    }

}
