package com.upf.stagiaire.mapper;

import org.springframework.stereotype.Component;

import com.upf.stagiaire.bean.DocumentBean;
import com.upf.stagiaire.model.Document;


import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
@Component
public class DocumentMapper extends ConfigurableMapper {
	
	@Override
	  protected void configure(MapperFactory factory) {
	    factory.classMap(Document.class, DocumentBean.class)
	      .field("id", "id")
	      .field("document", "document")
	      .field("description", "description")
	      .field("dateSoumission", "dateSoumission")

	      .byDefault()
	      .register();      
	  }
	}
