package com.upf.stagiaire.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A TypeDocument.
 */
@Entity
@Table(name = "type_document")
public class TypeDocument implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "jhi_type")
    private String type;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "typeDocument")
    @JsonIgnore
    private Set<Document> documents = new HashSet<>();

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

    public TypeDocument type(String type) {
        this.type = type;
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public TypeDocument description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public TypeDocument documents(Set<Document> documents) {
        this.documents = documents;
        return this;
    }

    public TypeDocument addDocument(Document document) {
        this.documents.add(document);
        document.setTypeDocument(this);
        return this;
    }

    public TypeDocument removeDocument(Document document) {
        this.documents.remove(document);
        document.setTypeDocument(null);
        return this;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
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
        TypeDocument typeDocument = (TypeDocument) o;
        if (typeDocument.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), typeDocument.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TypeDocument{" +
            "id=" + getId() +
            ", type='" + getType() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
