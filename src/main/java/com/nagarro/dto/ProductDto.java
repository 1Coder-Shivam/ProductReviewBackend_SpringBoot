package com.nagarro.dto;

import com.nagarro.entity.Review;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDto {
    private String productCode;
    private String name;
    private String brand;
    private String image;
    private double price;
    private String description;
    private String specification;
    private List<Review> reviews = new ArrayList<Review>();

}
