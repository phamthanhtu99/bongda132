package com.persisterce;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Team")
public class TeamEntity extends BaseEntity {
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "membermax")
    private int membermax;
    @Column(name = "membermin")
    private int membermin;
    @Column(name = "status")
    private Integer status;

    @Column(name = "codeImge")
    private String imge ;

    @Column(name = "slogan")
    private String slogan;

    public int getMembermax() {
        return membermax;
    }

    public void setMembermax(int membermax) {
        this.membermax = membermax;
    }

    public int getMembermin() {
        return membermin;
    }

    public void setMembermin(int membermin) {
        this.membermin = membermin;
    }

    public String getImge() {
        return imge;
    }

    public String getÌmge() {
        return imge;
    }

    public void setImge(String ìmge) {
        this.imge = ìmge;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    @OneToMany(mappedBy = "teamEntity")
    private List<Team_UserEntity> team_users;

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



    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
