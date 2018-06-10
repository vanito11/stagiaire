package com.upf.stagiaire.mapper;

import org.springframework.stereotype.Component;

import com.upf.stagiaire.bean.SeanceEncadrementBean;
import com.upf.stagiaire.model.SeanceEncadrement;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
@Component
public class SeanceEncadrementMapper extends ConfigurableMapper {
	
	@Override
	  protected void configure(MapperFactory factory) {
	    factory.classMap(SeanceEncadrement.class, SeanceEncadrementBean.class)
	      .field("id", "id")
	      .field("dateEncadrement", "dateEncadrement")
	      .field("description", "description")
	      .byDefault()
	      .register();      
	  }
	}
