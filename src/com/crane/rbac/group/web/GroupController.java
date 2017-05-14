package com.crane.rbac.group.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crane.rbac.group.exception.GroupException;
import com.crane.rbac.group.model.Group;
import com.crane.rbac.group.service.GroupService;

@Controller
public class GroupController {
    @Autowired
    private GroupService groupService;
    //    = new GroupServiceImpl();

    @GetMapping("/nav/group/list")
    public String list(Model model){
        model.addAttribute("list1111" , this.groupService.list());
        return "jsp/group/list";
    }
    
    @GetMapping("sys/group/groupInfo/{group_id}")
    public String userInfo(@PathVariable Integer group_id , Model model){
        model.addAttribute("user" , this.groupService.groupUserInfo(group_id));
        return "jsp/group/groupInfo";
    }

    @GetMapping("sys/group/groupUpdate/{group_id}")
    public String groupUpdate(@PathVariable Integer group_id , Model model){
        model.addAttribute("group" ,this.groupService.getGroupInfo(group_id));
        return "jsp/group/update";
    }
    
    @GetMapping("/sys/group/add")
    public String add(){
        return "jsp/group/add";
    }
    
    @PostMapping("sys/group/checkGroupName")
    @ResponseBody
    public Map<String,Object> checkGroupName(String group_name){
        Map<String , Object> map = new HashMap<String , Object>();
        try{
            this.groupService.checkGroupName(group_name);
        }catch(GroupException e){
            map.put("flag" , "error");
            map.put("message" , e.getMessage());
        }
        return map;
    }
    @DeleteMapping("sys/group/deleteGruop")
    @ResponseBody
    public Map<String,Object> deleteGruop(Integer group_id){
        Map<String , Object> map = new HashMap<String , Object>();
        try{
            int updates = this.groupService.deleteGroup(group_id);
            if(updates>0){
                map.put("flag" , "success");
            }else{
                map.put("message" , "删除失败");
            }
        }catch(GroupException e){
            map.put("message" , e.getMessage());
        }
        return map;
    }
    @PutMapping("sys/group/removeUser")
    @ResponseBody
    public Map<String,Object> removeUser(Integer user_id){
        Map<String , Object> map = new HashMap<String , Object>();
        try{
            int updates = this.groupService.removeUserGroup(user_id);
            if(updates>0){
                map.put("flag" , "success");
            }else{
                map.put("message" , "删除失败");
            }
        }catch(GroupException e){
            map.put("message" , e.getMessage());
        }
        return map;
    }

    @PutMapping("sys/group/groupUpdate")
    public String groupUpdate(Group group,Model model){
        try{
            int updates = this.groupService.groupUpdate(group);
            if(updates>0){
                model.addAttribute("flag" , "success");
                model.addAttribute("message" , "修改成功");
            }else{
                model.addAttribute("flag" , "error");
                model.addAttribute("message" , "修改失败");
            }
        }catch(GroupException e){
            model.addAttribute("flag" , "error");
            model.addAttribute("message" , e.getMessage());
        }
        return "jsp/msg";
    }

    @PostMapping("/sys/group/add")
    public String add(Group group,Model model){
        try{
            this.groupService.groupAdd(group);
            model.addAttribute("flag" , "success");
            model.addAttribute("message" , "添加成功");
        }catch(Exception e){
            e.printStackTrace();
            model.addAttribute("flag" , "error");
            model.addAttribute("message" , e.getMessage());
        }
        return "jsp/msg";
    }

}
