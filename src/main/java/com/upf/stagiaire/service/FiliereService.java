package com.upf.stagiaire.service;

import java.util.List;

import com.upf.stagiaire.model.Filiere;

/**
 * Service Interface for managing Filiere.
 */
public interface FiliereService {

    /**
     * Save a filiere.
     *
     * @param filiere the entity to save
     * @return the persisted entity
     */
    Filiere save(Filiere filiere);

    /**
     * Get all the filieres.
     *
     * @return the list of entities
     */
    List<Filiere> findAll();

    /**
     * Get the "id" filiere.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Filiere findOne(Long id);

    /**
     * Delete the "id" filiere.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
