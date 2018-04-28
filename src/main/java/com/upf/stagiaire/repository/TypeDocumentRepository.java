package com.upf.stagiaire.repository;

import org.springframework.stereotype.Repository;

import com.upf.stagiaire.model.TypeDocument;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the TypeDocument entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TypeDocumentRepository extends JpaRepository<TypeDocument, Long> {

}
