package com.upf.stagiaire.service;

import java.util.List;

import com.upf.stagiaire.model.StageStagiaire;

/**
 * Service Interface for managing StageStagiaire.
 */
public interface StageStagiaireService {

    /**
     * Save a StageStagiaire.
     *
     * @param StageStagiaire the entity to save
     * @return the persisted entity
     */
    StageStagiaire save(StageStagiaire StageStagiaire);

    /**
     * Get all the StageStagiaires.
     *
     * @return the list of entities
     */
    List<StageStagiaire> findAll();

    /**
     * Get the "id" StageStagiaire.
     *
     * @param id the id of the entity
     * @return the entity
     */
    StageStagiaire findOne(Long id);

    /**
     * Delete the "id" StageStagiaire.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
    StageStagiaire findByStageidAndStagiaireid(Long Stageid,Long Stagiaireid);
}
