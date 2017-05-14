package com.crane.rbac.group.service;

import java.util.List;

import com.crane.rbac.group.model.Group;
import com.crane.rbac.user.model.User;

public interface GroupService {
    List<Group> list ();
    void groupAdd(Group group);
    //查询组用户信息
    List<User>groupUserInfo(Integer group_id);
    //移除用户分组
    int removeUserGroup(Integer user_id);
    //查询组信息
    Group getGroupInfo(Integer group_id);
    //检查组名字
    void checkGroupName(String group_name);
    //修改组信息
    int groupUpdate(Group group);
    //删除组
    int deleteGroup(Integer group_id);
}
