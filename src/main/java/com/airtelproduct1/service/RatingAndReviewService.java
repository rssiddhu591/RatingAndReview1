package com.airtelproduct1.service;

import com.airtelproduct1.model.Apparel;
import com.airtelproduct1.model.Issue;
import com.airtelproduct1.model.RatingAndReview;
import com.airtelproduct1.model.User;
import com.airtelproduct1.repository.ApparelRepository;
import com.airtelproduct1.repository.IssueRepository;
import com.airtelproduct1.repository.RatingAndReviewRepository;
import com.airtelproduct1.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RatingAndReviewService {
    @Autowired
    private RatingAndReviewRepository ratingAndReviewRepository;
    private static final Logger LOGGER= LoggerFactory.getLogger(RatingAndReviewService.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ApparelRepository apparelRepository;
    @Autowired
    private IssueRepository issueRepository;
    public String addRateAndReview(RatingAndReview rar) {
        if(rar.getRating()<1|| rar.getRating()>5) {
            LOGGER.error("Rating should be in limits");
            return "Rating Not In Limits";
        }
        else {
            if (userRepository.existsByName(rar.getUser()))
            {
                LOGGER.info("Adding Review");
                List<String> issues=rar.getIss();
                for(String issue:issues)
                {
                    if(!(issueRepository.existsByDescription(issue)))
                    {
                        LOGGER.error("Issue Not Present");
                        return "Issue: "+issue+" Not Found";
                    }
                }
                rar.setCreatedAt(LocalDateTime.now());
                ratingAndReviewRepository.save(rar);
                LOGGER.info("Review Added Successfully");
            }
            else {
                try{
                    throw new Exception("User Not Found");
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                finally{
                    return "User Not Found";
                }
            }
            return "Rating And Review Added Successfully";
        }
    }

    public List<Apparel> getProductsSorted() {
        List<Apparel> apparels=apparelRepository.findAll();
        for(Apparel apparel:apparels)
        {
            double rating=0;
            int count=0;
            double res=0;

            List<User> users=userRepository.findAll();
          for(User user:users)
          {
                List<RatingAndReview> rateAndReviews = ratingAndReviewRepository.findByUserAndNameOrderByCreatedAtDesc(user.getName(),apparel.getName());
                if(!(rateAndReviews.isEmpty()))
                {
                    RatingAndReview rateAndReview=rateAndReviews.get(0);
                    rating+=rateAndReview.getRating();
                    count+=1;
                }
          }
            if(count!=0) {
                res = rating / count;
            }
            apparel.setRating(res);
            apparel.setCount(count);
            apparelRepository.save(apparel);
        }

        return apparelRepository.findAll(Sort.by(Sort.Direction.DESC,"rating"));
    }

    public List<Issue> getAllIssues() {
        List<Apparel> apparels = apparelRepository.findAll();
        for (Apparel apparel : apparels) {
            List<User> users = userRepository.findAll();
            for (User user : users) {
                List<RatingAndReview> rateAndReviews = ratingAndReviewRepository.findByUserAndNameOrderByCreatedAtDesc(user.getName(), apparel.getName());
                if(!(rateAndReviews.isEmpty()))
                {
                    RatingAndReview rateAndReview=rateAndReviews.get(0);
                    List<String> issues = rateAndReview.getIss();
                    for (String issue1:issues)
                    {
                        Issue issue = issueRepository.findByDescription(issue1);
                        issue.setCount(issue.getCount() + 1);
                        issueRepository.save(issue);
                    }
                }
            }
        }
        List<Issue> resIssue=issueRepository.findAll();
        List<Issue> resIssue1=issueRepository.findAll();
        for(Issue issue2:resIssue1)
        {
           issue2.setCount(0);
           issueRepository.save(issue2);
        }
        LOGGER.info("Displaying All Issues");
        return resIssue;
    }
}
