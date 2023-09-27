package com.inditex.zarachallenge.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Offer {

    private Long id;
    private LocalDateTime validFrom;
    private Double price;
    public Offer(Long id) {
        this.id=id;
    }

}
