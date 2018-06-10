package com.upf.stagiaire.bean;

import java.io.Serializable;
import java.util.Date;


public class SoutenanceBean implements Serializable {

    private static final long serialVersionUID = 1L;

 
    private Long id;

    private String dateSoutenance;

    private Integer encadrant;


    private Integer tuteur;


    private String president;


    private String exminateur1;


    private String examinateur2;


    private String rapporteur;


    private String rapport;


    private String description;


    private Float note;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getDateSoutenance() {
        return dateSoutenance;
    }


    public void setDateSoutenance(String dateSoutenance) {
        this.dateSoutenance = dateSoutenance;
    }


    public Integer getEncadrant() {
        return encadrant;
    }


    public void setEncadrant(Integer encadrant) {
        this.encadrant = encadrant;
    }


    public Integer getTuteur() {
        return tuteur;
    }


    public void setTuteur(Integer tuteur) {
        this.tuteur = tuteur;
    }


    public String getPresident() {
        return president;
    }


    public void setPresident(String president) {
        this.president = president;
    }


    public String getExminateur1() {
        return exminateur1;
    }


    public void setExminateur1(String exminateur1) {
        this.exminateur1 = exminateur1;
    }


    public String getExaminateur2() {
        return examinateur2;
    }


    public void setExaminateur2(String examinateur2) {
        this.examinateur2 = examinateur2;
    }


    public String getRapporteur() {
        return rapporteur;
    }


    public void setRapporteur(String rapporteur) {
        this.rapporteur = rapporteur;
    }


    public String getRapport() {
        return rapport;
    }


    public void setRapport(String rapport) {
        this.rapport = rapport;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public Float getNote() {
        return note;
    }


    public void setNote(Float note) {
        this.note = note;
    }

    
}
