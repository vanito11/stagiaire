package com.upf.stagiaire.service;

import java.util.List;

import com.upf.stagiaire.model.Etat;

/**
 * Service Interface for managing Etat.
 */
public interface EtatService {

    /**
     * Save a etat.
     *
     * @param etat the entity to save
     * @return the persisted entity
     */
    Etat save(Etat etat);

    /**
     * Get all the etats.
     *
     * @return the list of entities
     */
    List<Etat> findAll();

    /**
     * Get the "id" etat.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Etat findOne(Long id);

    /**
     * Delete the "id" etat.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
