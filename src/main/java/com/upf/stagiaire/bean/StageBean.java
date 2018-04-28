package com.upf.stagiaire.bean;

import java.io.Serializable;

public class StageBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long id;
    
    private String sujet;
    
    private String description;
    
    private Float duree;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getDuree() {
        return duree;
    }

    public void setDuree(Float duree) {
        this.duree = duree;
    }
    
}
