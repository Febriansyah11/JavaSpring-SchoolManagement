package com.school.management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "id_role")
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idRole;

    @Column(name = "role_name", length = 15)
    private String roleName;

    @OneToMany
    @JoinColumn(name = "id_role")
    @JsonIgnore
    private List<User> users;

    public Role() {}

    public Role(Integer idRole) {
        this.idRole = idRole;
    }
    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role(Integer idRole, String roleName) {
        this.idRole = idRole;
        this.roleName = roleName;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

