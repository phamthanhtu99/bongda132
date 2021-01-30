package com.serviceImpl;

import com.BeanUtils.*;
import com.Service.Team_Service;
import com.Service.Team_userService;
import com.Service.UserSerice;
import com.common.SecurityUtils;
import com.common.SystemConstant;
import com.dto.*;
import com.persisterce.Team_UserEntity;
import com.persisterce.Team_statusEntity;
import com.persisterce.UserEntity;
import com.repository.Team_userReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Team_UerServiceImpl implements Team_userService {
    private final Team_userDTO team_userDTO = new Team_userDTO();
    private final Status_team_useDTO status_team_useDTO = new Status_team_useDTO();
    private final Team_roleDTO team_roleDTO = new Team_roleDTO();
    @Autowired
    private Team_Service team_service;
    @Autowired
    private UserSerice userSerice;
    @Autowired
    private TeamBaenUtils teamBaenUtils;
    @Autowired
    private Team_userReository reository;

    @Override
    @Transactional
    public Team_userDTO Createteam(TeamDTO dto) {



        //------------------------------------------------
        Team_roleDTO roleDTO= new Team_roleDTO(); //lấy team role
        roleDTO.setId((long) 1);
        dto.setStatus(1);
        team_userDTO.setTeam_role(roleDTO);
       //---------------------------------//lấy team
        team_userDTO.setTeamDTO(team_service.Save(dto));


        //------------------------------------//lấy tinh trạng use
        Status_team_useDTO statusTeamUseDTO = new Status_team_useDTO();
        statusTeamUseDTO.setId((long) 1);
        team_userDTO.setStatus_team_use(statusTeamUseDTO);

        //------------------------------------//láy role team
        Team_roleDTO team_roleDTO = new Team_roleDTO();
        team_roleDTO.setId((long)1);
        team_userDTO.setTeam_role(team_roleDTO);
        //-------------------------------------------/layas use
        UserDTO userDTO =userSerice.FindOneByUsername(SecurityUtils.getprincipal().getUsername());
        team_userDTO.setUserDTO(userDTO);
        Team_UserEntity entity = Team_UserUtils.convertToEntity(team_userDTO);

        return Team_UserUtils.convertToDto(reository.save(entity));
    }

    @Override
    @Transactional
    public Team_userDTO AddTeam(Team_userDTO teamUserDTO) throws Exception{
        team_userDTO.setTeamDTO(teamUserDTO.getTeamDTO());
        team_userDTO.setUserDTO(teamUserDTO.getUserDTO());
        status_team_useDTO.setId(SystemConstant.Status_1_hoatdong);
        team_userDTO.setStatus_team_use(status_team_useDTO);
        team_roleDTO.setId(SystemConstant.roleteam_2_thanhvien);
        team_userDTO.setTeam_role(team_roleDTO);
        try {
            Team_UserEntity  entity = reository.save(Team_UserUtils.convertToEntity(team_userDTO));
            teamUserDTO = Team_UserUtils.convertToDto(entity);
            return teamUserDTO;
        }catch (Exception  exception){
            exception.printStackTrace();
            return null;
        }


    }

    @Override
    public List<UserDTO> findNonReferencedNames() {
        List<UserEntity> userEntities =reository.findNonReferencedNames();
        List<UserDTO> dtos= new ArrayList<>();
        for (UserEntity entity : userEntities){
            UserDTO dto = new UserDTO();
            dto = UserBeanUtils.EntitytoDTO(entity);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public Team_userDTO finDNOeUserAndStatus(UserDTO userDTO, Status_team_useDTO status_team_useDTO) {
        Team_UserEntity team_userEntities = reository.finduserandstatus(UserBeanUtils.DTOtoEntity(userDTO), Status_team_useUtils.convertToEntity(status_team_useDTO));
        return Team_UserUtils.convertToDto(team_userEntities);
    }

    @Override
    public List<Team_userDTO> FindBayAllUser(TeamDTO teamDTO) {
        List<Team_UserEntity> team_userUtils=reository.findAllByTeamEntity(TeamBaenUtils.teamEntity(teamDTO));
        List<Team_userDTO> dtos = new ArrayList<>();
        for (Team_UserEntity entity:team_userUtils){
            Team_userDTO dto= new Team_userDTO();
            dto = Team_UserUtils.convertToDto(entity);
            dtos.add(dto);
        }
        return dtos;
    }
}
