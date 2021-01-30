package com.BeanUtils;

import com.dto.UserDTO;
import com.persisterce.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserBeanUtils {
    public static   UserDTO EntitytoDTO(UserEntity userEntity){
        UserDTO dto = new UserDTO();
        dto.setId(userEntity.getId());
        dto.setFullName(userEntity.getFullName());
        dto.setPassword(userEntity.getPassword());
        dto.setUsername(userEntity.getUsername());
        return dto;
    }
    public static   UserEntity DTOtoEntity(UserDTO userDTO){
        UserEntity entity = new UserEntity();
        entity.setId(userDTO.getId());
        entity.setFullName(userDTO.getFullName());
        entity.setPassword(userDTO.getPassword());
        entity.setStatus(userDTO.getStatus());
        entity.setUsername(userDTO.getUsername());
        return entity;
    }
}
