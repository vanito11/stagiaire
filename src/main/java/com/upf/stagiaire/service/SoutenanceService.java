package com.upf.stagiaire.service;

import java.util.List;

import com.upf.stagiaire.model.Soutenance;

/**
 * Service Interface for managing Soutenance.
 */
public interface SoutenanceService {

    /**
     * Save a soutenance.
     *
     * @param soutenance the entity to save
     * @return the persisted entity
     */
    Soutenance save(Soutenance soutenance);

    /**
     * Get all the soutenances.
     *
     * @return the list of entities
     */
    List<Soutenance> findAll();

    /**
     * Get the "id" soutenance.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Soutenance findOne(Long id);

    /**
     * Delete the "id" soutenance.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
    
    List<Soutenance> findSoutenanceByStageId(Long id);
    void deleteSoutenanceByStageId(Long id);
}
