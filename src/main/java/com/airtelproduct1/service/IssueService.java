package com.airtelproduct1.service;

import com.airtelproduct1.model.Issue;
import com.airtelproduct1.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueService {
    @Autowired
    private IssueRepository issueRepository;

    public String addIssue(Issue issue) {
        issue.setCount(0);
        issueRepository.save(issue);
        return "Issue Added Successfully";
    }
}
