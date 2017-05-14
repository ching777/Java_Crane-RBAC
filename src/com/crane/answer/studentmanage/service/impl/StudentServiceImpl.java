package com.crane.answer.studentmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crane.answer.studentmanage.dao.StudentDao;
import com.crane.answer.studentmanage.exception.StudentException;
import com.crane.answer.studentmanage.model.Student;
import com.crane.answer.studentmanage.service.StudentService;
import com.crane.commons.model.Pager;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;
    
    @Override
    public Pager studentList(Pager pager) {
        List<Student> studentList = this.studentDao.studentList(pager);
        int studentCount = this.studentDao.studentCount(pager);
        pager.setDatas(studentList);
        pager.setTotalCount(studentCount);
        return pager;
    }
    
    @Override
    public void checkStudentNumber(String student_number ) {
        int flag = this.studentDao.checkStudentNumber(student_number);
        if(flag>0){
            throw new StudentException("学生编号已经存在");
        }
    }
    
    @Override
    public void studentAdd(Student student ) {
        try{
            this.studentDao.studentAdd(student);
        }catch(StudentException e){
            e.printStackTrace();
            throw new StudentException("StudentServiceImpl类中的studentAdd方法添加失败");
        }
    }
    
    @Override
    public Student studentInfo(String student_id ) {
        return this.studentDao.studentInfo(student_id);
    }
    
    @Override
    public void studentEdit(Student student ) {
        try{
            this.studentDao.studentEdit(student);
        }catch(StudentException e){
            e.printStackTrace();
            throw new StudentException("StudentServiceImpl类中的studentEdit方法出错");
        }

    }
    

}
