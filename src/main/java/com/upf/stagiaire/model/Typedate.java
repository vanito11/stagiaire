package com.upf.stagiaire.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Typedate.
 */
@Entity
@Table(name = "typedate")
public class Typedate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "jhi_type")
    private String type;

    @OneToMany(mappedBy = "typedate")
    @JsonIgnore
    private Set<Date> dates = new HashSet<>();

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

    public Typedate type(String type) {
        this.type = type;
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Date> getDates() {
        return dates;
    }

    public Typedate dates(Set<Date> dates) {
        this.dates = dates;
        return this;
    }

    public Typedate addDate(Date date) {
        this.dates.add(date);
        date.setTypedate(this);
        return this;
    }

    public Typedate removeDate(Date date) {
        this.dates.remove(date);
        date.setTypedate(null);
        return this;
    }

    public void setDates(Set<Date> dates) {
        this.dates = dates;
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
        Typedate typedate = (Typedate) o;
        if (typedate.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), typedate.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Typedate{" +
            "id=" + getId() +
            ", type='" + getType() + "'" +
            "}";
    }
}
