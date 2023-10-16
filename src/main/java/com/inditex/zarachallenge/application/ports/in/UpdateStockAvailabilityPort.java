package com.inditex.zarachallenge.application.ports.in;

import com.inditex.zarachallenge.domain.ProductAvailability;



public interface UpdateStockAvailabilityPort {
    void updateAvailability(ProductAvailability productAvailability);
}
