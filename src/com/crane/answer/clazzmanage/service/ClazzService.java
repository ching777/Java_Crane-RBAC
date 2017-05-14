package com.crane.answer.clazzmanage.service;

import java.util.List;

import com.crane.answer.clazzmanage.model.Clazz;
import com.crane.commons.model.Pager;

public interface ClazzService {
    //获取未完结班级
    List<Clazz> list(Pager pager);
    //查看名字是否重复
    void checkClazzName (String class_name);
    //添加班级
    void clazzAdd (Clazz clazz);
    //获取班级信息
    Clazz getClazz(String class_id);
    //维护班级
    void clazzUpdate(Clazz clazz);
}
