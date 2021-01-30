package com.BeanUtils;

import com.dto.Status_team_useDTO;
import com.dto.Team_use_KeyDTO;
import com.dto.Team_userDTO;
import com.persisterce.Team_UserEntity;
import com.persisterce.Team_statusEntity;
import com.persisterce.team_userkey;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
@Component
public class Team_UsekeyUtils {
    private static modelMapper mapper = new modelMapper();
    public static Team_use_KeyDTO convertToDto(team_userkey usekey) {
        Team_use_KeyDTO dto =new Team_use_KeyDTO();
        dto.setTeam_id(usekey.getTeam_id());
        dto.setUser_id(usekey.getUser_id());
        return dto;
    }
    public static team_userkey convertToEntity(Team_userDTO postDto)  {
        team_userkey team_userkey =new team_userkey();
        team_userkey.setTeam_id(postDto.getTeamDTO().getId());
        team_userkey.setUser_id(postDto.getUserDTO().getId());
        return team_userkey;
    }
}
