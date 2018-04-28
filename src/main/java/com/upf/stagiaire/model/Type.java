package com.upf.stagiaire.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Type.
 */
@Entity
@Table(name = "type")
public class Type implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "jhi_type")
    private String type;

    @OneToMany(mappedBy = "type")
    @JsonIgnore
    private Set<Stage> stages = new HashSet<>();

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

    public Type type(String type) {
        this.type = type;
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Stage> getStages() {
        return stages;
    }

    public Type stages(Set<Stage> stages) {
        this.stages = stages;
        return this;
    }

    public Type addStage(Stage stage) {
        this.stages.add(stage);
        stage.setType(this);
        return this;
    }

    public Type removeStage(Stage stage) {
        this.stages.remove(stage);
        stage.setType(null);
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
        Type type = (Type) o;
        if (type.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), type.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Type{" +
            "id=" + getId() +
            ", type='" + getType() + "'" +
            "}";
    }
}
