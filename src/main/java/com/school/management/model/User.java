package com.school.management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_user", unique = true, nullable = false, length = 64)
    private String idUser;

    @NotNull
    @Size(min = 3, message = "Name should have atleast 3 characters")
    @Column(nullable = false, length = 50)
    private String name;


    @Size(min = 8, message = "Password should have atleast 8 characters")
    @Column(nullable = false, length = 25)
    private String password;

    @CreatedDate
    @Column(name = "created_at")
    private Date createdDate;

    @CreatedDate
    @Column(name = "updated_at")
    private Date updatedDate;


    @Email
    @Column(unique = true, length = 50)
    private String email;


    @Column(unique = true, length = 25)
    private String phoneNumber;

    private String address;

    @Column(name = "id_card", unique = true, length = 50)
    private String idCard;

    @Column(name = "class", length = 50)
    private String className;

    @Column(name = "learning_program", length = 50)
    private String learningProgram;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role roles;

    public User() {}

    public User(String idCard, String learningProgram) {
        this.idCard = idCard;
        this.learningProgram = learningProgram;
    }

    public User(@NotNull @Size(min = 3, message = "Name should have atleast 3 characters") String name, @Size(min = 8, message = "Password should have atleast 8 characters") String password, Date createdDate, @Email String email, String phoneNumber) {
        this.name = name;
        this.password = password;
        this.createdDate = createdDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getLearningProgram() {
        return learningProgram;
    }

    public void setLearningProgram(String learningProgram) {
        this.learningProgram = learningProgram;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (obj instanceof User) {
            User user = (User) obj;
            if ((user.getEmail() == null && email == null) || (user.getEmail().equals(email)) ||
                    ((user.getPhoneNumber() == null && phoneNumber == null) || user.phoneNumber.equals(phoneNumber))) {
                return true;
            }
        }
        return false;
    }
    

}
