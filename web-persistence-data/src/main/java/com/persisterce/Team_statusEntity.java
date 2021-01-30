package com.persisterce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Status_team_User")
public class Team_statusEntity extends BaseEntity{
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "status_team_user")
    private List<Team_UserEntity>team_users= new ArrayList<>();

    public List<Team_UserEntity> getTeam_users() {
        return team_users;
    }

    public void setTeam_users(List<Team_UserEntity> team_users) {
        this.team_users = team_users;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
