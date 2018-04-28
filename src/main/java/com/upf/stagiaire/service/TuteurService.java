package com.upf.stagiaire.service;

import java.util.List;

import com.upf.stagiaire.model.Tuteur;

/**
 * Service Interface for managing Tuteur.
 */
public interface TuteurService {

    /**
     * Save a tuteur.
     *
     * @param tuteur the entity to save
     * @return the persisted entity
     */
    Tuteur save(Tuteur tuteur);

    /**
     * Get all the tuteurs.
     *
     * @return the list of entities
     */
    List<Tuteur> findAll();

    /**
     * Get the "id" tuteur.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Tuteur findOne(Long id);

    /**
     * Delete the "id" tuteur.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
