package com.dto;



public class TeamDTO extends AbstractDTO<TeamDTO>{

    private String code;
    private String name;
    private Integer status;
    private String imge ;
    private String slogan;
    private int membermax;
    private int membermin;

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

    public void setImge(String imge) {
        this.imge = imge;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
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
