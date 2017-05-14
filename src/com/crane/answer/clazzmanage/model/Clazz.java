/**
 * Clazz.java
 * ©2006-2016 四海兴唐科技有限公司
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-01-29 11:19:00
 **/
package com.crane.answer.clazzmanage.model;

import java.util.Date;

/**
 * class_manage 类
 * @Description :
 *
 * @author 胖先生
 * @version 1.0
 * 文件创建于: 2017-01-29 11:19:00
 **/
public class Clazz {

    @Override
    public String toString() {
        return "Clazz [class_id=" + this.class_id + ", class_name=" + this.class_name + ", class_open_time="
                + this.class_open_time + ", class_stage=" + this.class_stage + ", class_property=" + this.class_property
                + ", class_people=" + this.class_people + ", class_teacher=" + this.class_teacher + ", student_count="
                + this.student_count + "]";
    }

    private String class_id;
    private String class_name;
    private Date class_open_time;
    /**班级所处阶段,所属表字段为 class_manage.class_stage  */
    private String class_stage;
    /**班级性质,所属表字段为 class_manage.class_property  */
    private String class_property;
    private Integer class_people;
    private String class_teacher;
    private Integer student_count;


    public Integer getStudent_count() {
        return this.student_count;
    }
    
    public void setStudent_count(Integer student_count ) {
        this.student_count = student_count;
    }
    
    /**
     * 获取  字段:class_manage.class_id
     *
     * @return  class_manage.class_id
     */
    public String getClass_id() {
        return class_id;
    }

    /**
     * 设置  字段:class_manage.class_id
     *
     * @param class_id  class_manage.class_id
     */
    public void setClass_id(String class_id) {
        this.class_id = class_id == null ? null : class_id.trim();
    }

    /**
     * 获取  字段:class_manage.class_name
     *
     * @return  class_manage.class_name
     */
    public String getClass_name() {
        return class_name;
    }

    /**
     * 设置  字段:class_manage.class_name
     *
     * @param class_name  class_manage.class_name
     */
    public void setClass_name(String class_name) {
        this.class_name = class_name == null ? null : class_name.trim();
    }

    /**
     * 获取  字段:class_manage.class_open_time
     *
     * @return  class_manage.class_open_time
     */
    public Date getClass_open_time() {
        return class_open_time;
    }

    /**
     * 设置  字段:class_manage.class_open_time
     *
     * @param class_open_time  class_manage.class_open_time
     */
    public void setClass_open_time(Date class_open_time) {
        this.class_open_time = class_open_time;
    }

    /**
     * 获取 班级所处阶段 字段:class_manage.class_stage
     *
     * @return  class_manage.class_stage  ,班级所处阶段
     */
    public String getClass_stage() {
        return class_stage;
    }

    /**
     * 设置 班级所处阶段 字段:class_manage.class_stage
     *
     * @param class_stage  class_manage.class_stage,班级所处阶段
     */
    public void setClass_stage(String class_stage) {
        this.class_stage = class_stage == null ? null : class_stage.trim();
    }

    /**
     * 获取 班级性质 字段:class_manage.class_property
     *
     * @return  class_manage.class_property  ,班级性质
     */
    public String getClass_property() {
        return class_property;
    }

    /**
     * 设置 班级性质 字段:class_manage.class_property
     *
     * @param class_property  class_manage.class_property,班级性质
     */
    public void setClass_property(String class_property) {
        this.class_property = class_property == null ? null : class_property.trim();
    }

    /**
     * 获取  字段:class_manage.class_people
     *
     * @return  class_manage.class_people
     */
    public Integer getClass_people() {
        return class_people;
    }

    /**
     * 设置  字段:class_manage.class_people
     *
     * @param class_people  class_manage.class_people
     */
    public void setClass_people(Integer class_people) {
        this.class_people = class_people;
    }

    /**
     * 获取  字段:class_manage.class_teacher
     *
     * @return  class_manage.class_teacher
     */
    public String getClass_teacher() {
        return class_teacher;
    }

    /**
     * 设置  字段:class_manage.class_teacher
     *
     * @param class_teacher  class_manage.class_teacher
     */
    public void setClass_teacher(String class_teacher) {
        this.class_teacher = class_teacher == null ? null : class_teacher.trim();
    }
}