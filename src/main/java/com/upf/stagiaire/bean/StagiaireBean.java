package com.upf.stagiaire.bean;

import java.io.Serializable;
import java.util.Date;



public class StagiaireBean implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    private String nom;

    private String prenom;

    private Date dateNaissance;

    private String nationnalite;


    private String adresse;


    private String telephone;


    private String email;


    private String password;


    private String photo;


    private String niveau;


    private String cv;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getPrenom() {
        return prenom;
    }


    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public Date getDateNaissance() {
        return dateNaissance;
    }


    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }


    public String getNationnalite() {
        return nationnalite;
    }


    public void setNationnalite(String nationnalite) {
        this.nationnalite = nationnalite;
    }


    public String getAdresse() {
        return adresse;
    }


    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public String getTelephone() {
        return telephone;
    }


    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getPhoto() {
        return photo;
    }


    public void setPhoto(String photo) {
        this.photo = photo;
    }


    public String getNiveau() {
        return niveau;
    }


    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }


    public String getCv() {
        return cv;
    }


    public void setCv(String cv) {
        this.cv = cv;
    }
    
    
}
