package com.upf.stagiaire.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upf.stagiaire.model.Administrateur;
import com.upf.stagiaire.repository.AdministrateurRepository;
import com.upf.stagiaire.service.AdministrateurService;

/**
 * Service Implementation for managing Administrateur.
 */
@Service
@Transactional
public class AdministrateurServiceImpl implements AdministrateurService {
    
    private final Logger log = LoggerFactory.getLogger(AdministrateurServiceImpl.class);
    
    @Autowired
    private AdministrateurRepository administrateurRepository;
    
    /**
     * Save a administrateur.
     *
     * @param administrateur
     *            the entity to save
     * @return the persisted entity
     */
    @Override
    public Administrateur save(Administrateur administrateur) {
        log.debug("Request to save Administrateur : {}", administrateur);
        return administrateurRepository.save(administrateur);
    }
    
    /**
     * Get all the administrateurs.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Administrateur> findAll() {
        log.debug("Request to get all Administrateurs");
        return administrateurRepository.findAll();
    }
    
    /**
     * Get one administrateur by id.
     *
     * @param id
     *            the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Administrateur findOne(Long id) {
        log.debug("Request to get Administrateur : {}", id);
        return administrateurRepository.findOne(id);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<Administrateur> findByNom(String nom) {
        log.debug("Request to get Administrateur by nom : {}", nom);
        return administrateurRepository.findByNom(nom);
    }
    
    /**
     * Delete the administrateur by id.
     *
     * @param id
     *            the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Administrateur : {}", id);
        administrateurRepository.delete(id);
    }
}
