package com.crane.resource.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crane.resource.exception.ResourceException;
import com.crane.resource.model.Resource;
import com.crane.resource.service.ResourceService;

@Controller
@Scope("prototype")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @GetMapping("nav/resource/tree")
    public String index(Model model){
        model.addAttribute("parentNode" , this.resourceService.getParentId());
        model.addAttribute("childNode" , this.resourceService.getChildId());
        return"jsp/resource/index";
    }
    @GetMapping("sys/resource/{parent_id}/{resource_id}")
    public String load(@PathVariable Integer parent_id,@PathVariable Integer resource_id,Model model){
        model.addAttribute("resource" , this.resourceService.load(resource_id));
        if(parent_id!=-1){
            model.addAttribute("parentNodeList" , this.resourceService.getParentId());
        }
        return "jsp/resource/show";
    }
    //删除子节点
    @DeleteMapping("sys/resource/del")
    @ResponseBody
    public Map<String,Object> del(Integer resource_id){
        Map<String , Object> map = new HashMap<String , Object>();
        try{
            this.resourceService.del(resource_id);
            map.put("flag" , "success");
        }catch(ResourceException e){
            map.put("flag" , "error");
            map.put("message" , e.getMessage());
        }
        return map;
    }
    //查看父节点下是否有子节点
    @PostMapping("sys/resource/getParentResource_id")
    @ResponseBody
    public Map<String,Object> getParentResource_id(Integer resource_id){
        Map<String , Object> map = new HashMap<String , Object>();
        try{
            this.resourceService.getParentResource_id(resource_id);
        }catch(ResourceException e){
            map.put("flag" , "error");
            map.put("message" , e.getMessage());
        }
        return map;
    }
    //删除父节点
    @DeleteMapping("sys/resource/deleteParentNode")
    @ResponseBody
    public Map<String,Object> deleteParentNode(Integer resource_id){
        Map<String , Object> map = new HashMap<String , Object>();
        try{
            this.resourceService.deleteParentNode(resource_id);
        }catch(ResourceException e){
            map.put("flag" , "error");
            map.put("message" , e.getMessage());
        }
        return map;
    }
    //检查子节点名字
    @PostMapping("sys/resource/checkAddChild")
    @ResponseBody
    public Map<String,Object> checkAddChild(Resource resource){
        Map<String , Object> map = new HashMap<String , Object>();
        try{
        }catch(ResourceException e){
            map.put("flag" , "error");
            map.put("message" , e.getMessage());
        }
        return map;
    }
    //检查url
    @PostMapping("sys/resource/checkUrl")
    @ResponseBody
    public Map<String,Object> checkUrl(Resource resource){
        Map<String , Object> map = new HashMap<String , Object>();
        try{
            this.resourceService.checkUrl(resource.getUrl());
        }catch(ResourceException e){
            map.put("urlFlag" , "error");
            map.put("urlMessage" , e.getMessage());
        }

        try{
            this.resourceService.checkResourceNameInparentId(resource.getResource_name() , resource.getParent_id());
        }catch(ResourceException e){
            map.put("flag" , "error");
            map.put("message" , e.getMessage());
        }
        return map;
    }
    //添加子节点
    @PostMapping("sys/resource/addChild")
    public String addChlid(Resource resource,Model model){
        try{
            System.out.println(resource);
            this.resourceService.addChlidNode(resource);
            model.addAttribute("flag" , "success");
            model.addAttribute("message" , "添加成功");
        }catch(ResourceException e){
            model.addAttribute("flag" , "error");
            model.addAttribute("message" , e.getMessage());
        }
        return "jsp/msg";
    }
    


    //检查父节点名字是否重复
    @PostMapping("sys/resource/checkParentName")
    @ResponseBody
    public Map<String,Object> updateParent(Integer resource_id,String resource_name){
        Map<String , Object> map = new HashMap<String , Object>();
        try{
            this.resourceService.checkParentName(resource_id , resource_name);
        }catch(ResourceException e){
            map.put("flag" , "error");
            map.put("message" , e.getMessage());
        }
        return map;
    }
    //添加父节点
    @PostMapping("sys/resource/addParent")
    public String addParent(Resource resource,Model model){

        try{
            this.resourceService.addParentNode(resource);
            model.addAttribute("flag" , "success");
            model.addAttribute("message" , "添加成功");
        }catch(ResourceException e){
            model.addAttribute("flag" , "error");
            model.addAttribute("message" , e.getMessage());
        }
        return "jsp/msg";
    }
    
    
    //修改节点
    @PostMapping("sys/resource/updateNode")
    public String updateNode(Resource resource,Model model){
        try{
            System.out.println(resource);
            this.resourceService.updateResource(resource);
            model.addAttribute("flag" , "success");
            model.addAttribute("message" , "修改成功");
        }catch(ResourceException e){
            model.addAttribute("flag" , "error");
            model.addAttribute("message" , e.getMessage());
        }
        return "jsp/msg";
    }
    


    //跳转添加父节点
    @GetMapping("sys/resource/addParent")
    public String addParent(){
        return "jsp/resource/addParent";
    }
    //跳转添加子节点
    @GetMapping("sys/resource/addChlid")
    public String addChlid(Model model){
        model.addAttribute("parentNodeList" , this.resourceService.getParentId());
        return "jsp/resource/addChlid";
    }


}
