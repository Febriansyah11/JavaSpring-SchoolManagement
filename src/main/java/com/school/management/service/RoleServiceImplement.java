package com.school.management.service;

import com.school.management.model.Role;
import com.school.management.respository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@Service
public class RoleServiceImplement implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> findAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public Role findByRoleId(Integer idRole) {
        if (!roleRepository.findById(idRole).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return roleRepository.findById(idRole).get();
        }
    }

    @Override
    public List<Role> createRole() {
        Role Admin = new Role(1, "Admin");
        Role Administrasi = new Role(2, "Administrasi");
        Role BK = new Role(3, "BK");
        Role Teacher = new Role(4, "Teacher");
        Role Student = new Role(5, "Student");
        List<Role> roles = Arrays.asList(Admin, Administrasi, BK, Teacher, Student);
        return roleRepository.saveAll(roles);
    }


}
