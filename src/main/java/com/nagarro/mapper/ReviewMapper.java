package com.nagarro.mapper;

import com.nagarro.dto.ProductDto;
import com.nagarro.dto.ReviewDto;
import com.nagarro.entity.Product;
import com.nagarro.entity.Review;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    Review dtoToReview(ReviewDto reviewDto);

    ReviewDto reviewToDto(Review review);
}
