package com.inditex.zarachallenge.application.ports.out;

import com.inditex.zarachallenge.application.ports.in.ProductAvailability;

public interface ProductAvailabilityRepository {
    void updateAvailability(ProductAvailability availability);
}
