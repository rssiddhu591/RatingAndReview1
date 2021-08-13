package com.airtelproduct1.repository;

import com.airtelproduct1.model.Apparel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApparelRepository extends MongoRepository<Apparel,String> {
    public Apparel findByName(String n);
}
