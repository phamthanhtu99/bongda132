package com.API.web;

import com.Service.Team_Service;
import com.Service.Team_userService;
import com.dto.TeamDTO;
import com.dto.Team_userDTO;
import com.dto.UserDTO;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@RestController(value = "TeamUserAPIofweb")
public class TeamUserAPI {
    @Autowired
    private Team_userService team_userService;

    @PutMapping(value = "/api/TeamUserAPI/{teamDTO}/{UerDTO}")
    public ResponseEntity<Object> updata(@PathVariable("teamDTO") Long team,@PathVariable ("UerDTO") Long user){
        return  new ResponseEntity<>("ád", HttpStatus.OK);
    }
   /* @PostMapping(value ="/api/TeamUserAPI" )
    @Transactional
    public ResponseEntity<Object> save(@RequestParam(value = "TeamDTO",required = false) String  team) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,String> map = objectMapper.readValue(team,Map.class);
        Team_userDTO userDTO = team_userDTO(map);
        try{
            Team_userDTO teamUserDTO = team_userService.AddTeam(userDTO);
            return new ResponseEntity<>("á",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("á",HttpStatus.FAILED_DEPENDENCY);
        }

    }*/
   @PostMapping(value ="/api/TeamUserAPI" )
   public ResponseEntity<Object> save(@RequestBody Team_userDTO dto) throws Exception {

       try{


           Team_userDTO teamUserDTO = team_userService.AddTeam(dto);
           return new ResponseEntity<>(teamUserDTO,HttpStatus.OK);
       }catch (Exception e){
           return new ResponseEntity<>("á",HttpStatus.FAILED_DEPENDENCY);
       }

   }
    private Team_userDTO team_userDTO(Map<String,String> map){
        Team_userDTO teamUserDTO = new Team_userDTO();
        for (Map.Entry<String,String> entry: map.entrySet()){
            if (entry.getKey().equals("teamDTO")){
                TeamDTO dto = new TeamDTO();
                dto.setId(Long.valueOf(entry.getValue()));
                teamUserDTO.setTeamDTO(dto);
            }else  {
                UserDTO dto = new UserDTO();
                dto.setId(Long.valueOf(entry.getValue()));
                teamUserDTO.setUserDTO(dto);
            }
        }
        return  teamUserDTO;
    }
}

