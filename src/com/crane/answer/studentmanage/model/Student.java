/**
 * Student.java
 * ©2006-2016 四海兴唐科技有限公司
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-02-06 16:43:48
 **/
package com.crane.answer.studentmanage.model;

import com.crane.answer.clazzmanage.model.Clazz;

/**
 * student_manage 类
 * @Description :
 *
 * @author 胖先生
 * @version 1.0
 * 文件创建于: 2017-02-06 16:43:48
 **/
public class Student {

    private String student_id;
    private String student_name;
    /**学生编号,所属表字段为 student_manage.student_number  */
    private String student_number;
    /**学生状态,所属表字段为 student_manage.student_stage  */
    private String student_stage;
    private String student_sex;
    /**学生所在大学,所属表字段为 student_manage.student_school  */
    private String student_school;
    /**学生年级,所属表字段为 student_manage.student_grade  */
    private String student_grade;
    /**学生专业,所属表字段为 student_manage.student_major  */
    private String student_major;
    /**所学产品,所属表字段为 student_manage.student_product  */
    private String student_product;
    /**规划师姓名,所属表字段为 student_manage.student_teacher_name  */
    private String student_teacher_name;
    /**班级外键,所属表字段为 student_manage.fk_class_id  */
    private String fk_class_id;

    private Clazz clazz;
    

    @Override
    public String toString() {
        return "Student [student_id=" + this.student_id + ", student_name=" + this.student_name + ", student_number="
                + this.student_number + ", student_stage=" + this.student_stage + ", student_sex=" + this.student_sex
                + ", student_school=" + this.student_school + ", student_grade=" + this.student_grade
                + ", student_major=" + this.student_major + ", student_product=" + this.student_product
                + ", student_teacher_name=" + this.student_teacher_name + ", fk_class_id=" + this.fk_class_id
                + ", clazz=" + this.clazz + "]";
    }
    
    public Clazz getClazz() {
        return this.clazz;
    }

    public void setClazz(Clazz clazz ) {
        this.clazz = clazz;
    }

    /**
     * 获取  字段:student_manage.student_id
     *
     * @return  student_manage.student_id
     */
    public String getStudent_id() {
        return student_id;
    }

    /**
     * 设置  字段:student_manage.student_id
     *
     * @param student_id  student_manage.student_id
     */
    public void setStudent_id(String student_id) {
        this.student_id = student_id == null ? null : student_id.trim();
    }

    /**
     * 获取  字段:student_manage.student_name
     *
     * @return  student_manage.student_name
     */
    public String getStudent_name() {
        return student_name;
    }

    /**
     * 设置  字段:student_manage.student_name
     *
     * @param student_name  student_manage.student_name
     */
    public void setStudent_name(String student_name) {
        this.student_name = student_name == null ? null : student_name.trim();
    }

    /**
     * 获取 学生编号 字段:student_manage.student_number
     *
     * @return  student_manage.student_number  ,学生编号
     */
    public String getStudent_number() {
        return student_number;
    }

    /**
     * 设置 学生编号 字段:student_manage.student_number
     *
     * @param student_number  student_manage.student_number,学生编号
     */
    public void setStudent_number(String student_number) {
        this.student_number = student_number == null ? null : student_number.trim();
    }

    /**
     * 获取 学生状态 字段:student_manage.student_stage
     *
     * @return  student_manage.student_stage  ,学生状态
     */
    public String getStudent_stage() {
        return student_stage;
    }

    /**
     * 设置 学生状态 字段:student_manage.student_stage
     *
     * @param student_stage  student_manage.student_stage,学生状态
     */
    public void setStudent_stage(String student_stage) {
        this.student_stage = student_stage == null ? null : student_stage.trim();
    }

    /**
     * 获取  字段:student_manage.student_sex
     *
     * @return  student_manage.student_sex
     */
    public String getStudent_sex() {
        return student_sex;
    }

    /**
     * 设置  字段:student_manage.student_sex
     *
     * @param student_sex  student_manage.student_sex
     */
    public void setStudent_sex(String student_sex) {
        this.student_sex = student_sex == null ? null : student_sex.trim();
    }

    /**
     * 获取 学生所在大学 字段:student_manage.student_school
     *
     * @return  student_manage.student_school  ,学生所在大学
     */
    public String getStudent_school() {
        return student_school;
    }

    /**
     * 设置 学生所在大学 字段:student_manage.student_school
     *
     * @param student_school  student_manage.student_school,学生所在大学
     */
    public void setStudent_school(String student_school) {
        this.student_school = student_school == null ? null : student_school.trim();
    }

    /**
     * 获取 学生年级 字段:student_manage.student_grade
     *
     * @return  student_manage.student_grade  ,学生年级
     */
    public String getStudent_grade() {
        return student_grade;
    }

    /**
     * 设置 学生年级 字段:student_manage.student_grade
     *
     * @param student_grade  student_manage.student_grade,学生年级
     */
    public void setStudent_grade(String student_grade) {
        this.student_grade = student_grade == null ? null : student_grade.trim();
    }

    /**
     * 获取 学生专业 字段:student_manage.student_major
     *
     * @return  student_manage.student_major  ,学生专业
     */
    public String getStudent_major() {
        return student_major;
    }

    /**
     * 设置 学生专业 字段:student_manage.student_major
     *
     * @param student_major  student_manage.student_major,学生专业
     */
    public void setStudent_major(String student_major) {
        this.student_major = student_major == null ? null : student_major.trim();
    }

    /**
     * 获取 所学产品 字段:student_manage.student_product
     *
     * @return  student_manage.student_product  ,所学产品
     */
    public String getStudent_product() {
        return student_product;
    }

    /**
     * 设置 所学产品 字段:student_manage.student_product
     *
     * @param student_product  student_manage.student_product,所学产品
     */
    public void setStudent_product(String student_product) {
        this.student_product = student_product == null ? null : student_product.trim();
    }

    /**
     * 获取 规划师姓名 字段:student_manage.student_teacher_name
     *
     * @return  student_manage.student_teacher_name  ,规划师姓名
     */
    public String getStudent_teacher_name() {
        return student_teacher_name;
    }

    /**
     * 设置 规划师姓名 字段:student_manage.student_teacher_name
     *
     * @param student_teacher_name  student_manage.student_teacher_name,规划师姓名
     */
    public void setStudent_teacher_name(String student_teacher_name) {
        this.student_teacher_name = student_teacher_name == null ? null : student_teacher_name.trim();
    }

    /**
     * 获取 班级外键 字段:student_manage.fk_class_id
     *
     * @return  student_manage.fk_class_id  ,班级外键
     */
    public String getFk_class_id() {
        return fk_class_id;
    }

    /**
     * 设置 班级外键 字段:student_manage.fk_class_id
     *
     * @param fk_class_id  student_manage.fk_class_id,班级外键
     */
    public void setFk_class_id(String fk_class_id) {
        this.fk_class_id = fk_class_id == null ? null : fk_class_id.trim();
    }
}