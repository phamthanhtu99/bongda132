package com.serviceImpl;

import com.BeanUtils.UserBeanUtils;
import com.Service.Team_userService;
import com.common.SecurityUtils;
import com.common.SystemConstant;
import com.dto.MyUser;
import com.dto.Status_team_useDTO;
import com.dto.Team_userDTO;
import com.dto.UserDTO;
import com.persisterce.RoleEntity;
import com.persisterce.UserEntity;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class customUserDetailsService implements UserDetailsService {

            @Autowired
    UserRepository userRepository;
    @Autowired
    private  Team_userService teamUserService;

    @Override
    public UserDetails loadUserByUsername(String usernam) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findAllByUsernameAndStatus(usernam, SystemConstant.ACTIVE_STATUS);
        if (userEntity==null){
        throw new UsernameNotFoundException("không có user");
        }
        List<GrantedAuthority>authorities =new ArrayList<>();
        for (RoleEntity entity :userEntity.getRoleEntity()){
            authorities.add(new SimpleGrantedAuthority(entity.getCode()));
        }
        MyUser myUser = new MyUser(userEntity.getUsername(), userEntity.getPassword(),userEntity.getId(),
                true, true, true, true, authorities);
        myUser.setFullname(userEntity.getFullName());
        myUser.setUsername(userEntity.getUsername());
        myUser.setId(userEntity.getId());

            return myUser;



    }
    public  Map<Team_userDTO, List<Team_userDTO>> TeamUser(UserDTO dto) {
        Map<Team_userDTO, List<Team_userDTO>> listMap = new HashMap<>();
        Status_team_useDTO statusTeamUseDTO = new Status_team_useDTO();
        statusTeamUseDTO.setId(SystemConstant.Status_1_hoatdong);
        Team_userDTO teamUserDTO = teamUserService.finDNOeUserAndStatus(dto, statusTeamUseDTO);
        List<Team_userDTO> dtos = new ArrayList<>();
        dtos = teamUserService.FindBayAllUser(teamUserDTO.getTeamDTO());
        listMap.put(teamUserDTO, dtos);

        return listMap;
    }
}
