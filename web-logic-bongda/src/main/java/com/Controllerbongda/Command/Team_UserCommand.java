package com.Controllerbongda.Command;

import com.Service.Team_Service;
import com.Service.Team_userService;
import com.common.SecurityUtils;
import com.common.SystemConstant;
import com.dto.Status_team_useDTO;
import com.dto.TeamDTO;
import com.dto.Team_userDTO;
import com.dto.UserDTO;
import com.repository.TeamRepository;
import com.repository.Team_userReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Team_UserCommand {
    @Autowired
    private Team_userService teamUserService;
    @Autowired
    private Team_Service teamService;

    public Map<List<TeamDTO>, List<UserDTO>> teamDTOUserDTO(int status, Pageable pageable) {
        Map<List<TeamDTO>, List<UserDTO>> map = new HashMap<>();
        List<TeamDTO> dtos = teamService.findallbystatus(status, pageable);
        map.put(dtos, teamUserService.findNonReferencedNames());
        for (Map.Entry<List<TeamDTO>, List<UserDTO>> entry : map.entrySet()) {
            for (TeamDTO dto : entry.getKey()) {
                System.out.println(dto.getName());
            }
            for (UserDTO dto : entry.getValue()) {
                System.out.println(dto.getFullName());
            }
        }
        return map;
    }
    public Map<Team_userDTO, List<Team_userDTO>> TeamUser() {
        Map<Team_userDTO, List<Team_userDTO>> listMap = new HashMap<>();
        UserDTO dto = new UserDTO();
        dto.setId(SecurityUtils.getprincipal().getId());
        Status_team_useDTO statusTeamUseDTO = new Status_team_useDTO();
        statusTeamUseDTO.setId(SystemConstant.Status_1_hoatdong);
        Team_userDTO teamUserDTO = teamUserService.finDNOeUserAndStatus(dto, statusTeamUseDTO);
        List<Team_userDTO> dtos = new ArrayList<>();
        dtos = teamUserService.FindBayAllUser(teamUserDTO.getTeamDTO());
        listMap.put(teamUserDTO, dtos);

        return listMap;
    }

}
