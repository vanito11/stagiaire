package com.upf.stagiaire.repository;

import org.springframework.stereotype.Repository;

import com.upf.stagiaire.model.Encadrant;

import org.springframework.data.jpa.repository.*;

/**
 * Spring Data JPA repository for the Encadrant entity.
 */
@Repository
public interface EncadrantRepository extends JpaRepository<Encadrant, Long> {

	Encadrant findByEmail(String Email);

}
