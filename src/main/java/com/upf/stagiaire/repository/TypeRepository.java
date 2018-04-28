package com.upf.stagiaire.repository;

import org.springframework.stereotype.Repository;

import com.upf.stagiaire.model.Type;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Type entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

}
