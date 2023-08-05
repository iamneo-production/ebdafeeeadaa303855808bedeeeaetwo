
package com.example.springapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.springapp.model.User;

@Service
public class UserService {
    private final Map<String, User> users = new HashMap<>();

    public User createUser(User user) {
        if (user.getName() == null || user.getEmail() == null || user.getAge() <= 0 || user.getAddress() == null) {
            return null;
        }

        String userId = generateUniqueId();
        user.setId(userId);
        users.put(userId, user);

        return user;
    }

    public User getUserById(String id) {
        return users.get(id);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }
}
