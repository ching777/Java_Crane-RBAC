package com.crane.commons.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.crane.rbac.user.model.User;
import com.crane.resource.service.ResourceService;

@Controller
public class MainController {

    @Autowired
    @Qualifier("resourceServiceImpl")
    private ResourceService resourceService;

    @GetMapping("/sys/main")
    public String main(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("session_user");
        Integer role_id = user.getFk_role_id();
        if(role_id==null){
            model.addAttribute("message","该用户文分配角色,无法使用该系统");
            return "jsp/login";
        }else{
            model.addAttribute("childList" , this.resourceService.getSelectedResourceListByRoleId(role_id));
            model.addAttribute("parentList" , this.resourceService.getSelectParentResourceListByRoleId(role_id));
            return "jsp/main";
        }
    }

}
