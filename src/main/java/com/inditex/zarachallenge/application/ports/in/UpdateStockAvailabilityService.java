package com.inditex.zarachallenge.application.ports.in;

import com.inditex.zarachallenge.domain.ProductAvailability;



public interface UpdateStockAvailabilityService {
    void updateAvailability(ProductAvailability productAvailability);
}
