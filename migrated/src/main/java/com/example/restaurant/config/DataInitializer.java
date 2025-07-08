package com.example.restaurant.config;

import com.example.restaurant.domain.Group;
import com.example.restaurant.domain.User;
import com.example.restaurant.service.GroupService;
import com.example.restaurant.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final GroupService groupService;
    private final UserService userService;

    public DataInitializer(GroupService groupService, UserService userService) {
        this.groupService = groupService;
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        Group adminGroup = new Group();
        adminGroup.setGroupName("ADMINISTRATORS");
        adminGroup.setGroupDescription("The admin group");

        User adminUser = new User();
        adminUser.setUserName("admin");
        adminUser.setPassword("admin");
        adminUser.addGroup(adminGroup);

        groupService.save(adminGroup);
        userService.save(adminUser);
    }
}
