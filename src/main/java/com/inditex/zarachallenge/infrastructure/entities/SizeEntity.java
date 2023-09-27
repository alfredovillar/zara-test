package com.inditex.zarachallenge.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name="SIZE")
@Data
public class SizeEntity {
    @Id
    private Long id;
    private String size;
    private Boolean availability;
    @Column(name="last_updated")
    private LocalDateTime lastUpdated;

    @Column(name="product_id")
    private Long productId;

}
