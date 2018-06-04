package com.upf.stagiaire.mapper;

import org.springframework.stereotype.Component;

import com.upf.stagiaire.bean.EntrepriseBean;
import com.upf.stagiaire.model.Entreprise;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class EntrepriseMapper extends ConfigurableMapper {
	
	@Override
	  protected void configure(MapperFactory factory) {
	    factory.classMap(Entreprise.class, EntrepriseBean.class)
	      .field("id", "id")
	      .field("nom", "nom")
	      .field("ville", "ville")
	      .field("pays", "pays")
	      .field("email", "email")
	      .field("site", "site")
	      .field("adresse", "adresse")
	      .field("telephone", "telephone")
	      .field("fax", "fax")
	      .byDefault()
	      .register();      
	  }
	}
