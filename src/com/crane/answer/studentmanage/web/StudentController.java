package com.crane.answer.studentmanage.web;

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

import com.crane.answer.clazzmanage.service.ClazzService;
import com.crane.answer.studentmanage.exception.StudentException;
import com.crane.answer.studentmanage.model.Student;
import com.crane.answer.studentmanage.service.StudentService;
import com.crane.commons.model.Pager;

@Controller
public class StudentController {
    @Autowired
    private ClazzService clazzService;
    @Autowired
    private StudentService studentService;

    @GetMapping("answer/student/list")
    public String studentList(Model model,Pager pager){
        model.addAttribute("pager" , this.studentService.studentList(pager));
        return "jsp/student/studentList";
    }

    @GetMapping("answer/student/list/{class_name}")
    public String studentList(@PathVariable  String class_name, Model model,Pager pager){
        Map<String , Object> map = new HashMap<String , Object>();
        map.put("class_name" , class_name);
        map.put("stage" , "yes");
        pager.setQuery(map);
        model.addAttribute("pager" , this.studentService.studentList(pager));
        return  "jsp/student/studentList";
    }
    
    @GetMapping("answer/student/studentUpdate/{student_id}")
    public String studentInfo(@PathVariable String student_id, Model model,Pager pager){
        model.addAttribute("clazz" , this.clazzService.list(pager));
        model.addAttribute("datas" , this.studentService.studentInfo(student_id));
        return "jsp/student/studentUpdte";
    }
    @PutMapping("answer/student/studentUpdate")
    public String studentInfo(Student student, Model model){
        
        try{
            this.studentService.studentEdit(student);
            model.addAttribute("flag" , "success");
            model.addAttribute("message" , "修改成功");
        }catch(StudentException e){
            model.addAttribute("flag" , "error");
            model.addAttribute("message" , e.getMessage());
        }
        return "jsp/msg";
    }
    @GetMapping("answer/student/studentAdd")
    public String studentAdd(Pager pager,Model model){
        model.addAttribute("clazz" , this.clazzService.list(pager));
        return "jsp/student/studentAdd";
    }
    @PostMapping("answer/student/studentAdd")
    public String studentAdd(Student student,Model model){
        try{
            this.studentService.studentAdd(student);
            model.addAttribute("flag" , "success");
            model.addAttribute("message" , "添加成功");
        }catch(StudentException e){
            model.addAttribute("flag" , "error");
            model.addAttribute("message" , e.getMessage());
        }
        return "jsp/msg";
    }
    
    @PostMapping("answer/student/checkStudentNumber")
    @ResponseBody
    public Map<String ,Object > checkstudent_number(String student_number,Model model){
        Map<String , Object> map = new HashMap<String , Object>();
        try{
            this.studentService.checkStudentNumber(student_number);
        }catch(StudentException e){
            map.put("flag" , "error");
            map.put("message" , e.getMessage());
        }
        return map;
    }
}
