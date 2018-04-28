package com.upf.stagiaire.repository;

import org.springframework.stereotype.Repository;

import com.upf.stagiaire.model.Etat;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Etat entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EtatRepository extends JpaRepository<Etat, Long> {

}
