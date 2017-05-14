package com.crane.rbac.user.dao;

import com.crane.rbac.user.model.UserDetail;
public interface UserDetailDao {

    //添加用户信息
    void userDetailadd(UserDetail userDetail);
    //修改userDetail
    void userDetailUpdate(UserDetail userDetail);
    //删除userDetail关联
    void delUserDetail(Integer id);
    //修改头像
    void updatePhoto(Integer user_id,String photo);
}
