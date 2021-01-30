package com.Service;

import com.dto.Status_team_useDTO;
import com.dto.TeamDTO;
import com.dto.Team_userDTO;
import com.dto.UserDTO;

import java.util.List;

public interface Team_userService {
    Team_userDTO Createteam(TeamDTO dto);
    Team_userDTO AddTeam(Team_userDTO teamUserDTO) throws Exception;
    List<UserDTO> findNonReferencedNames ();
    Team_userDTO finDNOeUserAndStatus(UserDTO userDTO, Status_team_useDTO status_team_useDTO);
    List<Team_userDTO> FindBayAllUser(TeamDTO teamDTO);
}
