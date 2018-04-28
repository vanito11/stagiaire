package com.upf.stagiaire.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Filiere.
 */
@Entity
@Table(name = "filiere")
public class Filiere implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom_filiere")
    private String nomFiliere;

    @Column(name = "description")
    private String description;

    @ManyToOne
    private Administrateur administrateur;

    @OneToMany(mappedBy = "filiere")
    @JsonIgnore
    private Set<Stagiaire> stagiaires = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomFiliere() {
        return nomFiliere;
    }

    public Filiere nomFiliere(String nomFiliere) {
        this.nomFiliere = nomFiliere;
        return this;
    }

    public void setNomFiliere(String nomFiliere) {
        this.nomFiliere = nomFiliere;
    }

    public String getDescription() {
        return description;
    }

    public Filiere description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public Filiere administrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
        return this;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }

    public Set<Stagiaire> getStagiaires() {
        return stagiaires;
    }

    public Filiere stagiaires(Set<Stagiaire> stagiaires) {
        this.stagiaires = stagiaires;
        return this;
    }

    public Filiere addStagiaire(Stagiaire stagiaire) {
        this.stagiaires.add(stagiaire);
        stagiaire.setFiliere(this);
        return this;
    }

    public Filiere removeStagiaire(Stagiaire stagiaire) {
        this.stagiaires.remove(stagiaire);
        stagiaire.setFiliere(null);
        return this;
    }

    public void setStagiaires(Set<Stagiaire> stagiaires) {
        this.stagiaires = stagiaires;
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
        Filiere filiere = (Filiere) o;
        if (filiere.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), filiere.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Filiere{" +
            "id=" + getId() +
            ", nomFiliere='" + getNomFiliere() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
