package com.upf.stagiaire.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Stage.
 */
@Entity
@Table(name = "stage")
public class Stage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sujet")
    private String sujet;

    @Column(name = "description")
    private String description;

    @Column(name = "duree")
    private Float duree;

    @ManyToOne
    private Encadrant encadrant;

    @ManyToOne
    private Etat etat;

    @OneToMany(mappedBy = "stage")
    @JsonIgnore
    private Set<SeanceEncadrement> seanceEncadrements = new HashSet<>();

    @OneToMany(mappedBy = "stage")
    @JsonIgnore
    private Set<Document> documents = new HashSet<>();

    @OneToMany(mappedBy = "stage")
    @JsonIgnore
    private Set<Message> messages = new HashSet<>();

    @OneToMany(mappedBy = "stage")
    @JsonIgnore
    private Set<Visite> visites = new HashSet<>();

    @OneToMany(mappedBy = "stage")
    @JsonIgnore
    private Set<Date> dates = new HashSet<>();

    @OneToMany(mappedBy = "stage")
    @JsonIgnore
    private Set<Soutenance> soutenances = new HashSet<>();

    @ManyToOne
    private Tuteur tuteur;

    @ManyToOne
    private Type type;
    
//    @ManyToMany(cascade = { CascadeType.ALL })
//    @JoinTable(
//        name = "stagestagiaire",
//        joinColumns = { @JoinColumn(name = "stage_id") }, 
//        inverseJoinColumns = { @JoinColumn(name = "stagiaire_id") }
//    )
//    private  Set<Stagiaire> stagiaire = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public Stage sujet(String sujet) {
        this.sujet = sujet;
        return this;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDescription() {
        return description;
    }

    public Stage description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getDuree() {
        return duree;
    }

    public Stage duree(Float duree) {
        this.duree = duree;
        return this;
    }

    public void setDuree(Float duree) {
        this.duree = duree;
    }

    public Encadrant getEncadrant() {
        return encadrant;
    }

    public Stage encadrant(Encadrant encadrant) {
        this.encadrant = encadrant;
        return this;
    }

    public void setEncadrant(Encadrant encadrant) {
        this.encadrant = encadrant;
    }

    public Etat getEtat() {
        return etat;
    }

    public Stage etat(Etat etat) {
        this.etat = etat;
        return this;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public Set<SeanceEncadrement> getSeanceEncadrements() {
        return seanceEncadrements;
    }

    public Stage seanceEncadrements(Set<SeanceEncadrement> seanceEncadrements) {
        this.seanceEncadrements = seanceEncadrements;
        return this;
    }

    public Stage addSeanceEncadrement(SeanceEncadrement seanceEncadrement) {
        this.seanceEncadrements.add(seanceEncadrement);
        seanceEncadrement.setStage(this);
        return this;
    }

    public Stage removeSeanceEncadrement(SeanceEncadrement seanceEncadrement) {
        this.seanceEncadrements.remove(seanceEncadrement);
        seanceEncadrement.setStage(null);
        return this;
    }

    public void setSeanceEncadrements(Set<SeanceEncadrement> seanceEncadrements) {
        this.seanceEncadrements = seanceEncadrements;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public Stage documents(Set<Document> documents) {
        this.documents = documents;
        return this;
    }

    public Stage addDocument(Document document) {
        this.documents.add(document);
        document.setStage(this);
        return this;
    }

    public Stage removeDocument(Document document) {
        this.documents.remove(document);
        document.setStage(null);
        return this;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public Stage messages(Set<Message> messages) {
        this.messages = messages;
        return this;
    }

    public Stage addMessage(Message message) {
        this.messages.add(message);
        message.setStage(this);
        return this;
    }

    public Stage removeMessage(Message message) {
        this.messages.remove(message);
        message.setStage(null);
        return this;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public Set<Visite> getVisites() {
        return visites;
    }

    public Stage visites(Set<Visite> visites) {
        this.visites = visites;
        return this;
    }

    public Stage addVisite(Visite visite) {
        this.visites.add(visite);
        visite.setStage(this);
        return this;
    }

    public Stage removeVisite(Visite visite) {
        this.visites.remove(visite);
        visite.setStage(null);
        return this;
    }

    public void setVisites(Set<Visite> visites) {
        this.visites = visites;
    }

    public Set<Date> getDates() {
        return dates;
    }

    public Stage dates(Set<Date> dates) {
        this.dates = dates;
        return this;
    }

    public Stage addDate(Date date) {
        this.dates.add(date);
        date.setStage(this);
        return this;
    }

    public Stage removeDate(Date date) {
        this.dates.remove(date);
        date.setStage(null);
        return this;
    }

    public void setDates(Set<Date> dates) {
        this.dates = dates;
    }

    public Set<Soutenance> getSoutenances() {
        return soutenances;
    }

    public Stage soutenances(Set<Soutenance> soutenances) {
        this.soutenances = soutenances;
        return this;
    }

    public Stage addSoutenance(Soutenance soutenance) {
        this.soutenances.add(soutenance);
        soutenance.setStage(this);
        return this;
    }

    public Stage removeSoutenance(Soutenance soutenance) {
        this.soutenances.remove(soutenance);
        soutenance.setStage(null);
        return this;
    }

    public void setSoutenances(Set<Soutenance> soutenances) {
        this.soutenances = soutenances;
    }

    public Tuteur getTuteur() {
        return tuteur;
    }

    public Stage tuteur(Tuteur tuteur) {
        this.tuteur = tuteur;
        return this;
    }

    public void setTuteur(Tuteur tuteur) {
        this.tuteur = tuteur;
    }

    public Type getType() {
        return type;
    }

    public Stage type(Type type) {
        this.type = type;
        return this;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Stage stage = (Stage) o;
        if (stage.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), stage.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Stage{" +
            "id=" + getId() +
            ", sujet='" + getSujet() + "'" +
            ", description='" + getDescription() + "'" +
            ", duree=" + getDuree() +
            "}";
    }
}
