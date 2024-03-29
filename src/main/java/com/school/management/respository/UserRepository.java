package com.school.management.respository;

import com.school.management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    User findByUsername(String username);
    List<User> findAllByClassName(String className);
}
