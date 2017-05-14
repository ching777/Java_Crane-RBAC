package com.crane.answer.works.dao;

import java.util.List;

import com.crane.answer.works.model.Works;
import com.crane.commons.model.Pager;

public interface WorksDao {
    //获取优秀列表
    List<Works> getWorkList(Pager pager);
    //添加时候获取班级
    List<Works> getClassName();
    //添加时候获取学生
    List<Works> getStudentName(String class_name);
    //添加作品
    void workAdd( Works works);
    //获取一个信息
    Works getOneWork(String works_id);
    //修改作品
    void workUpdate(Works works);
    //删除作品
    void workDel (String works_id);
}
