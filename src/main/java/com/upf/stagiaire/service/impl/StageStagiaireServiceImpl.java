package com.upf.stagiaire.service.impl;

import com.upf.stagiaire.service.StageStagiaireService;
import com.upf.stagiaire.model.StageStagiaire;
import com.upf.stagiaire.model.Stagiaire;
import com.upf.stagiaire.repository.StageStagiaireRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing StageStagiaire.
 */
@Service
@Transactional
public class StageStagiaireServiceImpl implements StageStagiaireService {

    private final Logger log = LoggerFactory.getLogger(StageStagiaireServiceImpl.class);

    private final StageStagiaireRepository StageStagiaireRepository;

    public StageStagiaireServiceImpl(StageStagiaireRepository StageStagiaireRepository) {
        this.StageStagiaireRepository = StageStagiaireRepository;
    }

    /**
     * Save a StageStagiaire.
     *
     * @param StageStagiaire the entity to save
     * @return the persisted entity
     */
    @Override
    public StageStagiaire save(StageStagiaire StageStagiaire) {
        log.debug("Request to save StageStagiaire : {}", StageStagiaire);
        return StageStagiaireRepository.save(StageStagiaire);
    }

    /**
     * Get all the StageStagiaires.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<StageStagiaire> findAll() {
        log.debug("Request to get all StageStagiaires");
        return StageStagiaireRepository.findAll();
    }

    /**
     * Get one StageStagiaire by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public StageStagiaire findOne(Long id) {
        log.debug("Request to get StageStagiaire : {}", id);
        return StageStagiaireRepository.findOne(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public StageStagiaire findByStageidAndStagiaireid(Long Stageid,Long Stagiaireid) {
        log.debug("Request to get all StageStagiaireRepository");
		return StageStagiaireRepository.findByStageidAndStagiaireid(Stageid,Stagiaireid);
    }
    

    /**
     * Delete the StageStagiaire by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete StageStagiaire : {}", id);
        StageStagiaireRepository.delete(id);
    }
}
