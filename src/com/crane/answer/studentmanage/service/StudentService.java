package com.crane.answer.studentmanage.service;

import com.crane.answer.studentmanage.model.Student;
import com.crane.commons.model.Pager;

public interface StudentService {
    //获取学生信息
    Pager studentList(Pager pager);
    //检查学生ID 重复
    void checkStudentNumber(String student_number);
    //添加学生
    void studentAdd(Student student);
    //学生信息
    Student studentInfo(String student_id);
    //学生修改
    void studentEdit(Student student);
}
