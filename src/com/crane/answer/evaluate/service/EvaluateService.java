package com.crane.answer.evaluate.service;

import java.util.List;

import com.crane.answer.evaluate.model.Evaluate;
import com.crane.answer.evaluate.model.EvaluateList;

public interface EvaluateService {
    
    //获取评价
    List<EvaluateList> getEvaluateList();
    //获取班级
    List<EvaluateList> getClass_name();
    //获取学生
    List<EvaluateList> getStudentName(String class_name);
    //添加备忘录
    void evaluateAdd(Evaluate evaluate);
    //获取一个备忘录
    Evaluate getOneEvaluate(String evaluate_id);
    //修改备忘录
    void evaluateUpdate(Evaluate evaluate);
    //删除一个备忘录
    void evaluateDel(String evaluate_id);
}
