package com.upf.stagiaire.bean;

import java.io.Serializable;

import com.upf.stagiaire.model.Date;


public class DateBean implements Serializable  {
    private static final long serialVersionUID = 1L;
    

    private Long id;


    private String date;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }


    
}
