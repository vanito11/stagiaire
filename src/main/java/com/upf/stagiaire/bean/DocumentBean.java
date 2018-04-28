package com.upf.stagiaire.bean;

import java.io.Serializable;
import java.util.Date;



public class DocumentBean implements Serializable  {
    private static final long serialVersionUID = 1L;
    private Long id;


    private String document;


    private String description;


    private Date dateSoumission;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getDocument() {
        return document;
    }


    public void setDocument(String document) {
        this.document = document;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public Date getDateSoumission() {
        return dateSoumission;
    }


    public void setDateSoumission(Date dateSoumission) {
        this.dateSoumission = dateSoumission;
    }
    
    
}
