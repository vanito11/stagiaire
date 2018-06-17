package com.upf.stagiaire.repository;

import org.springframework.stereotype.Repository;

import com.upf.stagiaire.model.*;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the StageStagiaire entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StageStagiaireRepository extends JpaRepository<StageStagiaire, Long> {
	
	StageStagiaire findByStageidAndStagiaireid(Long Stageid,Long Stagiaireid);

}
