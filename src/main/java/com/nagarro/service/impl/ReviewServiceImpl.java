package com.nagarro.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nagarro.custom.exception.ReviewNotFoundException;
import com.nagarro.dto.ProductDto;
import com.nagarro.dto.ReviewDto;
import com.nagarro.mapper.ReviewMapper;
import com.nagarro.service.ProductService;
import com.nagarro.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nagarro.entity.Product;
import com.nagarro.entity.Review;
import com.nagarro.repository.ReviewRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * class implement services of review
 *
 * @author shivammaurya01
 */

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository repo;
    @Autowired
    ProductService productService;
    @Autowired
    ReviewMapper reviewMapper;

    @Override
    public Long countAllReview() {
        return repo.countAcceptedReviews();
    }


    @Override
    public ReviewDto saveOrUpdateReviews(Review review) {
        DateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dateTime = new Date();
        String formattedDateTime = dateTimeFormat.format(dateTime);
        review.setDate(formattedDateTime);
        return reviewMapper.reviewToDto(repo.save(review));
    }

    @Override
    public List<ReviewDto> getAllReviews() {
        List<Review> reviews = repo.findAll();
        if (reviews.isEmpty()) {
            throw new ReviewNotFoundException("No reviews found");
        }

        List<ReviewDto> reviewDtoList = new ArrayList<>();
        for (Review review : reviews) {
            reviewDtoList.add(reviewMapper.reviewToDto(review));
        }
        return reviewDtoList;
    }


    @Override
    public List<ReviewDto> findReviewByProductId(String productCode) {
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        List<Review> reviewList = repo.findByProductCode(productCode);
        if (reviewList.isEmpty()) {
            throw new ReviewNotFoundException("No reviews found for product code: " + productCode);
        }

        for (Review review : reviewList) {
            reviewDtoList.add(reviewMapper.reviewToDto(review));
        }
        return reviewDtoList;
    }

    public void reviewAction(Integer id, String status) {
        repo.reviewAction(id, status);
    }


}
