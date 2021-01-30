package com.BeanUtils;

import com.dto.Status_team_useDTO;
import com.persisterce.Team_statusEntity;
import org.springframework.stereotype.Component;

@Component
public class Status_team_useUtils {
    private static modelMapper mapper = new modelMapper();
    public static Status_team_useDTO convertToDto(Team_statusEntity team_statusEntity) {
        Status_team_useDTO postDto =new Status_team_useDTO();
        postDto.setId(team_statusEntity.getId());
        postDto.setCode(team_statusEntity.getCode());
        postDto.setName(team_statusEntity.getName());
        return postDto;
    }
    public static Team_statusEntity convertToEntity(Status_team_useDTO postDto)  {
        Team_statusEntity post =new Team_statusEntity();
        post.setId(postDto.getId());
        post.setCode(postDto.getCode());
        post.setName(postDto.getName());
        return post;
    }
}
