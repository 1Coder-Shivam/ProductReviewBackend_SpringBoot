package com.nagarro.service;

import java.util.List;

import com.nagarro.dto.ReviewDto;
import com.nagarro.entity.Product;
import com.nagarro.entity.Review;

public interface ReviewService {


    Long countAllReview();

    ReviewDto saveOrUpdateReviews(Review review);
    List<ReviewDto> getAllReviews();

    List<ReviewDto> findReviewByProductId(String productCode);
    void reviewAction(Integer id, String status);


}
