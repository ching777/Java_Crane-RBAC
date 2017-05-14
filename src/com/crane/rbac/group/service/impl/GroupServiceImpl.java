package com.crane.rbac.group.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crane.rbac.group.dao.GroupDao;
import com.crane.rbac.group.exception.GroupException;
import com.crane.rbac.group.model.Group;
import com.crane.rbac.group.service.GroupService;
import com.crane.rbac.user.model.User;
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Override
    public List<Group> list() {
        List<Group> list= this.groupDao.list();
        return list;
    }

    @Override
    public void groupAdd(Group group ) {
        try{
            this.groupDao.groupAdd(group);
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("添加失败");
        }
    }
    
    
    @Override
    public List<User> groupUserInfo(Integer group_id ) {
        return this.groupDao.groupUserInfo(group_id);
    }

    @Override
    public int removeUserGroup(Integer user_id ) {
        int updates = 0;
        try{
            updates = this.groupDao.removeUserGroup(user_id);
        }catch(GroupException e){
            throw new GroupException("GroupServiceImpl类中removeUserGroup方法,移除失败");
        }
        return updates;
    }
    
    @Override
    public Group getGroupInfo(Integer group_id ) {
        return this.groupDao.getGroupInfo(group_id);
    }
    
    @Override
    public void checkGroupName(String group_name ) {
        int count = this.groupDao.checkGroupName(group_name);
        if(count>0){
            throw new GroupException("该组已经存在,请输入其他");
        }
    }

    @Override
    public int groupUpdate(Group group ) {
        int updates = 0;
        try{
            updates = this.groupDao.groupUpdate(group);
        }catch(GroupException e){
            throw new GroupException("GroupServiceImpl类中groupUpdate方法,修改失败");
        }
        return updates;
    }
    
    @Override
    public int deleteGroup(Integer group_id ) {
        int updates = 0;
        try{
            updates = this.groupDao.deleteGroup(group_id);
        }catch(GroupException e){
            throw new GroupException("GroupServiceImpl类中deleteGroup方法,删除失败");
        }
        return updates;
    }
}
