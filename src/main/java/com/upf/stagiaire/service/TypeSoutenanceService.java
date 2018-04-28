package com.upf.stagiaire.service;

import java.util.List;

import com.upf.stagiaire.model.TypeSoutenance;

/**
 * Service Interface for managing TypeSoutenance.
 */
public interface TypeSoutenanceService {

    /**
     * Save a typeSoutenance.
     *
     * @param typeSoutenance the entity to save
     * @return the persisted entity
     */
    TypeSoutenance save(TypeSoutenance typeSoutenance);

    /**
     * Get all the typeSoutenances.
     *
     * @return the list of entities
     */
    List<TypeSoutenance> findAll();

    /**
     * Get the "id" typeSoutenance.
     *
     * @param id the id of the entity
     * @return the entity
     */
    TypeSoutenance findOne(Long id);

    /**
     * Delete the "id" typeSoutenance.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
