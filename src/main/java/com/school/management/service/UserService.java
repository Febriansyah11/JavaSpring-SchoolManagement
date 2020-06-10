package com.school.management.service;

import com.school.management.model.User;

import java.util.List;

public interface UserService {
    User findById(String id);
    //    User findByUsername(String username);
    User createUser(User user);
    User editUser(User user);
    User editTeacher(User user);
    List<User> findAllUsers();
    List<User> findAllByClassName(String className);
}
