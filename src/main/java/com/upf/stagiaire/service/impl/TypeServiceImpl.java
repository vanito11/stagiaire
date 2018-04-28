package com.upf.stagiaire.service.impl;

import com.upf.stagiaire.service.TypeService;
import com.upf.stagiaire.model.Type;
import com.upf.stagiaire.repository.TypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Type.
 */
@Service
@Transactional
public class TypeServiceImpl implements TypeService {

    private final Logger log = LoggerFactory.getLogger(TypeServiceImpl.class);

    private final TypeRepository typeRepository;

    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    /**
     * Save a type.
     *
     * @param type the entity to save
     * @return the persisted entity
     */
    @Override
    public Type save(Type type) {
        log.debug("Request to save Type : {}", type);
        return typeRepository.save(type);
    }

    /**
     * Get all the types.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Type> findAll() {
        log.debug("Request to get all Types");
        return typeRepository.findAll();
    }

    /**
     * Get one type by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Type findOne(Long id) {
        log.debug("Request to get Type : {}", id);
        return typeRepository.findOne(id);
    }

    /**
     * Delete the type by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Type : {}", id);
        typeRepository.delete(id);
    }
}
