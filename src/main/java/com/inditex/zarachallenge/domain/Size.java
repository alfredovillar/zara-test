package com.inditex.zarachallenge.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
public class Size {
    private Long id;
    private String size;
    private boolean availability;
    private LocalDateTime lastUpdated;
}
