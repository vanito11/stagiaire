package com.upf.stagiaire.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.encoding.PasswordEncoder;
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
import com.upf.stagiaire.model.Stagiaire;
import com.upf.stagiaire.service.StagiaireService;
import com.upf.stagiaire.util.HeaderUtil;

/**
 * REST controller for managing Stagiaire.
 */
@RestController
@RequestMapping("/api")
public class StagiaireResource {
    
    private final Logger log = LoggerFactory.getLogger(StagiaireResource.class);
    
    private static final String ENTITY_NAME = "stagiaire";
    
    private final StagiaireService stagiaireService;
    
    public StagiaireResource(StagiaireService stagiaireService) {
        this.stagiaireService = stagiaireService;
    }
    
    /**
     * POST /stagiaires : Create a new stagiaire.
     *
     * @param stagiaire
     *            the stagiaire to create
     * @return the ResponseEntity with status 201 (Created) and with body the new stagiaire, or with status 400 (Bad
     *         Request) if the stagiaire has already an ID
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PostMapping("/stagiaires")
    @Timed
    public ResponseEntity<Stagiaire> createStagiaire(@RequestBody Stagiaire stagiaire) throws URISyntaxException {
        log.debug("REST request to save Stagiaire : {}", stagiaire);
        if (stagiaire.getId() != null) {
            throw new BadRequestAlertException("A new stagiaire cannot already have an ID", ENTITY_NAME, "idexists");
        }
       
        
        Stagiaire result = stagiaireService.save(stagiaire);
        return ResponseEntity.created(new URI("/api/stagiaires/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }
    
    /**
     * PUT /stagiaires : Updates an existing stagiaire.
     *
     * @param stagiaire
     *            the stagiaire to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated stagiaire, or with status 400 (Bad
     *         Request) if the stagiaire is not valid, or with status 500 (Internal Server Error) if the stagiaire
     *         couldn't be updated
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PutMapping("/stagiaires")
    @Timed
    public ResponseEntity<Stagiaire> updateStagiaire(@RequestBody Stagiaire stagiaire) throws URISyntaxException {
        log.debug("REST request to update Stagiaire : {}", stagiaire);
        if (stagiaire.getId() == null) {
            return createStagiaire(stagiaire);
        }
        Stagiaire result = stagiaireService.save(stagiaire);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, stagiaire.getId().toString()))
                .body(result);
    }
    
    /**
     * GET /stagiaires : get all the stagiaires.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of stagiaires in body
     */
    @GetMapping("/stagiaires")
    @Timed
    public List<Stagiaire> getAllStagiaires() {
        log.debug("REST request to get all Stagiaires");
        return stagiaireService.findAll();
    }
    
    /**
     * GET /stagiaires/:id : get the "id" stagiaire.
     *
     * @param id
     *            the id of the stagiaire to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the stagiaire, or with status 404 (Not Found)
     */
    @GetMapping("/stagiaires/{id}")
    @Timed
    public Stagiaire getStagiaire(@PathVariable Long id) {
        log.debug("REST request to get Stagiaire : {}", id);
        Stagiaire stagiaire = stagiaireService.findOne(id);
        return stagiaire;
    }
    
    /**
     * DELETE /stagiaires/:id : delete the "id" stagiaire.
     *
     * @param id
     *            the id of the stagiaire to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/stagiaires/{id}")
    @Timed
    public ResponseEntity<Void> deleteStagiaire(@PathVariable Long id) {
        log.debug("REST request to delete Stagiaire : {}", id);
        stagiaireService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
