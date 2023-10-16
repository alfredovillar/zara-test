package com.inditex.zarachallenge.infrastructure.out.persistence;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class RestApiClientProductRepository {

    private final RestTemplate restTemplate;

    public RestApiClientProductRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Integer> getSimilarIdsByProduct(Long productId) {
        ParameterizedTypeReference<List<Integer>> parameterizedTypeReference =
                new ParameterizedTypeReference<>(){};

        final String uri = "http://localhost:3005/product/{productId}/similarids";
        String finalUri=uri.replace("{productId}",productId+"");
        ResponseEntity<List<Integer>> response = restTemplate.exchange(finalUri, HttpMethod.GET,null ,parameterizedTypeReference);;
        return response.getBody();
    }
}
