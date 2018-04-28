package com.upf.stagiaire.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A Admins.
 */
@Entity
@Table(name = "admins")
public class Admins implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nom")
    private String nom;
    
    @Column(name = "prenom")
    private String prenom;
    
    @Column(name = "date_naissance")
    private Date dateNaissance;
    
    @Column(name = "adresse")
    private String adresse;
    
    @Column(name = "telephone")
    private String telephone;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "jhi_password")
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
    
    public Admins nom(String nom) {
        this.nom = nom;
        return this;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public Admins prenom(String prenom) {
        this.prenom = prenom;
        return this;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public Date getDateNaissance() {
        return dateNaissance;
    }
    
    public Admins dateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
        return this;
    }
    
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    
    public String getAdresse() {
        return adresse;
    }
    
    public Admins adresse(String adresse) {
        this.adresse = adresse;
        return this;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    public String getTelephone() {
        return telephone;
    }
    
    public Admins telephone(String telephone) {
        this.telephone = telephone;
        return this;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public Admins email(String email) {
        this.email = email;
        return this;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public Admins password(String password) {
        this.password = password;
        return this;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Admins admins = (Admins) o;
        if (admins.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), admins.getId());
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
    
    @Override
    public String toString() {
        return "Admins{" +
                "id=" + getId() +
                ", nom='" + getNom() + "'" +
                ", prenom='" + getPrenom() + "'" +
                ", dateNaissance='" + getDateNaissance() + "'" +
                ", adresse='" + getAdresse() + "'" +
                ", telephone='" + getTelephone() + "'" +
                ", email='" + getEmail() + "'" +
                ", password='" + getPassword() + "'" +
                "}";
    }
}
