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
import com.upf.stagiaire.model.Admins;
import com.upf.stagiaire.service.AdminsService;
import com.upf.stagiaire.util.HeaderUtil;

/**
 * REST controller for managing Admins.
 */
@RestController
@RequestMapping("/api")
public class AdminsResource {
    
    private final Logger log = LoggerFactory.getLogger(AdminsResource.class);
    
    private static final String ENTITY_NAME = "admins";
    
    private final AdminsService adminsService;
    
    public AdminsResource(AdminsService adminsService) {
        this.adminsService = adminsService;
    }
    
    /**
     * POST /admins : Create a new admins.
     *
     * @param admins
     *            the admins to create
     * @return the ResponseEntity with status 201 (Created) and with body the new admins, or with status 400 (Bad
     *         Request) if the admins has already an ID
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PostMapping("/admins")
    @Timed
    public ResponseEntity<Admins> createAdmins(@RequestBody Admins admins) throws URISyntaxException {
        log.debug("REST request to save Admins : {}", admins);
        if (admins.getId() != null) {
            throw new BadRequestAlertException("A new admins cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Admins result = adminsService.save(admins);
        return ResponseEntity.created(new URI("/api/admins/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }
    
    /**
     * PUT /admins : Updates an existing admins.
     *
     * @param admins
     *            the admins to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated admins, or with status 400 (Bad
     *         Request) if the admins is not valid, or with status 500 (Internal Server Error) if the admins couldn't be
     *         updated
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PutMapping("/admins")
    @Timed
    public ResponseEntity<Admins> updateAdmins(@RequestBody Admins admins) throws URISyntaxException {
        log.debug("REST request to update Admins : {}", admins);
        if (admins.getId() == null) {
            return createAdmins(admins);
        }
        Admins result = adminsService.save(admins);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, admins.getId().toString()))
                .body(result);
    }
    
    /**
     * GET /admins : get all the admins.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of admins in body
     */
    @GetMapping("/admins")
    public List<Admins> getAllAdmins() {
        log.debug("REST request to get all Admins");
        return adminsService.findAll();
    }
    
    /**
     * GET /admins/:id : get the "id" admins.
     *
     * @param id
     *            the id of the admins to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the admins, or with status 404 (Not Found)
     */
    @GetMapping("/admins/{id}")
    public Admins getAdmins(@PathVariable Long id) {
        log.debug("REST request to get Admins : {}", id);
        Admins admins = adminsService.findOne(id);
        return admins;
    }
    
    /**
     * DELETE /admins/:id : delete the "id" admins.
     *
     * @param id
     *            the id of the admins to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/admins/{id}")
    @Timed
    public ResponseEntity<Void> deleteAdmins(@PathVariable Long id) {
        log.debug("REST request to delete Admins : {}", id);
        adminsService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
