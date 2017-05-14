package com.crane.answer.timemanage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crane.answer.clazzmanage.dao.ClazzDao;
import com.crane.answer.timemanage.dao.TimeDao;
import com.crane.answer.timemanage.exception.TimeException;
import com.crane.answer.timemanage.model.Time;
import com.crane.answer.timemanage.service.TimeService;
import com.crane.commons.model.Pager;
@Service
public class TimeServiceImpl implements TimeService {
    @Autowired
    private TimeDao timeDao;
    @Autowired
    private ClazzDao clazzDao;

    @Override
    public Pager getAnswerTime(Pager pager ) {
        pager.setDatas(this.timeDao.getAnswerTime(pager));
        return pager;
    }

    @Override
    public void answerTimeAdd(Time time ) {
        try{
            this.timeDao.answerTimeAdd(time);
            this.clazzDao.answer_statesUpdate(time.getFk_class_id(),null);
        }catch(TimeException e){
            e.printStackTrace();
            throw new TimeException("TimeServiceImpl类中,answerTimeAdd方法出错");
        }
    }

    @Override
    public Time answerTimeInfo(String answer_id ) {
        return this.timeDao.answerTimeInfo(answer_id);
    }
    
    @Override
    public void timeUpdate(Time time,String mark) {
        try{
            if(mark!=null){
                this.clazzDao.answer_statesUpdate(time.getFk_class_id(), mark);
                this.timeDao.timeUpdate(time);
            }else{
                this.timeDao.timeUpdate(time);
            }
        }catch(TimeException e){
            e.printStackTrace();
            throw new TimeException("TimeServiceImpl类中,timeUpdate方法出错");
        }
    }
    
}
