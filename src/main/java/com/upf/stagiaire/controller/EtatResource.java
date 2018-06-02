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
import com.upf.stagiaire.model.Etat;
import com.upf.stagiaire.service.EtatService;
import com.upf.stagiaire.util.HeaderUtil;

/**
 * REST controller for managing Etat.
 */
@RestController
@RequestMapping("/api")

public class EtatResource {
    
    private final Logger log = LoggerFactory.getLogger(EtatResource.class);
    
    private static final String ENTITY_NAME = "etat";
    
    private final EtatService etatService;
    
    public EtatResource(EtatService etatService) {
        this.etatService = etatService;
    }
    
    /**
     * POST /etats : Create a new etat.
     *
     * @param etat
     *            the etat to create
     * @return the ResponseEntity with status 201 (Created) and with body the new etat, or with status 400 (Bad Request)
     *         if the etat has already an ID
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PostMapping("/etats")
    @Timed
    public ResponseEntity<Etat> createEtat(@RequestBody Etat etat) throws URISyntaxException {
        log.debug("REST request to save Etat : {}", etat);
        if (etat.getId() != null) {
            throw new BadRequestAlertException("A new etat cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Etat result = etatService.save(etat);
        return ResponseEntity.created(new URI("/api/etats/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }
    
    /**
     * PUT /etats : Updates an existing etat.
     *
     * @param etat
     *            the etat to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated etat, or with status 400 (Bad Request)
     *         if the etat is not valid, or with status 500 (Internal Server Error) if the etat couldn't be updated
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PutMapping("/etats")
    @Timed
    public ResponseEntity<Etat> updateEtat(@RequestBody Etat etat) throws URISyntaxException {
        log.debug("REST request to update Etat : {}", etat);
        if (etat.getId() == null) {
            return createEtat(etat);
        }
        Etat result = etatService.save(etat);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, etat.getId().toString()))
                .body(result);
    }
    
    /**
     * GET /etats : get all the etats.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of etats in body
     */
    @GetMapping("/etats")
    @Timed
    public List<Etat> getAllEtats() {
        log.debug("REST request to get all Etats");
        return etatService.findAll();
    }
    
    /**
     * GET /etats/:id : get the "id" etat.
     *
     * @param id
     *            the id of the etat to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the etat, or with status 404 (Not Found)
     */
    @GetMapping("/etats/{id}")
    @Timed
    public Etat getEtat(@PathVariable Long id) {
        log.debug("REST request to get Etat : {}", id);
        Etat etat = etatService.findOne(id);
        return etat;
    }
    
    /**
     * DELETE /etats/:id : delete the "id" etat.
     *
     * @param id
     *            the id of the etat to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/etats/{id}")
    @Timed
    public ResponseEntity<Void> deleteEtat(@PathVariable Long id) {
        log.debug("REST request to delete Etat : {}", id);
        etatService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
