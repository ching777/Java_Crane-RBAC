package com.crane.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request , HttpServletResponse response , Object handler )
            throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute("session_user")==null){
            request.setAttribute("message" , "您没有登录");
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request , response);
            return false;
        }else{
            return true;
        }
    }
    
}
