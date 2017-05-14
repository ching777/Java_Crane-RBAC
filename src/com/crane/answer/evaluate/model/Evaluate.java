/**
 * Evaluate.java
 * ©2006-2016 四海兴唐科技有限公司
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-02-10 16:16:08
 **/
package com.crane.answer.evaluate.model;

import com.crane.answer.clazzmanage.model.Clazz;
import com.crane.answer.studentmanage.model.Student;
import com.crane.answer.timemanage.model.Time;

/**
 * answer_student_evaluate 类
 * @Description :
 *
 * @author 胖先生
 * @version 1.0
 * 文件创建于: 2017-02-10 16:16:08
 **/
public class Evaluate {

    @Override
    public String toString() {
        return "Evaluate [evaluate_id=" + this.evaluate_id + ", evaluate_student_id=" + this.evaluate_student_id
                + ", evaluate_answer_id=" + this.evaluate_answer_id + ", evaluate_info=" + this.evaluate_info
                + ", clazz=" + this.clazz + ", time=" + this.time + ", student=" + this.student + "]";
    }
    
    private String evaluate_id;
    private String evaluate_student_id;
    private String evaluate_answer_id;
    private String evaluate_info;
    private Clazz clazz;
    private Time time;
    private Student student;

    public Clazz getClazz() {
        return this.clazz;
    }
    
    public void setClazz(Clazz clazz ) {
        this.clazz = clazz;
    }
    
    public Time getTime() {
        return this.time;
    }
    
    public void setTime(Time time ) {
        this.time = time;
    }
    
    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student ) {
        this.student = student;
    }
    
    /**
     * 获取  字段:answer_student_evaluate.evaluate_id
     *
     * @return  answer_student_evaluate.evaluate_id
     */
    public String getEvaluate_id() {
        return evaluate_id;
    }

    /**
     * 设置  字段:answer_student_evaluate.evaluate_id
     *
     * @param evaluate_id  answer_student_evaluate.evaluate_id
     */
    public void setEvaluate_id(String evaluate_id) {
        this.evaluate_id = evaluate_id == null ? null : evaluate_id.trim();
    }

    /**
     * 获取  字段:answer_student_evaluate.evaluate_student_id
     *
     * @return  answer_student_evaluate.evaluate_student_id
     */
    public String getevaluate_student_id() {
        return evaluate_student_id;
    }

    /**
     * 设置  字段:answer_student_evaluate.evaluate_student_id
     *
     * @param evaluate_student_id  answer_student_evaluate.evaluate_student_id
     */
    public void setevaluate_student_id(String evaluate_student_id) {
        this.evaluate_student_id = evaluate_student_id == null ? null : evaluate_student_id.trim();
    }

    /**
     * 获取  字段:answer_student_evaluate.evaluate_answer_id
     *
     * @return  answer_student_evaluate.evaluate_answer_id
     */
    public String getevaluate_answer_id() {
        return evaluate_answer_id;
    }

    /**
     * 设置  字段:answer_student_evaluate.evaluate_answer_id
     *
     * @param evaluate_answer_id  answer_student_evaluate.evaluate_answer_id
     */
    public void setevaluate_answer_id(String evaluate_answer_id) {
        this.evaluate_answer_id = evaluate_answer_id == null ? null : evaluate_answer_id.trim();
    }

    /**
     * 获取  字段:answer_student_evaluate.evaluate_info
     *
     * @return  answer_student_evaluate.evaluate_info
     */
    public String getEvaluate_info() {
        return evaluate_info;
    }

    /**
     * 设置  字段:answer_student_evaluate.evaluate_info
     *
     * @param evaluate_info  answer_student_evaluate.evaluate_info
     */
    public void setEvaluate_info(String evaluate_info) {
        this.evaluate_info = evaluate_info == null ? null : evaluate_info.trim();
    }
}