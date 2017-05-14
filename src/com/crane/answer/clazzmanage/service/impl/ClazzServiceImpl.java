package com.crane.answer.clazzmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crane.answer.clazzmanage.dao.ClazzDao;
import com.crane.answer.clazzmanage.model.Clazz;
import com.crane.answer.clazzmanage.service.ClazzService;
import com.crane.answer.studentmanage.dao.StudentDao;
import com.crane.answer.studentmanage.exception.StudentException;
import com.crane.answer.studentmanage.model.Student;
import com.crane.commons.model.Pager;
@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzDao clazzDao;
    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Clazz> list(Pager pager) {
        return this.clazzDao.list(pager);
    }
    
    @Override
    public void checkClazzName(String class_name ) {
        int count = this.clazzDao.checkClazzName(class_name);
        if(count>0){
            throw new StudentException("该班级已经存在,请输入其他名称");
        }
        
    }
    
    @Override
    public void clazzAdd(Clazz clazz ) {
        try{
            this.clazzDao.clazzAdd(clazz);
        }catch(StudentException e){
            e.printStackTrace();
            throw new StudentException("ClazzServiceImpl类中,clazzAdd方法添加失败");
        }

    }

    @Override
    public Clazz getClazz(String class_id ) {
        
        return this.clazzDao.getClazz(class_id);
    }
    
    @Override
    public void clazzUpdate(Clazz clazz ) {
        try{
            Student student = new Student();
            student.setFk_class_id(clazz.getClass_id());
            student.setStudent_stage(clazz.getClass_stage());
            this.studentDao.studentUpdateStage(student);
            this.clazzDao.clazzUpdate(clazz);
        }catch(StudentException e){
            e.printStackTrace();
            throw new StudentException("ClazzServiceImpl类中,clazzUpdate方法修改失败");
        }
    }
    
}
