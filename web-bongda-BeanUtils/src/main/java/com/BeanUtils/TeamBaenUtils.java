package com.BeanUtils;

import com.common.SystemConstant;
import com.dto.TeamDTO;
import com.persisterce.TeamEntity;
import org.springframework.stereotype.Component;

@Component
public class TeamBaenUtils {
    public static TeamDTO EntitytoDTO(TeamEntity teamEntity){
        TeamDTO dto = new TeamDTO();
        dto.setId(teamEntity.getId());
        dto.setName(teamEntity.getName());
        dto.setCode(teamEntity.getCode());
        dto.setSlogan(teamEntity.getSlogan());
        dto.setImge(teamEntity.getÌmge());
        return dto;
    }
    public static TeamEntity teamEntity (TeamDTO dto){
        TeamEntity entity = new TeamEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setSlogan(dto.getSlogan());
        entity.setMembermax(SystemConstant.Maxmember);
        entity.setImge(dto.getImge());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
