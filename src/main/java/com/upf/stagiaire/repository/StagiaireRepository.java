package com.upf.stagiaire.repository;

import org.springframework.stereotype.Repository;

import com.upf.stagiaire.model.Stagiaire;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Stagiaire entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StagiaireRepository extends JpaRepository<Stagiaire, Long> {

}
