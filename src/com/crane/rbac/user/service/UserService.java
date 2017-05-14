package com.crane.rbac.user.service;

import java.util.Map;

import com.crane.commons.model.Pager;
import com.crane.rbac.user.model.User;
import com.crane.rbac.user.model.UserDetail;

public interface UserService {
    User checkUser(String account,String password);
    Pager find(Pager pager);
    public Map<String,Object>getPhtoto(Integer user_id);

    public User getUserDetailByPK(Integer user_id);
    //删除userDetail关联
    void delUserDetail(Integer id);
    //检查账号是否重复
    public void checkAccount(String account);
    //添加账号
    public void userAdd(User user);
    //修改账号
    public void userUpdate(User user);
    //检查电话是否重复
    public void checkTel(String tel);
    //检查邮箱是否重复
    public void checkEmail(String email);
    //删除账号
    public void userDelete(Integer user_id);
    //添加用户信息
    Integer userDetailadd(UserDetail userDetail);
    //修改fk_user_id 外键
    int updateUserfk_user_detail_id(Integer detail_id,Integer user_id);
    //修改userDetail
    void userDetailUpdate(UserDetail userDetail);
    //修改头像
    void updatePhoto(Integer user_id,Integer fk_user_detail_id,String photo);
}
