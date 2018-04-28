package com.upf.stagiaire.service;

import java.util.List;

import com.upf.stagiaire.model.Typedate;

/**
 * Service Interface for managing Typedate.
 */
public interface TypedateService {

    /**
     * Save a typedate.
     *
     * @param typedate the entity to save
     * @return the persisted entity
     */
    Typedate save(Typedate typedate);

    /**
     * Get all the typedates.
     *
     * @return the list of entities
     */
    List<Typedate> findAll();

    /**
     * Get the "id" typedate.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Typedate findOne(Long id);

    /**
     * Delete the "id" typedate.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
