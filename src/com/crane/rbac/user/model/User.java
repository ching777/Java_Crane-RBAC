package com.crane.rbac.user.model;

import com.crane.rbac.group.model.Group;
import com.crane.rbac.role.model.Role;

public class User {

    private Integer user_id;
    private String account;
    private String password;
    private String email;
    private String tel;
    private Integer user_status;
    private Integer fk_group_id;
    private Integer fk_user_detail_id;
    private Integer fk_role_id;
    private UserDetail userDetail;
    private Role role;
    private Group group;
    
    public UserDetail getUserDetail() {
        return this.userDetail;
    }
    public void setUserDetail(UserDetail userDetail ) {
        this.userDetail = userDetail;
    }
    public Role getRole() {
        return this.role;
    }
    public void setRole(Role role ) {
        this.role = role;
    }
    public Group getGroup() {
        return this.group;
    }
    public void setGroup(Group group ) {
        this.group = group;
    }
    public Integer getUser_id() {
        return this.user_id;
    }
    public void setUser_id(Integer user_id ) {
        this.user_id = user_id;
    }
    public String getAccount() {
        return this.account;
    }
    public void setAccount(String account ) {
        this.account = account;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password ) {
        this.password = password;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email ) {
        this.email = email;
    }
    public Integer getUser_status() {
        return this.user_status;
    }
    public void setUser_status(Integer user_status ) {
        this.user_status = user_status;
    }
    public Integer getFk_group_id() {
        return this.fk_group_id;
    }
    public void setFk_group_id(Integer fk_group_id ) {
        this.fk_group_id = fk_group_id;
    }
    public Integer getFk_user_detail_id() {
        return this.fk_user_detail_id;
    }
    public void setFk_user_detail_id(Integer fk_user_detail_id ) {
        this.fk_user_detail_id = fk_user_detail_id;
    }
    public Integer getFk_role_id() {
        return this.fk_role_id;
    }
    public void setFk_role_id(Integer fk_role_id ) {
        this.fk_role_id = fk_role_id;
    }
    @Override
    public String toString() {
        return "User [user_id=" + this.user_id + ", account=" + this.account + ", password=" + this.password
                + ", email=" + this.email + ", tel=" + this.tel + ", user_status=" + this.user_status + ", fk_group_id="
                + this.fk_group_id + ", fk_user_detail_id=" + this.fk_user_detail_id + ", fk_role_id=" + this.fk_role_id
                + ", userDetail=" + this.userDetail + ", role=" + this.role + ", group=" + this.group + "]";
    }
    public String getTel() {
        return this.tel;
    }
    public void setTel(String tel ) {
        this.tel = tel;
    }
    
    
}
