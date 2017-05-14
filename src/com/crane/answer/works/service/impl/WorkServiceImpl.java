package com.crane.answer.works.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crane.answer.works.dao.WorksDao;
import com.crane.answer.works.exception.WorksException;
import com.crane.answer.works.model.Works;
import com.crane.answer.works.service.WorkService;
import com.crane.commons.model.Pager;
@Service
public class WorkServiceImpl implements WorkService {
    
    @Autowired
    private WorksDao worksDao;
    
    @Override
    public Pager getWorkList(Pager pager ) {
        
        pager.setDatas(this.worksDao.getWorkList(pager));
        return pager;
    }
    
    @Override
    public List<Works> getClassName() {
        return this.worksDao.getClassName();
    }
    
    @Override
    public List<Works> getStudentName(String class_name ) {
        return this.worksDao.getStudentName(class_name);
    }
    
    @Override
    public void workAdd(Works works ) {
        try{
            this.worksDao.workAdd(works);
        }catch(WorksException e){
            e.printStackTrace();
            throw new WorksException("WorkServiceImpl类中,workAdd方法出错");
        }
    }
    
    @Override
    public Works getOneWork(String works_id ) {
        return this.worksDao.getOneWork(works_id);
    }
    
    @Override
    public void workUpdate(Works works ) {
        try{
            this.worksDao.workUpdate(works);
        }catch(WorksException e){
            e.printStackTrace();
            throw new WorksException("WorkServiceImpl类中,workUpdate方法出错");
        }

    }
    
    @Override
    public void workDel(String works_id ) {
        try{
            this.worksDao.workDel(works_id);
        }catch(WorksException e){
            e.printStackTrace();
            throw new WorksException("WorkServiceImpl类中,workDel方法出错");
        }

    }
    
}
