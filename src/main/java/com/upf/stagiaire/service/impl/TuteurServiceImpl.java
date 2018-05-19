package com.upf.stagiaire.service.impl;

import com.upf.stagiaire.service.TuteurService;
import com.upf.stagiaire.model.Tuteur;
import com.upf.stagiaire.model.UserRequest;
import com.upf.stagiaire.repository.TuteurRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Tuteur.
 */
@Service
@Transactional
public class TuteurServiceImpl implements TuteurService {
    
    private final Logger log = LoggerFactory.getLogger(TuteurServiceImpl.class);
    
    private final TuteurRepository tuteurRepository;
    
    public TuteurServiceImpl(TuteurRepository tuteurRepository) {
        this.tuteurRepository = tuteurRepository;
    }
    
    /**
     * Save a tuteur.
     *
     * @param tuteur
     *            the entity to save
     * @return the persisted entity
     */
    @Override
    public Tuteur save(Tuteur tuteur) {
        log.debug("Request to save Tuteur : {}", tuteur);
        return tuteurRepository.save(tuteur);
    }
    
    /**
     * Singup a tuteur.
     *
     * @param UserRequest
     *            the entity to save
     * @return the persisted entity
     */
    @Override
    public Tuteur signupTuteur(UserRequest userRequest) {
        log.debug("Request to save Tuteur : {}", userRequest);
        Tuteur tuteur = new Tuteur();
        tuteur.setEmail(userRequest.getUsername());
        tuteur.setNom(userRequest.getLastname());
        tuteur.setPrenom(userRequest.getFirstname());
        
        return tuteurRepository.save(tuteur);
    }
    
    /**
     * Get all the tuteurs.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Tuteur> findAll() {
        log.debug("Request to get all Tuteurs");
        return tuteurRepository.findAll();
    }
    
    /**
     * Get one tuteur by id.
     *
     * @param id
     *            the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Tuteur findOne(Long id) {
        log.debug("Request to get Tuteur : {}", id);
        return tuteurRepository.findOne(id);
    }
    
    /**
     * Delete the tuteur by id.
     *
     * @param id
     *            the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Tuteur : {}", id);
        tuteurRepository.delete(id);
    }
}
