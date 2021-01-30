package com.dto;

public class UserDTO extends AbstractDTO<UserDTO> {
    private String username;
    private String password;
    private String fullName;
    private Integer status;
    private String namerole;
    private String coderole;
    private String codeteam;
    private String nameteam;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getNamerole() {
        return namerole;
    }

    public void setNamerole(String namerole) {
        this.namerole = namerole;
    }

    public String getCoderole() {
        return coderole;
    }

    public void setCoderole(String coderole) {
        this.coderole = coderole;
    }

    public String getCodeteam() {
        return codeteam;
    }

    public void setCodeteam(String codeteam) {
        this.codeteam = codeteam;
    }

    public String getNameteam() {
        return nameteam;
    }

    public void setNameteam(String nameteam) {
        this.nameteam = nameteam;
    }
}
