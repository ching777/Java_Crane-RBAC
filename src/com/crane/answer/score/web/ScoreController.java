package com.crane.answer.score.web;

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

import com.crane.answer.score.exception.ScoreException;
import com.crane.answer.score.model.Score;
import com.crane.answer.score.service.ScoreService;
import com.crane.commons.model.Pager;

@Controller
public class ScoreController {
    @Autowired
    ScoreService scoreService;
    

    @GetMapping("answer/score/scoreList")
    public String getScoreList(Pager pager , Model model){
        model.addAttribute("class_name" , this.scoreService.getClass_name());
        model.addAttribute("student" , this.scoreService.getScoreList(pager));
        return "jsp/score/scoreList";
    }
    @GetMapping("answer/score/scoreAdd")
    public String socreAdd( Model model){
        model.addAttribute("class_name" , this.scoreService.getSocreAddClass());
        return "jsp/score/scoreAdd";
    }
    @PostMapping("answer/score/scoreAdd")
    public String socreAdd(Score score,Model model){
        try{
            this.scoreService.scoreAdd(score);
            model.addAttribute("flag" , "success");
            model.addAttribute("message" , "添加成功");
        }catch(ScoreException e){
            model.addAttribute("flag" , "error");
            model.addAttribute("message" , e.getMessage());
        }
        return "jsp/msg";
    }
    @PutMapping("answer/score/scoreUpdate")
    public String scoreUpdate(Score score,Model model){
        try{
            this.scoreService.scoreUpdate(score);
            model.addAttribute("flag" , "success");
            model.addAttribute("message" , "修改成功");
        }catch(ScoreException e){
            model.addAttribute("flag" , "error");
            model.addAttribute("message" , e.getMessage());
        }
        return "jsp/msg";
    }


    @PostMapping("answer/score/getAnswerQuestion")
    @ResponseBody
    public Map<String,Object> getAnswerQuestion(String class_name,Pager pager){
        Map<String  , Object> map = new HashMap<String  , Object>();
        map.put("class_name" , class_name);
        pager.setQuery(map);
        map.put("pageSelect",this.scoreService.getPageSelect(pager));

        return map;
    }
    @PostMapping("answer/score/getStudent")
    @ResponseBody
    public Map<String,Object> getStudent(String class_name){
        Map<String  , Object> map = new HashMap<String  , Object>();
        map.put("student_name" , this.scoreService.getStudent(class_name));
        return map;
    }

    @GetMapping("answer/score/scoreUpdate/{score_id}")
    public String scoreUpdate(@PathVariable String score_id,Model model){
        System.out.println(score_id);
        model.addAttribute("score" , this.scoreService.getScoreInfo(score_id));
        return "jsp/score/scoreUpdate";
    }
}
