package com.upf.stagiaire.service.impl;

import com.upf.stagiaire.service.TypeSoutenanceService;
import com.upf.stagiaire.model.TypeSoutenance;
import com.upf.stagiaire.repository.TypeSoutenanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing TypeSoutenance.
 */
@Service
@Transactional
public class TypeSoutenanceServiceImpl implements TypeSoutenanceService {

    private final Logger log = LoggerFactory.getLogger(TypeSoutenanceServiceImpl.class);

    private final TypeSoutenanceRepository typeSoutenanceRepository;

    public TypeSoutenanceServiceImpl(TypeSoutenanceRepository typeSoutenanceRepository) {
        this.typeSoutenanceRepository = typeSoutenanceRepository;
    }

    /**
     * Save a typeSoutenance.
     *
     * @param typeSoutenance the entity to save
     * @return the persisted entity
     */
    @Override
    public TypeSoutenance save(TypeSoutenance typeSoutenance) {
        log.debug("Request to save TypeSoutenance : {}", typeSoutenance);
        return typeSoutenanceRepository.save(typeSoutenance);
    }

    /**
     * Get all the typeSoutenances.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<TypeSoutenance> findAll() {
        log.debug("Request to get all TypeSoutenances");
        return typeSoutenanceRepository.findAll();
    }

    /**
     * Get one typeSoutenance by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public TypeSoutenance findOne(Long id) {
        log.debug("Request to get TypeSoutenance : {}", id);
        return typeSoutenanceRepository.findOne(id);
    }

    /**
     * Delete the typeSoutenance by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete TypeSoutenance : {}", id);
        typeSoutenanceRepository.delete(id);
    }
}
