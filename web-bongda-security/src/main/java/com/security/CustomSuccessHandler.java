package com.security;

import com.Service.Team_userService;
import com.common.SecurityUtils;
import com.common.SystemConstant;
import com.dto.Status_team_useDTO;
import com.dto.Team_userDTO;
import com.dto.UserDTO;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private Team_userService teamUserService;
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy() ;
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);

        }
    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    private String determineTargetUrl(Authentication authentication) {
        String url = "";
        List<String> roles = SecurityUtils.getAuthorities();
        if (isAdmin(roles)) {
            url = "/trang-chu";
        } else if (isUser(roles)) {
            url = "/trang-chu";
        }
        return url;
    }

    private boolean isAdmin(List<String> roles) {
        if (roles.contains("ADMIN")) {
            return true;
        }
        return false;
    }

    private boolean isUser(List<String> roles) {
        if (roles.contains("USER")) {
            return true;
        }
        return false;
    }
    public Map<Team_userDTO, List<Team_userDTO>> TeamUser(UserDTO dto) {
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
