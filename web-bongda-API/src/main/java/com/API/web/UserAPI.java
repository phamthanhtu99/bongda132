package com.API.web;

import com.dto.UserDTO;
import com.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "useapiofweb")
public class UserAPI {
    @Autowired
    private UserServiceImpl userService;

    @Autowired BCryptPasswordEncoder bCryptPasswordEncoder;
    @Transactional
    @PostMapping("/api/use")
    public UserDTO save(@RequestBody UserDTO dto) {

        return  userService.save(dto);
    }


}
