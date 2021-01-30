package com.Service;

import com.dto.TeamDTO;
import com.dto.Team_userDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Team_Service {
    TeamDTO Save(TeamDTO dto);
    List<TeamDTO> findallbystatus(int status, Pageable pageable);
    int getTotalItem();
}

