package com.upf.stagiaire.service.impl;

import com.upf.stagiaire.service.AdminsService;
import com.upf.stagiaire.model.Admins;
import com.upf.stagiaire.repository.AdminsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Admins.
 */
@Service
@Transactional
public class AdminsServiceImpl implements AdminsService {

    private final Logger log = LoggerFactory.getLogger(AdminsServiceImpl.class);

    private final AdminsRepository adminsRepository;

    public AdminsServiceImpl(AdminsRepository adminsRepository) {
        this.adminsRepository = adminsRepository;
    }

    /**
     * Save a admins.
     *
     * @param admins the entity to save
     * @return the persisted entity
     */
    @Override
    public Admins save(Admins admins) {
        log.debug("Request to save Admins : {}", admins);
        return adminsRepository.save(admins);
    }

    /**
     * Get all the admins.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Admins> findAll() {
        log.debug("Request to get all Admins");
        return adminsRepository.findAll();
    }

    /**
     * Get one admins by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Admins findOne(Long id) {
        log.debug("Request to get Admins : {}", id);
        return adminsRepository.findOne(id);
    }

    /**
     * Delete the admins by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Admins : {}", id);
        adminsRepository.delete(id);
    }
}
