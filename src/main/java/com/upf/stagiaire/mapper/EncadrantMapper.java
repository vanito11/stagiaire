package com.upf.stagiaire.mapper;

import org.springframework.stereotype.Component;

import com.upf.stagiaire.bean.EncadrantBean;
import com.upf.stagiaire.model.Encadrant;


import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
@Component
public class EncadrantMapper extends ConfigurableMapper {
	
	@Override
	  protected void configure(MapperFactory factory) {
	    factory.classMap(Encadrant.class, EncadrantBean.class)
	      .field("id", "id")
	      .field("nom", "nom")
	      .field("prenom", "prenom")
	      .field("dateNaissance", "dateNaissance")
	      .field("adresse", "adresse")
	      .field("telephone", "telephone")
	      .field("email", "email")
	      .byDefault()
	      .register();      
	  }
	}
