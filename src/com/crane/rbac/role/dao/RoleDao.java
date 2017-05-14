package com.crane.rbac.role.dao;

import java.util.List;

import com.crane.rbac.role.model.Role;

public interface RoleDao {
    public List<Role> roleList();
    public int valid(String role_key);
    public void add(Role role);
    public Role load(Integer role_id);
    public void role_update(Role role);
    public void delete(Integer role_id);
}
