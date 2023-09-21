package com.nagarro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private String productCode;
    private String name;
    private String brand;
    private String image;
    private double price;
    private String description;
    private String specification;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="productCode", referencedColumnName = "productCode")
    private List<Review> reviews = new ArrayList<>();

}
