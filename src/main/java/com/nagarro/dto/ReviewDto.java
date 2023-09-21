package com.nagarro.dto;

import lombok.Data;

@Data
public class ReviewDto {
    private int id;
    private String productCode;

    private String body;
    private String headline;
    private int rating;
    private String date;
    private String userName;
    private String status;

}
