package com.dto;

public class Team_userDTO extends AbstractDTO<Team_userDTO>{
    private TeamDTO teamDTO;
    private  UserDTO userDTO;
    private Team_roleDTO team_role;
    private Status_team_useDTO status_team_use;

    public TeamDTO getTeamDTO() {
        return teamDTO;
    }

    public void setTeamDTO(TeamDTO teamDTO) {
        this.teamDTO = teamDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public Team_roleDTO getTeam_role() {
        return team_role;
    }

    public void setTeam_role(Team_roleDTO team_role) {
        this.team_role = team_role;
    }

    public Status_team_useDTO getStatus_team_use() {
        return status_team_use;
    }

    public void setStatus_team_use(Status_team_useDTO status_team_use) {
        this.status_team_use = status_team_use;
    }
}
