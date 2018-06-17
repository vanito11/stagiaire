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
import com.upf.stagiaire.exception.BadRequestAlertException;
import com.upf.stagiaire.model.Soutenance;
import com.upf.stagiaire.model.StageStagiaire;
import com.upf.stagiaire.model.Stagiaire;
import com.upf.stagiaire.service.DateService;
import com.upf.stagiaire.service.DocumentService;
import com.upf.stagiaire.service.SeanceEncadrementService;
import com.upf.stagiaire.service.SoutenanceService;
import com.upf.stagiaire.service.StageService;
import com.upf.stagiaire.service.StageStagiaireService;
import com.upf.stagiaire.service.VisiteService;
import com.upf.stagiaire.util.HeaderUtil;

/**
 * REST controller for managing StageStagiaire.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class StageStagiaireResource {
    
    private final Logger log = LoggerFactory.getLogger(StageStagiaireResource.class);
    
    private static final String ENTITY_NAME = "StageStagiaire";
    
    @Autowired
    private final StageStagiaireService StageStagiaireService;
    @Autowired
    private DateService dateService;
    @Autowired
    private StageService stageService;
    @Autowired
    private SoutenanceService soutenanceService;
    @Autowired
    private VisiteService visiteService;
    @Autowired
    private DocumentService documentService;
    @Autowired
    private SeanceEncadrementService seanceEncadrementService;
    
    public StageStagiaireResource(StageStagiaireService StageStagiaireService) {
        this.StageStagiaireService = StageStagiaireService;
    }
    
    /**
     * POST /StageStagiaires : Create a new StageStagiaire.
     *
     * @param StageStagiaire
     *            the StageStagiaire to create
     * @return the ResponseEntity with status 201 (Created) and with body the new StageStagiaire, or with status 400 (Bad
     *         Request) if the StageStagiaire has already an ID
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PostMapping("/StageStagiaires")
    @Timed
    public ResponseEntity<StageStagiaire> createStageStagiaire(@RequestBody StageStagiaire StageStagiaire) throws URISyntaxException {
        log.debug("REST request to save StageStagiaire : {}", StageStagiaire);
        StageStagiaire p = new StageStagiaire();
        p.setStageid(StageStagiaire.getStageid());
        p.setStagiaireid(StageStagiaire.getStagiaireid());
        StageStagiaire result = StageStagiaireService.save(p);
        return ResponseEntity.created(new URI("/api/StageStagiaires/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }
    
    /**
     * PUT /StageStagiaires : Updates an existing StageStagiaire.
     *
     * @param StageStagiaire
     *            the StageStagiaire to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated StageStagiaire, or with status 400 (Bad
     *         Request) if the StageStagiaire is not valid, or with status 500 (Internal Server Error) if the StageStagiaire couldn't
     *         be updated
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PutMapping("/StageStagiaires")
    public ResponseEntity<StageStagiaire> updateStageStagiaire(@RequestBody StageStagiaire StageStagiaire) throws URISyntaxException {
        log.debug("REST request to update StageStagiaire : {}", StageStagiaire);
        if (StageStagiaire.getId() == null) {
            return createStageStagiaire(StageStagiaire);
        }
        StageStagiaire result = StageStagiaireService.save(StageStagiaire);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, StageStagiaire.getId().toString()))
                .body(result);
    }
    

    
    /**
     * GET /StageStagiaires : get all the StageStagiaires.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of StageStagiaires in body
     */
    @GetMapping("/StageStagiaires")
    @Timed
    public List<StageStagiaire> getAllStageStagiaires() {
        log.debug("REST request to get all StageStagiaires");
        return StageStagiaireService.findAll();
    }
    
    /**
     * GET /StageStagiaires/:id : get the "id" StageStagiaire.
     *
     * @param id
     *            the id of the StageStagiaire to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the StageStagiaire, or with status 404 (Not Found)
     */
    @GetMapping("/StageStagiaires/{id}")
    @Timed
    public StageStagiaire getStageStagiaire(@PathVariable Long id) {
        log.debug("REST request to get StageStagiaire : {}", id);
        StageStagiaire StageStagiaire = StageStagiaireService.findOne(id);
        return StageStagiaire;
    }
    
	@GetMapping("/StageStagiaires/stage/{Stageid}/{Stagiaireid}")
	@Timed
	public StageStagiaire getStageStagiaireStage(@PathVariable Long Stageid,@PathVariable Long Stagiaireid) {

		StageStagiaire StageStagiaire = StageStagiaireService.findByStageidAndStagiaireid(Stageid,Stagiaireid);
		return StageStagiaire;
	}
	
	 @DeleteMapping("/StageStagiaires/stage/{Stageid}/{Stagiaireid}")
	@Timed
	public void deleteStageStagiaireStag(@PathVariable Long Stageid,@PathVariable Long Stagiaireid) {

		StageStagiaire StageStagiaire = StageStagiaireService.findByStageidAndStagiaireid(Stageid,Stagiaireid);
		
		StageStagiaireService.delete(StageStagiaire.getId());
		
		
		  dateService.deleteDateByStageId(Stageid);
		  seanceEncadrementService.deleteSeanceEncadrementByStageId(Stageid);
		  visiteService.deleteVisiteByStageId(Stageid);
		  documentService.deleteDocumentByStageId(Stageid);
		  soutenanceService.deleteSoutenanceByStageId(Stageid);
	      stageService.delete(Stageid);

	}
    
    /**
     * DELETE /StageStagiaires/:id : delete the "id" StageStagiaire.
     *
     * @param id
     *            the id of the StageStagiaire to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/StageStagiaires/{id}")
    @Timed
    public ResponseEntity<Void> deleteStageStagiaire(@PathVariable Long id) {
        log.debug("REST request to delete StageStagiaire : {}", id);
        StageStagiaireService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
