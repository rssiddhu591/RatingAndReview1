package com.airtelproduct1.service;

import com.airtelproduct1.model.User;
import com.airtelproduct1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String addUser(User user) {
        userRepository.save(user);
        return "User Added Sucessfully";

    }
}
