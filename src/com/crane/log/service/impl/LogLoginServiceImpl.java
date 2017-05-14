package com.crane.log.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crane.log.dao.LoginLogDao;
import com.crane.log.model.LoginLog;
import com.crane.log.service.LogLoginService;
@Service("logLoginServiceImpl")
public class LogLoginServiceImpl implements LogLoginService {
    @Autowired
    private LoginLogDao loginLogDao;

    @Override
    public void add_log(LoginLog loginLog ) {
        try{
            this.loginLogDao.add_log(loginLog);
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("日志保存失败");
        }
    }
}
