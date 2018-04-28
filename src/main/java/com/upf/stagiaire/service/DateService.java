package com.upf.stagiaire.service;

import java.util.List;

import com.upf.stagiaire.model.Date;

/**
 * Service Interface for managing Date.
 */
public interface DateService {

    /**
     * Save a date.
     *
     * @param date the entity to save
     * @return the persisted entity
     */
    Date save(Date date);

    /**
     * Get all the dates.
     *
     * @return the list of entities
     */
    List<Date> findAll();

    /**
     * Get the "id" date.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Date findOne(Long id);

    /**
     * Delete the "id" date.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
