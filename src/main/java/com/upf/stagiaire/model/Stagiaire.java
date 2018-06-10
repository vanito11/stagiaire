package com.upf.stagiaire.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * A Stagiaire.
 */

@Entity
@Table(name = "stagiaire")
public class Stagiaire implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "date_naissance")
	private String dateNaissance;

	@Column(name = "nationnalite")
	private String nationnalite;

	@Column(name = "adresse")
	private String adresse;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "email")
	private String email;

	@Column(name = "photo")
	private String photo;

	@Column(name = "niveau")
	private String niveau;

	@Column(name = "cv")
	private String cv;

	@ManyToOne
	private Filiere filiere;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "stagestagiaire", 
	    joinColumns = { @JoinColumn(name = "stagiaire_id",referencedColumnName = "id") }, 
	    inverseJoinColumns = {
		@JoinColumn(name = "stage_id",referencedColumnName = "id") })
	private Set<Stage> stage = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public Stagiaire nom(String nom) {
		this.nom = nom;
		return this;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public Stagiaire prenom(String prenom) {
		this.prenom = prenom;
		return this;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public Stagiaire dateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
		return this;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getNationnalite() {
		return nationnalite;
	}

	public Stagiaire nationnalite(String nationnalite) {
		this.nationnalite = nationnalite;
		return this;
	}

	public void setNationnalite(String nationnalite) {
		this.nationnalite = nationnalite;
	}

	public String getAdresse() {
		return adresse;
	}

	public Stagiaire adresse(String adresse) {
		this.adresse = adresse;
		return this;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public Stagiaire telephone(String telephone) {
		this.telephone = telephone;
		return this;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public Stagiaire email(String email) {
		this.email = email;
		return this;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return photo;
	}

	public Stagiaire photo(String photo) {
		this.photo = photo;
		return this;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getNiveau() {
		return niveau;
	}

	public Stagiaire niveau(String niveau) {
		this.niveau = niveau;
		return this;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getCv() {
		return cv;
	}

	public Stagiaire cv(String cv) {
		this.cv = cv;
		return this;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public Stagiaire filiere(Filiere filiere) {
		this.filiere = filiere;
		return this;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public Set<Stage> getStage() {
		return stage;
	}

	public void setStage(Set<Stage> stage) {
		this.stage = stage;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Stagiaire stagiaire = (Stagiaire) o;
		if (stagiaire.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), stagiaire.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "Stagiaire{" + "id=" + getId() + ", nom='" + getNom() + "'" + ", prenom='" + getPrenom() + "'"
				+ ", dateNaissance='" + getDateNaissance() + "'" + ", nationnalite='" + getNationnalite() + "'"
				+ ", adresse='" + getAdresse() + "'" + ", telephone='" + getTelephone() + "'" + ", email='" + getEmail()
				+ "'" + "'" + ", photo='" + getPhoto() + "'" + ", niveau='" + getNiveau() + "'" + ", cv='" + getCv()
				+ "'" + "}";
	}
}
