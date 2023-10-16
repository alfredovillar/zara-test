package com.inditex.zarachallenge.application;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message) {
        log.error(message);
    }
}
