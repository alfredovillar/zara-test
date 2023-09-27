package com.inditex.zarachallenge.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import shaded_package.org.joda.time.DateTime;

import java.time.LocalDateTime;

@Entity
@Table(name="OFFER")
@Data
public class OfferEntity {
    @Id
    private Long id;
    @Column(name="valid_from")
    private LocalDateTime validFrom;
    private Double price;
    @Column(name="product_id")
    private Long productId;

}
