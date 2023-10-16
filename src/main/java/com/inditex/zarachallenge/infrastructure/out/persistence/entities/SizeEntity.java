package com.inditex.zarachallenge.infrastructure.out.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="SIZE")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
