package com.upf.stagiaire.service;

import java.util.List;

import com.upf.stagiaire.model.Encadrant;

/**
 * Service Interface for managing Encadrant.
 */
public interface EncadrantService {

    /**
     * Save a encadrant.
     *
     * @param encadrant the entity to save
     * @return the persisted entity
     */
    Encadrant save(Encadrant encadrant);

    /**
     * Get all the encadrants.
     *
     * @return the list of entities
     */
    List<Encadrant> findAll();

    /**
     * Get the "id" encadrant.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Encadrant findOne(Long id);

    /**
     * Delete the "id" encadrant.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
