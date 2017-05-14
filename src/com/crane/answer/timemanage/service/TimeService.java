package com.crane.answer.timemanage.service;

import com.crane.answer.timemanage.model.Time;
import com.crane.commons.model.Pager;

public interface TimeService {
    //获取答辩信息
    Pager getAnswerTime(Pager pager );
    //申请答辩
    void answerTimeAdd(Time time);
    //答辩详细信息
    Time answerTimeInfo(String answer_id );
    //修改答辩
    void timeUpdate(Time time,String mark);
    
}
