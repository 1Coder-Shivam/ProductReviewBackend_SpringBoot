package com.nagarro.service.impl;

/**
 * this class is used to implement services of product
 *
 * @author shivammaurya01
 */

import com.nagarro.custom.exception.ProductNotFoundException;
import com.nagarro.dto.ProductDto;
import com.nagarro.mapper.ProductMapper;
import com.nagarro.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nagarro.entity.Product;
import com.nagarro.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repo;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = productMapper.dtoToProduct(productDto);
        repo.save(product);
        return productDto;
    }

    @Override
    public ProductDto getProduct(String productCode) {
        Product productObj = repo.findByProductCode(productCode);
        ProductDto productDto = productMapper.productToDto(productObj);
        if (Objects.nonNull(productDto)) {
            return productDto;
        } else {
            throw new ProductNotFoundException("Product not found.....");
        }

    }

    @Override
    public Long countAllProduct() {
        return repo.countByImageNotNull();
    }

    @Override
    public List<ProductDto> getProducts() {
        List<ProductDto> productDtoList = new ArrayList<>();
        List<Product> products = this.repo.findAll();
        for (Product product : products) {
            ProductDto productDto = productMapper.productToDto(product);
            if (productDto.getImage() != null) {
                productDtoList.add(productDto);
            }
        }
        if (!productDtoList.isEmpty()) {
            return productDtoList;
        } else {
            throw new ProductNotFoundException("Product not found.....");
        }
    }

    @Override
    public List<ProductDto> fetchProductByParameter(String parameter) {
        List<ProductDto> productDtoList = new ArrayList<>();
        List<Product> product = repo.findByOneParameter(parameter);
        for (Product p : product) {
            productDtoList.add(productMapper.productToDto(p));
        }
        if (Objects.nonNull(product)) {
            return productDtoList;
        } else {
            throw new ProductNotFoundException("Product not found.....");
        }
    }


}