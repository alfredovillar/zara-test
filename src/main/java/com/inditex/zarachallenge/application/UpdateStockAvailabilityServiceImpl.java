package com.inditex.zarachallenge.application;

import com.inditex.zarachallenge.application.port.ProductRepository;
import com.inditex.zarachallenge.domain.ProductAvailability;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        LocalDateTime now=LocalDateTime.parse(today,
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX"));
        Timestamp todayTime=Timestamp
                .valueOf(now);
        productRepository.getProductAvailable(productAvailability.getSkuId());
        if()

    }
}
