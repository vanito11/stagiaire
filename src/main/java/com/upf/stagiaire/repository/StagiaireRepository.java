package com.upf.stagiaire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upf.stagiaire.bean.StageSatagiaireBean;
import com.upf.stagiaire.model.Stage;
import com.upf.stagiaire.model.Stagiaire;


/**
 * Spring Data JPA repository for the Stagiaire entity.
 */
@Repository
public interface StagiaireRepository extends JpaRepository<Stagiaire, Long> {
	
	Stagiaire findOneByStageId(Long id);





	
	

}
