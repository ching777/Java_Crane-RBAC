package com.crane.rbac.group.dao;

import java.util.List;

import com.crane.rbac.group.model.Group;
import com.crane.rbac.user.model.User;

public interface GroupDao {
    //带统计人数
    List<Group> list();
    void groupAdd(Group group);
    //查询当前组多少人
    int getCountPeople(Integer group_id);
    //查询组用户信息
    List<User>groupUserInfo(Integer group_id);
    //移除用户分组
    int removeUserGroup(Integer user_id);
    //查询组信息
    Group getGroupInfo(Integer group_id);
    //检查组名字
    int checkGroupName(String group_name);
    //修改组信息
    int groupUpdate(Group group);
    //删除组
    int deleteGroup(Integer group_id);
}
