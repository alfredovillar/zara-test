package com.inditex.zarachallenge.infrastructure.in.rest;

import com.inditex.zarachallenge.application.ProductNotFoundException;
import com.inditex.zarachallenge.application.ports.in.ProductSimilarPort;
import com.inditex.zarachallenge.infrastructure.in.rest.dto.ProductResponse;
import com.inditex.zarachallenge.mappers.ProductMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SimilarController {

    private final ProductSimilarPort productSimilarPort;
    private final ProductMapper mapper;

    public SimilarController(ProductSimilarPort productSimilarPort, ProductMapper mapper) {
        this.productSimilarPort = productSimilarPort;
        this.mapper=mapper;
    }

    @GetMapping("/product/{productId}/similarids")
    public ResponseEntity<List<Integer>> getSimilards(@PathVariable String productId)  {
            return ResponseEntity.ok(productSimilarPort.getSimilarIds(Long.valueOf(productId)));

    }
    @GetMapping("/product/{productId}/similar")
    public ResponseEntity<ProductResponse> getSimilar(@PathVariable String productId)  {
        try {
            return ResponseEntity.ok(mapper.toDto(productSimilarPort.getSimilarId(Long.valueOf(productId))));
        }
        catch(ProductNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
