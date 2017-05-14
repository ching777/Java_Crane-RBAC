package com.crane.answer.evaluate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crane.answer.evaluate.dao.EvaluateDao;
import com.crane.answer.evaluate.exception.EvaluateException;
import com.crane.answer.evaluate.model.Evaluate;
import com.crane.answer.evaluate.model.EvaluateList;
import com.crane.answer.evaluate.service.EvaluateService;

@Service
public class EvaluateServiceImpl implements EvaluateService{

    @Autowired
    private EvaluateDao evaluateDao;

    @Override
    public List<EvaluateList> getEvaluateList() {
        return this.evaluateDao.getEvaluateList();
    }
    
    @Override
    public List<EvaluateList> getClass_name() {
        return this.evaluateDao.getClass_name();
    }

    @Override
    public List<EvaluateList> getStudentName(String class_name) {
        return this.evaluateDao.getStudentName(class_name);
    }

    @Override
    public void evaluateAdd(Evaluate evaluate ) {
        int count = this.evaluateDao.checkEvaluate(evaluate.getevaluate_student_id());
        if(count>0){
            throw new EvaluateException("该用户已经建立备忘录,请修改");
        }else{
            try{
                this.evaluateDao.evaluateAdd(evaluate);
            }catch(EvaluateException e){
                e.printStackTrace();
                throw new EvaluateException("EvaluateServiceImpl类中,evaluateAdd方法添加失败");
            }
        }
        
    }
    
    @Override
    public Evaluate getOneEvaluate(String evaluate_id ) {
        return this.evaluateDao.getOneEvaluate(evaluate_id);
    }

    @Override
    public void evaluateUpdate(Evaluate evaluate ) {
        try{
            this.evaluateDao.evaluateUpdate(evaluate);
        }catch(EvaluateException e){
            e.printStackTrace();
            throw new EvaluateException("EvaluateServiceImpl类中,evaluateUpdate方法修改失败");
        }
        
    }
    
    @Override
    public void evaluateDel(String evaluate_id ) {
        try{
            this.evaluateDao.evaluateDel(evaluate_id);
        }catch(EvaluateException e){
            e.printStackTrace();
            e.getMessage();
        }

    }
    
}
