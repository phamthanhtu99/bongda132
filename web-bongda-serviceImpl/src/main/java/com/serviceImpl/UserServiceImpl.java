package com.serviceImpl;

import com.BeanUtils.RoleBeanUtils;
import com.BeanUtils.UserBeanUtils;
import com.Service.UserSerice;
import com.dto.RoleDTO;
import com.dto.UserDTO;
import com.persisterce.RoleEntity;
import com.persisterce.UserEntity;
import com.repository.RoleReository;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserSerice {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserBeanUtils beanUtils;
    @Autowired BCryptPasswordEncoder encode;
    @Autowired
    RoleBeanUtils roleBeanUtils;
    @Autowired
    RoleReository roleReository;
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDTO save(UserDTO dto) {
        RoleEntity roleEntity = roleReository.findOneByCode("USER");
        dto.setPassword(encode.encode(dto.getPassword()));
        dto.setStatus(1);
        UserEntity entity= beanUtils.DTOtoEntity(dto);
        entity.setRoleEntity(Collections.singletonList(roleEntity));
        return beanUtils.EntitytoDTO(repository.save(entity)) ;
    }

    @Override
    public UserDTO FindOneByUsername(String username) {
        UserDTO dto = UserBeanUtils.EntitytoDTO(userRepository.findOneByUsername(username));
        return dto;
    }
}
