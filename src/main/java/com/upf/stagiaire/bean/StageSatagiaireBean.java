package com.upf.stagiaire.bean;



import java.util.List;

import com.upf.stagiaire.model.Stage;
import com.upf.stagiaire.model.StageStagiaire;
import com.upf.stagiaire.model.Stagiaire;

public class StageSatagiaireBean {

	private Long id;

	private Stage stageBean;

	private Stagiaire stagiaireBean;
	
	private StageStagiaire stageStagiaire;


	
	public StageStagiaire getStageStagiaire() {
	return stageStagiaire;
}

public void setStageStagiaire(StageStagiaire stageStagiaire) {
	this.stageStagiaire = stageStagiaire;
}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Stage getStageBean() {
		return stageBean;
	}

	public void setStageBean(Stage stageBean) {
		this.stageBean = stageBean;
	}

	public Stagiaire getStagiaireBean() {
		return stagiaireBean;
	}

	public void setStagiaireBean(Stagiaire stagiaireBean) {
		this.stagiaireBean = stagiaireBean;
	}

	



}
