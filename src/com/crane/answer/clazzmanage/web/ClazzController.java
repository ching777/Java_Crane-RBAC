package com.crane.answer.clazzmanage.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crane.answer.clazzmanage.model.Clazz;
import com.crane.answer.clazzmanage.service.ClazzService;
import com.crane.answer.studentmanage.exception.StudentException;
import com.crane.commons.model.Pager;
import com.crane.commons.web.BaseController;

@Controller
public class ClazzController extends BaseController{

    @Autowired
    private  ClazzService clazzService;
    
    @GetMapping("answer/clazz/add")
    public String addClazz(Model model){
        return "jsp/clazz/clazzAdd";
    }
    
    @PostMapping("answer/clazz/add")
    public String addClazz(Clazz clazz,Model model){
        try{
            this.clazzService.clazzAdd(clazz);
            model.addAttribute("flag" , "success");
            model.addAttribute("message" , "添加班级成功");
        }catch(StudentException e){
            model.addAttribute("flag" , "error");
            model.addAttribute("message" , e.getMessage());
        }
        return "jsp/msg";
    }
    

    @GetMapping("answer/clazz/find")
    public String find(Model model){
        return "jsp/clazz/clazzList";
    }

    @GetMapping("answer/clazz/list")
    public String clazzList(Pager  pager,Model model){
        List<Clazz> c = this.clazzService.list(pager);
        model.addAttribute("clazzList" , c);
        return "jsp/clazz/clazzList";
    }
    
    @PostMapping("answer/clazz/checkClazzName")
    @ResponseBody
    public Map<String,Object> checkClazzName(String class_name){
        Map<String , Object> map = new HashMap<String , Object>();
        try{
            this.clazzService.checkClazzName(class_name);
        }catch(StudentException e){
            map.put("flag" , "error");
            map.put("message" , e.getMessage());
        }
        return map;
    }
    
    @GetMapping("answer/clazz/update/{clazz_id}")
    public String clazzUpdate(@PathVariable String clazz_id,Model model){
        model.addAttribute("clazz" , this.clazzService.getClazz(clazz_id));
        return "jsp/clazz/clazzUpdate";
    }

    @PutMapping("answer/clazz/update")
    public String clazzUpdate(Clazz clazz,Model model){
        try{
            this.clazzService.clazzUpdate(clazz);
            model.addAttribute("flag" , "success");
            model.addAttribute("message" , "维护班级成功");
        }catch(StudentException e){
            model.addAttribute("flag" , "error");
            model.addAttribute("message" , e.getMessage());
        }
        return "jsp/msg";
    }
    
    @PutMapping("answer/clazz/stage")
    @ResponseBody
    public Map<String,Object> stage(String clazz_id,String clazz_stage){
        Clazz clazz = new Clazz();
        clazz.setClass_stage(clazz_stage);
        clazz.setClass_id(clazz_id);
        Map<String , Object> map = new HashMap<String , Object>();
        try{
            this.clazzService.clazzUpdate(clazz);
        }catch(StudentException e){
            map.put("flag" , "error");
            map.put("message" , e.getMessage());
        }
        return map;
    }
}
