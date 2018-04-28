package com.upf.stagiaire.service.impl;

import com.upf.stagiaire.service.FiliereService;
import com.upf.stagiaire.model.Filiere;
import com.upf.stagiaire.repository.FiliereRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Filiere.
 */
@Service
@Transactional
public class FiliereServiceImpl implements FiliereService {

    private final Logger log = LoggerFactory.getLogger(FiliereServiceImpl.class);

    private final FiliereRepository filiereRepository;

    public FiliereServiceImpl(FiliereRepository filiereRepository) {
        this.filiereRepository = filiereRepository;
    }

    /**
     * Save a filiere.
     *
     * @param filiere the entity to save
     * @return the persisted entity
     */
    @Override
    public Filiere save(Filiere filiere) {
        log.debug("Request to save Filiere : {}", filiere);
        return filiereRepository.save(filiere);
    }

    /**
     * Get all the filieres.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Filiere> findAll() {
        log.debug("Request to get all Filieres");
        return filiereRepository.findAll();
    }

    /**
     * Get one filiere by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Filiere findOne(Long id) {
        log.debug("Request to get Filiere : {}", id);
        return filiereRepository.findOne(id);
    }

    /**
     * Delete the filiere by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Filiere : {}", id);
        filiereRepository.delete(id);
    }
}
