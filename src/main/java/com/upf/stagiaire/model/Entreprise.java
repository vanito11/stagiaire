package com.upf.stagiaire.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Entreprise.
 */
@Entity
@Table(name = "entreprise")
public class Entreprise implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "ville")
    private String ville;

    @Column(name = "pays")
    private String pays;

    @Column(name = "email")
    private String email;

    @Column(name = "site")
    private String site;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "fax")
    private String fax;

    @OneToMany(mappedBy = "entreprise")
    @JsonIgnore
    private Set<Tuteur> tuteurs = new HashSet<>();

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

    public Entreprise nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public Entreprise ville(String ville) {
        this.ville = ville;
        return this;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public Entreprise pays(String pays) {
        this.pays = pays;
        return this;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getEmail() {
        return email;
    }

    public Entreprise email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public Entreprise site(String site) {
        this.site = site;
        return this;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getAdresse() {
        return adresse;
    }

    public Entreprise adresse(String adresse) {
        this.adresse = adresse;
        return this;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public Entreprise telephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public Entreprise fax(String fax) {
        this.fax = fax;
        return this;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Set<Tuteur> getTuteurs() {
        return tuteurs;
    }

    public Entreprise tuteurs(Set<Tuteur> tuteurs) {
        this.tuteurs = tuteurs;
        return this;
    }

    public Entreprise addTuteur(Tuteur tuteur) {
        this.tuteurs.add(tuteur);
        tuteur.setEntreprise(this);
        return this;
    }

    public Entreprise removeTuteur(Tuteur tuteur) {
        this.tuteurs.remove(tuteur);
        tuteur.setEntreprise(null);
        return this;
    }

    public void setTuteurs(Set<Tuteur> tuteurs) {
        this.tuteurs = tuteurs;
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
        Entreprise entreprise = (Entreprise) o;
        if (entreprise.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), entreprise.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Entreprise{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", ville='" + getVille() + "'" +
            ", pays='" + getPays() + "'" +
            ", email='" + getEmail() + "'" +
            ", site='" + getSite() + "'" +
            ", adresse='" + getAdresse() + "'" +
            ", telephone='" + getTelephone() + "'" +
            ", fax='" + getFax() + "'" +
            "}";
    }
}
