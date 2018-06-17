package com.upf.stagiaire.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stagestagiaire")
public class StageStagiaire implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(name = "stagiaireid")
    private Long stagiaireid;
    
	@Column(name = "stageid")
    private Long stageid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStagiaireid() {
		return stagiaireid;
	}

	public void setStagiaireid(Long stagiaireid) {
		this.stagiaireid = stagiaireid;
	}

	public Long getStageid() {
		return stageid;
	}

	public void setStageid(Long stageid) {
		this.stageid = stageid;
	}


	
	
    
}