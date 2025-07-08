package com.example.restaurant.controller;

import com.example.restaurant.domain.Manager;
import com.example.restaurant.service.ManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {

    private final ManagerService service;

    public ManagerController(ManagerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Manager> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manager> byId(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
