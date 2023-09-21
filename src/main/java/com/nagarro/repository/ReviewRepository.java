package com.nagarro.repository;

import com.nagarro.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByProductCode(@Param("productCode") String code);
    @Modifying
    @Query("update Review set status=:status  where id=:id")
    @Transactional
    void reviewAction(@Param("id") Integer id, @Param("status") String status);

    @Query("SELECT COUNT(r) FROM Review r WHERE r.status = 'accepted'")
    Long countAcceptedReviews();


}
