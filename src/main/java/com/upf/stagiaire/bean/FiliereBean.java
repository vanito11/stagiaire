package com.upf.stagiaire.bean;

import java.io.Serializable;



public class FiliereBean implements Serializable {

    private static final long serialVersionUID = 1L;
    

    private Long id;


    private String nomFiliere;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomFiliere() {
        return nomFiliere;
    }

    public void setNomFiliere(String nomFiliere) {
        this.nomFiliere = nomFiliere;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

    
}
