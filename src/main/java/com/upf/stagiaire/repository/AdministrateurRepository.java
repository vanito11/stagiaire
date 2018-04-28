package com.upf.stagiaire.repository;

import org.springframework.stereotype.Repository;

import com.upf.stagiaire.model.Administrateur;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;


/**
 * Spring Data JPA repository for the Administrateur entity.
 */
@Repository
public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {
    
    public List<Administrateur> findByNom(String nom);
    
    public List<Administrateur> findByNomContaining(String nom);
    
//    @Query("select a.* form Administrateur a  where a.email like %:email%")
//    public List<Administrateur> findByEmail(@Param("email") String email);


}
