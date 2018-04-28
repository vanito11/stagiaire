package com.upf.stagiaire.bean;

import java.io.Serializable;


public class MessageBean implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;


    private Integer idEnvoie;


    private Integer idReception;


    private String messageEnvoyer;


    private String type;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Integer getIdEnvoie() {
        return idEnvoie;
    }


    public void setIdEnvoie(Integer idEnvoie) {
        this.idEnvoie = idEnvoie;
    }


    public Integer getIdReception() {
        return idReception;
    }


    public void setIdReception(Integer idReception) {
        this.idReception = idReception;
    }


    public String getMessageEnvoyer() {
        return messageEnvoyer;
    }


    public void setMessageEnvoyer(String messageEnvoyer) {
        this.messageEnvoyer = messageEnvoyer;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }
    
    
}
