package com.airtelproduct1.controller;

import com.airtelproduct1.model.Issue;
import com.airtelproduct1.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IssueController {
    @Autowired
    private IssueService issueService;
    @PostMapping("/addIssue")
    public String addIssue(@RequestBody Issue issue)
    {
        return issueService.addIssue(issue);
    }
}
