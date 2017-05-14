/**
 * Works.java
 * ©2006-2016 四海兴唐科技有限公司
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-02-12 12:53:33
 **/
package com.crane.answer.works.model;

/**
 * answer_works_manage 类
 * @Description :
 *
 * @author 胖先生
 * @version 1.0
 * 文件创建于: 2017-02-12 12:53:33
 **/
public class Works {
    
    private String works_id;
    private String works_student_id;
    private String works_answer_id;
    /**标签说明,所属表字段为 answer_works_manage.works_label  */
    private String works_label;
    /**源码上传,所属表字段为 answer_works_manage.works_code_update  */
    private String works_code_update;
    /**脚本文件,所属表字段为 answer_works_manage.works_js_data  */
    private String works_js_data;
    private String works_video;
    private String works_states;
    private String student_name;
    private String answer_question;
    private String class_name;
    private String student_id;
    private String answer_id;
    private String old_code;
    private String old_js;
    private String old_video;


    
    public String getOld_code() {
        return this.old_code;
    }
    
    public void setOld_code(String old_code ) {
        this.old_code = old_code;
    }
    
    public String getOld_js() {
        return this.old_js;
    }
    
    public void setOld_js(String old_js ) {
        this.old_js = old_js;
    }
    
    public String getOld_video() {
        return this.old_video;
    }
    
    public void setOld_video(String old_video ) {
        this.old_video = old_video;
    }
    
    
    @Override
    public String toString() {
        return "Works [works_id=" + this.works_id + ", works_student_id=" + this.works_student_id + ", works_answer_id="
                + this.works_answer_id + ", works_label=" + this.works_label + ", works_code_update="
                + this.works_code_update + ", works_js_data=" + this.works_js_data + ", works_video=" + this.works_video
                + ", works_states=" + this.works_states + ", student_name=" + this.student_name + ", answer_question="
                + this.answer_question + ", class_name=" + this.class_name + ", student_id=" + this.student_id
                + ", answer_id=" + this.answer_id + ", old_code=" + this.old_code + ", old_js=" + this.old_js
                + ", old_video=" + this.old_video + "]";
    }
    
    public String getStudent_name() {
        return this.student_name;
    }

    public void setStudent_name(String student_name ) {
        this.student_name = student_name.trim();
    }

    public String getAnswer_question() {
        return this.answer_question;
    }

    public void setAnswer_question(String answer_question ) {
        this.answer_question = answer_question.trim();
    }

    /**
     * 获取  字段:answer_works_manage.works_id
     *
     * @return  answer_works_manage.works_id
     */
    public String getWorks_id() {
        return works_id;
    }
    
    /**
     * 设置  字段:answer_works_manage.works_id
     *
     * @param works_id  answer_works_manage.works_id
     */
    public void setWorks_id(String works_id) {
        this.works_id = works_id == null ? null : works_id.trim();
    }
    
    /**
     * 获取  字段:answer_works_manage.works_student_id
     *
     * @return  answer_works_manage.works_student_id
     */
    public String getWorks_student_id() {
        return works_student_id;
    }
    
    /**
     * 设置  字段:answer_works_manage.works_student_id
     *
     * @param works_student_id  answer_works_manage.works_student_id
     */
    public void setWorks_student_id(String works_student_id) {
        this.works_student_id = works_student_id == null ? null : works_student_id.trim();
    }
    
    /**
     * 获取  字段:answer_works_manage.works_answer_id
     *
     * @return  answer_works_manage.works_answer_id
     */
    public String getWorks_answer_id() {
        return works_answer_id;
    }
    
    /**
     * 设置  字段:answer_works_manage.works_answer_id
     *
     * @param works_answer_id  answer_works_manage.works_answer_id
     */
    public void setWorks_answer_id(String works_answer_id) {
        this.works_answer_id = works_answer_id == null ? null : works_answer_id.trim();
    }
    
    /**
     * 获取 标签说明 字段:answer_works_manage.works_label
     *
     * @return  answer_works_manage.works_label  ,标签说明
     */
    public String getWorks_label() {
        return works_label;
    }
    
    /**
     * 设置 标签说明 字段:answer_works_manage.works_label
     *
     * @param works_label  answer_works_manage.works_label,标签说明
     */
    public void setWorks_label(String works_label) {
        this.works_label = works_label == null ? null : works_label.trim();
    }
    
    /**
     * 获取 源码上传 字段:answer_works_manage.works_code_update
     *
     * @return  answer_works_manage.works_code_update  ,源码上传
     */
    public String getWorks_code_update() {
        return works_code_update;
    }
    
    /**
     * 设置 源码上传 字段:answer_works_manage.works_code_update
     *
     * @param works_code_update  answer_works_manage.works_code_update,源码上传
     */
    public void setWorks_code_update(String works_code_update) {
        this.works_code_update = works_code_update == null ? null : works_code_update.trim();
    }
    
    /**
     * 获取 脚本文件 字段:answer_works_manage.works_js_data
     *
     * @return  answer_works_manage.works_js_data  ,脚本文件
     */
    public String getWorks_js_data() {
        return works_js_data;
    }
    
    /**
     * 设置 脚本文件 字段:answer_works_manage.works_js_data
     *
     * @param works_js_data  answer_works_manage.works_js_data,脚本文件
     */
    public void setWorks_js_data(String works_js_data) {
        this.works_js_data = works_js_data == null ? null : works_js_data.trim();
    }
    
    /**
     * 获取  字段:answer_works_manage.works_video
     *
     * @return  answer_works_manage.works_video
     */
    public String getWorks_video() {
        return works_video;
    }
    
    /**
     * 设置  字段:answer_works_manage.works_video
     *
     * @param works_video  answer_works_manage.works_video
     */
    public void setWorks_video(String works_video) {
        this.works_video = works_video == null ? null : works_video.trim();
    }
    
    /**
     * 获取  字段:answer_works_manage.works_states
     *
     * @return  answer_works_manage.works_states
     */
    public String getWorks_states() {
        return works_states;
    }
    
    /**
     * 设置  字段:answer_works_manage.works_states
     *
     * @param works_states  answer_works_manage.works_states
     */
    public void setWorks_states(String works_states) {
        this.works_states = works_states == null ? null : works_states.trim();
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name ) {
        this.class_name = class_name;
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