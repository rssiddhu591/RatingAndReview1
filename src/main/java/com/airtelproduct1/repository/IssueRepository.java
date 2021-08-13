package com.airtelproduct1.repository;

import com.airtelproduct1.model.Issue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends MongoRepository<Issue,String> {
    Issue findByDescription(String issue1);

    boolean existsByDescription(String issue);
}
