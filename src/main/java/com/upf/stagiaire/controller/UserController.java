package com.upf.stagiaire.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.upf.stagiaire.exception.ResourceConflictException;
import com.upf.stagiaire.model.Authority;
import com.upf.stagiaire.model.User;
import com.upf.stagiaire.model.UserRequest;
import com.upf.stagiaire.service.AuthorityService;
import com.upf.stagiaire.service.EncadrantService;
import com.upf.stagiaire.service.StagiaireService;
import com.upf.stagiaire.service.TuteurService;
import com.upf.stagiaire.service.UserService;

/**
 *
 */

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)

public class UserController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private TuteurService tuteurService;
    
    @Autowired
    private StagiaireService stagiaireService;
    
    @Autowired
    private EncadrantService encadrantService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AuthorityService authService;
    
    @RequestMapping(method = GET, value = "/user/{userId}")
    public User loadById(@PathVariable Long userId) {
        return this.userService.findById(userId);
    }
    
    @RequestMapping(method = GET, value = "/user/all")
    public List<User> loadAll() {
        return this.userService.findAll();
    }
    
    @RequestMapping(method = GET, value = "/user/reset-credentials")
    public ResponseEntity<Map> resetCredentials() {
        this.userService.resetCredentials();
        Map<String, String> result = new HashMap<>();
        result.put("result", "success");
        return ResponseEntity.accepted().body(result);
    }
    
    @RequestMapping(method = POST, value = "/signup")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addUser(@RequestBody UserRequest userRequest,
            UriComponentsBuilder ucBuilder) {
        
        User existUser = this.userService.findByUsername(userRequest.getUsername());
        if (existUser != null) {
            throw new ResourceConflictException(userRequest.getId(), "Username already exists");
        }
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
                stagiaireService.signupStagaiare(userRequest);
                break;
            case "encadrant":
                authority = "ROLE_ENCADRANT";
                encadrantService.signupEncadrant(userRequest);
                break;
            case "tuteur":
                authority = "ROLE_TUTEUR";
                tuteurService.signupTuteur(userRequest);
                break;
            default:
                authority = "ROLE_USER";
                break;
        }
        user.setRole(authority);
        List<Authority> auth = authService.findByname(authority);
        user.setAuthorities(auth);
        userService.register(user);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{userId}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }
    
    /*
     * We are not using userService.findByUsername here(we could), so it is good that we are making sure that the user
     * has role "ROLE_USER" to access this endpoint.
     */
    @RequestMapping("/whoami")
    public User user() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    
}
