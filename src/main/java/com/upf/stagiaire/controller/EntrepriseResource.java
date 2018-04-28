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
import com.upf.stagiaire.model.Entreprise;
import com.upf.stagiaire.service.EntrepriseService;
import com.upf.stagiaire.util.HeaderUtil;

/**
 * REST controller for managing Entreprise.
 */
@RestController
@RequestMapping("/api")
public class EntrepriseResource {
    
    private final Logger log = LoggerFactory.getLogger(EntrepriseResource.class);
    
    private static final String ENTITY_NAME = "entreprise";
    
    private final EntrepriseService entrepriseService;
    
    public EntrepriseResource(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }
    
    /**
     * POST /entreprises : Create a new entreprise.
     *
     * @param entreprise
     *            the entreprise to create
     * @return the ResponseEntity with status 201 (Created) and with body the new entreprise, or with status 400 (Bad
     *         Request) if the entreprise has already an ID
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PostMapping("/entreprises")
    @Timed
    public ResponseEntity<Entreprise> createEntreprise(@RequestBody Entreprise entreprise) throws URISyntaxException {
        log.debug("REST request to save Entreprise : {}", entreprise);
        if (entreprise.getId() != null) {
            throw new BadRequestAlertException("A new entreprise cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Entreprise result = entrepriseService.save(entreprise);
        return ResponseEntity.created(new URI("/api/entreprises/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }
    
    /**
     * PUT /entreprises : Updates an existing entreprise.
     *
     * @param entreprise
     *            the entreprise to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated entreprise, or with status 400 (Bad
     *         Request) if the entreprise is not valid, or with status 500 (Internal Server Error) if the entreprise
     *         couldn't be updated
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PutMapping("/entreprises")
    @Timed
    public ResponseEntity<Entreprise> updateEntreprise(@RequestBody Entreprise entreprise) throws URISyntaxException {
        log.debug("REST request to update Entreprise : {}", entreprise);
        if (entreprise.getId() == null) {
            return createEntreprise(entreprise);
        }
        Entreprise result = entrepriseService.save(entreprise);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, entreprise.getId().toString()))
                .body(result);
    }
    
    /**
     * GET /entreprises : get all the entreprises.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of entreprises in body
     */
    @GetMapping("/entreprises")
    @Timed
    public List<Entreprise> getAllEntreprises() {
        log.debug("REST request to get all Entreprises");
        return entrepriseService.findAll();
    }
    
    /**
     * GET /entreprises/:id : get the "id" entreprise.
     *
     * @param id
     *            the id of the entreprise to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the entreprise, or with status 404 (Not Found)
     */
    @GetMapping("/entreprises/{id}")
    @Timed
    public Entreprise getEntreprise(@PathVariable Long id) {
        log.debug("REST request to get Entreprise : {}", id);
        Entreprise entreprise = entrepriseService.findOne(id);
        return entreprise;
    }
    
    /**
     * DELETE /entreprises/:id : delete the "id" entreprise.
     *
     * @param id
     *            the id of the entreprise to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/entreprises/{id}")
    @Timed
    public ResponseEntity<Void> deleteEntreprise(@PathVariable Long id) {
        log.debug("REST request to delete Entreprise : {}", id);
        entrepriseService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
