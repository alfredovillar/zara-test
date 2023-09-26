package com.inditex.zarachallenge.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Offer {
    public Offer(Integer id) {
        this.id=id;
    }
    private Integer id;
    private LocalDateTime validFrom;
    private Double price;
}
