package com.upf.stagiaire.bean;

import java.io.Serializable;


public class EntrepriseBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id;


    private String nom;


    private String ville;


    private String pays;


    private String email;

    private String site;


    private String adresse;


    private String telephone;


    private String fax;


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


    public String getVille() {
        return ville;
    }


    public void setVille(String ville) {
        this.ville = ville;
    }


    public String getPays() {
        return pays;
    }


    public void setPays(String pays) {
        this.pays = pays;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getSite() {
        return site;
    }


    public void setSite(String site) {
        this.site = site;
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

    public String getFax() {
        return fax;
    }


    public void setFax(String fax) {
        this.fax = fax;
    }

    
}
