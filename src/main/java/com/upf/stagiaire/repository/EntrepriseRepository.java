package com.upf.stagiaire.repository;

import org.springframework.stereotype.Repository;

import com.upf.stagiaire.model.Entreprise;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Entreprise entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {

}
