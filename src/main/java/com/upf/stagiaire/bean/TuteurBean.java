package com.upf.stagiaire.bean;

import java.io.Serializable;
import java.util.Date;

import com.upf.stagiaire.model.Entreprise;



public class TuteurBean implements Serializable {

    private static final long serialVersionUID = 1L;
    

    private Long id;


    private String nom;


    private String prenom;


    private Date dateNaissance;


    private String telephone;


    private String email;


    private String password;

    private Entreprise entreprise;

    public Entreprise getEntreprise() {
		return entreprise;
	}


	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}


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
    
    
}
