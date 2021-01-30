package com.API.web;

import com.Service.Team_Service;
import com.Service.Team_userService;
import com.common.webConstan;
import com.dto.TeamDTO;
import com.serviceImpl.Team_UerServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web.google.api.handler;


import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController(value = "teamofapi")
public class TeamAPI {
    @Autowired
   private Team_Service team_service;
    @Autowired
    private Team_userService team_uerService;
    @Transactional
    @PostMapping(value = "/api/team",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object>  addteam (@RequestParam("file")MultipartFile multipartFile,
                                           @RequestParam(value = "datateam")  String teamDTO) throws IOException, GeneralSecurityException {
        try {
               ObjectMapper objectMapper = new ObjectMapper();
               TeamDTO dto = objectMapper.readValue(teamDTO,TeamDTO.class);
               dto.setImge(handler.handleImge(multipartFile,"anhbongda"));
                team_uerService.Createteam(dto);
            return  new ResponseEntity<>(dto,HttpStatus.OK);
           }catch (IOException e) {
                String dto="thất bại";
            return   new ResponseEntity<>(dto,HttpStatus.OK);
           }
    }
    @DeleteMapping(value = "/api/team")
    public void aVoid(){

    }
}
