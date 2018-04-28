package com.upf.stagiaire.repository;

import org.springframework.stereotype.Repository;

import com.upf.stagiaire.model.Stage;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Stage entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StageRepository extends JpaRepository<Stage, Long> {

}
