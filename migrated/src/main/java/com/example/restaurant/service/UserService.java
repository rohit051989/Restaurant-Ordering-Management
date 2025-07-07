package com.example.restaurant.service;

import com.example.restaurant.domain.User;
import com.example.restaurant.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends BaseService<User, String> {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    public Optional<User> findByUserName(String username) {
        return userRepository.findByUserName(username);
    }
}
