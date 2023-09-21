package com.nagarro.mapper;

import com.nagarro.dto.ProductDto;
import com.nagarro.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {


    Product dtoToProduct(ProductDto productDto);

    ProductDto productToDto(Product product);
}
