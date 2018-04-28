package com.upf.stagiaire.service;

import java.util.List;

import com.upf.stagiaire.model.Administrateur;

/**
 * Service Interface for managing Administrateur.
 */
public interface AdministrateurService {

    /**
     * Save a administrateur.
     *
     * @param administrateur the entity to save
     * @return the persisted entity
     */
    Administrateur save(Administrateur administrateur);

    /**
     * Get all the administrateurs.
     *
     * @return the list of entities
     */
    List<Administrateur> findAll();

    /**
     * Get the "id" administrateur.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Administrateur findOne(Long id);

    /**
     * Delete the "id" administrateur.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Get by  nom
     * 
     * @param nom
     * @return
     */
    List<Administrateur> findByNom(String nom);
}
