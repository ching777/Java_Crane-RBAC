package com.crane.answer.studentmanage.dao;

import java.util.List;

import com.crane.answer.studentmanage.model.Student;
import com.crane.commons.model.Pager;

public interface StudentDao {
    //获取学生信息
    List<Student> studentList(Pager pager);
    //学生总数
    Integer studentCount(Pager pager);
    //检查学生ID 重复
    int checkStudentNumber(String student_number);
    //添加学生
    void studentAdd(Student student);
    //学生信息
    Student studentInfo(String student_id);
    //学生修改
    void studentEdit(Student student);
    //修改学生状态
    void studentUpdateStage(Student student);
}
