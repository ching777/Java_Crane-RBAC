package com.crane.rbac.user.model;

import java.util.Date;

/**
 * Created by Administrator on 2016/12/15 0015.
 */
public class UserDetail implements  java.io.Serializable{
    
    private Integer id;
    private String user_name;
    private String sex;
    private Date birthday;
    private String photo;

    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id ) {
        this.id = id;
    }
    public String getUser_name() {
        return this.user_name;
    }
    public void setUser_name(String user_name ) {
        this.user_name = user_name;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex ) {
        this.sex = sex;
    }
    public Date getBirthday() {
        return this.birthday;
    }
    public void setBirthday(Date birthday ) {
        this.birthday = birthday;
    }
    public String getPhoto() {
        return this.photo;
    }
    public void setPhoto(String photo ) {
        this.photo = photo;
    }
    @Override
    public String toString() {
        return "UserDetail [id=" + this.id + ", user_name=" + this.user_name + ", sex=" + this.sex + ", birthday="
                + this.birthday + ", photo=" + this.photo + "]";
    }
    
}
