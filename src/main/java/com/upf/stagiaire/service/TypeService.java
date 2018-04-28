package com.upf.stagiaire.service;

import java.util.List;

import com.upf.stagiaire.model.Type;

/**
 * Service Interface for managing Type.
 */
public interface TypeService {

    /**
     * Save a type.
     *
     * @param type the entity to save
     * @return the persisted entity
     */
    Type save(Type type);

    /**
     * Get all the types.
     *
     * @return the list of entities
     */
    List<Type> findAll();

    /**
     * Get the "id" type.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Type findOne(Long id);

    /**
     * Delete the "id" type.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
