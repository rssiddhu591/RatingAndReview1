package com.airtelproduct1.repository;

import com.airtelproduct1.model.RatingAndReview;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingAndReviewRepository extends MongoRepository<RatingAndReview,Integer> {

    List<RatingAndReview> findByUserAndNameOrderByCreatedAtDesc(String name, String name1);
}
