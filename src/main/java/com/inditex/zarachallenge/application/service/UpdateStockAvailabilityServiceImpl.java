package com.inditex.zarachallenge.application.service;

import com.inditex.zarachallenge.application.port.out.ProductRepository;
import com.inditex.zarachallenge.application.port.in.UpdateStockAvailabilityService;
import com.inditex.zarachallenge.domain.ProductAvailability;
import org.springframework.stereotype.Service;


@Service
public class UpdateStockAvailabilityServiceImpl implements UpdateStockAvailabilityService {

    private final ProductRepository productRepository;

    public UpdateStockAvailabilityServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void updateAvailability(ProductAvailability productAvailability) {

            productRepository.updateAvailability(productAvailability);


    }

}
