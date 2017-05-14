package com.crane.rbac.role.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crane.commons.exception.ValidDataException;
import com.crane.rbac.role.exception.RoleServiceException;
import com.crane.rbac.role.model.Role;
import com.crane.rbac.role.service.RoleService;
import com.crane.resource.service.ResourceService;

@Controller
public class RoleController {

    @Autowired
    @Qualifier("roleServiceImpl")
    private RoleService roleService;
    @Autowired
    private ResourceService resourceService;
    
    @RequestMapping("nav/role/list")
    public String roleList(Model model){
        model.addAttribute("roleList" , this.roleService.roleList());
        return "jsp/role/roleList";
    }
    
    @GetMapping("sys/role/add")
    public String roleAdd(){
        return "jsp/role/add";
    }
    @PostMapping("sys/role/add")
    public String roleAdd(Role role,Model model){
        try{
            this.roleService.add(role);
            model.addAttribute("flag" , "success");
            model.addAttribute("message" , "添加角色成功");
        }catch(RoleServiceException e){
            model.addAttribute("flag" , "error");
            model.addAttribute("message" , e.getMessage());
        }
        return "jsp/msg";
    }

    @PostMapping("sys/role/valid")
    @ResponseBody
    public Map<String,Object> valid(String role_key){
        Map<String , Object> map = new HashMap<String , Object>();
        try{
            this.roleService.valid(role_key);
        }catch(ValidDataException e){
            map.put("flag" , "error");
            map.put("message" , e.getMessage());
        }
        return map;
    }
    @GetMapping("sys/role/{role_id}/resource")
    public String resource (@PathVariable Integer role_id,Model model ){
        model.addAttribute("selectResourceList" , this.resourceService.getSelectedResourceListByRoleId(role_id));
        model.addAttribute("unSelectResourceList" , this.resourceService.getUnSelectedResourceListByRoleId(role_id));
        model.addAttribute("role" , this.roleService.load(role_id));
        return "jsp/role/resourceLR";
    }
    @PutMapping("sys/role/updata/resource")
    public String updata(Integer role_id,Integer[] resources,Model model){
        try{
            this.roleService.updateResource(role_id , resources);
            model.addAttribute("flag" , "success");
            model.addAttribute("message" , "角色设置成功");
            
        }catch(RoleServiceException e){
            model.addAttribute("flag" , "error");
            model.addAttribute("message" , e.getMessage());
        }
        return "jsp/msg";
    }

    @GetMapping("sys/role/update/{role_id}")
    public String update(@PathVariable Integer role_id,Model model){
        model.addAttribute("role" , this.roleService.load(role_id));
        return "jsp/role/update";
    }


    @PutMapping("sys/role/update")
    public String update(Role role,Model model){
        try{
            this.roleService.role_update(role);
            model.addAttribute("flag" , "success");
            model.addAttribute("message" , "角色更新成功");
            
        }catch(RoleServiceException e){
            model.addAttribute("flag" , "error");
            model.addAttribute("message" , e.getMessage());
        }
        return "jsp/msg";
    }

    @DeleteMapping("sys/role/delete")
    @ResponseBody
    public Map<String,Object> delete(Integer role_id){
        
        Map<String , Object> map = new HashMap<String , Object>();
        try{
            this.roleService.delete(role_id);
            map.put("flag" , "success");
        }catch(ValidDataException e){
            map.put("flag" , "error");
            map.put("message" , e.getMessage());
        }
        return map;
    }
}
