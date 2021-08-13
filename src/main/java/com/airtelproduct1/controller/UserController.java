package com.airtelproduct1.controller;

import com.airtelproduct1.model.User;
import com.airtelproduct1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/addUser")
    public String addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }
}
