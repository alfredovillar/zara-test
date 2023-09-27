package com.inditex.zarachallenge.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ProductAvailability {
    private Long skuId;
    private Boolean available;
    private LocalDateTime updated;

    public ProductAvailability(Long skuId) {
        this.skuId = skuId;
    }
}
