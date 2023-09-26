package com.inditex.zarachallenge.controller;

import com.inditex.zarachallenge.application.ProductNotFoundException;
import com.inditex.zarachallenge.application.ProductSimilarService;
import com.inditex.zarachallenge.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SimilarController {
    @Autowired
    ProductSimilarService productSimilarService;
    @GetMapping("/product/{productId}/similarids")
    public ResponseEntity<List<Integer>> getSimilards(@PathVariable String productId)  {
            return ResponseEntity.ok(productSimilarService.getSimilarIds(productId));

    }
    @GetMapping("/product/{productId}/similarid")
    public ResponseEntity<Product> getSimilarId(@PathVariable Integer productId)  {
        try {
            return ResponseEntity.ok(productSimilarService.getSimilarId(productId));
        }
        catch(ProductNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
