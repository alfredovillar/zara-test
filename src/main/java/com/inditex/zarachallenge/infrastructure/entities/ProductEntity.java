package com.inditex.zarachallenge.infrastructure.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="PRODUCT")
@Data
public class ProductEntity {
    @Id
    private Long id;
    private String name;
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="product_id")
    private List<OfferEntity> offers=new ArrayList<>();
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="product_id")
    private List<SizeEntity> sizes=new ArrayList<>();
}
