package com.upf.stagiaire.repository;

import org.springframework.stereotype.Repository;

import com.upf.stagiaire.model.Filiere;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Filiere entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FiliereRepository extends JpaRepository<Filiere, Long> {

}
