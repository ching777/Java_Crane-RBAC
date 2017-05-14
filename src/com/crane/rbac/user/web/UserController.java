package com.crane.rbac.user.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.crane.commons.model.Pager;
import com.crane.rbac.group.service.GroupService;
import com.crane.rbac.role.service.RoleService;
import com.crane.rbac.user.exception.UserException;
import com.crane.rbac.user.model.User;
import com.crane.rbac.user.service.UserService;
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private GroupService groupService;

    
    @GetMapping("nav/user/list")
    public String find(Pager pager,Model model){
        model.addAttribute("pager" , this.userService.find(pager));
        return "jsp/user/list";
    }


    @PostMapping("sys/user/checkUpdateUser")
    @ResponseBody
    public Map<String,Object> checkTel(User user){
        Map<String , Object> map = new HashMap<String , Object>();
        try{
            this.userService.checkTel(user.getTel());
        }catch(Exception e){
            map.put("flagTel" , "error");
            map.put("message" , e.getMessage());
        }
        try{
            this.userService.checkEmail(user.getEmail());
        }catch(Exception e){
            map.put("flagEmail" , "error");
            map.put("messageEmail" , e.getMessage());
        }
        return map;
    }

    @GetMapping("sys/user/update/photo")
    public String photo(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("session_user");
        System.out.println(user);
        model.addAttribute("photoMap" , this.userService.getPhtoto(user.getUser_id()));
        return "jsp/user/photo";
    }
    @PostMapping("sys/user/update/photo")
    public String photo(Model model,HttpServletRequest request,MultipartFile photo,Integer user_id,Integer fk_user_detail_id) throws IllegalStateException, IOException {
        //获取路径
        String path  = request.getSession().getServletContext().getRealPath("/attr/");
        String path2  = request.getSession().getServletContext().getRealPath("/attr/e6acbf28-2069-4248-94fe-ad40196c34e8.jpg");
        //创建一个文件夹
        File delFile = new File(path2);
        if(delFile.exists()){
            if(delFile.delete()){
                System.out.println("删除成功");
            } else{
                System.out.println("删除失败");
            }

        }else{
            System.out.println("文件不存在");
        }

        File folder = new File(path);
        if(!folder.exists()){
            folder.mkdirs();
        }
        
        //获取上传文件名
        String fileNane = photo.getOriginalFilename();
        //获取main 类型
        String ext = FilenameUtils.getExtension(fileNane);
        //新文件名
        String newFileName = UUID.randomUUID().toString()+"."+ext;
        //创建一个新文件
        File newFile = new File(path+"/"+newFileName);
        //上传文件
        photo.transferTo(newFile);
        try{
            this.userService.updatePhoto(user_id ,fk_user_detail_id, newFileName);
            model.addAttribute("flag" , "success");
            model.addAttribute("message" , "修改成功");
        }catch(UserException e){
            model.addAttribute("flag" , "error");
            model.addAttribute("message" , e.getMessage());
        }
        return "jsp/msg";
    }
    
    @GetMapping("sys/user/update/{user_id}")
    public String update(@PathVariable Integer user_id,Model model){
        model.addAttribute("user" , this.userService.getUserDetailByPK(user_id));
        model.addAttribute("roleList" , this.roleService.roleList());
        model.addAttribute("groupList" , this.groupService.list());
        return "jsp/user/update";
    }
    @PutMapping("sys/user/update")
    public String update(User user , Model model){
        try{
            this.userService.userUpdate(user);
            model.addAttribute("flag" , "success");
            model.addAttribute("message" , "修改成功");
        }catch(UserException e){
            model.addAttribute("flag" , "error");
            model.addAttribute("message" , e.getMessage());
        }
        return "jsp/msg";
    }
    
    @DeleteMapping("sys/user/delete")
    @ResponseBody
    public Map<String,Object> deleteUser(User user){
        Integer  fk_user_detail_id = user.getFk_user_detail_id();
        Map<String , Object> map = new HashMap<String , Object>();
        try{
            this.userService.userDelete(user.getUser_id());
            if(fk_user_detail_id!=null){
                this.userService.delUserDetail(fk_user_detail_id);
            }
        }catch(Exception e){
            map.put("flagTel" , "error");
            map.put("message" , e.getMessage());
        }
        return map;
    }
    
    
    
    @GetMapping("sys/user/getAddJsp")
    public String getAddJsp(){
        return "jsp/user/add";
    }
    
    @PostMapping("sys/user/checkAccount")
    @ResponseBody
    public Map<String,Object> checkAccount(String account){
        Map<String  , Object> map = new HashMap<String  , Object>();
        try{
            this.userService.checkAccount(account);
        }catch(UserException e){
            map.put("flag" , "error");
            map.put("message" ,e.getMessage() );
        }
        return map;
    }
    
    
    
    @PostMapping("sys/user/add")
    public String add(Model model,User user){
        try{
            this.userService.userAdd(user);
            model.addAttribute("flag" , "success");
            model.addAttribute("message" , "添加成功");
        }catch(UserException e){
            model.addAttribute("flag" , "error");
            model.addAttribute("message" , e.getMessage());
        }
        return "jsp/msg";
    }
    
    
    
    
}
