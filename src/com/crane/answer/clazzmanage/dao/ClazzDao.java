package com.crane.answer.clazzmanage.dao;

import java.util.List;

import com.crane.answer.clazzmanage.model.Clazz;
import com.crane.commons.model.Pager;

public interface ClazzDao {
    //获取未完结班级
    List<Clazz> list( Pager pager);
    //查看名字是否重复
    int checkClazzName (String class_name);
    //添加班级
    void clazzAdd (Clazz clazz);
    //获取班级信息
    Clazz getClazz(String class_id);
    //维护班级
    void clazzUpdate(Clazz clazz);
    //维护班级
    void stage(Integer stage);
    //修改答辩状态
    void answer_statesUpdate( String class_id,String mark);
}
