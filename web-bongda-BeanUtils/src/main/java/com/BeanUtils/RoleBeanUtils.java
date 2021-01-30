package com.BeanUtils;

import com.dto.RoleDTO;
import com.persisterce.RoleEntity;
import org.springframework.stereotype.Component;

@Component
public class RoleBeanUtils {
    public RoleEntity DTOtoEntity(RoleDTO dto){
        RoleEntity entity = new RoleEntity();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        return entity;
    }
    public RoleDTO EntitytoDTO (RoleEntity entity){
        RoleDTO dto =new RoleDTO();
        dto.setCode(entity.getCode());
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
