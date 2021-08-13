package com.airtelproduct1.controller;

import com.airtelproduct1.model.Apparel;
import com.airtelproduct1.model.Issue;
import com.airtelproduct1.model.RatingAndReview;
import com.airtelproduct1.service.RatingAndReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RatingAndReviewController {
    @Autowired
    private RatingAndReviewService ratingAndReviewService;
    @PostMapping("/addRateAndReview")
    public String addRateAndReview(@RequestBody RatingAndReview rar)
    {
        return ratingAndReviewService.addRateAndReview(rar);
    }
    @GetMapping("/getProductsSorted")
    public List<Apparel> getProductsSorted()
    {
        return ratingAndReviewService.getProductsSorted();
    }
    @GetMapping("/getAllIssues")
    public List<Issue> getAllIssues()
    {
        return ratingAndReviewService.getAllIssues();
    }
}
