package com.upf.stagiaire.service;

import java.util.List;

import com.upf.stagiaire.model.Visite;

/**
 * Service Interface for managing Visite.
 */
public interface VisiteService {

    /**
     * Save a visite.
     *
     * @param visite the entity to save
     * @return the persisted entity
     */
    Visite save(Visite visite);

    /**
     * Get all the visites.
     *
     * @return the list of entities
     */
    List<Visite> findAll();

    /**
     * Get the "id" visite.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Visite findOne(Long id);

    /**
     * Delete the "id" visite.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
    
    List<Visite> findVisiteByStageId(Long id);
}
