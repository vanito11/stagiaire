package com.upf.stagiaire.service.impl;

import com.upf.stagiaire.service.TypeDocumentService;
import com.upf.stagiaire.model.TypeDocument;
import com.upf.stagiaire.repository.TypeDocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing TypeDocument.
 */
@Service
@Transactional
public class TypeDocumentServiceImpl implements TypeDocumentService {

    private final Logger log = LoggerFactory.getLogger(TypeDocumentServiceImpl.class);

    private final TypeDocumentRepository typeDocumentRepository;

    public TypeDocumentServiceImpl(TypeDocumentRepository typeDocumentRepository) {
        this.typeDocumentRepository = typeDocumentRepository;
    }

    /**
     * Save a typeDocument.
     *
     * @param typeDocument the entity to save
     * @return the persisted entity
     */
    @Override
    public TypeDocument save(TypeDocument typeDocument) {
        log.debug("Request to save TypeDocument : {}", typeDocument);
        return typeDocumentRepository.save(typeDocument);
    }

    /**
     * Get all the typeDocuments.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<TypeDocument> findAll() {
        log.debug("Request to get all TypeDocuments");
        return typeDocumentRepository.findAll();
    }

    /**
     * Get one typeDocument by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public TypeDocument findOne(Long id) {
        log.debug("Request to get TypeDocument : {}", id);
        return typeDocumentRepository.findOne(id);
    }

    /**
     * Delete the typeDocument by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete TypeDocument : {}", id);
        typeDocumentRepository.delete(id);
    }
}
