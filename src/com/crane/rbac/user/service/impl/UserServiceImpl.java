package com.crane.rbac.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crane.commons.model.Pager;
import com.crane.rbac.user.dao.UserDao;
import com.crane.rbac.user.dao.UserDetailDao;
import com.crane.rbac.user.exception.UserException;
import com.crane.rbac.user.model.User;
import com.crane.rbac.user.model.UserDetail;
import com.crane.rbac.user.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserDetailDao userDetailDao;
    @Override
    public User checkUser(String account,String password){
        User user = this.userDao.login(account , password);
        if(user!=null){
            if(user.getUser_status()!=-1){
                return user;
            }else{
                throw new UserException("该用户已禁用");
            }
        }else{
            throw new UserException("用户密码错误");
        }
    }

    @Override
    public Pager find(Pager pager ) {
        List<User> userList = this.userDao.find(pager);
        int totalCount = this.userDao.find_count(pager);
        pager.setTotalCount(totalCount);
        pager.setDatas(userList);
        return pager;
    }
    @Override
    public Map<String , Object> getPhtoto(Integer user_id ) {
        return this.userDao.getPhtoto(user_id);
    }
    @Override
    public User getUserDetailByPK(Integer user_id ) {
        return this.userDao.getUserDetailByPK(user_id);
    }

    @Override
    public void checkAccount(String account ) {
        int count = this.userDao.checkAccount(account);
        if(count>0){
            throw new UserException("该账户已存在,请输入其他用户名");
        }
    }
    
    @Override
    public void userAdd(User user ) {
        try{
            this.userDao.userAdd(user);
        }catch(UserException e){
            e.printStackTrace();
            throw new UserException("User类中的UserServiceImpl方法,添加失败");
        }
    }
    @Override
    public void userUpdate(User user ) {
        try{
            this.userDao.userUpdate(user);
        }catch(UserException e){
            e.printStackTrace();
            throw new UserException("User类中的userUpdate方法,修改失败");
        }

    }
    
    @Override
    public void checkTel(String  tel) {
        int countTel = this.userDao.checkTel(tel);
        // int countEmail = this.userDao.checkEmail(user.getEmail());
        if(countTel>0){
            throw new UserException("该电话已被使用,请输入其他的电话号码");
        }
    }
    @Override
    public void checkEmail(String  email) {
        int countEmail = this.userDao.checkEmail(email);
        if(countEmail>0){
            throw new UserException("该邮箱已被使用,请输入其他的邮箱");
        }
    }
    
    @Override
    public void userDelete(Integer user_id ) {
        try{
            this.userDao.userDelete(user_id);
        }catch(UserException e){
            e.printStackTrace();
            throw new UserException("User类中的userDelete方法,删除失败");
        }
    }

    @Override
    public Integer userDetailadd(UserDetail userDetail ) {
        try{
            this.userDetailDao.userDetailadd(userDetail);
            return userDetail.getId();
        }catch(UserException e){
            e.printStackTrace();
            throw new UserException("User类中的userDetailadd方法,添加失败");
        }
    }

    @Override
    public int updateUserfk_user_detail_id(Integer detail_id,Integer user_id ) {
        try{
            return this.userDao.updateUserfk_user_detail_id(detail_id,user_id);
        }catch(UserException e){
            e.printStackTrace();
            throw new UserException("User类中的updateUserfk_user_detail_id方法,修改失败");
        }
    }

    @Override
    public void userDetailUpdate(UserDetail userDetail ) {
        try{
            this.userDetailDao.userDetailUpdate(userDetail);
        }catch(UserException e){
            e.printStackTrace();
            throw new UserException("User类中的userDetailUpdate方法,修改失败");
        }
    }
    
    @Override
    public void delUserDetail(Integer id ) {
        try{
            this.userDetailDao.delUserDetail(id);
        }catch(UserException e){
            e.printStackTrace();
            throw new UserException("User类中的delUserDetail方法,删除失败");
        }
    }
    
    @Override
    public void updatePhoto(Integer user_id ,Integer fk_user_detail_id, String photo ) {
        UserDetail us = new UserDetail();
        us.setPhoto(photo);
        try{
            if(fk_user_detail_id==null){
                this.userDetailDao.userDetailadd(us);
                this.userDao.updateUserfk_user_detail_id(us.getId() , user_id);
            }else{
                us.setId(fk_user_detail_id);
                this.userDetailDao.userDetailUpdate(us);
            }
        }catch(UserException e){
            e.printStackTrace();
            throw new UserException("User类中的updatePhoto方法,修改失败");
        }

    }
}
