package com.crane.answer.evaluate.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crane.answer.evaluate.exception.EvaluateException;
import com.crane.answer.evaluate.model.Evaluate;
import com.crane.answer.evaluate.service.EvaluateService;

@Controller
public class EvaluateController {

    @Autowired
    private EvaluateService evaluateService;

    @GetMapping("answer/evaluate/evaluateList")
    public String evaluateList(Model model){
        model.addAttribute("evaluateList" , this.evaluateService.getEvaluateList());
        return "jsp/evaluate/evaluateList";
    }
    
    @GetMapping("answer/evaluate/evaluateAdd")
    public String getClass_name(Model model){
        model.addAttribute("clazz" , this.evaluateService.getClass_name());
        return "jsp/evaluate/evaluateAdd";
    }
    @PostMapping("answer/evaluate/getStudentName")
    @ResponseBody
    public Map<String,Object> getStudentName(String class_name,Model model){
        Map<String , Object> map = new HashMap<String , Object>();
        map.put("clazz" , this.evaluateService.getStudentName(class_name));
        return map;
    }

    @PostMapping("answer/evaluate/evaluateAdd")
    public String evaluateAdd(Evaluate evaluate ,Model model){
        try{
            this.evaluateService.evaluateAdd(evaluate);
            model.addAttribute("flag" , "success");
            model.addAttribute("message" , "添加成功");
        }catch(EvaluateException e){
            model.addAttribute("flag" , "error");
            model.addAttribute("message" , e.getMessage());
        }
        return "jsp/msg";
    }

    @GetMapping("answer/evaluate/evaluateUpdate/{evaluate_id}")
    public String evaluateUpdate(@PathVariable String evaluate_id ,Model model){
        model.addAttribute("evaluate" , this.evaluateService.getOneEvaluate(evaluate_id));
        return "jsp/evaluate/evaluateUpdate";
    }
    @GetMapping("answer/evaluate/evaluateDel/{evaluate_id}")
    public String evaluateDel(@PathVariable String evaluate_id ,Model model){
        try{
            this.evaluateService.evaluateDel(evaluate_id);
            model.addAttribute("flag" , "success");
            model.addAttribute("message" , "删除成功");
        }catch(EvaluateException e){
            model.addAttribute("flag" , "error");
            model.addAttribute("message" , e.getMessage());
        }
        return "jsp/msg";
    }
    
    @PutMapping("answer/evaluate/evaluateUpdate")
    public String evaluateUpda(Evaluate evaluate ,Model model){
        try{
            this.evaluateService.evaluateUpdate(evaluate);
            model.addAttribute("flag" , "success");
            model.addAttribute("message" , "修改成功");
        }catch(EvaluateException e){
            model.addAttribute("flag" , "error");
            model.addAttribute("message" , e.getMessage());
        }
        return "jsp/msg";
    }

}
