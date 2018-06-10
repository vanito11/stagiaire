package com.upf.stagiaire.service.impl;

import com.upf.stagiaire.service.SeanceEncadrementService;
import com.upf.stagiaire.model.SeanceEncadrement;
import com.upf.stagiaire.repository.SeanceEncadrementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing SeanceEncadrement.
 */
@Service
@Transactional
public class SeanceEncadrementServiceImpl implements SeanceEncadrementService {

    private final Logger log = LoggerFactory.getLogger(SeanceEncadrementServiceImpl.class);

    private final SeanceEncadrementRepository seanceEncadrementRepository;

    public SeanceEncadrementServiceImpl(SeanceEncadrementRepository seanceEncadrementRepository) {
        this.seanceEncadrementRepository = seanceEncadrementRepository;
    }

    /**
     * Save a seanceEncadrement.
     *
     * @param seanceEncadrement the entity to save
     * @return the persisted entity
     */
    @Override
    public SeanceEncadrement save(SeanceEncadrement seanceEncadrement) {
        log.debug("Request to save SeanceEncadrement : {}", seanceEncadrement);
        return seanceEncadrementRepository.save(seanceEncadrement);
    }

    /**
     * Get all the seanceEncadrements.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<SeanceEncadrement> findAll() {
        log.debug("Request to get all SeanceEncadrements");
        return seanceEncadrementRepository.findAll();
    }

    /**
     * Get one seanceEncadrement by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public SeanceEncadrement findOne(Long id) {
        log.debug("Request to get SeanceEncadrement : {}", id);
        return seanceEncadrementRepository.findOne(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<SeanceEncadrement> findSeanceEncadrementByStageId(Long id) {
        log.debug("Request to get SeanceEncadrement : {}", id);
        return seanceEncadrementRepository.findSeanceEncadrementByStageId(id);
    }

    /**
     * Delete the seanceEncadrement by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete SeanceEncadrement : {}", id);
        seanceEncadrementRepository.delete(id);
    }
}
