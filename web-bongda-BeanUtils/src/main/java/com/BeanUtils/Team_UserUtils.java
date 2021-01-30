package com.BeanUtils;

import com.dto.Team_roleDTO;
import com.dto.Team_use_KeyDTO;
import com.dto.Team_userDTO;
import com.persisterce.Role_teamEntity;
import com.persisterce.TeamEntity;
import com.persisterce.Team_UserEntity;
import org.springframework.stereotype.Component;

@Component
public class Team_UserUtils {
    private modelMapper mapper = new modelMapper();
    public static Team_userDTO convertToDto(Team_UserEntity team_userEntity) {
        Team_userDTO team_userDTO =new Team_userDTO();
        team_userDTO.setTeamDTO(TeamBaenUtils.EntitytoDTO(team_userEntity.getTeamEntity()));
        team_userDTO.setUserDTO(UserBeanUtils.EntitytoDTO(team_userEntity.getUserEntity()));
        team_userDTO.setStatus_team_use(Status_team_useUtils.convertToDto(team_userEntity.getStatus_team_user()));
        team_userDTO.setTeam_role(Team_roleUtils.convertToDto(team_userEntity.getRole_teamEntity()));
        return team_userDTO;
    }
    public static Team_UserEntity convertToEntity(Team_userDTO postDto)  {
        Team_UserEntity team_userEntity = new Team_UserEntity();
        team_userEntity.setTeamEntity(TeamBaenUtils.teamEntity(postDto.getTeamDTO()));
        team_userEntity.setId(Team_UsekeyUtils.convertToEntity(postDto));
        team_userEntity.setUserEntity(UserBeanUtils.DTOtoEntity(postDto.getUserDTO()));
        team_userEntity.setRole_teamEntity(Team_roleUtils.convertToEntity(postDto.getTeam_role()));
        team_userEntity.setStatus_team_user(Status_team_useUtils.convertToEntity(postDto.getStatus_team_use()));
        return team_userEntity;
    }
}

