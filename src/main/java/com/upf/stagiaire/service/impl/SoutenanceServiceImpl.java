package com.upf.stagiaire.service.impl;

import com.upf.stagiaire.service.SoutenanceService;



import com.upf.stagiaire.model.Soutenance;
import com.upf.stagiaire.repository.SoutenanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Soutenance.
 */
@Service
@Transactional
public class SoutenanceServiceImpl implements SoutenanceService {

    private final Logger log = LoggerFactory.getLogger(SoutenanceServiceImpl.class);

    private final SoutenanceRepository soutenanceRepository;

    public SoutenanceServiceImpl(SoutenanceRepository soutenanceRepository) {
        this.soutenanceRepository = soutenanceRepository;
    }

    /**
     * Save a soutenance.
     *
     * @param soutenance the entity to save
     * @return the persisted entity
     */
    @Override
    public Soutenance save(Soutenance soutenance) {
        log.debug("Request to save Soutenance : {}", soutenance);
        return soutenanceRepository.save(soutenance);
    }

    /**
     * Get all the soutenances.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Soutenance> findAll() {
        log.debug("Request to get all Soutenances");
        return soutenanceRepository.findAll();
    }

    /**
     * Get one soutenance by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Soutenance findOne(Long id) {
        log.debug("Request to get Soutenance : {}", id);
        return soutenanceRepository.findOne(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Soutenance> findSoutenanceByStageId(Long id) {
        log.debug("Request to get SeanceEncadrement : {}", id);
        return soutenanceRepository.findSoutenanceByStageId(id);
    }
    @Override
    @Transactional(readOnly = true)
    public void deleteSoutenanceByStageId(Long id) {
        log.debug("Request to get SeanceEncadrement : {}", id);
        soutenanceRepository.deleteSoutenanceByStageId(id);
    }

    /**
     * Delete the soutenance by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Soutenance : {}", id);
        soutenanceRepository.delete(id);
    }
}
