package com.airtelproduct1.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString

@Document(collection="RatingAndReview1")
public class RatingAndReview {
    private double rating;
    private String user;
    private String name;
    private String feedback;
    private List<String> iss;
    private LocalDateTime createdAt;


}