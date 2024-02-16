package com.example.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.jpa.configs.CustomQueryRewriter;
import com.example.jpa.models.User;

public interface UserRepo extends JpaRepository<User, Long> {

    /**
     * When you write ByColumnName in your JPA method, it anticipates a WHERE clause
     * e.g. findByColumnName. In your scenario, you are doing findDistinctById and
     * JPA is looking for a parameter id. Since you are not providing id parameter
     * JPA is throwing the exception.
     * 
     * What you are trying to achieve is to fetch unique values of a specific column
     * without giving any parameter and this is not achievable in JPA method. You
     * can achieve this through @Query
     * 
     * @return
     */

    /**
     * Custom Query Rewriter Class: You provide a custom class that implements the
     * QueryRewriter interface. This interface allows you to modify the query before
     * it's executed by Spring Data JPA.
     * 
     * @return
     */
    @Query(value = """
            SELECT DISTINCT u.userName FROM User u
            """, nativeQuery = false, queryRewriter = CustomQueryRewriter.class)
    Iterable<String> findDistinctUserNames();

    User findByAddress_ZipCode(String zipCode);

}