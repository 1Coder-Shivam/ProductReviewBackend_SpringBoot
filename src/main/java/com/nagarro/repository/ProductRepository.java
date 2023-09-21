package com.nagarro.repository;

import com.nagarro.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.nagarro.entity.Product;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    Product findByProductCode(String productCode);


    @Query("SELECT p FROM Product p WHERE p.name = ?1 OR p.productCode = ?1 OR p.brand=?1")
    List<Product> findByOneParameter(String parameter);

    @Query("SELECT COUNT(r) FROM Product r WHERE r.image IS NOT NULL")
    Long countByImageNotNull();
}
