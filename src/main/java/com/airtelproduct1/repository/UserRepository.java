package com.airtelproduct1.repository;

import com.airtelproduct1.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    User findByName(String userId);
    boolean existsByName(String userId);
}
