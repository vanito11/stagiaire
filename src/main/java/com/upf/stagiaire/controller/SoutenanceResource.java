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
import com.upf.stagiaire.model.Soutenance;
import com.upf.stagiaire.service.SoutenanceService;
import com.upf.stagiaire.util.HeaderUtil;

/**
 * REST controller for managing Soutenance.
 */
@RestController
@RequestMapping("/api")
public class SoutenanceResource {
    
    private final Logger log = LoggerFactory.getLogger(SoutenanceResource.class);
    
    private static final String ENTITY_NAME = "soutenance";
    
    private final SoutenanceService soutenanceService;
    
    public SoutenanceResource(SoutenanceService soutenanceService) {
        this.soutenanceService = soutenanceService;
    }
    
    /**
     * POST /soutenances : Create a new soutenance.
     *
     * @param soutenance
     *            the soutenance to create
     * @return the ResponseEntity with status 201 (Created) and with body the new soutenance, or with status 400 (Bad
     *         Request) if the soutenance has already an ID
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PostMapping("/soutenances")
    @Timed
    public ResponseEntity<Soutenance> createSoutenance(@RequestBody Soutenance soutenance) throws URISyntaxException {
        log.debug("REST request to save Soutenance : {}", soutenance);
        if (soutenance.getId() != null) {
            throw new BadRequestAlertException("A new soutenance cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Soutenance result = soutenanceService.save(soutenance);
        return ResponseEntity.created(new URI("/api/soutenances/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }
    
    /**
     * PUT /soutenances : Updates an existing soutenance.
     *
     * @param soutenance
     *            the soutenance to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated soutenance, or with status 400 (Bad
     *         Request) if the soutenance is not valid, or with status 500 (Internal Server Error) if the soutenance
     *         couldn't be updated
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PutMapping("/soutenances")
    @Timed
    public ResponseEntity<Soutenance> updateSoutenance(@RequestBody Soutenance soutenance) throws URISyntaxException {
        log.debug("REST request to update Soutenance : {}", soutenance);
        if (soutenance.getId() == null) {
            return createSoutenance(soutenance);
        }
        Soutenance result = soutenanceService.save(soutenance);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, soutenance.getId().toString()))
                .body(result);
    }
    
    /**
     * GET /soutenances : get all the soutenances.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of soutenances in body
     */
    @GetMapping("/soutenances")
    @Timed
    public List<Soutenance> getAllSoutenances() {
        log.debug("REST request to get all Soutenances");
        return soutenanceService.findAll();
    }
    
    /**
     * GET /soutenances/:id : get the "id" soutenance.
     *
     * @param id
     *            the id of the soutenance to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the soutenance, or with status 404 (Not Found)
     */
    @GetMapping("/soutenances/{id}")
    @Timed
    public Soutenance getSoutenance(@PathVariable Long id) {
        log.debug("REST request to get Soutenance : {}", id);
        Soutenance soutenance = soutenanceService.findOne(id);
        return soutenance;
    }
    
    /**
     * DELETE /soutenances/:id : delete the "id" soutenance.
     *
     * @param id
     *            the id of the soutenance to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/soutenances/{id}")
    @Timed
    public ResponseEntity<Void> deleteSoutenance(@PathVariable Long id) {
        log.debug("REST request to delete Soutenance : {}", id);
        soutenanceService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
