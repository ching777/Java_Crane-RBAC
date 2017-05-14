package com.crane.commons.web;

import java.beans.PropertyEditorSupport;
import java.util.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.crane.commons.helper.DateHelper;

public abstract class BaseController {
    @InitBinder
    public void date(WebDataBinder dataBinder){
        dataBinder.registerCustomEditor(Date.class , new PropertyEditorSupport(){
            @Override
            public void setAsText(String text){
                setValue(DateHelper.parseDate(text));
            }
        });
    }
}
