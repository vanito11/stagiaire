package com.upf.stagiaire.bean;

import java.io.Serializable;
import java.util.Date;



public class SeanceEncadrementBean implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    private Date dateEncadrement;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateEncadrement() {
        return dateEncadrement;
    }

    public void setDateEncadrement(Date dateEncadrement) {
        this.dateEncadrement = dateEncadrement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
