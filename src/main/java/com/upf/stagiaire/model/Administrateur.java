package com.upf.stagiaire.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import java.util.Date;
/**
 * A Administrateur.
 */
@Entity
@Table(name = "administrateur")
public class Administrateur implements Serializable {

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

    @Column(name = "emil")
    private String emil;

    @Column(name = "jhi_password")
    private String password;

    @OneToMany(mappedBy = "administrateur")
    @JsonIgnore
    private Set<Filiere> filieres = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public Administrateur nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Administrateur prenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public Administrateur dateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
        return this;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public Administrateur adresse(String adresse) {
        this.adresse = adresse;
        return this;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public Administrateur telephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmil() {
        return emil;
    }

    public Administrateur emil(String emil) {
        this.emil = emil;
        return this;
    }

    public void setEmil(String emil) {
        this.emil = emil;
    }

    public String getPassword() {
        return password;
    }

    public Administrateur password(String password) {
        this.password = password;
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Filiere> getFilieres() {
        return filieres;
    }

    public Administrateur filieres(Set<Filiere> filieres) {
        this.filieres = filieres;
        return this;
    }

    public Administrateur addFiliere(Filiere filiere) {
        this.filieres.add(filiere);
        filiere.setAdministrateur(this);
        return this;
    }

    public Administrateur removeFiliere(Filiere filiere) {
        this.filieres.remove(filiere);
        filiere.setAdministrateur(null);
        return this;
    }

    public void setFilieres(Set<Filiere> filieres) {
        this.filieres = filieres;
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
        Administrateur administrateur = (Administrateur) o;
        if (administrateur.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), administrateur.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Administrateur{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", prenom='" + getPrenom() + "'" +
            ", dateNaissance='" + getDateNaissance() + "'" +
            ", adresse='" + getAdresse() + "'" +
            ", telephone='" + getTelephone() + "'" +
            ", emil='" + getEmil() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }
}
