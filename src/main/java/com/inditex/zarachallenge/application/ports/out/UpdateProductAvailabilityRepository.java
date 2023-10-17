package com.inditex.zarachallenge.application.ports.out;

import com.inditex.zarachallenge.application.ports.in.ProductAvailability;

public interface UpdateProductAvailabilityRepository {
    void updateAvailability(ProductAvailability availability);
}
