package com.upf.stagiaire.service.impl;

import com.upf.stagiaire.service.TypedateService;
import com.upf.stagiaire.model.Typedate;
import com.upf.stagiaire.repository.TypedateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Typedate.
 */
@Service
@Transactional
public class TypedateServiceImpl implements TypedateService {

    private final Logger log = LoggerFactory.getLogger(TypedateServiceImpl.class);

    private final TypedateRepository typedateRepository;

    public TypedateServiceImpl(TypedateRepository typedateRepository) {
        this.typedateRepository = typedateRepository;
    }

    /**
     * Save a typedate.
     *
     * @param typedate the entity to save
     * @return the persisted entity
     */
    @Override
    public Typedate save(Typedate typedate) {
        log.debug("Request to save Typedate : {}", typedate);
        return typedateRepository.save(typedate);
    }

    /**
     * Get all the typedates.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Typedate> findAll() {
        log.debug("Request to get all Typedates");
        return typedateRepository.findAll();
    }

    /**
     * Get one typedate by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Typedate findOne(Long id) {
        log.debug("Request to get Typedate : {}", id);
        return typedateRepository.findOne(id);
    }

    /**
     * Delete the typedate by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Typedate : {}", id);
        typedateRepository.delete(id);
    }
}
