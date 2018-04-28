package com.upf.stagiaire.service;

import java.util.List;

import com.upf.stagiaire.model.SeanceEncadrement;

/**
 * Service Interface for managing SeanceEncadrement.
 */
public interface SeanceEncadrementService {

    /**
     * Save a seanceEncadrement.
     *
     * @param seanceEncadrement the entity to save
     * @return the persisted entity
     */
    SeanceEncadrement save(SeanceEncadrement seanceEncadrement);

    /**
     * Get all the seanceEncadrements.
     *
     * @return the list of entities
     */
    List<SeanceEncadrement> findAll();

    /**
     * Get the "id" seanceEncadrement.
     *
     * @param id the id of the entity
     * @return the entity
     */
    SeanceEncadrement findOne(Long id);

    /**
     * Delete the "id" seanceEncadrement.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
