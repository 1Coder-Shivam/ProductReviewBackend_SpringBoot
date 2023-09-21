package com.nagarro.controller;

import com.nagarro.dto.ReviewDto;
import com.nagarro.entity.Review;
import com.nagarro.mapper.ProductMapper;
import com.nagarro.service.ProductService;
import com.nagarro.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ProductService productService;

    @Autowired
    ProductMapper productMapper;

    @GetMapping("/reviews")
    public ResponseEntity<List<ReviewDto>> getAllReviews() {
        List<ReviewDto> results = reviewService.getAllReviews();
        return ResponseEntity.ok(results);
    }

    @PostMapping("/reviews")
    public ResponseEntity<Void> addReviews(@RequestBody Review review) {
        reviewService.saveOrUpdateReviews(review);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/reviews")
    public ResponseEntity<Void> updateReview(@RequestBody Review review) {
        reviewService.saveOrUpdateReviews(review);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/reviews/product/{id}")
    public ResponseEntity<List<ReviewDto>> findReviewByProductId(@PathVariable(value = "id") String code) {
        List<ReviewDto> reviews = reviewService.findReviewByProductId(code);
        return ResponseEntity.ok(reviews);
    }

    @PostMapping("/reviews/{id}/{status}")
    public ResponseEntity<String> reviewAction(
            @PathVariable(value = "id") Integer id,
            @PathVariable(value = "status") String status
    ) {
        reviewService.reviewAction(id, status);
        return ResponseEntity.ok("Successfully Updated");
    }
}
