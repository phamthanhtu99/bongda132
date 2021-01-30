package com.Controllerbongda.web;

import com.Controllerbongda.Command.Team_UserCommand;
import com.Service.Team_Service;
import com.common.SystemConstant;
import com.dto.TeamDTO;
import com.dto.Team_userDTO;
import com.dto.UserDTO;
import com.google.api.services.drive.Drive;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.google.api.GoogleDriveUtils;

import java.io.*;
import java.util.List;
import java.util.Map;

@Controller(value = "teamofhome")
public class teamController {
    @Autowired
    private Team_Service team_service;
    @Autowired private Team_UserCommand team_userCommand;
    @RequestMapping(value = "/trang-chu/danh-sach-team",method = RequestMethod.GET)
    public ModelAndView viewsListTeam(@RequestParam("page") int page, @RequestParam("limit") int limit){
//        TeamDTO dto = new TeamDTO();
        Team_userDTO dto = new Team_userDTO();
        dto.setPage(page);
        dto.setLimit(limit);
        dto. setTotalItem(team_service.getTotalItem());
        dto.setTotalPage((int) Math.ceil((double) dto.getTotalItem()/dto.getLimit()));
        Pageable pageable =new PageRequest(page-1,limit);
        ModelAndView view = new ModelAndView("web/List_team");

        Map<List<TeamDTO>, List<UserDTO>> map = team_userCommand.teamDTOUserDTO(1,pageable);
//        dto.setListResult(team_service.findallbystatus(1,pageable));
        view.addObject("page",dto);
        view.addObject(SystemConstant.List,map);
        return view;
    }
    @RequestMapping(value ="/trang-chu/danh-sach-team/tao-doi" ,method = RequestMethod.GET)
    public ModelAndView Addteam(){
        ModelAndView view = new ModelAndView("web/Add_Team");
        view.addObject("team",new TeamDTO());
        return view;
    }


}
