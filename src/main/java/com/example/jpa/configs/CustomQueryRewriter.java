package com.example.jpa.configs;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.QueryRewriter;

/**
 * Custom Query Rewriter Class: You provide a custom class that implements the
 * QueryRewriter interface. This interface allows you to modify the query before
 * it's executed by Spring Data JPA.
 * 
 * @return
 */
public class CustomQueryRewriter implements QueryRewriter {

    @Override
    public String rewrite(String query, Sort sort) {
        System.out.println("We are at CustomQueryReWriter.");
        return query;
    }

}