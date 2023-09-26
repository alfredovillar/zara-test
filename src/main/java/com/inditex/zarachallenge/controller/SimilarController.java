package com.inditex.zarachallenge.controller;

import com.inditex.zarachallenge.application.ProductSimilarService;
import org.springframework.beans.factory.annotation.Autowired;
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
            return ResponseEntity.ok(productSimilarService.getSimilarService(productId));

    }

	// TODO: Insert code in this controller
}
