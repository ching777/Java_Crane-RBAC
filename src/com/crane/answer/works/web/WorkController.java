package com.crane.answer.works.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.crane.answer.works.exception.WorksException;
import com.crane.answer.works.model.Works;
import com.crane.answer.works.service.WorkService;
import com.crane.commons.model.Pager;

@Controller
public class WorkController {

    @Autowired
    private WorkService workService;

    @GetMapping("answer/work/main")
    public String sendWorkMain(Pager pager , Model model){
        model.addAttribute("pager" , this.workService.getWorkList(pager));
        return "jsp/work/workMain";
    }

    @GetMapping("answer/work/workAdd")
    public String workAdd( Model model){
        model.addAttribute("clazz" , this.workService.getClassName());
        return "jsp/work/workAdd";
    }
    @GetMapping("answer/work/workUpdate/{works_id}")
    public String workUpdate(@PathVariable String works_id, Model model){
        model.addAttribute("works" , this.workService.getOneWork(works_id));
        return "jsp/work/workUpdate";
    }

    @PostMapping("answer/work/studentChange")
    @ResponseBody
    public Map<String , Object> studentChange(String class_name){
        Map<String , Object> map = new HashMap<String , Object>();
        map.put("student" , this.workService.getStudentName(class_name));
        return map;
    }
    

    @PostMapping("answer/work/workUpdate")
    public String workUpdate(Works works,MultipartFile works_js,MultipartFile video,MultipartFile works_code, Model model ,HttpServletRequest request) throws IllegalStateException, IOException {
        if(! works_code.isEmpty()){
            String pathCode  = request.getSession().getServletContext().getRealPath("/attr/code/");
            String delCode  = request.getSession().getServletContext().getRealPath("/attr/code/"+works.getOld_code());
            File delFile = new File(delCode);
            if(delFile.exists()){
                delFile.delete();
            }
            String fileNaneWc = works_code.getOriginalFilename();
            String extc = FilenameUtils.getExtension(fileNaneWc);
            String newFileNamec = UUID.randomUUID().toString()+"."+extc;
            File newFilec = new File(pathCode+"/"+newFileNamec);
            works_code.transferTo(newFilec);
            works.setWorks_code_update(newFileNamec);
        }


        if(! works_js.isEmpty()){
            String pathSql  = request.getSession().getServletContext().getRealPath("/attr/sql/");
            String delJs  = request.getSession().getServletContext().getRealPath("/attr/sql/"+works.getOld_js());
            
            File delFile = new File(delJs);
            if(delFile.exists()){
                delFile.delete();
            }

            String works_jsj = works_js.getOriginalFilename();
            String extj = FilenameUtils.getExtension(works_jsj);
            String newFileNamej = UUID.randomUUID().toString()+"."+extj;
            File newFilej = new File(pathSql+"/"+newFileNamej);
            works_js.transferTo(newFilej);
            works.setWorks_js_data(newFileNamej);
            
        }
        if(! video.isEmpty()){
            String pathVideo  = request.getSession().getServletContext().getRealPath("/attr/video/");
            String delVideo  = request.getSession().getServletContext().getRealPath("/attr/video/"+works.getOld_video());

            File delFile = new File(delVideo);
            if(delFile.exists()){
                delFile.delete();
            }
            String works_v = video.getOriginalFilename();
            String extv = FilenameUtils.getExtension(works_v);
            String newFileNamev = UUID.randomUUID().toString()+"."+extv;
            File newFilev = new File(pathVideo+"/"+newFileNamev);
            video.transferTo(newFilev);
            works.setWorks_video(newFileNamev);
        }

        
        try{
            this.workService.workUpdate(works);
            model.addAttribute("flag" , "success");
            model.addAttribute("message" , "修改成功");
        }catch(WorksException e){
            model.addAttribute("flag" , "error");
            model.addAttribute("message" , e.getMessage());
        }
        return "jsp/msg";
    }
    
    @PostMapping("answer/work/workAdd")
    public String workAdd(Works works,MultipartFile works_js,MultipartFile video,MultipartFile works_code, Model model ,HttpServletRequest request) throws IllegalStateException, IOException {
        //获取路径
        String pathCode  = request.getSession().getServletContext().getRealPath("/attr/code/");
        String pathSql  = request.getSession().getServletContext().getRealPath("/attr/sql/");
        String pathVideo  = request.getSession().getServletContext().getRealPath("/attr/video/");
        //创建一个文件夹
        //        //获取上传文件名
        String fileNaneWc = works_code.getOriginalFilename();
        //获取main 类型
        String extc = FilenameUtils.getExtension(fileNaneWc);
        //新文件名
        String newFileNamec = UUID.randomUUID().toString()+"."+extc;
        //创建一个新文件
        File newFilec = new File(pathCode+"/"+newFileNamec);
        //上传文件
        works_code.transferTo(newFilec);
        
        String works_jsj = works_js.getOriginalFilename();
        String extj = FilenameUtils.getExtension(works_jsj);
        String newFileNamej = UUID.randomUUID().toString()+"."+extj;
        File newFilej = new File(pathSql+"/"+newFileNamej);
        works_js.transferTo(newFilej);

        String works_v = video.getOriginalFilename();
        String extv = FilenameUtils.getExtension(works_v);
        String newFileNamev = UUID.randomUUID().toString()+"."+extv;
        File newFilev = new File(pathVideo+"/"+newFileNamev);
        video.transferTo(newFilev);

        works.setWorks_video(newFileNamev);
        works.setWorks_js_data(newFileNamej);
        works.setWorks_code_update(newFileNamec);

        try{
            this.workService.workAdd(works);
            model.addAttribute("flag" , "success");
            model.addAttribute("message" , "添加成功");
        }catch(WorksException e){
            model.addAttribute("flag" , "error");
            model.addAttribute("message" , e.getMessage());
        }
        return "jsp/msg";
    }
    @PutMapping("answer/works/worksDel")
    @ResponseBody
    public Map<String,Object> workDel(String works_id,Works works,HttpServletRequest request){
        Map<String , Object> map = new HashMap<String , Object>();
        works = this.workService.getOneWork(works_id);

        try{
            String delVideo  = request.getSession().getServletContext().getRealPath("/attr/video/"+works.getWorks_video());
            File delFile = new File(delVideo);
            if(delFile.exists()){
                delFile.delete();
            }
            
            String delJs  = request.getSession().getServletContext().getRealPath("/attr/sql/"+works.getWorks_js_data());
            File delFilej = new File(delJs);
            if(delFilej.exists()){
                delFilej.delete();
            }
            
            String delCode  = request.getSession().getServletContext().getRealPath("/attr/code/"+works.getWorks_code_update());
            File delFilec = new File(delCode);
            if(delFilec.exists()){
                delFilec.delete();
            }
            this.workService.workDel(works_id);
            map.put("flag" , "success");
            map.put("message" , "删除成功");
        }catch(WorksException e){
            map.put("flag" , "error");
            map.put("message" , e.getMessage());
        }
        return map;
    }
    
}

