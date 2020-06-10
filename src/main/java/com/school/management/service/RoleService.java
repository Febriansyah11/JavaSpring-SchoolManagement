package com.school.management.service;

import com.school.management.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAllRole();
    Role findByRoleId(Integer idRole);
    List<Role> createRole();
}
