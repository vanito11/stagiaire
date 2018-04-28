package com.upf.stagiaire.service.impl;

import com.upf.stagiaire.service.EncadrantService;
import com.upf.stagiaire.model.Encadrant;
import com.upf.stagiaire.repository.EncadrantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Encadrant.
 */
@Service
@Transactional
public class EncadrantServiceImpl implements EncadrantService {

    private final Logger log = LoggerFactory.getLogger(EncadrantServiceImpl.class);

    private final EncadrantRepository encadrantRepository;

    public EncadrantServiceImpl(EncadrantRepository encadrantRepository) {
        this.encadrantRepository = encadrantRepository;
    }

    /**
     * Save a encadrant.
     *
     * @param encadrant the entity to save
     * @return the persisted entity
     */
    @Override
    public Encadrant save(Encadrant encadrant) {
        log.debug("Request to save Encadrant : {}", encadrant);
        return encadrantRepository.save(encadrant);
    }

    /**
     * Get all the encadrants.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Encadrant> findAll() {
        log.debug("Request to get all Encadrants");
        return encadrantRepository.findAll();
    }

    /**
     * Get one encadrant by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Encadrant findOne(Long id) {
        log.debug("Request to get Encadrant : {}", id);
        return encadrantRepository.findOne(id);
    }

    /**
     * Delete the encadrant by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Encadrant : {}", id);
        encadrantRepository.delete(id);
    }
}
