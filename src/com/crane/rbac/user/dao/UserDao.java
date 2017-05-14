package com.crane.rbac.user.dao;

import java.util.List;
import java.util.Map;

import com.crane.commons.model.Pager;
import com.crane.rbac.user.model.User;
import com.crane.rbac.user.model.UserDetail;
public interface UserDao {
    User login(String account,String password);

    public List<User> find(Pager pager);
    public int find_count(Pager pager);

    public Map<String,Object>getPhtoto(Integer user_id);
    
    public User getUserDetailByPK(Integer user_id);
    //检查账号是否重复
    public int checkAccount(String account);
    //检查电话是否重复
    public int checkTel(String tel);
    //检查邮箱是否重复
    public int checkEmail(String email);
    //添加账号
    public int userAdd(User user);
    //修改账号
    public void userUpdate(User user);
    //删除账号
    public void userDelete(Integer user_id);
    //添加用户信息
    void userDetailadd(UserDetail userDetail);
    //修改fk_user_id 外键
    int updateUserfk_user_detail_id(Integer detail_id,Integer user_id);
    //修改userDetail
    void userDetailUpdate(UserDetail userDetail);
}
