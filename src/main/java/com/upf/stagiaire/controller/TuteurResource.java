package com.upf.stagiaire.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.upf.stagiaire.bean.FiliereBean;
import com.upf.stagiaire.bean.TuteurBean;
import com.upf.stagiaire.exception.BadRequestAlertException;
import com.upf.stagiaire.mapper.TuteurMapper;
import com.upf.stagiaire.model.Filiere;
import com.upf.stagiaire.model.Tuteur;
import com.upf.stagiaire.service.TuteurService;
import com.upf.stagiaire.util.HeaderUtil;

/**
 * REST controller for managing Tuteur.
 */
@RestController
@RequestMapping("/api")

public class TuteurResource {
    
    private final Logger log = LoggerFactory.getLogger(TuteurResource.class);
    
    private static final String ENTITY_NAME = "tuteur";
    
    @Autowired
    private final TuteurService tuteurService;
    
    @Autowired
    private TuteurMapper tuteurMapper;
    
    public TuteurResource(TuteurService tuteurService) {
        this.tuteurService = tuteurService;
    }
    
    /**
     * POST /tuteurs : Create a new tuteur.
     *
     * @param tuteur
     *            the tuteur to create
     * @return the ResponseEntity with status 201 (Created) and with body the new tuteur, or with status 400 (Bad
     *         Request) if the tuteur has already an ID
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PostMapping("/tuteurs")
    @Timed
    public ResponseEntity<Tuteur> createTuteur(@RequestBody Tuteur tuteur) throws URISyntaxException {
        log.debug("REST request to save Tuteur : {}", tuteur);
        if (tuteur.getId() != null) {
            throw new BadRequestAlertException("A new tuteur cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Tuteur result = tuteurService.save(tuteur);
        return ResponseEntity.created(new URI("/api/tuteurs/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }
    
    /**
     * PUT /tuteurs : Updates an existing tuteur.
     *
     * @param tuteur
     *            the tuteur to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated tuteur, or with status 400 (Bad
     *         Request) if the tuteur is not valid, or with status 500 (Internal Server Error) if the tuteur couldn't be
     *         updated
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PutMapping("/tuteurs")
    @Timed
    public ResponseEntity<Tuteur> updateTuteur(@RequestBody Tuteur tuteur) throws URISyntaxException {
        log.debug("REST request to update Tuteur : {}", tuteur);
        if (tuteur.getId() == null) {
            return createTuteur(tuteur);
        }
        Tuteur result = tuteurService.save(tuteur);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, tuteur.getId().toString()))
                .body(result);
    }
    
    @PutMapping("/tuteurs/update/{id}")
	public void updateTuteur(@PathVariable Long id, @RequestBody TuteurBean request) throws URISyntaxException {
		log.debug("REST request to update Stagiaire : {}", request);
		if (request != null) {
			Tuteur st = tuteurService.findOne(id);
			if (st != null) {
				st = tuteurMapper.map(request, Tuteur.class);
				tuteurService.save(st);
			}
		}

	}
    /**
     * GET /tuteurs : get all the tuteurs.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of tuteurs in body
     */
    @GetMapping("/tuteurs")
    @Timed
    public List<Tuteur> getAllTuteurs() {
        log.debug("REST request to get all Tuteurs");
        return tuteurService.findAll();
    }
    
    /**
     * GET /tuteurs/:id : get the "id" tuteur.
     *
     * @param id
     *            the id of the tuteur to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the tuteur, or with status 404 (Not Found)
     */
    @GetMapping("/tuteurs/{id}")
    @Timed
    public Tuteur getTuteur(@PathVariable Long id) {
        log.debug("REST request to get Tuteur : {}", id);
        Tuteur tuteur = tuteurService.findOne(id);
        return tuteur;
    }
    
    /**
     * DELETE /tuteurs/:id : delete the "id" tuteur.
     *
     * @param id
     *            the id of the tuteur to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/tuteurs/{id}")
    @Timed
    public ResponseEntity<Void> deleteTuteur(@PathVariable Long id) {
        log.debug("REST request to delete Tuteur : {}", id);
        tuteurService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
