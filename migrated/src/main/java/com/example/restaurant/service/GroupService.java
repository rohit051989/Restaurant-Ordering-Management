package com.example.restaurant.service;

import com.example.restaurant.domain.Group;
import com.example.restaurant.repository.GroupRepository;
import org.springframework.stereotype.Service;

@Service
public class GroupService extends BaseService<Group, String> {

    public GroupService(GroupRepository repo) {
        super(repo);
    }
}
