package com.persisterce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role_team")
public class Role_teamEntity extends BaseEntity{

    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;

    public String getName() {
        return name;
    }

    @OneToMany(mappedBy = "role_teamEntity")
    private List<Team_UserEntity> list =new ArrayList<>();

    public List<Team_UserEntity> getList() {
        return list;
    }

    public void setList(List<Team_UserEntity> list) {
        this.list = list;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
