package com.school.management.utils;

import com.school.management.model.Role;
import com.school.management.model.User;
import com.school.management.respository.RoleRepository;
import com.school.management.respository.UserRepository;
import com.school.management.service.AdminService;
import com.school.management.service.RoleService;
import com.school.management.service.RoleServiceImplement;
import com.school.management.service.UserService;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(value = 1)
public class DBInit implements ApplicationRunner {
    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (roleService.findAllRole().isEmpty()) {
            roleService.createRole();

            adminService.createAdmin();
            System.out.println("Role created");
        } else {
            System.out.println("Role exist");
        }

    }

    }
