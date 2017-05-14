package com.crane.answer.score.service;

import java.util.List;

import com.crane.answer.score.model.Score;
import com.crane.commons.model.Pager;

public interface ScoreService {
    //获取班级
    List<Score> getPageSelect(Pager pager);
    //获取班级
    List<Score> getClass_name();
    //获取学生信息
    Pager getStudent(Pager pager);
    //获取学生列表
    Pager getScoreList(Pager pager);
    //获取学生
    List<Score> getSocreAddClass();
    //获取学生
    List<Score> getStudent(String class_name);
    //获取学生
    void scoreAdd(Score score);
    //获取答辩信息
    Score getScoreInfo(String score_id);
    //成绩修改
    void scoreUpdate(Score score);
    
}
