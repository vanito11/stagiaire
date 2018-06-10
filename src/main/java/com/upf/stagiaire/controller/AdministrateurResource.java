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

import com.upf.stagiaire.exception.BadRequestAlertException;
import com.upf.stagiaire.model.Administrateur;
import com.upf.stagiaire.service.AdministrateurService;
import com.upf.stagiaire.util.HeaderUtil;

/**
 * REST controller for managing Administrateur.
 */
@RestController
@RequestMapping("/api")

public class AdministrateurResource {
    
    private final Logger log = LoggerFactory.getLogger(AdministrateurResource.class);
    
    private static final String ENTITY_NAME = "administrateur";
    
    private final AdministrateurService administrateurService;
    
    public AdministrateurResource(AdministrateurService administrateurService) {
        this.administrateurService = administrateurService;
    }
    
    /**
     * POST /administrateurs : Create a new administrateur.
     *
     * @param administrateur
     *            the administrateur to create
     * @return the ResponseEntity with status 201 (Created) and with body the new administrateur, or with status 400
     *         (Bad Request) if the administrateur has already an ID
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PostMapping("/administrateurs/add")    
    public ResponseEntity<Administrateur> createAdministrateur(@RequestBody Administrateur administrateur)
        throws URISyntaxException {
        log.debug("REST request to save Administrateur : {}", administrateur);
        if (administrateur.getId() != null) {
            throw new BadRequestAlertException("A new administrateur cannot already have an ID", ENTITY_NAME,
                    "idexists");
        }
        Administrateur result = administrateurService.save(administrateur);
        return ResponseEntity.created(new URI("/api/administrateurs/add" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }
    
    /**
     * PUT /administrateurs : Updates an existing administrateur.
     *
     * @param administrateur
     *            the administrateur to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated administrateur, or with status 400 (Bad
     *         Request) if the administrateur is not valid, or with status 500 (Internal Server Error) if the
     *         administrateur couldn't be updated
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PutMapping("/administrateurs/update")    
    public ResponseEntity<Administrateur> updateAdministrateur(@RequestBody Administrateur administrateur)
        throws URISyntaxException {
        log.debug("REST request to update Administrateur : {}", administrateur);
        if (administrateur.getId() == null) {
            return createAdministrateur(administrateur);
        }
        
        Administrateur result = administrateurService.save(administrateur);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, administrateur.getId().toString()))
                .body(result);
    }
    
    /**
     * GET /administrateurs : get all the administrateurs.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of administrateurs in body
     */
    @GetMapping("/administrateurs")    
    public List<Administrateur> getAllAdministrateurs() {
        log.debug("REST request to get all Administrateurs");
        return administrateurService.findAll();
    }
    
    /**
     * GET /administrateurs/:id : get the "id" administrateur.
     *
     * @param id
     *            the id of the administrateur to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the administrateur, or with status 404 (Not Found)
     */
    @GetMapping("/administrateurs/search/id/{id}")    
    public Administrateur getAdministrateur(@PathVariable Long id) {
        log.debug("REST request to get Administrateur : {}", id);
        Administrateur administrateur = administrateurService.findOne(id);
        return administrateur;
    }
    
    /**
     * GET /administrateurs : get all the administrateurs.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of administrateurs in body
     */
    @GetMapping("/administrateurs/search/nom/{nom}")    
    public List<Administrateur> getAdministrateursByNom(@PathVariable String nom) {
        log.debug("REST request to get all Administrateurs");
        return administrateurService.findByNom(nom);
    }
    
    /**
     * DELETE /administrateurs/:id : delete the "id" administrateur.
     *
     * @param id
     *            the id of the administrateur to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/administrateurs/{id}")
    
    public ResponseEntity<Void> deleteAdministrateur(@PathVariable Long id) {
        log.debug("REST request to delete Administrateur : {}", id);
        administrateurService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
