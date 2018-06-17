package com.upf.stagiaire.repository;

import org.springframework.stereotype.Repository;


import com.upf.stagiaire.model.Soutenance;

import java.util.List;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Soutenance entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SoutenanceRepository extends JpaRepository<Soutenance, Long> {
    
   public List<Soutenance>  findByStageSujet(String sujet);
   
   
   
   List<Soutenance> findSoutenanceByStageId(Long id);
   void deleteSoutenanceByStageId(Long id);

}
