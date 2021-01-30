package com.Controllerbongda.web;

import com.Controllerbongda.Command.Team_UserCommand;
import com.common.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.WebFilter;

@Controller(value = "homeofweb")
public class home {
    @Autowired
   private Team_UserCommand team_userCommand;
    @RequestMapping(value = "/trang-chu",method = RequestMethod.GET)
    public ModelAndView homepage(){
        ModelAndView view = new ModelAndView("web/home");
        return view;
    }

}
