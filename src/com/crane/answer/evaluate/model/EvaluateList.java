package com.crane.answer.evaluate.model;

public class EvaluateList {
    private String evaluate_id;
    private String evaluate_info;
    private String student_name;
    private String class_name;
    private String class_stage;
    private String answer_question;
    private String Student_id;
    private String answer_id;


    public String getStudent_id() {
        return this.Student_id;
    }
    public void setStudent_id(String student_id ) {
        this.Student_id = student_id;
    }
    public String getAnswer_id() {
        return this.answer_id;
    }
    public void setAnswer_id(String answer_id ) {
        this.answer_id = answer_id;
    }
    public String getClass_stage() {
        return this.class_stage;
    }
    public void setClass_stage(String class_stage ) {
        this.class_stage = class_stage;
    }

    public String getEvaluate_id() {
        return this.evaluate_id;
    }
    public void setEvaluate_id(String evaluate_id ) {
        this.evaluate_id = evaluate_id;
    }
    public String getEvaluate_info() {
        return this.evaluate_info;
    }
    public void setEvaluate_info(String evaluate_info ) {
        this.evaluate_info = evaluate_info;
    }
    public String getStudent_name() {
        return this.student_name;
    }
    public void setStudent_name(String student_name ) {
        this.student_name = student_name;
    }
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
    
}
