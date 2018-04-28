package com.upf.stagiaire.repository;

import org.springframework.stereotype.Repository;

import com.upf.stagiaire.model.Typedate;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Typedate entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TypedateRepository extends JpaRepository<Typedate, Long> {

}
