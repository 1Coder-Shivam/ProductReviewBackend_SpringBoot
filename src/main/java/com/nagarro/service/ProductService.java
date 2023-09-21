package com.nagarro.service;

import com.nagarro.dto.ProductDto;
import com.nagarro.entity.Product;

import java.util.List;

public interface ProductService {

	ProductDto saveProduct(ProductDto productDto);
	
	ProductDto getProduct(String productCode);

	Long countAllProduct();

	List<ProductDto> getProducts();

	List<ProductDto> fetchProductByParameter(String parameter);
}
