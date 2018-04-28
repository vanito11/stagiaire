package com.upf.stagiaire.bean;

import java.io.Serializable;
import java.util.Date;



public class AdministrateurBean  implements Serializable {
    private static final long serialVersionUID = 1L;
    

    private Long id;


    private String nom;


    private String prenom;


    private Date dateNaissance;


    private String adresse;


    private String telephone;


    private String emil;


    private String password;


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


    public String getEmil() {
        return emil;
    }


    public void setEmil(String emil) {
        this.emil = emil;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    }
