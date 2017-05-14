/**
 * Time.java
 * ©2006-2016 四海兴唐科技有限公司
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-02-09 11:26:05
 **/
package com.crane.answer.timemanage.model;

import java.util.Date;

import com.crane.answer.clazzmanage.model.Clazz;

/**
 * answer_time_manage 类
 * @Description :
 *
 * @author 胖先生
 * @version 1.0
 * 文件创建于: 2017-02-09 11:26:05
 **/
public class Time {
    
    private String answer_id;
    /**申请日期,所属表字段为 answer_time_manage.answer_apple_date  */
    private Date answer_apple_date;
    private String fk_class_id;
    private Integer answer_people_number;
    /**答辩题目,所属表字段为 answer_time_manage.answer_question  */
    private String answer_question;
    /**评委姓名,所属表字段为 answer_time_manage.answer_judge_name  */
    private String answer_judge_name;
    /**答辩状态,所属表字段为 answer_time_manage.answer_states  */
    private String answer_states;
    /**延期原因,所属表字段为 answer_time_manage.answer_delay_reason  */
    private String answer_delay_reason;
    private Clazz clazz;
    
    @Override
    public String toString() {
        return "Time [answer_id=" + this.answer_id + ", answer_apple_date=" + this.answer_apple_date + ", fk_class_id="
                + this.fk_class_id + ", answer_people_number=" + this.answer_people_number + ", answer_question="
                + this.answer_question + ", answer_judge_name=" + this.answer_judge_name + ", answer_states="
                + this.answer_states + ", answer_delay_reason=" + this.answer_delay_reason + ", clazz=" + this.clazz
                + "]";
    }
    
    public Clazz getClazz() {
        return this.clazz;
    }
    
    public void setClazz(Clazz clazz ) {
        this.clazz = clazz;
    }
    
    /**
     * 获取  字段:answer_time_manage.answer_id
     *
     * @return  answer_time_manage.answer_id
     */
    public String getAnswer_id() {
        return answer_id;
    }
    
    /**
     * 设置  字段:answer_time_manage.answer_id
     *
     * @param answer_id  answer_time_manage.answer_id
     */
    public void setAnswer_id(String answer_id) {
        this.answer_id = answer_id == null ? null : answer_id.trim();
    }
    
    /**
     * 获取 申请日期 字段:answer_time_manage.answer_apple_date
     *
     * @return  answer_time_manage.answer_apple_date  ,申请日期
     */
    public Date getAnswer_apple_date() {
        return answer_apple_date;
    }
    
    /**
     * 设置 申请日期 字段:answer_time_manage.answer_apple_date
     *
     * @param answer_apple_date  answer_time_manage.answer_apple_date,申请日期
     */
    public void setAnswer_apple_date(Date answer_apple_date) {
        this.answer_apple_date = answer_apple_date;
    }
    
    /**
     * 获取  字段:answer_time_manage.fk_class_id
     *
     * @return  answer_time_manage.fk_class_id
     */
    public String getFk_class_id() {
        return fk_class_id;
    }
    
    /**
     * 设置  字段:answer_time_manage.fk_class_id
     *
     * @param fk_class_id  answer_time_manage.fk_class_id
     */
    public void setFk_class_id(String fk_class_id) {
        this.fk_class_id = fk_class_id == null ? null : fk_class_id.trim();
    }
    
    /**
     * 获取  字段:answer_time_manage.answer_people_number
     *
     * @return  answer_time_manage.answer_people_number
     */
    public Integer getAnswer_people_number() {
        return answer_people_number;
    }
    
    /**
     * 设置  字段:answer_time_manage.answer_people_number
     *
     * @param answer_people_number  answer_time_manage.answer_people_number
     */
    public void setAnswer_people_number(Integer answer_people_number) {
        this.answer_people_number = answer_people_number;
    }
    
    /**
     * 获取 答辩题目 字段:answer_time_manage.answer_question
     *
     * @return  answer_time_manage.answer_question  ,答辩题目
     */
    public String getAnswer_question() {
        return answer_question;
    }
    
    /**
     * 设置 答辩题目 字段:answer_time_manage.answer_question
     *
     * @param answer_question  answer_time_manage.answer_question,答辩题目
     */
    public void setAnswer_question(String answer_question) {
        this.answer_question = answer_question == null ? null : answer_question.trim();
    }
    
    /**
     * 获取 评委姓名 字段:answer_time_manage.answer_judge_name
     *
     * @return  answer_time_manage.answer_judge_name  ,评委姓名
     */
    public String getAnswer_judge_name() {
        return answer_judge_name;
    }
    
    /**
     * 设置 评委姓名 字段:answer_time_manage.answer_judge_name
     *
     * @param answer_judge_name  answer_time_manage.answer_judge_name,评委姓名
     */
    public void setAnswer_judge_name(String answer_judge_name) {
        this.answer_judge_name = answer_judge_name == null ? null : answer_judge_name.trim();
    }
    
    /**
     * 获取 答辩状态 字段:answer_time_manage.answer_states
     *
     * @return  answer_time_manage.answer_states  ,答辩状态
     */
    public String getAnswer_states() {
        return answer_states;
    }
    
    /**
     * 设置 答辩状态 字段:answer_time_manage.answer_states
     *
     * @param answer_states  answer_time_manage.answer_states,答辩状态
     */
    public void setAnswer_states(String answer_states) {
        this.answer_states = answer_states == null ? null : answer_states.trim();
    }
    
    /**
     * 获取 延期原因 字段:answer_time_manage.answer_delay_reason
     *
     * @return  answer_time_manage.answer_delay_reason  ,延期原因
     */
    public String getAnswer_delay_reason() {
        return answer_delay_reason;
    }
    
    /**
     * 设置 延期原因 字段:answer_time_manage.answer_delay_reason
     *
     * @param answer_delay_reason  answer_time_manage.answer_delay_reason,延期原因
     */
    public void setAnswer_delay_reason(String answer_delay_reason) {
        this.answer_delay_reason = answer_delay_reason == null ? null : answer_delay_reason.trim();
    }
}