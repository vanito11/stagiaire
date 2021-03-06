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
import com.upf.stagiaire.model.Encadrant;
import com.upf.stagiaire.service.EncadrantService;
import com.upf.stagiaire.util.HeaderUtil;

/**
 * REST controller for managing Encadrant.
 */
@RestController
@RequestMapping("/api")
public class EncadrantResource {
    
    private final Logger log = LoggerFactory.getLogger(EncadrantResource.class);
    
    private static final String ENTITY_NAME = "encadrant";
    
    private final EncadrantService encadrantService;
    
    public EncadrantResource(EncadrantService encadrantService) {
        this.encadrantService = encadrantService;
    }
    
    /**
     * POST /encadrants : Create a new encadrant.
     *
     * @param encadrant
     *            the encadrant to create
     * @return the ResponseEntity with status 201 (Created) and with body the new encadrant, or with status 400 (Bad
     *         Request) if the encadrant has already an ID
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PostMapping("/encadrants")
    @Timed
    public ResponseEntity<Encadrant> createEncadrant(@RequestBody Encadrant encadrant) throws URISyntaxException {
        log.debug("REST request to save Encadrant : {}", encadrant);
        if (encadrant.getId() != null) {
            throw new BadRequestAlertException("A new encadrant cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Encadrant result = encadrantService.save(encadrant);
        return ResponseEntity.created(new URI("/api/encadrants/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }
    
    /**
     * PUT /encadrants : Updates an existing encadrant.
     *
     * @param encadrant
     *            the encadrant to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated encadrant, or with status 400 (Bad
     *         Request) if the encadrant is not valid, or with status 500 (Internal Server Error) if the encadrant
     *         couldn't be updated
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PutMapping("/encadrants")
    @Timed
    public ResponseEntity<Encadrant> updateEncadrant(@RequestBody Encadrant encadrant) throws URISyntaxException {
        log.debug("REST request to update Encadrant : {}", encadrant);
        if (encadrant.getId() == null) {
            return createEncadrant(encadrant);
        }
        Encadrant result = encadrantService.save(encadrant);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, encadrant.getId().toString()))
                .body(result);
    }
    
    /**
     * GET /encadrants : get all the encadrants.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of encadrants in body
     */
    @GetMapping("/encadrants")
    @Timed
    public List<Encadrant> getAllEncadrants() {
        log.debug("REST request to get all Encadrants");
        return encadrantService.findAll();
    }
    
    /**
     * GET /encadrants/:id : get the "id" encadrant.
     *
     * @param id
     *            the id of the encadrant to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the encadrant, or with status 404 (Not Found)
     */
    @GetMapping("/encadrants/{id}")
    @Timed
    public Encadrant getEncadrant(@PathVariable Long id) {
        log.debug("REST request to get Encadrant : {}", id);
        Encadrant encadrant = encadrantService.findOne(id);
        return encadrant;
    }
    
    /**
     * DELETE /encadrants/:id : delete the "id" encadrant.
     *
     * @param id
     *            the id of the encadrant to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/encadrants/{id}")
    @Timed
    public ResponseEntity<Void> deleteEncadrant(@PathVariable Long id) {
        log.debug("REST request to delete Encadrant : {}", id);
        encadrantService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
