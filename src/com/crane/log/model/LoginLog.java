package com.crane.log.model;

import java.util.Date;

public class LoginLog implements java.io.Serializable{
    private String login_id;
    private Date login_time;
    private String account;
    private String ip;
    public String getLogin_id() {
        return this.login_id;
    }
    public void setLogin_id(String login_id ) {
        this.login_id = login_id;
    }
    public Date getLogin_time() {
        return this.login_time;
    }
    public void setLogin_time(Date login_time ) {
        this.login_time = login_time;
    }
    public String getAccount() {
        return this.account;
    }
    public void setAccount(String account ) {
        this.account = account;
    }
    public String getIp() {
        return this.ip;
    }
    public void setIp(String ip ) {
        this.ip = ip;
    }
    
}
