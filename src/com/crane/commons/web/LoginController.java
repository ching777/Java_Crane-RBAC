package com.crane.commons.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.crane.log.model.LoginLog;
import com.crane.log.service.LogLoginService;
import com.crane.rbac.user.exception.UserException;
import com.crane.rbac.user.model.User;
import com.crane.rbac.user.service.UserService;

@Controller
@SessionAttributes("session_user")
public class LoginController extends BaseController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;
    //    = new UserServiceImpl();
    @Autowired
    private LogLoginService logLoginService;
    //= new LogLoginServiceImpl();
    
    @GetMapping("/sys/login")
    public String login(){
        return "jsp/login";
    }
    @GetMapping("sys/user/userDetailUpdate")
    public String userDetailUpdate( ){
        return "jsp/user/userDetailUpdate";
    }
    
    @PostMapping("sys/user/userDetailUpdate")
    public String userDetailUpdate(User user, Model model){
        System.out.println(user);
        Integer user_id = user.getUser_id();
        Integer fk_user_detail_id = user.getFk_user_detail_id();
        if(fk_user_detail_id==null){
            try{
                int detail_id = this.userService.userDetailadd(user.getUserDetail());
                this.userService.updateUserfk_user_detail_id(detail_id,user_id);
                model.addAttribute("flag" , "success");
                model.addAttribute("message" , "修改成功");
            }catch(UserException e){
                model.addAttribute("flag" , "error");
                model.addAttribute("message" , e.getMessage());
            }
        }else{
            try{
                user.getUserDetail().setId(fk_user_detail_id);
                this.userService.userDetailUpdate(user.getUserDetail());
                model.addAttribute("flag" , "success");
                model.addAttribute("message" , "修改成功");
            }catch(UserException e){
                model.addAttribute("flag" , "error");
                model.addAttribute("message" , e.getMessage());
            }
        }
        return "jsp/msg";
    }
    

    @PostMapping("/sys/login")
    public String login(String account,String password,Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        LoginLog loginLog = new LoginLog();
        try{
            User user = this.userService.checkUser(account , password);
            if(session.getAttribute("session_user")==null){
                loginLog.setAccount(account);
                loginLog.setIp(request.getRemoteAddr());
                this.logLoginService.add_log(loginLog);
            }
            model.addAttribute("session_user" , user);
            return "redirect:/sys/main";
        }catch(Exception e){
            model.addAttribute("account" , account);
            model.addAttribute("message" , e.getMessage());
            return "jsp/login";
        }
    }
    
    
    @GetMapping("sys/loginOut")
    public String loginOut(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "redirect:/sys/login";
    }
    
    
    
}
