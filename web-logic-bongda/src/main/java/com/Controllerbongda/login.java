package com.Controllerbongda;

import com.dto.UserDTO;
import com.persisterce.UserEntity;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller(value = "login")
public class login {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
    public ModelAndView homepage() {
        ModelAndView mode = new ModelAndView("login");

        return mode;
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accessDenied() {
        return new ModelAndView("redirect:/dang-nhap?accessDenied");
    }

    @RequestMapping(value = "/thoat", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request,response,auth);
        }
        return new ModelAndView("redirect:/trang-chu");
    }
        @RequestMapping(value = "/ajax-fromdangky",method = RequestMethod.GET)
        public ModelAndView fromdangky(){
        ModelAndView view = new ModelAndView("registration");
        view.addObject("user",new UserDTO());
         return view;
        }
}
