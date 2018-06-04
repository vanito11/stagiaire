package com.upf.stagiaire.mapper;

import org.springframework.stereotype.Component;

import com.upf.stagiaire.bean.FiliereBean;
import com.upf.stagiaire.model.Filiere;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class FiliereMapper extends ConfigurableMapper {
	
	@Override
	  protected void configure(MapperFactory factory) {
	    factory.classMap(Filiere.class, FiliereBean.class)
	      .field("id", "id")
	      .field("nomFiliere", "nomFiliere")
	      .field("description", "description")
	      .byDefault()
	      .register();      
	  }
	}
