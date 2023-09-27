package com.inditex.zarachallenge.controller;

import com.inditex.zarachallenge.application.ProductNotFoundException;
import com.inditex.zarachallenge.application.ProductSimilarService;
import com.inditex.zarachallenge.domain.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SimilarController {

    private final ProductSimilarService productSimilarService;

    public SimilarController(ProductSimilarService productSimilarService) {
        this.productSimilarService = productSimilarService;
    }

    @GetMapping("/product/{productId}/similards")
    public ResponseEntity<List<Integer>> getSimilards(@PathVariable Long productId)  {
            return ResponseEntity.ok(productSimilarService.getSimilarIds(productId));

    }
    @GetMapping("/product/{productId}/similar")
    public ResponseEntity<Product> getSimilar(@PathVariable Long productId)  {
        try {
            return ResponseEntity.ok(productSimilarService.getSimilarId(productId));
        }
        catch(ProductNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
