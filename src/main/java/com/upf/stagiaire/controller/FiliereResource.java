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
import com.upf.stagiaire.model.Filiere;
import com.upf.stagiaire.service.FiliereService;
import com.upf.stagiaire.util.HeaderUtil;

/**
 * REST controller for managing Filiere.
 */
@RestController
@RequestMapping("/api")
public class FiliereResource {
    
    private final Logger log = LoggerFactory.getLogger(FiliereResource.class);
    
    private static final String ENTITY_NAME = "filiere";
    
    private final FiliereService filiereService;
    
    public FiliereResource(FiliereService filiereService) {
        this.filiereService = filiereService;
    }
    
    /**
     * POST /filieres : Create a new filiere.
     *
     * @param filiere
     *            the filiere to create
     * @return the ResponseEntity with status 201 (Created) and with body the new filiere, or with status 400 (Bad
     *         Request) if the filiere has already an ID
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PostMapping("/filieres")
    @Timed
    public ResponseEntity<Filiere> createFiliere(@RequestBody Filiere filiere) throws URISyntaxException {
        log.debug("REST request to save Filiere : {}", filiere);
        if (filiere.getId() != null) {
            throw new BadRequestAlertException("A new filiere cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Filiere result = filiereService.save(filiere);
        return ResponseEntity.created(new URI("/api/filieres/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }
    
    /**
     * PUT /filieres : Updates an existing filiere.
     *
     * @param filiere
     *            the filiere to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated filiere, or with status 400 (Bad
     *         Request) if the filiere is not valid, or with status 500 (Internal Server Error) if the filiere couldn't
     *         be updated
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PutMapping("/filieres")
    @Timed
    public ResponseEntity<Filiere> updateFiliere(@RequestBody Filiere filiere) throws URISyntaxException {
        log.debug("REST request to update Filiere : {}", filiere);
        if (filiere.getId() == null) {
            return createFiliere(filiere);
        }
        Filiere result = filiereService.save(filiere);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, filiere.getId().toString()))
                .body(result);
    }
    
    /**
     * GET /filieres : get all the filieres.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of filieres in body
     */
    @GetMapping("/filieres")
    @Timed
    public List<Filiere> getAllFilieres() {
        log.debug("REST request to get all Filieres");
        return filiereService.findAll();
    }
    
    /**
     * GET /filieres/:id : get the "id" filiere.
     *
     * @param id
     *            the id of the filiere to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the filiere, or with status 404 (Not Found)
     */
    @GetMapping("/filieres/{id}")
    @Timed
    public Filiere getFiliere(@PathVariable Long id) {
        log.debug("REST request to get Filiere : {}", id);
        Filiere filiere = filiereService.findOne(id);
        return filiere;
    }
    
    /**
     * DELETE /filieres/:id : delete the "id" filiere.
     *
     * @param id
     *            the id of the filiere to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/filieres/{id}")
    @Timed
    public ResponseEntity<Void> deleteFiliere(@PathVariable Long id) {
        log.debug("REST request to delete Filiere : {}", id);
        filiereService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
