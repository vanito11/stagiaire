package com.upf.stagiaire.service;

import java.util.List;

import com.upf.stagiaire.model.TypeDocument;

/**
 * Service Interface for managing TypeDocument.
 */
public interface TypeDocumentService {

    /**
     * Save a typeDocument.
     *
     * @param typeDocument the entity to save
     * @return the persisted entity
     */
    TypeDocument save(TypeDocument typeDocument);

    /**
     * Get all the typeDocuments.
     *
     * @return the list of entities
     */
    List<TypeDocument> findAll();

    /**
     * Get the "id" typeDocument.
     *
     * @param id the id of the entity
     * @return the entity
     */
    TypeDocument findOne(Long id);

    /**
     * Delete the "id" typeDocument.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
