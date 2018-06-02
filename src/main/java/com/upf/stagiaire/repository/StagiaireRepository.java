package com.upf.stagiaire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upf.stagiaire.model.Stagiaire;


/**
 * Spring Data JPA repository for the Stagiaire entity.
 */
@Repository
public interface StagiaireRepository extends JpaRepository<Stagiaire, Long> {
	
	List<Stagiaire> findByStageId(Long id);

}
