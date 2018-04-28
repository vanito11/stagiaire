package com.upf.stagiaire.model;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Date.
 */
@Entity
@Table(name = "date")
public class Date implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "jhi_date")
    private Date date;

    @ManyToOne
    private Stage stage;

    @ManyToOne
    private Typedate typedate;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public Date date(Date date) {
        this.date = date;
        return this;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Stage getStage() {
        return stage;
    }

    public Date stage(Stage stage) {
        this.stage = stage;
        return this;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Typedate getTypedate() {
        return typedate;
    }

    public Date typedate(Typedate typedate) {
        this.typedate = typedate;
        return this;
    }

    public void setTypedate(Typedate typedate) {
        this.typedate = typedate;
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
        Date date = (Date) o;
        if (date.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), date.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Date{" +
            "id=" + getId() +
            ", date='" + getDate() + "'" +
            "}";
    }
}
