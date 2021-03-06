package com.upf.stagiaire.repository;

import org.springframework.stereotype.Repository;

import com.upf.stagiaire.model.Document;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Document entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

}
