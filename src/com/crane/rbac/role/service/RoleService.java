package com.crane.rbac.role.service;

import java.util.List;

import com.crane.rbac.role.model.Role;

public interface RoleService {
    public List<Role> roleList();
    public void valid(String role_key);
    public void add(Role role);
    public Role load(Integer role_id);
    public void updateResource(Integer role_id,Integer[] resources);
    public void role_update(Role role);
    public void delete(Integer role_id);
}
