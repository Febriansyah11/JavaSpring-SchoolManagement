package com.school.management.service;

import com.school.management.exception.ExceptionResponse.*;
import com.school.management.exception.ExceptionSize.*;
import com.school.management.model.Role;
import com.school.management.model.User;
import com.school.management.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.List;

@Service
public class UserServiceImplement implements UserService {
    Date date = new Date((System.currentTimeMillis()));
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleService roleService;

    @Override
    public User findById(String id) {
        if (!userRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return userRepository.findById(id).get();
        }
    }

    @Override
    public User createUser(User user) {
        User usr = new User();
        Role role = roleService.findByRoleId(5);
        if (user.getEmail() != "" && user.getPassword() != "" && user.getPhoneNumber() != "" && user.getName() != "") {
            validator(user);
            usr.setEmail(user.getEmail());
            usr.setPassword(user.getPassword());
            usr.setPhoneNumber(user.getPhoneNumber());
            usr.setName(user.getName());
            usr.setAddress(user.getAddress());
            usr.setCreatedDate(date);
            usr.setRoles(role);
            for (User allUser : findAllUsers()) {
                if (usr.equals(allUser)) throw new EmailOrPhoneNumberAlreadyUsed();
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return userRepository.save(usr);
    }
    private void validator(User user) {
        if (user.getName().length() < 3) throw new NameSize();
        if (user.getPassword().length() < 8) throw new PasswordSize();
    }


    @Override
    public User editUser(User user) {
        User usr = findById(user.getIdUser());
        usr.setName(user.getName());
        usr.setEmail(user.getEmail());
        usr.setPassword(user.getPassword());
        usr.setPhoneNumber(user.getPhoneNumber());
        usr.setAddress(user.getAddress());
        usr.setUpdatedDate(date);
        return userRepository.save(usr);
    }

    @Override
    public User editTeacher(User user) {
        User teacher = findById(user.getIdUser());
        teacher.setLearningProgram(user.getLearningProgram());
        teacher.setIdCard(user.getIdCard());
        teacher.setUpdatedDate(date);
        return userRepository.save(teacher);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAllByClassName(String className) {
        return userRepository.findAllByClassName(className);
    }
}
