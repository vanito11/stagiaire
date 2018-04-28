package com.upf.stagiaire.repository;

import org.springframework.stereotype.Repository;

import com.upf.stagiaire.model.Admins;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Admins entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AdminsRepository extends JpaRepository<Admins, Long> {

}
