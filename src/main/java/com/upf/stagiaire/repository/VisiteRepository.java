package com.upf.stagiaire.repository;

import org.springframework.stereotype.Repository;

import com.upf.stagiaire.model.Visite;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Visite entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VisiteRepository extends JpaRepository<Visite, Long> {

}
