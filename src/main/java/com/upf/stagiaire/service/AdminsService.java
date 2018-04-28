package com.upf.stagiaire.service;

import java.util.List;

import com.upf.stagiaire.model.Admins;

/**
 * Service Interface for managing Admins.
 */
public interface AdminsService {

    /**
     * Save a admins.
     *
     * @param admins the entity to save
     * @return the persisted entity
     */
    Admins save(Admins admins);

    /**
     * Get all the admins.
     *
     * @return the list of entities
     */
    List<Admins> findAll();

    /**
     * Get the "id" admins.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Admins findOne(Long id);

    /**
     * Delete the "id" admins.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
