package com.example.jpa.repositories;

import java.util.List;

import org.springframework.data.repository.RepositoryDefinition;

import com.example.jpa.models.User;

/**
 * If you do not want to extend Spring Data interfaces
 * , you can also annotate your repository interface with @RepositoryDefinition.
 * But you need to declare all the methods you will use.
 */
@RepositoryDefinition(domainClass = User.class, idClass = Long.class)
public interface UserRepoWithoutJpaRepo {
    List<User> findAll();
}
