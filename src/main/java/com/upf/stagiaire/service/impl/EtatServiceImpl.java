package com.upf.stagiaire.service.impl;

import com.upf.stagiaire.service.EtatService;
import com.upf.stagiaire.model.Etat;
import com.upf.stagiaire.repository.EtatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Etat.
 */
@Service
@Transactional
public class EtatServiceImpl implements EtatService {

    private final Logger log = LoggerFactory.getLogger(EtatServiceImpl.class);

    private final EtatRepository etatRepository;

    public EtatServiceImpl(EtatRepository etatRepository) {
        this.etatRepository = etatRepository;
    }

    /**
     * Save a etat.
     *
     * @param etat the entity to save
     * @return the persisted entity
     */
    @Override
    public Etat save(Etat etat) {
        log.debug("Request to save Etat : {}", etat);
        return etatRepository.save(etat);
    }

    /**
     * Get all the etats.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Etat> findAll() {
        log.debug("Request to get all Etats");
        return etatRepository.findAll();
    }

    /**
     * Get one etat by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Etat findOne(Long id) {
        log.debug("Request to get Etat : {}", id);
        return etatRepository.findOne(id);
    }

    /**
     * Delete the etat by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Etat : {}", id);
        etatRepository.delete(id);
    }
}
