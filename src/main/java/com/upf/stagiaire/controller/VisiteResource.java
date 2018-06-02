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
import com.upf.stagiaire.model.Visite;
import com.upf.stagiaire.service.VisiteService;
import com.upf.stagiaire.util.HeaderUtil;

/**
 * REST controller for managing Visite.
 */
@RestController
@RequestMapping("/api")

public class VisiteResource {
    
    private final Logger log = LoggerFactory.getLogger(VisiteResource.class);
    
    private static final String ENTITY_NAME = "visite";
    
    private final VisiteService visiteService;
    
    public VisiteResource(VisiteService visiteService) {
        this.visiteService = visiteService;
    }
    
    /**
     * POST /visites : Create a new visite.
     *
     * @param visite
     *            the visite to create
     * @return the ResponseEntity with status 201 (Created) and with body the new visite, or with status 400 (Bad
     *         Request) if the visite has already an ID
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PostMapping("/visites")
    @Timed
    public ResponseEntity<Visite> createVisite(@RequestBody Visite visite) throws URISyntaxException {
        log.debug("REST request to save Visite : {}", visite);
        if (visite.getId() != null) {
            throw new BadRequestAlertException("A new visite cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Visite result = visiteService.save(visite);
        return ResponseEntity.created(new URI("/api/visites/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }
    
    /**
     * PUT /visites : Updates an existing visite.
     *
     * @param visite
     *            the visite to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated visite, or with status 400 (Bad
     *         Request) if the visite is not valid, or with status 500 (Internal Server Error) if the visite couldn't be
     *         updated
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PutMapping("/visites")
    @Timed
    public ResponseEntity<Visite> updateVisite(@RequestBody Visite visite) throws URISyntaxException {
        log.debug("REST request to update Visite : {}", visite);
        if (visite.getId() == null) {
            return createVisite(visite);
        }
        Visite result = visiteService.save(visite);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, visite.getId().toString()))
                .body(result);
    }
    
    /**
     * GET /visites : get all the visites.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of visites in body
     */
    @GetMapping("/visites")
    @Timed
    public List<Visite> getAllVisites() {
        log.debug("REST request to get all Visites");
        return visiteService.findAll();
    }
    
    /**
     * GET /visites/:id : get the "id" visite.
     *
     * @param id
     *            the id of the visite to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the visite, or with status 404 (Not Found)
     */
    @GetMapping("/visites/{id}")
    @Timed
    public Visite getVisite(@PathVariable Long id) {
        log.debug("REST request to get Visite : {}", id);
        Visite visite = visiteService.findOne(id);
        return visite;
    }
    
    /**
     * DELETE /visites/:id : delete the "id" visite.
     *
     * @param id
     *            the id of the visite to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/visites/{id}")
    @Timed
    public ResponseEntity<Void> deleteVisite(@PathVariable Long id) {
        log.debug("REST request to delete Visite : {}", id);
        visiteService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
