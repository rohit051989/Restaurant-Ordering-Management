package com.example.restaurant.service;

import com.example.restaurant.domain.Customer;
import com.example.restaurant.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService extends BaseService<Customer, Long> {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Optional<Customer> findByUsername(String username) {
        return repository.findByUser_UserName(username);
    }
}
