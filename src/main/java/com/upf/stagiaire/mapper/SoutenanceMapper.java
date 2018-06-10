package com.upf.stagiaire.mapper;

import org.springframework.stereotype.Component;

import com.upf.stagiaire.bean.SoutenanceBean;
import com.upf.stagiaire.model.Soutenance;


import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
@Component
public class SoutenanceMapper extends ConfigurableMapper {
	
	@Override
	  protected void configure(MapperFactory factory) {
	    factory.classMap(Soutenance.class, SoutenanceBean.class)
	      .field("id", "id")
	      .field("dateSoutenance", "dateSoutenance")
	      .field("encadrant", "encadrant")
	      .field("tuteur", "tuteur")
	      .field("president", "president")
	      .field("exminateur1", "exminateur1")
	      .field("examinateur2", "examinateur2")
	      .field("rapporteur", "rapporteur")
	      .field("rapport", "rapport")
	      .field("description", "description")
	      .byDefault()
	      .register();      
	  }
	}

