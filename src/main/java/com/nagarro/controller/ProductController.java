package com.nagarro.controller;

import com.nagarro.dto.ProductDto;
import com.nagarro.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nagarro.entity.Product;

import java.util.List;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService service;

    /**
     * Api to insert a new product
     *
     * @param productDto : product object
     * @return null
     */

    @PostMapping("/products")
    public ResponseEntity<Void> insertProduct(@RequestBody ProductDto productDto) {
        service.saveProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * To get product by product code
     *
     * @param productCode is product code parameter
     * @return a single product
     */
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") String productCode) {
        ProductDto productDto = service.getProduct(productCode);
        return ResponseEntity.ok(productDto);
    }

    /**
     * Api to get all products.
     *
     * @return list of all products.
     */

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> productDtoList;
        productDtoList = service.getProducts();
        return ResponseEntity.ok(productDtoList);
    }

    /**
     * Api to get list of products
     *
     * @param parameter search product based on name, code or brand
     * @return a list of searched products
     */
    @RequestMapping("/products/search/{parameter}")
    public ResponseEntity<List<ProductDto>> getProductByParameter(@PathVariable("parameter") String parameter) {
        List<ProductDto> products = service.fetchProductByParameter(parameter);
        return ResponseEntity.ok(products);
    }



}