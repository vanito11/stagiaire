package com.upf.stagiaire.service.impl;

import com.upf.stagiaire.service.StageService;
import com.upf.stagiaire.model.Stage;
import com.upf.stagiaire.repository.StageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Stage.
 */
@Service
@Transactional
public class StageServiceImpl implements StageService {

    private final Logger log = LoggerFactory.getLogger(StageServiceImpl.class);

    private final StageRepository stageRepository;

    public StageServiceImpl(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    /**
     * Save a stage.
     *
     * @param stage the entity to save
     * @return the persisted entity
     */
    @Override
    public Stage save(Stage stage) {
        log.debug("Request to save Stage : {}", stage);
        return stageRepository.save(stage);
    }

    /**
     * Get all the stages.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Stage> findAll() {
        log.debug("Request to get all Stages");
        return stageRepository.findAll();
    }

    /**
     * Get one stage by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Stage findOne(Long id) {
        log.debug("Request to get Stage : {}", id);
        return stageRepository.findOne(id);
    }

    /**
     * Delete the stage by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Stage : {}", id);
        stageRepository.delete(id);
    }
}
