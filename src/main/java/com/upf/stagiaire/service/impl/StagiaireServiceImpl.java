package com.upf.stagiaire.service.impl;

import com.upf.stagiaire.service.StagiaireService;
import com.upf.stagiaire.model.Stagiaire;
import com.upf.stagiaire.repository.StagiaireRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Stagiaire.
 */
@Service
@Transactional
public class StagiaireServiceImpl implements StagiaireService {

    private final Logger log = LoggerFactory.getLogger(StagiaireServiceImpl.class);

    private final StagiaireRepository stagiaireRepository;

    public StagiaireServiceImpl(StagiaireRepository stagiaireRepository) {
        this.stagiaireRepository = stagiaireRepository;
    }

    /**
     * Save a stagiaire.
     *
     * @param stagiaire the entity to save
     * @return the persisted entity
     */
    @Override
    public Stagiaire save(Stagiaire stagiaire) {
        log.debug("Request to save Stagiaire : {}", stagiaire);
        return stagiaireRepository.save(stagiaire);
    }

    /**
     * Get all the stagiaires.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Stagiaire> findAll() {
        log.debug("Request to get all Stagiaires");
        return stagiaireRepository.findAll();
    }

    /**
     * Get one stagiaire by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Stagiaire findOne(Long id) {
        log.debug("Request to get Stagiaire : {}", id);
        return stagiaireRepository.findOne(id);
    }

    /**
     * Delete the stagiaire by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Stagiaire : {}", id);
        stagiaireRepository.delete(id);
    }
}
