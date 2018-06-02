package com.upf.stagiaire.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.upf.stagiaire.model.Typedate;
import com.upf.stagiaire.service.TypedateService;
import com.upf.stagiaire.util.HeaderUtil;

/**
 * REST controller for managing Typedate.
 */
@RestController
@RequestMapping("/api")

public class TypedateResource {
    
    private final Logger log = LoggerFactory.getLogger(TypedateResource.class);
    
    private static final String ENTITY_NAME = "typedate";
    
    private final TypedateService typedateService;
    
    public TypedateResource(TypedateService typedateService) {
        this.typedateService = typedateService;
    }
    
    /**
     * POST /typedates : Create a new typedate.
     *
     * @param typedate
     *            the typedate to create
     * @return the ResponseEntity with status 201 (Created) and with body the new typedate, or with status 400 (Bad
     *         Request) if the typedate has already an ID
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PostMapping("/typedates")
    @Timed
    public ResponseEntity<Typedate> createTypedate(@RequestBody Typedate typedate) throws URISyntaxException {
        log.debug("REST request to save Typedate : {}", typedate);
        if (typedate.getId() != null) {
            throw new BadRequestAlertException("A new typedate cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Typedate result = typedateService.save(typedate);
        return ResponseEntity.created(new URI("/api/typedates/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }
    
    /**
     * PUT /typedates : Updates an existing typedate.
     *
     * @param typedate
     *            the typedate to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated typedate, or with status 400 (Bad
     *         Request) if the typedate is not valid, or with status 500 (Internal Server Error) if the typedate
     *         couldn't be updated
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PutMapping("/typedates")
    @Timed
    public ResponseEntity<Typedate> updateTypedate(@RequestBody Typedate typedate) throws URISyntaxException {
        log.debug("REST request to update Typedate : {}", typedate);
        if (typedate.getId() == null) {
            return createTypedate(typedate);
        }
        Typedate result = typedateService.save(typedate);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, typedate.getId().toString()))
                .body(result);
    }
    
    /**
     * GET /typedates : get all the typedates.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of typedates in body
     */
    @GetMapping("/typedates")
    @Timed
    public List<Typedate> getAllTypedates() {
        log.debug("REST request to get all Typedates");
        return typedateService.findAll();
    }
    
    /**
     * GET /typedates/:id : get the "id" typedate.
     *
     * @param id
     *            the id of the typedate to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the typedate, or with status 404 (Not Found)
     */
    @GetMapping("/typedates/{id}")
    @Timed
    public Typedate getTypedate(@PathVariable Long id) {
        log.debug("REST request to get Typedate : {}", id);
        Typedate typedate = typedateService.findOne(id);
        return typedate;
    }
    
    /**
     * DELETE /typedates/:id : delete the "id" typedate.
     *
     * @param id
     *            the id of the typedate to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/typedates/{id}")
    @Timed
    public ResponseEntity<Void> deleteTypedate(@PathVariable Long id) {
        log.debug("REST request to delete Typedate : {}", id);
        typedateService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
