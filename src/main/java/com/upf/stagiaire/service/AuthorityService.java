package com.upf.stagiaire.service;

import java.util.List;

import com.upf.stagiaire.model.Authority;

public interface AuthorityService {
  List<Authority> findById(Long id);

  List<Authority> findByname(String name);

}
