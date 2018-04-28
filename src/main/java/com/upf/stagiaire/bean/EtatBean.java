package com.upf.stagiaire.bean;

import java.io.Serializable;



public class EtatBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;


    private String etat;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getEtat() {
        return etat;
    }


    public void setEtat(String etat) {
        this.etat = etat;
    }

    
}
