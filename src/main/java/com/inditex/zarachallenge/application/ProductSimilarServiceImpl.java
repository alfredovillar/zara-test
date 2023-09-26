package com.inditex.zarachallenge.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductSimilarServiceImpl implements ProductSimilarService {

    @Override
    public List<Integer> getSimilarService(String productId) {
        RestTemplate restTemplate=new RestTemplate();
        final String uri="http://localhost:3005/product/{productId}/similarids";
        ResponseEntity<List> list=restTemplate.getForEntity(uri, List.class,productId);
        return list.getBody();
    }
}
