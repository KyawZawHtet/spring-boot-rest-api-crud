package com.kyaw.springbootrestapicrud.service;

// Step 3

import com.kyaw.springbootrestapicrud.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserById(Long userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);
}
