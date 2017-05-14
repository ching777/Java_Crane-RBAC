/**
 * Score.java
 * ©2006-2016 四海兴唐科技有限公司
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-02-11 12:51:02
 **/
package com.crane.answer.score.model;

/**
 * answer_score_manage 类
 * @Description :
 *
 * @author 胖先生
 * @version 1.0
 * 文件创建于: 2017-02-11 12:51:02
 **/
public class Score {

    @Override
    public String toString() {
        return "Score [score_id=" + this.score_id + ", score_student_id=" + this.score_student_id + ", score_answer_id="
                + this.score_answer_id + ", score_ppt=" + this.score_ppt + ", score_express=" + this.score_express
                + ", score_code=" + this.score_code + ", score_function=" + this.score_function + ", score_basal="
                + this.score_basal + ", score_robust=" + this.score_robust + ", score_safe=" + this.score_safe
                + ", score_other=" + this.score_other + ", score_student_teacher=" + this.score_student_teacher
                + ", score_oral=" + this.score_oral + ", score_total=" + this.score_total + ", score_class_stage="
                + this.score_class_stage + ", class_name=" + this.class_name + ", answer_question="
                + this.answer_question + "]";
    }

    private String score_id;
    private String score_student_id;
    private String score_answer_id;
    /**ppt成绩,所属表字段为 answer_score_manage.score_ppt  */
    private Integer score_ppt;
    /**表达成绩,所属表字段为 answer_score_manage.score_express  */
    private Integer score_express;
    /**代码掌握,所属表字段为 answer_score_manage.score_code  */
    private Integer score_code;
    /**功能评分,所属表字段为 answer_score_manage.score_function  */
    private Integer score_function;
    /**基础知识评分,所属表字段为 answer_score_manage.score_basal  */
    private Integer score_basal;
    /**健壮性,所属表字段为 answer_score_manage.score_robust  */
    private Integer score_robust;
    /**安全性,所属表字段为 answer_score_manage.score_safe  */
    private Integer score_safe;
    /**其他评分,所属表字段为 answer_score_manage.score_other  */
    private Integer score_other;
    /**任课老师评分,所属表字段为 answer_score_manage.score_student_teacher  */
    private String score_student_teacher;
    /**笔试成绩,所属表字段为 answer_score_manage.score_oral  */
    private Integer score_oral;
    /**总成绩,所属表字段为 answer_score_manage.score_total  */
    private Integer score_total;
    private Integer score_class_stage;
    private Integer score_add;
    private String class_name;
    private String answer_question;
    private String student_name;
    private String student_id;
    private String answer_id;

    public String getClass_name() {
        return this.class_name;
    }
    
    public void setClass_name(String class_name ) {
        this.class_name = class_name;
    }
    
    public String getAnswer_question() {
        return this.answer_question;
    }
    
    public void setAnswer_question(String answer_question ) {
        this.answer_question = answer_question;
    }
    

    /**
     * 获取  字段:answer_score_manage.score_id
     *
     * @return  answer_score_manage.score_id
     */
    public String getScore_id() {
        return score_id;
    }

    /**
     * 设置  字段:answer_score_manage.score_id
     *
     * @param score_id  answer_score_manage.score_id
     */
    public void setScore_id(String score_id) {
        this.score_id = score_id == null ? null : score_id.trim();
    }

    /**
     * 获取  字段:answer_score_manage.score_student_id
     *
     * @return  answer_score_manage.score_student_id
     */
    public String getScore_student_id() {
        return score_student_id;
    }

    /**
     * 设置  字段:answer_score_manage.score_student_id
     *
     * @param score_student_id  answer_score_manage.score_student_id
     */
    public void setScore_student_id(String score_student_id) {
        this.score_student_id = score_student_id == null ? null : score_student_id.trim();
    }

    /**
     * 获取  字段:answer_score_manage.score_answer_id
     *
     * @return  answer_score_manage.score_answer_id
     */
    public String getScore_answer_id() {
        return score_answer_id;
    }

    /**
     * 设置  字段:answer_score_manage.score_answer_id
     *
     * @param score_answer_id  answer_score_manage.score_answer_id
     */
    public void setScore_answer_id(String score_answer_id) {
        this.score_answer_id = score_answer_id == null ? null : score_answer_id.trim();
    }

    /**
     * 获取 ppt成绩 字段:answer_score_manage.score_ppt
     *
     * @return  answer_score_manage.score_ppt  ,ppt成绩
     */
    public Integer getScore_ppt() {
        return score_ppt;
    }

    /**
     * 设置 ppt成绩 字段:answer_score_manage.score_ppt
     *
     * @param score_ppt  answer_score_manage.score_ppt,ppt成绩
     */
    public void setScore_ppt(Integer score_ppt) {
        this.score_ppt = score_ppt;
    }

    /**
     * 获取 表达成绩 字段:answer_score_manage.score_express
     *
     * @return  answer_score_manage.score_express  ,表达成绩
     */
    public Integer getScore_express() {
        return score_express;
    }

