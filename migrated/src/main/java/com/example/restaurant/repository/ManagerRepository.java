package com.example.restaurant.repository;

import com.example.restaurant.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Optional<Manager> findByUser_UserName(String username);
}
