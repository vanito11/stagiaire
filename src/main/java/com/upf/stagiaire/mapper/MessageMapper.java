package com.upf.stagiaire.mapper;

import com.google.inject.spi.Message;
import com.upf.stagiaire.bean.MessageBean;


import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

public class MessageMapper extends ConfigurableMapper {
	
	@Override
	  protected void configure(MapperFactory factory) {
	    factory.classMap(Message.class, MessageBean.class)
	      .field("id", "id")
	      .field("idEnvoie", "idEnvoie")
	      .field("idReception", "idReception")
	      .field("messageEnvoyer", "messageEnvoyer")
	      .field("type", "type")
	      .byDefault()
	      .register();      
	  }
	}