package com.crane.rbac.role.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crane.commons.exception.ValidDataException;
import com.crane.rbac.role.dao.RoleDao;
import com.crane.rbac.role.exception.RoleServiceException;
import com.crane.rbac.role.model.Role;
import com.crane.rbac.role.service.RoleService;
import com.crane.resource.dao.ResourceDao;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private ResourceDao resourceDao;
    @Override
    public List<Role> roleList() {
        return this.roleDao.roleList();
    }
    @Override
    public void valid(String role_key ) {
        int count = this.roleDao.valid(role_key);
        if(count>0){
            throw new ValidDataException("角色已经被使用,请重新设置");
        }
    }
    @Override
    public void add(Role role ) {
        try{
            this.roleDao.add(role);
        }catch(RoleServiceException e){
            e.printStackTrace();
            new RoleServiceException("RoleServiceImpl类中的Add方法,添加失败");

        }
        
    }
    @Override
    public Role load(Integer role_id ) {
        return this.roleDao.load(role_id);
    }
    @Override
    public void updateResource(Integer role_id , Integer[] resources ) {
        try{
            this.resourceDao.deleteRoleMappingResource(role_id);
            if(resources!=null&&resources.length>0){
                this.resourceDao.insertRoleMappingResource(role_id , resources);
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new RoleServiceException("RoleServiceImpl类中的updateResource方法,角色分配失败");
        }
    }
    @Override
    public void role_update(Role role ) {
        try{
            this.roleDao.role_update(role);
        }catch(RoleServiceException e){
            e.printStackTrace();
            new RoleServiceException("RoleServiceImpl类中的update方法,更新失败");
        }
    }
    @Override
    public void delete(Integer role_id ) {
        try{
            this.roleDao.delete(role_id);
        }catch(RoleServiceException e){
            e.printStackTrace();
            throw new RoleServiceException("RoleServiceImpl类中的delete方法,删除失败");
        }
    }
}
