package com.crane.answer.timemanage.dao;

import java.util.List;

import com.crane.answer.timemanage.model.Time;
import com.crane.commons.model.Pager;

public interface TimeDao {
    //获取答辩信息
    List<Time> getAnswerTime(Pager pager);
    //申请答辩
    void answerTimeAdd(Time time);
    //答辩详细信息
    Time answerTimeInfo(String answer_id);
    //修改答辩
    void timeUpdate(Time time);
}
