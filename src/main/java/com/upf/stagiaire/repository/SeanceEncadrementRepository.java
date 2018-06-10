package com.upf.stagiaire.repository;

import org.springframework.stereotype.Repository;

import com.upf.stagiaire.model.SeanceEncadrement;

import java.util.List;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the SeanceEncadrement entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SeanceEncadrementRepository extends JpaRepository<SeanceEncadrement, Long> {
	
	List<SeanceEncadrement> findSeanceEncadrementByStageId(Long id);

}
