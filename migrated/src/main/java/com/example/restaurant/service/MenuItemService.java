package com.example.restaurant.service;

import com.example.restaurant.domain.MenuItem;
import com.example.restaurant.repository.MenuItemRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuItemService extends BaseService<MenuItem, Long> {

    private final MenuItemRepository repository;

    public MenuItemService(MenuItemRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Optional<MenuItem> findByItemName(String itemName) {
        return repository.findByItemName(itemName);
    }
}
