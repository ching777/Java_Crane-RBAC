package com.crane.rbac.role.model;

public class Role {
    private Integer role_id;
    private String role_name;
    private Integer role_status;
    private String role_key;
    private String market;
    public Integer getRole_id() {
        return this.role_id;
    }
    public void setRole_id(Integer role_id ) {
        this.role_id = role_id;
    }
    public String getRole_name() {
        return this.role_name;
    }
    public void setRole_name(String role_name ) {
        this.role_name = role_name;
    }
    public Integer getRole_status() {
        return this.role_status;
    }
    public void setRole_status(Integer role_status ) {
        this.role_status = role_status;
    }
    public String getRole_key() {
        return this.role_key;
    }
    public void setRole_key(String role_key ) {
        this.role_key = role_key;
    }
    public String getMarket() {
        return this.market;
    }
    public void setMarket(String market ) {
        this.market = market;
    }


}
