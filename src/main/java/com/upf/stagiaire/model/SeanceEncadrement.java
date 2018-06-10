package com.upf.stagiaire.model;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Date;

/**
 * A SeanceEncadrement.
 */
@Entity
@Table(name = "seance_encadrement")
public class SeanceEncadrement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_encadrement")
    private String dateEncadrement;

    @Column(name = "description")
    private String description;

    @ManyToOne
    private Stage stage;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateEncadrement() {
        return dateEncadrement;
    }

    public SeanceEncadrement dateEncadrement(String dateEncadrement) {
        this.dateEncadrement = dateEncadrement;
        return this;
    }

    public void setDateEncadrement(String dateEncadrement) {
        this.dateEncadrement = dateEncadrement;
    }

    public String getDescription() {
        return description;
    }

    public SeanceEncadrement description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Stage getStage() {
        return stage;
    }

    public SeanceEncadrement stage(Stage stage) {
        this.stage = stage;
        return this;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
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
        SeanceEncadrement seanceEncadrement = (SeanceEncadrement) o;
        if (seanceEncadrement.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), seanceEncadrement.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SeanceEncadrement{" +
            "id=" + getId() +
            ", dateEncadrement='" + getDateEncadrement() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
