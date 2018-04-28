package com.upf.stagiaire.bean;

import java.io.Serializable;
import java.util.Date;

public class VisiteBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long id;
    
    private Date date;
    
    private String description;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
}
