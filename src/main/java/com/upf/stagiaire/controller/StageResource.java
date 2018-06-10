package com.upf.stagiaire.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
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
import com.upf.stagiaire.bean.StageSatagiaireBean;
import com.upf.stagiaire.exception.BadRequestAlertException;
import com.upf.stagiaire.model.Stage;
import com.upf.stagiaire.service.StageService;
import com.upf.stagiaire.service.StagiaireService;
import com.upf.stagiaire.util.HeaderUtil;

/**
 * REST controller for managing Stage.
 */
@RestController
@RequestMapping("/api")

public class StageResource {
    
    private final Logger log = LoggerFactory.getLogger(StageResource.class);
    
    private static final String ENTITY_NAME = "stage";
    @Autowired
    private StageService stageService;
    @Autowired
    private StagiaireService stagiaireService;
    
    public StageResource(StageService stageService) {
        this.stageService = stageService;
    }
    
    /**
     * POST /stages : Create a new stage.
     *
     * @param stage
     *            the stage to create
     * @return the ResponseEntity with status 201 (Created) and with body the new stage, or with status 400 (Bad
     *         Request) if the stage has already an ID
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PostMapping("/stages")
    @Timed
    public ResponseEntity<Stage> createStage(@RequestBody Stage stage) throws URISyntaxException {
        log.debug("REST request to save Stage : {}", stage);
        if (stage.getId() != null) {
            throw new BadRequestAlertException("A new stage cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Stage result = stageService.save(stage);
        return ResponseEntity.created(new URI("/api/stages/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }
    
    /**
     * PUT /stages : Updates an existing stage.
     *
     * @param stage
     *            the stage to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated stage, or with status 400 (Bad Request)
     *         if the stage is not valid, or with status 500 (Internal Server Error) if the stage couldn't be updated
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PutMapping("/stages")
    @Timed
    public ResponseEntity<Stage> updateStage(@RequestBody Stage stage) throws URISyntaxException {
        log.debug("REST request to update Stage : {}", stage);
        if (stage.getId() == null) {
            return createStage(stage);
        }
        Stage result = stageService.save(stage);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, stage.getId().toString()))
                .body(result);
    }
    
    /**
     * GET /stages : get all the stages.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of stages in body
     */
    @GetMapping("/stages")
    @Timed
    public List<Stage> getAllStages() {
        log.debug("REST request to get all Stages");
        return stageService.findAll();
    }

    
    /* GET /stages : get all the stages.
    *
    * @return the ResponseEntity with status 200 (OK) and the list of stages in body
    */
    

     
    
    
    
   @GetMapping("/stages/en/{id}")
   @Timed
   public List<Stage> getAllStagesenc(@PathVariable Long id) {
       log.debug("REST request to get all Stages");
       return stageService.findStageByEncadrantId(id);
   }
    
   
	@GetMapping("/stagestagaires")
	public List<StageSatagiaireBean> getAllStageStagiaires() {


		List<StageSatagiaireBean> response = new ArrayList<StageSatagiaireBean>();

		List<Stage> stages = stageService.findAll();
		for (Stage st : stages) {
			StageSatagiaireBean newS = new StageSatagiaireBean();
			newS.setStagiaireBean(stagiaireService.findByStageId(st.getId()));
			newS.setStageBean(st);
			response.add(newS);
		}
		return response;
	}
    
    /**
     * GET /stages/:id : get the "id" stage.
     *
     * @param id
     *            the id of the stage to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the stage, or with status 404 (Not Found)
     */
    @GetMapping("/stages/{id}")
    @Timed
    public Stage getStage(@PathVariable Long id) {
        log.debug("REST request to get Stage : {}", id);
        Stage stage = stageService.findOne(id);
        return stage;
    }
    
    /**
     * DELETE /stages/:id : delete the "id" stage.
     *
     * @param id
     *            the id of the stage to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/stages/{id}")
    public ResponseEntity<Void> deleteStage(@PathVariable Long id) {
        log.debug("REST request to delete Stage : {}", id);
        stageService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
