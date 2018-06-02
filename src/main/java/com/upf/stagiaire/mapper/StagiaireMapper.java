package com.upf.stagiaire.mapper;

import org.springframework.stereotype.Component;

import com.upf.stagiaire.bean.StagiaireBean;
import com.upf.stagiaire.model.Stagiaire;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class StagiaireMapper extends ConfigurableMapper {
	
	@Override
	  protected void configure(MapperFactory factory) {
	    factory.classMap(Stagiaire.class, StagiaireBean.class)
	      .field("id", "id")
	      .field("nom", "nom")
	      .field("prenom", "prenom")
	      .field("dateNaissance", "dateNaissance")
	      .field("nationnalite", "nationnalite")
	      .field("adresse", "adresse")
	      .field("telephone", "telephone")
	      .field("email", "email")
	      .field("photo", "photo")
	      .field("niveau", "niveau")
	      .byDefault()
	      .register();      
	  }
	}