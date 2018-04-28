package com.upf.stagiaire.service;

import java.util.List;

import com.upf.stagiaire.model.Stagiaire;

/**
 * Service Interface for managing Stagiaire.
 */
public interface StagiaireService {

    /**
     * Save a stagiaire.
     *
     * @param stagiaire the entity to save
     * @return the persisted entity
     */
    Stagiaire save(Stagiaire stagiaire);

    /**
     * Get all the stagiaires.
     *
     * @return the list of entities
     */
    List<Stagiaire> findAll();

    /**
     * Get the "id" stagiaire.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Stagiaire findOne(Long id);

    /**
     * Delete the "id" stagiaire.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
