package com.upf.stagiaire.service.impl;

import com.upf.stagiaire.service.EntrepriseService;
import com.upf.stagiaire.model.Entreprise;
import com.upf.stagiaire.repository.EntrepriseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Entreprise.
 */
@Service
@Transactional
public class EntrepriseServiceImpl implements EntrepriseService {

    private final Logger log = LoggerFactory.getLogger(EntrepriseServiceImpl.class);

    private final EntrepriseRepository entrepriseRepository;

    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    /**
     * Save a entreprise.
     *
     * @param entreprise the entity to save
     * @return the persisted entity
     */
    @Override
    public Entreprise save(Entreprise entreprise) {
        log.debug("Request to save Entreprise : {}", entreprise);
        return entrepriseRepository.save(entreprise);
    }

    /**
     * Get all the entreprises.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Entreprise> findAll() {
        log.debug("Request to get all Entreprises");
        return entrepriseRepository.findAll();
    }

    /**
     * Get one entreprise by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Entreprise findOne(Long id) {
        log.debug("Request to get Entreprise : {}", id);
        return entrepriseRepository.findOne(id);
    }

    /**
     * Delete the entreprise by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Entreprise : {}", id);
        entrepriseRepository.delete(id);
    }
}
