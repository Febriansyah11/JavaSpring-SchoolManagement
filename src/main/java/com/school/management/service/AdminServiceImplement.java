package com.school.management.service;

import com.school.management.model.Role;
import com.school.management.model.User;
import com.school.management.respository.RoleRepository;
import com.school.management.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class AdminServiceImplement implements  AdminService{
    Date date = new Date((System.currentTimeMillis()));
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;


    @Override
    public User createAdmin() {
        Date date = new Date((System.currentTimeMillis()));
        Role role = roleService.findByRoleId(1);
        User user = new User();
        user.setName("Your school name");
        user.setPhoneNumber("Your school phone number");
        user.setEmail("school@gmail.com");
        user.setPassword("schooladmin");
        user.setCreatedDate(date);
        user.setAddress("Your school address");
        user.setRoles(role);
        return userRepository.save(user);
    }

    @Override
    public User editRole(String userId, Integer roleId) {
        User user = userService.findById(userId);
        Role role = roleService.findByRoleId(roleId);
        user.setRoles(role);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        User user = userService.findById(id);
        userRepository.deleteById(user.getIdUser());
    }

}
