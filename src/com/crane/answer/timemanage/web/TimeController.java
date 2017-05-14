package com.crane.answer.timemanage.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.crane.answer.clazzmanage.service.ClazzService;
import com.crane.answer.timemanage.exception.TimeException;
import com.crane.answer.timemanage.model.Time;
import com.crane.answer.timemanage.service.TimeService;
import com.crane.commons.model.Pager;
import com.crane.commons.web.BaseController;

@Controller
public class TimeController extends BaseController {
    @Autowired
    private TimeService timeService;
    @Autowired
    private ClazzService clazzService;

    @GetMapping("answer/time")
    public String answerTime(Model model,Pager pager){
        model.addAttribute("timeList" , this.timeService.getAnswerTime(pager));
        return "jsp/time/timeList";
    }
    
    @GetMapping("answer/time/timeUpdate/{answer_id}")
    public String answerTime(@PathVariable String answer_id, Model model,Pager pager){
        Map<String , Object> map = new HashMap<String , Object>();
        map.put("answer_states" , "yes");
        pager.setQuery(map);
        model.addAttribute("clazz" , this.clazzService.list(pager));
        model.addAttribute("time" , this.timeService.answerTimeInfo(answer_id));
        return "jsp/time/timeUpdate";
    }

    @GetMapping("answer/time/answerStageUpdate/{answer_id}")
    public String answerStageUpdate(@PathVariable String answer_id, Model model){
        model.addAttribute("time" , this.timeService.answerTimeInfo(answer_id));
        return "jsp/time/timeUpdateStage";
    }
    
    @PutMapping("answer/time/answerStageUpdate")
    public String answerStageUpdate(Time time, Model model){
        String mark = "mark";
        try{
            if(time.getAnswer_states().equals("完毕")){
                this.timeService.timeUpdate(time,mark);
            }else{
                this.timeService.timeUpdate(time,null);
            }
            model.addAttribute("flag" , "success");
            model.addAttribute("message" , "修改成功");
        }catch(TimeException e){
            model.addAttribute("flag" , "error");
            model.addAttribute("message" , e.getMessage());
        }
        return "jsp/msg";
    }

    @GetMapping("answer/time/timeAdd")
    public String answerTimeAdd(Pager pager,Model model){
        Map<String , Object> map = new HashMap<String , Object>();
        map.put("answer_states" , "yes");
        pager.setQuery(map);
        model.addAttribute("clazz" , this.clazzService.list(pager));
        return "jsp/time/timeAdd";
    }

    @PostMapping("answer/time/timeAdd1")
    public String answerTimeAdd(Time time,Model model){
        try{
            this.timeService.answerTimeAdd(time);
            model.addAttribute("flag" , "success");
            model.addAttribute("message" , "申请成功");
        }catch(TimeException e){
            model.addAttribute("flag" , "error");
            model.addAttribute("message" , e.getMessage());
        }
        return "jsp/msg";
    }
    
    @PutMapping("answer/time/timeUpdate")
    public String timeUpdate(Time time,Model model){
        try{
            this.timeService.timeUpdate(time,null);
            model.addAttribute("flag" , "success");
            model.addAttribute("message" , "修改成功");
        }catch(TimeException e){
            model.addAttribute("flag" , "error");
            model.addAttribute("message" , e.getMessage());
        }
        return "jsp/msg";
    }
}
