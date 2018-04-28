package com.upf.stagiaire.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A TypeSoutenance.
 */
@Entity
@Table(name = "type_soutenance")
public class TypeSoutenance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "jhi_type")
    private String type;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "typeSoutenance")
    @JsonIgnore
    private Set<Soutenance> soutenances = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public TypeSoutenance type(String type) {
        this.type = type;
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public TypeSoutenance description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Soutenance> getSoutenances() {
        return soutenances;
    }

    public TypeSoutenance soutenances(Set<Soutenance> soutenances) {
        this.soutenances = soutenances;
        return this;
    }

    public TypeSoutenance addSoutenance(Soutenance soutenance) {
        this.soutenances.add(soutenance);
        soutenance.setTypeSoutenance(this);
        return this;
    }

    public TypeSoutenance removeSoutenance(Soutenance soutenance) {
        this.soutenances.remove(soutenance);
        soutenance.setTypeSoutenance(null);
        return this;
    }

    public void setSoutenances(Set<Soutenance> soutenances) {
        this.soutenances = soutenances;
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
        TypeSoutenance typeSoutenance = (TypeSoutenance) o;
        if (typeSoutenance.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), typeSoutenance.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TypeSoutenance{" +
            "id=" + getId() +
            ", type='" + getType() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
