package com.upf.stagiaire.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.upf.stagiaire.bean.SeanceEncadrementBean;
import com.upf.stagiaire.exception.BadRequestAlertException;
import com.upf.stagiaire.mapper.SeanceEncadrementMapper;
import com.upf.stagiaire.model.SeanceEncadrement;
import com.upf.stagiaire.service.SeanceEncadrementService;
import com.upf.stagiaire.util.HeaderUtil;

/**
 * REST controller for managing SeanceEncadrement.
 */
@RestController
@RequestMapping("/api")

public class SeanceEncadrementResource {
    
    private final Logger log = LoggerFactory.getLogger(SeanceEncadrementResource.class);
    
    private static final String ENTITY_NAME = "seanceEncadrement";
    @Autowired
    private SeanceEncadrementService seanceEncadrementService;
    @Autowired
    private SeanceEncadrementMapper seanceEncadrementMapper;

    
    public SeanceEncadrementResource(SeanceEncadrementService seanceEncadrementService) {
        this.seanceEncadrementService = seanceEncadrementService;
    }
    
    /**
     * POST /seance-encadrements : Create a new seanceEncadrement.
     *
     * @param seanceEncadrement
     *            the seanceEncadrement to create
     * @return the ResponseEntity with status 201 (Created) and with body the new seanceEncadrement, or with status 400
     *         (Bad Request) if the seanceEncadrement has already an ID
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PostMapping("/seanceencadrements")
    @Timed
    public ResponseEntity<SeanceEncadrement> createSeanceEncadrement(@RequestBody SeanceEncadrement seanceEncadrement)
        throws URISyntaxException {
        log.debug("REST request to save SeanceEncadrement : {}", seanceEncadrement);
        if (seanceEncadrement.getId() != null) {
            throw new BadRequestAlertException("A new seanceEncadrement cannot already have an ID", ENTITY_NAME,
                    "idexists");
        }
        SeanceEncadrement result = seanceEncadrementService.save(seanceEncadrement);
        return ResponseEntity.created(new URI("/api/seance-encadrements/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }
    
    /**
     * PUT /seance-encadrements : Updates an existing seanceEncadrement.
     *
     * @param seanceEncadrement
     *            the seanceEncadrement to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated seanceEncadrement, or with status 400
     *         (Bad Request) if the seanceEncadrement is not valid, or with status 500 (Internal Server Error) if the
     *         seanceEncadrement couldn't be updated
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PutMapping("/seanceencadrements")
    @Timed
    public ResponseEntity<SeanceEncadrement> updateSeanceEncadrement(@RequestBody SeanceEncadrement seanceEncadrement)
        throws URISyntaxException {
        log.debug("REST request to update SeanceEncadrement : {}", seanceEncadrement);
        if (seanceEncadrement.getId() == null) {
            return createSeanceEncadrement(seanceEncadrement);
        }
        SeanceEncadrement result = seanceEncadrementService.save(seanceEncadrement);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, seanceEncadrement.getId().toString()))
                .body(result);
    }
    
    
    @PutMapping("/seanceencadrements/update/{id}")
	public void updateSeanceEncadrement(@PathVariable Long id, @RequestBody SeanceEncadrement request) throws URISyntaxException {

				seanceEncadrementService.save(request);
			
		

	}
    /**
     * GET /seance-encadrements : get all the seanceEncadrements.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of seanceEncadrements in body
     */
    @GetMapping("/seanceencadrements")
    @Timed
    public List<SeanceEncadrement> getAllSeanceEncadrements() {
        log.debug("REST request to get all SeanceEncadrements");
        return seanceEncadrementService.findAll();
    }
    
    /**
     * GET /seance-encadrements/:id : get the "id" seanceEncadrement.
     *
     * @param id
     *            the id of the seanceEncadrement to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the seanceEncadrement, or with status 404 (Not
     *         Found)
     */
    @GetMapping("/seanceencadrements/{id}")
    @Timed
    public SeanceEncadrement getSeanceEncadrement(@PathVariable Long id) {
        log.debug("REST request to get SeanceEncadrement : {}", id);
        SeanceEncadrement seanceEncadrement = seanceEncadrementService.findOne(id);
        return seanceEncadrement;
    }
    
    @GetMapping("/stages/seanceencadrements/{id}")
    @Timed
    public List<SeanceEncadrement> getSeanceEncadrementStageById(@PathVariable Long id) {
        log.debug("REST request to get SeanceEncadrement : {}", id);
        List<SeanceEncadrement> seanceEncadrement = seanceEncadrementService.findSeanceEncadrementByStageId(id);

        return seanceEncadrement;
    }
    
    /**
     * DELETE /seance-encadrements/:id : delete the "id" seanceEncadrement.
     *
     * @param id
     *            the id of the seanceEncadrement to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/seanceencadrements/{id}")
    @Timed
    public ResponseEntity<Void> deleteSeanceEncadrement(@PathVariable Long id) {
        log.debug("REST request to delete SeanceEncadrement : {}", id);
        seanceEncadrementService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
