package com.upf.stagiaire.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Etat.
 */
@Entity
@Table(name = "etat")
public class Etat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "etat")
    private String etat;

    @OneToMany(mappedBy = "etat")
    @JsonIgnore
    private Set<Stage> stages = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEtat() {
        return etat;
    }

    public Etat etat(String etat) {
        this.etat = etat;
        return this;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Set<Stage> getStages() {
        return stages;
    }

    public Etat stages(Set<Stage> stages) {
        this.stages = stages;
        return this;
    }

    public Etat addStage(Stage stage) {
        this.stages.add(stage);
        stage.setEtat(this);
        return this;
    }

    public Etat removeStage(Stage stage) {
        this.stages.remove(stage);
        stage.setEtat(null);
        return this;
    }

    public void setStages(Set<Stage> stages) {
        this.stages = stages;
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
        Etat etat = (Etat) o;
        if (etat.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), etat.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Etat{" +
            "id=" + getId() +
            ", etat='" + getEtat() + "'" +
            "}";
    }
}
