package com.inditex.zarachallenge.application.service;

import com.inditex.zarachallenge.application.ports.out.ProductAvailabilityRepository;
import com.inditex.zarachallenge.application.ports.out.ProductRepository;
import com.inditex.zarachallenge.application.ports.in.UpdateStockAvailabilityPort;
import com.inditex.zarachallenge.application.ports.in.ProductAvailability;
import org.springframework.stereotype.Service;


@Service
public class UpdateStockAvailabilityService implements UpdateStockAvailabilityPort {

    private final ProductAvailabilityRepository productAvailabilityRepository;

    public UpdateStockAvailabilityService(ProductAvailabilityRepository productAvailabilityRepository) {
        this.productAvailabilityRepository = productAvailabilityRepository;
    }

    @Override
    public void updateAvailability(ProductAvailability productAvailability) {

            productAvailabilityRepository.updateAvailability(productAvailability);


    }

}
