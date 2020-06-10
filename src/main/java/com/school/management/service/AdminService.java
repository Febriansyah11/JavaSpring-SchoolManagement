package com.school.management.service;

import com.school.management.model.Role;
import com.school.management.model.User;

public interface AdminService {
    User createAdmin();
    User editRole(String userId, Integer roleId);
    void deleteUser(String id);
}
