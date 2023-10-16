package com.inditex.zarachallenge.infrastructure.repositories.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="OFFER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferEntity {
    @Id
    private Long id;
    @Column(name="valid_from")
    private LocalDateTime validFrom;
    private Double price;
    @Column(name="product_id")
    private Long productId;

}
