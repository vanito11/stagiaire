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
import com.upf.stagiaire.model.TypeSoutenance;
import com.upf.stagiaire.service.TypeSoutenanceService;
import com.upf.stagiaire.util.HeaderUtil;

/**
 * REST controller for managing TypeSoutenance.
 */
@RestController
@RequestMapping("/api")

public class TypeSoutenanceResource {
    
    private final Logger log = LoggerFactory.getLogger(TypeSoutenanceResource.class);
    
    private static final String ENTITY_NAME = "typeSoutenance";
    
    private final TypeSoutenanceService typeSoutenanceService;
    
    public TypeSoutenanceResource(TypeSoutenanceService typeSoutenanceService) {
        this.typeSoutenanceService = typeSoutenanceService;
    }
    
    /**
     * POST /type-soutenances : Create a new typeSoutenance.
     *
     * @param typeSoutenance
     *            the typeSoutenance to create
     * @return the ResponseEntity with status 201 (Created) and with body the new typeSoutenance, or with status 400
     *         (Bad Request) if the typeSoutenance has already an ID
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PostMapping("/type-soutenances")
    @Timed
    public ResponseEntity<TypeSoutenance> createTypeSoutenance(@RequestBody TypeSoutenance typeSoutenance)
        throws URISyntaxException {
        log.debug("REST request to save TypeSoutenance : {}", typeSoutenance);
        if (typeSoutenance.getId() != null) {
            throw new BadRequestAlertException("A new typeSoutenance cannot already have an ID", ENTITY_NAME,
                    "idexists");
        }
        TypeSoutenance result = typeSoutenanceService.save(typeSoutenance);
        return ResponseEntity.created(new URI("/api/type-soutenances/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }
    
    /**
     * PUT /type-soutenances : Updates an existing typeSoutenance.
     *
     * @param typeSoutenance
     *            the typeSoutenance to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated typeSoutenance, or with status 400 (Bad
     *         Request) if the typeSoutenance is not valid, or with status 500 (Internal Server Error) if the
     *         typeSoutenance couldn't be updated
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PutMapping("/type-soutenances")
    @Timed
    public ResponseEntity<TypeSoutenance> updateTypeSoutenance(@RequestBody TypeSoutenance typeSoutenance)
        throws URISyntaxException {
        log.debug("REST request to update TypeSoutenance : {}", typeSoutenance);
        if (typeSoutenance.getId() == null) {
            return createTypeSoutenance(typeSoutenance);
        }
        TypeSoutenance result = typeSoutenanceService.save(typeSoutenance);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, typeSoutenance.getId().toString()))
                .body(result);
    }
    
    /**
     * GET /type-soutenances : get all the typeSoutenances.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of typeSoutenances in body
     */
    @GetMapping("/type-soutenances")
    @Timed
    public List<TypeSoutenance> getAllTypeSoutenances() {
        log.debug("REST request to get all TypeSoutenances");
        return typeSoutenanceService.findAll();
    }
    
    /**
     * GET /type-soutenances/:id : get the "id" typeSoutenance.
     *
     * @param id
     *            the id of the typeSoutenance to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the typeSoutenance, or with status 404 (Not Found)
     */
    @GetMapping("/type-soutenances/{id}")
    @Timed
    public TypeSoutenance getTypeSoutenance(@PathVariable Long id) {
        log.debug("REST request to get TypeSoutenance : {}", id);
        TypeSoutenance typeSoutenance = typeSoutenanceService.findOne(id);
        return typeSoutenance;
    }
    
    /**
     * DELETE /type-soutenances/:id : delete the "id" typeSoutenance.
     *
     * @param id
     *            the id of the typeSoutenance to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/type-soutenances/{id}")
    @Timed
    public ResponseEntity<Void> deleteTypeSoutenance(@PathVariable Long id) {
        log.debug("REST request to delete TypeSoutenance : {}", id);
        typeSoutenanceService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
