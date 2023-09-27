package com.inditex.zarachallenge.controller;

import com.inditex.zarachallenge.application.ProductNotFoundException;
import com.inditex.zarachallenge.application.port.in.ProductSimilarService;
import com.inditex.zarachallenge.controller.dto.ProductResponse;
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

    @GetMapping("/product/{productId}/similarids")
    public ResponseEntity<List<Integer>> getSimilards(@PathVariable String productId)  {
            return ResponseEntity.ok(productSimilarService.getSimilarIds(Long.valueOf(productId)));

    }
    @GetMapping("/product/{productId}/similar")
    public ResponseEntity<ProductResponse> getSimilar(@PathVariable String productId)  {
        try {
            return ResponseEntity.ok(productSimilarService.getSimilarId(Long.valueOf(productId)));
        }
        catch(ProductNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
