package com.upf.stagiaire.repository;

import org.springframework.stereotype.Repository;

import com.upf.stagiaire.model.Date;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Date entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DateRepository extends JpaRepository<Date, Long> {

}
