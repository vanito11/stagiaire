package com.upf.stagiaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upf.stagiaire.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
  Authority findByName(String name);
}
