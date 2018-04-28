package com.upf.stagiaire.repository;

import org.springframework.stereotype.Repository;

import com.upf.stagiaire.model.Tuteur;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Tuteur entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TuteurRepository extends JpaRepository<Tuteur, Long> {

}
