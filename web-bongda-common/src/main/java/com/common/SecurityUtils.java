package com.common;

import com.Service.Team_userService;
import com.dto.MyUser;
import com.dto.Status_team_useDTO;
import com.dto.Team_userDTO;
import com.dto.UserDTO;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class SecurityUtils {

        public static MyUser getprincipal(){
        MyUser myUser = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return myUser;
        }
        public static List<String> getAuthorities() {
                List<String> results = new ArrayList<>();
                List<GrantedAuthority> authorities = (List<GrantedAuthority>)(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
                for (GrantedAuthority authority : authorities) {
                        results.add(authority.getAuthority());
                }
                return results;
        }
        public  Map<Team_userDTO, List<Team_userDTO>> displayTeam(){

                Map<Team_userDTO, List<Team_userDTO>> listMap = new HashMap<>();
                UserDTO dto = new UserDTO();
                dto.setId(getprincipal().getId());
                return listMap;
        }



}
