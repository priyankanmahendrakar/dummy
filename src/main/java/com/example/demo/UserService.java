package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticateUser(User user) {
        String userId = user.getUserId();
        Optional<User> userOptional = userRepository.findByUserId(userId);

        return userOptional.isPresent() && user.getPassword().equals(userOptional.get().getPassword());
    }
}
