package com.upf.stagiaire.service.impl;

import com.upf.stagiaire.service.VisiteService;
import com.upf.stagiaire.model.Visite;
import com.upf.stagiaire.repository.VisiteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Visite.
 */
@Service
@Transactional
public class VisiteServiceImpl implements VisiteService {

    private final Logger log = LoggerFactory.getLogger(VisiteServiceImpl.class);

    private final VisiteRepository visiteRepository;

    public VisiteServiceImpl(VisiteRepository visiteRepository) {
        this.visiteRepository = visiteRepository;
    }

    /**
     * Save a visite.
     *
     * @param visite the entity to save
     * @return the persisted entity
     */
    @Override
    public Visite save(Visite visite) {
        log.debug("Request to save Visite : {}", visite);
        return visiteRepository.save(visite);
    }

    /**
     * Get all the visites.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Visite> findAll() {
        log.debug("Request to get all Visites");
        return visiteRepository.findAll();
    }

    /**
     * Get one visite by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Visite findOne(Long id) {
        log.debug("Request to get Visite : {}", id);
        return visiteRepository.findOne(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Visite> findVisiteByStageId(Long id) {
        log.debug("Request to get Visite : {}", id);
        return visiteRepository.findVisiteByStageId(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public void deleteVisiteByStageId(Long id) {
        log.debug("Request to get Visite : {}", id);
        visiteRepository.deleteVisiteByStageId(id);
    }


    /**
     * Delete the visite by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Visite : {}", id);
        visiteRepository.delete(id);
    }
}
