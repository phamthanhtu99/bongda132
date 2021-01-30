package com.BeanUtils;

import com.dto.Team_roleDTO;
import com.persisterce.Role_teamEntity;
import org.springframework.stereotype.Component;

@Component
public class Team_roleUtils {
   private static modelMapper mapper = new modelMapper();
    public static Team_roleDTO convertToDto(Role_teamEntity role_teamEntity) {
        Team_roleDTO postDto = new Team_roleDTO();
        postDto.setId(role_teamEntity.getId());
        postDto.setCode(role_teamEntity.getCode());
        postDto.setName(role_teamEntity.getName());
        return postDto;
    }
    public static Role_teamEntity convertToEntity(Team_roleDTO postDto)  {
        Role_teamEntity post = new Role_teamEntity();
        post.setId(postDto.getId());
        post.setCode(post.getCode());
        post.setName(postDto.getName());
        return post;
    }
}
