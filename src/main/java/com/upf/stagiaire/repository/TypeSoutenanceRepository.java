package com.upf.stagiaire.repository;

import org.springframework.stereotype.Repository;

import com.upf.stagiaire.model.TypeSoutenance;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the TypeSoutenance entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TypeSoutenanceRepository extends JpaRepository<TypeSoutenance, Long> {

}
