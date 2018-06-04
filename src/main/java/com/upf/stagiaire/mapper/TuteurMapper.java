package com.upf.stagiaire.mapper;

import org.springframework.stereotype.Component;

import com.upf.stagiaire.bean.TuteurBean;
import com.upf.stagiaire.model.Tuteur;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class TuteurMapper extends ConfigurableMapper {
	
	@Override
	  protected void configure(MapperFactory factory) {
	    factory.classMap(Tuteur.class, TuteurBean.class)
	      .field("id", "id")
	      .field("nom", "nom")
	      .field("prenom", "prenom")
	      .field("dateNaissance", "dateNaissance")
	      .field("telephone", "telephone")
	      .field("email", "email")
	      .field("entreprise", "entreprise")
	      .byDefault()
	      .register();      
	  }
	}
