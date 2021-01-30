package com.serviceImpl;

import com.BeanUtils.TeamBaenUtils;
import com.BeanUtils.Team_UserUtils;
import com.Service.Team_Service;
import com.dto.TeamDTO;
import com.dto.UserDTO;
import com.persisterce.*;
import com.repository.TeamRepository;
import com.repository.Team_userReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamServiecImpl implements Team_Service {

    @Autowired
    TeamRepository teamRepository;
    @Autowired
    Team_userReository team_userReository;
    @Autowired
    private TeamBaenUtils baenUtils;
    @Override
    @Transactional
    public TeamDTO Save(TeamDTO teamDTO) {
        return baenUtils.EntitytoDTO(teamRepository.save(baenUtils.teamEntity(teamDTO)));
    }


    @Override
    public List<TeamDTO> findallbystatus(int status, Pageable pageable) {

        List<TeamEntity> list = teamRepository.findAllByStatus(status,pageable);
        List<TeamDTO> dtos = new ArrayList<>();
        for (TeamEntity entity : list){
            TeamDTO dto = TeamBaenUtils.EntitytoDTO(entity);
            dtos.add(dto);
         }
        return dtos;
    }

    @Override
    public int getTotalItem() {
        return (int) teamRepository.count();
    }


}
