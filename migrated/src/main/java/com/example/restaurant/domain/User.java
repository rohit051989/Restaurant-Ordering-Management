package com.example.restaurant.domain;

import com.google.common.hash.Hashing;
import jakarta.persistence.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "security_user")
public class User {

    @Id
    private String userName;

    private String password;
    private boolean disabled;

    @ManyToMany
    @JoinTable(name = "sec_user_groups",
            joinColumns = @JoinColumn(name = "USERNAME"),
            inverseJoinColumns = @JoinColumn(name = "GROUPNAME"))
    private List<Group> groups = new ArrayList<>();

    @PrePersist
    @PreUpdate
    public void hashPassword() {
        String sha256hex = Hashing.sha256()
                .hashString(this.password, StandardCharsets.UTF_8)
                .toString();
        this.password = sha256hex;
    }

    public void addGroup(Group g) {
        if (!groups.contains(g)) {
            groups.add(g);
        }
        if (!g.getUsers().contains(this)) {
            g.getUsers().add(this);
        }
    }

    // getters and setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
