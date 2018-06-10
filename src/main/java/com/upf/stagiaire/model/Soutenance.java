package com.upf.stagiaire.model;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Date;
/**
 * A Soutenance.
 */
@Entity
@Table(name = "soutenance")
public class Soutenance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_soutenance")
    private String dateSoutenance;

    @Column(name = "encadrant")
    private Integer encadrant;

    @Column(name = "tuteur")
    private Integer tuteur;

    @Column(name = "president")
    private String president;

    @Column(name = "exminateur_1")
    private String exminateur1;

    @Column(name = "examinateur_2")
    private String examinateur2;

    @Column(name = "rapporteur")
    private String rapporteur;

    @Column(name = "rapport")
    private String rapport;

    @Column(name = "description")
    private String description;

    @Column(name = "note")
    private Float note;

    @ManyToOne
    private Stage stage;

    @ManyToOne
    private TypeSoutenance typeSoutenance;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateSoutenance() {
        return dateSoutenance;
    }

    public Soutenance dateSoutenance(String dateSoutenance) {
        this.dateSoutenance = dateSoutenance;
        return this;
    }

    public void setDateSoutenance(String dateSoutenance) {
        this.dateSoutenance = dateSoutenance;
    }

    public Integer getEncadrant() {
        return encadrant;
    }

    public Soutenance encadrant(Integer encadrant) {
        this.encadrant = encadrant;
        return this;
    }

    public void setEncadrant(Integer encadrant) {
        this.encadrant = encadrant;
    }

    public Integer getTuteur() {
        return tuteur;
    }

    public Soutenance tuteur(Integer tuteur) {
        this.tuteur = tuteur;
        return this;
    }

    public void setTuteur(Integer tuteur) {
        this.tuteur = tuteur;
    }

    public String getPresident() {
        return president;
    }

    public Soutenance president(String president) {
        this.president = president;
        return this;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getExminateur1() {
        return exminateur1;
    }

    public Soutenance exminateur1(String exminateur1) {
        this.exminateur1 = exminateur1;
        return this;
    }

    public void setExminateur1(String exminateur1) {
        this.exminateur1 = exminateur1;
    }

    public String getExaminateur2() {
        return examinateur2;
    }

    public Soutenance examinateur2(String examinateur2) {
        this.examinateur2 = examinateur2;
        return this;
    }

    public void setExaminateur2(String examinateur2) {
        this.examinateur2 = examinateur2;
    }

    public String getRapporteur() {
        return rapporteur;
    }

    public Soutenance rapporteur(String rapporteur) {
        this.rapporteur = rapporteur;
        return this;
    }

    public void setRapporteur(String rapporteur) {
        this.rapporteur = rapporteur;
    }

    public String getRapport() {
        return rapport;
    }

    public Soutenance rapport(String rapport) {
        this.rapport = rapport;
        return this;
    }

    public void setRapport(String rapport) {
        this.rapport = rapport;
    }

    public String getDescription() {
        return description;
    }

    public Soutenance description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getNote() {
        return note;
    }

    public Soutenance note(Float note) {
        this.note = note;
        return this;
    }

    public void setNote(Float note) {
        this.note = note;
    }

    public Stage getStage() {
        return stage;
    }

    public Soutenance stage(Stage stage) {
        this.stage = stage;
        return this;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public TypeSoutenance getTypeSoutenance() {
        return typeSoutenance;
    }

    public Soutenance typeSoutenance(TypeSoutenance typeSoutenance) {
        this.typeSoutenance = typeSoutenance;
        return this;
    }

    public void setTypeSoutenance(TypeSoutenance typeSoutenance) {
        this.typeSoutenance = typeSoutenance;
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
        Soutenance soutenance = (Soutenance) o;
        if (soutenance.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), soutenance.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Soutenance{" +
            "id=" + getId() +
            ", dateSoutenance='" + getDateSoutenance() + "'" +
            ", encadrant=" + getEncadrant() +
            ", tuteur=" + getTuteur() +
            ", president='" + getPresident() + "'" +
            ", exminateur1='" + getExminateur1() + "'" +
            ", examinateur2='" + getExaminateur2() + "'" +
            ", rapporteur='" + getRapporteur() + "'" +
            ", rapport='" + getRapport() + "'" +
            ", description='" + getDescription() + "'" +
            ", note=" + getNote() +
            "}";
    }
}
