package com.inditex.zarachallenge.infrastructure.repositories;

import com.inditex.zarachallenge.infrastructure.repositories.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {
    @Modifying
    @Query("update SizeEntity s set s.availability = :availability  where s.productId = :productId AND s.lastUpdated < :updated ")
    void updateProductAvailability(Boolean availability,Long  productId,LocalDateTime updated);
}
