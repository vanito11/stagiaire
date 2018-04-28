/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upf.stagiaire.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Zakariae
 */

public class AdminBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nom;

	private String prenom;

	private Date dateNaissance;

	private String adresse;

	private String telephone;

	private String email;

	private String password;

	public AdminBean() {
	}

	public AdminBean(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, dateNaissance, adresse, telephone, email, password);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof AdminBean) {
            AdminBean that = (AdminBean) object;
            return Objects.equals(this.id, that.id)
                    && Objects.equals(this.nom, that.nom)
                    && Objects.equals(this.prenom, that.prenom)
                    && Objects.equals(this.dateNaissance, that.dateNaissance)
                    && Objects.equals(this.adresse, that.adresse)
                    && Objects.equals(this.telephone, that.telephone)
                    && Objects.equals(this.email, that.email)
                    && Objects.equals(this.password, that.password);
        }
        return false;
    }
	
	

}
