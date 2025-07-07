package com.example.restaurant.service;

import com.example.restaurant.domain.Manager;
import com.example.restaurant.repository.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagerService extends BaseService<Manager, Long> {

    private final ManagerRepository repository;

    public ManagerService(ManagerRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Optional<Manager> findByUsername(String username) {
        return repository.findByUser_UserName(username);
    }
}
