package com.school.management.controller;

import com.school.management.model.User;
import com.school.management.service.AdminService;
import com.school.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserControler {
    @Autowired
    UserService userService;

    @Autowired
    AdminService adminService;

    @GetMapping("/class")
    public List<User> findAllByClassName(@RequestParam String name) {
        return userService.findAllByClassName(name);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable String id) {
        adminService.deleteUser(id);
    }

    @PatchMapping("/editRole/{userId}/{roleId}")
    public User editRole(@PathVariable String userId,@PathVariable  Integer roleId) {
        return adminService.editRole(userId, roleId);
    }

    //Public
    @GetMapping("{id}")
    public User findById(@PathVariable String id) {
        return userService.findById(id);
    }

    @GetMapping("")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping("")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/editUser")
    public User editUser(@RequestBody User user) {
        return userService.editUser(user);
    }

    @PutMapping("/editTeacher")
    public User editTeacher(@RequestBody User user) {
        return userService.editTeacher(user);
    }
}
