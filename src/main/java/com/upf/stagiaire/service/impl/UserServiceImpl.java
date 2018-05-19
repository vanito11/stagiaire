package com.upf.stagiaire.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.upf.stagiaire.model.Authority;
import com.upf.stagiaire.model.User;
import com.upf.stagiaire.model.UserRequest;
import com.upf.stagiaire.repository.UserRepository;
import com.upf.stagiaire.service.AuthorityService;
import com.upf.stagiaire.service.UserService;

/**
 * Created by fan.jin on 2016-10-15.
 */

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AuthorityService authService;
    
    public void resetCredentials() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            user.setPassword(passwordEncoder.encode("123"));
            userRepository.save(user);
        }
    }
    
    @Override
    // @PreAuthorize("hasRole('USER')")
    public User findByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.findByUsername(username);
        return u;
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    public User findById(Long id) throws AccessDeniedException {
        User u = userRepository.findOne(id);
        return u;
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> findAll() throws AccessDeniedException {
        List<User> result = userRepository.findAll();
        return result;
    }
    
    @Override
    public User register(User user) {
        this.userRepository.save(user);
        return user;
    }
    
    @Override
    public User save(UserRequest userRequest) {
        
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setFirstname(userRequest.getFirstname());
        user.setLastname(userRequest.getLastname());
        String role = userRequest.getRole();
        String authority = "";
        switch (role) {
            case "stagiaire":
                authority = "ROLE_STAGIAIRE";
                break;
            case "encadrant":
                authority = "ROLE_ENCADRANT";
                break;
            case "tuteur":
                authority = "ROLE_TUTEUR";
                
                break;
            default:
                authority = "ROLE_USER";
                break;
        }
        user.setRole(authority);
        List<Authority> auth = authService.findByname(authority);
        user.setAuthorities(auth);
        
        this.userRepository.save(user);
        return user;
    }
    
}
