package com.upf.stagiaire.mapper;

import org.springframework.stereotype.Component;


import com.upf.stagiaire.bean.VisiteBean;
import com.upf.stagiaire.model.Visite;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class VisiteMapper extends ConfigurableMapper {
	
	@Override
	  protected void configure(MapperFactory factory) {
	    factory.classMap(Visite.class, VisiteBean.class)
	      .field("id", "id")
	      .field("date", "date")
	      .field("description", "description")
	      .byDefault()
	      .register();      
	  }
	}
