package com.inditex.zarachallenge.application.service;

import com.inditex.zarachallenge.application.ports.out.UpdateProductAvailabilityRepository;
import com.inditex.zarachallenge.application.ports.in.UpdateStockAvailabilityPort;
import com.inditex.zarachallenge.application.ports.in.ProductAvailability;
import org.springframework.stereotype.Service;


@Service
public class UpdateStockAvailabilityService implements UpdateStockAvailabilityPort {

    private final UpdateProductAvailabilityRepository updateProductAvailabilityRepository;

    public UpdateStockAvailabilityService(UpdateProductAvailabilityRepository updateProductAvailabilityRepository) {
        this.updateProductAvailabilityRepository = updateProductAvailabilityRepository;
    }

    @Override
    public void updateAvailability(ProductAvailability productAvailability) {

            updateProductAvailabilityRepository.updateAvailability(productAvailability);


    }

}
