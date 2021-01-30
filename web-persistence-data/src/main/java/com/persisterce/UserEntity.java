package com.persisterce;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
public class    UserEntity extends BaseEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullName;

    @Column
    private Integer status;

    @OneToMany(mappedBy = "userEntity")
    private List<Team_UserEntity> teamUsers;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RoleEntity> roleEntity = new ArrayList<>();

    public List<RoleEntity> getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(List<RoleEntity> roleEntity) {
        this.roleEntity = roleEntity;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Team_UserEntity> getTeamUsers() {
        return teamUsers;
    }

    public void setTeamUsers(List<Team_UserEntity> teamUsers) {
        this.teamUsers = teamUsers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsernam(String usernam) {
        this.username = usernam;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
