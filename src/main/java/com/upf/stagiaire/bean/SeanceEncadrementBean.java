package com.upf.stagiaire.bean;

import java.io.Serializable;




public class SeanceEncadrementBean implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    private String dateEncadrement;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateEncadrement() {
        return dateEncadrement;
    }

    public void setDateEncadrement(String dateEncadrement) {
        this.dateEncadrement = dateEncadrement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
