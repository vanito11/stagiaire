package com.upf.stagiaire.service;

import java.util.List;

import com.upf.stagiaire.model.Document;

/**
 * Service Interface for managing Document.
 */
public interface DocumentService {

    /**
     * Save a document.
     *
     * @param document the entity to save
     * @return the persisted entity
     */
    Document save(Document document);

    /**
     * Get all the documents.
     *
     * @return the list of entities
     */
    List<Document> findAll();

    /**
     * Get the "id" document.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Document findOne(Long id);

    /**
     * Delete the "id" document.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
    
    List<Document> findDocumentByStageId(Long id);
    void deleteDocumentByStageId(Long id);
}
