package com.upf.stagiaire.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.upf.stagiaire.exception.BadRequestAlertException;
import com.upf.stagiaire.model.TypeDocument;
import com.upf.stagiaire.service.TypeDocumentService;
import com.upf.stagiaire.util.HeaderUtil;

/**
 * REST controller for managing TypeDocument.
 */
@RestController
@RequestMapping("/api")
public class TypeDocumentResource {
    
    private final Logger log = LoggerFactory.getLogger(TypeDocumentResource.class);
    
    private static final String ENTITY_NAME = "typeDocument";
    
    private final TypeDocumentService typeDocumentService;
    
    public TypeDocumentResource(TypeDocumentService typeDocumentService) {
        this.typeDocumentService = typeDocumentService;
    }
    
    /**
     * POST /type-documents : Create a new typeDocument.
     *
     * @param typeDocument
     *            the typeDocument to create
     * @return the ResponseEntity with status 201 (Created) and with body the new typeDocument, or with status 400 (Bad
     *         Request) if the typeDocument has already an ID
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PostMapping("/type-documents")
    @Timed
    public ResponseEntity<TypeDocument> createTypeDocument(@RequestBody TypeDocument typeDocument)
        throws URISyntaxException {
        log.debug("REST request to save TypeDocument : {}", typeDocument);
        if (typeDocument.getId() != null) {
            throw new BadRequestAlertException("A new typeDocument cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TypeDocument result = typeDocumentService.save(typeDocument);
        return ResponseEntity.created(new URI("/api/type-documents/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }
    
    /**
     * PUT /type-documents : Updates an existing typeDocument.
     *
     * @param typeDocument
     *            the typeDocument to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated typeDocument, or with status 400 (Bad
     *         Request) if the typeDocument is not valid, or with status 500 (Internal Server Error) if the typeDocument
     *         couldn't be updated
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PutMapping("/type-documents")
    @Timed
    public ResponseEntity<TypeDocument> updateTypeDocument(@RequestBody TypeDocument typeDocument)
        throws URISyntaxException {
        log.debug("REST request to update TypeDocument : {}", typeDocument);
        if (typeDocument.getId() == null) {
            return createTypeDocument(typeDocument);
        }
        TypeDocument result = typeDocumentService.save(typeDocument);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, typeDocument.getId().toString()))
                .body(result);
    }
    
    /**
     * GET /type-documents : get all the typeDocuments.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of typeDocuments in body
     */
    @GetMapping("/type-documents")
    @Timed
    public List<TypeDocument> getAllTypeDocuments() {
        log.debug("REST request to get all TypeDocuments");
        return typeDocumentService.findAll();
    }
    
    /**
     * GET /type-documents/:id : get the "id" typeDocument.
     *
     * @param id
     *            the id of the typeDocument to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the typeDocument, or with status 404 (Not Found)
     */
    @GetMapping("/type-documents/{id}")
    @Timed
    public TypeDocument getTypeDocument(@PathVariable Long id) {
        log.debug("REST request to get TypeDocument : {}", id);
        TypeDocument typeDocument = typeDocumentService.findOne(id);
        return typeDocument;
    }
    
    /**
     * DELETE /type-documents/:id : delete the "id" typeDocument.
     *
     * @param id
     *            the id of the typeDocument to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/type-documents/{id}")
    @Timed
    public ResponseEntity<Void> deleteTypeDocument(@PathVariable Long id) {
        log.debug("REST request to delete TypeDocument : {}", id);
        typeDocumentService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
