package com.upf.stagiaire.model;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Message.
 */
@Entity
@Table(name = "message")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_envoie")
    private Integer idEnvoie;

    @Column(name = "id_reception")
    private Integer idReception;

    @Column(name = "message_envoyer")
    private String messageEnvoyer;

    @Column(name = "jhi_type")
    private String type;

    @ManyToOne
    private Stage stage;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdEnvoie() {
        return idEnvoie;
    }

    public Message idEnvoie(Integer idEnvoie) {
        this.idEnvoie = idEnvoie;
        return this;
    }

    public void setIdEnvoie(Integer idEnvoie) {
        this.idEnvoie = idEnvoie;
    }

    public Integer getIdReception() {
        return idReception;
    }

    public Message idReception(Integer idReception) {
        this.idReception = idReception;
        return this;
    }

    public void setIdReception(Integer idReception) {
        this.idReception = idReception;
    }

    public String getMessageEnvoyer() {
        return messageEnvoyer;
    }

    public Message messageEnvoyer(String messageEnvoyer) {
        this.messageEnvoyer = messageEnvoyer;
        return this;
    }

    public void setMessageEnvoyer(String messageEnvoyer) {
        this.messageEnvoyer = messageEnvoyer;
    }

    public String getType() {
        return type;
    }

    public Message type(String type) {
        this.type = type;
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Stage getStage() {
        return stage;
    }

    public Message stage(Stage stage) {
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
        Message message = (Message) o;
        if (message.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), message.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Message{" +
            "id=" + getId() +
            ", idEnvoie=" + getIdEnvoie() +
            ", idReception=" + getIdReception() +
            ", messageEnvoyer='" + getMessageEnvoyer() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }
}
