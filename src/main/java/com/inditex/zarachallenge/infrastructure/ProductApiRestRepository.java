package com.inditex.zarachallenge.infrastructure;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class ProductApiRestRepository  {

    private final RestTemplate restTemplate;

    public ProductApiRestRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Integer> getSimilarIdsByProduct(Integer productId) {

        final String uri = "http://localhost:3005/product/{productId}/similarids";
        ResponseEntity<List> list = restTemplate.getForEntity(uri, List.class, productId);
        return list.getBody();
    }
}
