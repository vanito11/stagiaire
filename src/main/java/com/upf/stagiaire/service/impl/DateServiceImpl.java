package com.upf.stagiaire.service.impl;

import com.upf.stagiaire.service.DateService;
import com.upf.stagiaire.model.Date;
import com.upf.stagiaire.repository.DateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Date.
 */
@Service
@Transactional
public class DateServiceImpl implements DateService {

    private final Logger log = LoggerFactory.getLogger(DateServiceImpl.class);

    private final DateRepository dateRepository;

    public DateServiceImpl(DateRepository dateRepository) {
        this.dateRepository = dateRepository;
    }

    /**
     * Save a date.
     *
     * @param date the entity to save
     * @return the persisted entity
     */
    @Override
    public Date save(Date date) {
        log.debug("Request to save Date : {}", date);
        return dateRepository.save(date);
    }

    /**
     * Get all the dates.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Date> findAll() {
        log.debug("Request to get all Dates");
        return dateRepository.findAll();
    }

    /**
     * Get one date by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Date findOne(Long id) {
        log.debug("Request to get Date : {}", id);
        return dateRepository.findOne(id);
    }

    /**
     * Delete the date by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Date : {}", id);
        dateRepository.delete(id);
    }
}