    /**
     * 设置 表达成绩 字段:answer_score_manage.score_express
     *
     * @param score_express  answer_score_manage.score_express,表达成绩
     */
    public void setScore_express(Integer score_express) {
        this.score_express = score_express;
    }

    /**
     * 获取 代码掌握 字段:answer_score_manage.score_code
     *
     * @return  answer_score_manage.score_code  ,代码掌握
     */
    public Integer getScore_code() {
        return score_code;
    }

    /**
     * 设置 代码掌握 字段:answer_score_manage.score_code
     *
     * @param score_code  answer_score_manage.score_code,代码掌握
     */
    public void setScore_code(Integer score_code) {
        this.score_code = score_code;
    }

    /**
     * 获取 功能评分 字段:answer_score_manage.score_function
     *
     * @return  answer_score_manage.score_function  ,功能评分
     */
    public Integer getScore_function() {
        return score_function;
    }

    /**
     * 设置 功能评分 字段:answer_score_manage.score_function
     *
     * @param score_function  answer_score_manage.score_function,功能评分
     */
    public void setScore_function(Integer score_function) {
        this.score_function = score_function;
    }

    /**
     * 获取 基础知识评分 字段:answer_score_manage.score_basal
     *
     * @return  answer_score_manage.score_basal  ,基础知识评分
     */
    public Integer getScore_basal() {
        return score_basal;
    }

    /**
     * 设置 基础知识评分 字段:answer_score_manage.score_basal
     *
     * @param score_basal  answer_score_manage.score_basal,基础知识评分
     */
    public void setScore_basal(Integer score_basal) {
        this.score_basal = score_basal;
    }

    /**
     * 获取 健壮性 字段:answer_score_manage.score_robust
     *
     * @return  answer_score_manage.score_robust  ,健壮性
     */
    public Integer getScore_robust() {
        return score_robust;
    }

    /**
     * 设置 健壮性 字段:answer_score_manage.score_robust
     *
     * @param score_robust  answer_score_manage.score_robust,健壮性
     */
    public void setScore_robust(Integer score_robust) {
        this.score_robust = score_robust;
    }

    /**
     * 获取 安全性 字段:answer_score_manage.score_safe
     *
     * @return  answer_score_manage.score_safe  ,安全性
     */
    public Integer getScore_safe() {
        return score_safe;
    }

    /**
     * 设置 安全性 字段:answer_score_manage.score_safe
     *
     * @param score_safe  answer_score_manage.score_safe,安全性
     */
    public void setScore_safe(Integer score_safe) {
        this.score_safe = score_safe;
    }

    /**
     * 获取 其他评分 字段:answer_score_manage.score_other
     *
     * @return  answer_score_manage.score_other  ,其他评分
     */
    public Integer getScore_other() {
        return score_other;
    }

    /**
     * 设置 其他评分 字段:answer_score_manage.score_other
     *
     * @param score_other  answer_score_manage.score_other,其他评分
     */
    public void setScore_other(Integer score_other) {
        this.score_other = score_other;
    }

    /**
     * 获取 任课老师评分 字段:answer_score_manage.score_student_teacher
     *
     * @return  answer_score_manage.score_student_teacher  ,任课老师评分
     */
    public String getScore_student_teacher() {
        return score_student_teacher;
    }

    /**
     * 设置 任课老师评分 字段:answer_score_manage.score_student_teacher
     *
     * @param score_student_teacher  answer_score_manage.score_student_teacher,任课老师评分
     */
    public void setScore_student_teacher(String score_student_teacher) {
        this.score_student_teacher = score_student_teacher;
    }

    /**
     * 获取 笔试成绩 字段:answer_score_manage.score_oral
     *
     * @return  answer_score_manage.score_oral  ,笔试成绩
     */
    public Integer getScore_oral() {
        return score_oral;
    }

    /**
     * 设置 笔试成绩 字段:answer_score_manage.score_oral
     *
     * @param score_oral  answer_score_manage.score_oral,笔试成绩
     */
    public void setScore_oral(Integer score_oral) {
        this.score_oral = score_oral;
    }

    /**
     * 获取 总成绩 字段:answer_score_manage.score_total
     *
     * @return  answer_score_manage.score_total  ,总成绩
     */
    public Integer getScore_total() {
        return score_total;
    }

    /**
     * 设置 总成绩 字段:answer_score_manage.score_total
     *
     * @param score_total  answer_score_manage.score_total,总成绩
     */
    public void setScore_total(Integer score_total) {
        this.score_total = score_total;
    }

    public Integer getScore_class_stage() {
        return score_class_stage;
    }

    public void setScore_class_stage(Integer score_class_stage ) {
        this.score_class_stage = score_class_stage;
    }
    
    public String getStudent_name() {
        return student_name;
    }
    
    public void setStudent_name(String student_name ) {
        this.student_name = student_name;
    }

    public Integer getScore_add() {
        return score_add;
    }

    public void setScore_add(Integer score_add ) {
        this.score_add = score_add;
    }
    
    public String getStudent_id() {
        return student_id;
    }
    
    public void setStudent_id(String student_id ) {
        this.student_id = student_id;
    }

    public String getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(String answer_id ) {
        this.answer_id = answer_id;
    }
}