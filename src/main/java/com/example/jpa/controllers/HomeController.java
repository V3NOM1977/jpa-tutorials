package com.example.jpa.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.models.Address;
import com.example.jpa.models.User;
import com.example.jpa.repositories.UserRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path = "/api/v1")
public class HomeController {

    private final UserRepo userRepo;

    @PersistenceContext
    private EntityManager entityManager;
    
    public HomeController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public Iterable<String> distinctNames() {
        return userRepo.findDistinctUserNames();
    }

    @GetMapping(path = "get-user-by-zipcode")
    public User getUserByZipCode() {
        return userRepo.findByAddress_ZipCode("12104");
    }

    @GetMapping(path = "named-query")
    public List<Address> namedQuery() {
        return entityManager.createNamedQuery("User.findById", Address.class)
                .setParameter(1, 1)
                .getResultList();
    }

}
