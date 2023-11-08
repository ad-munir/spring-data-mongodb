package com.springboot.mongodb.repository;

import com.springboot.mongodb.entity.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends MongoRepository<Author, String>, CustomAuthorRepo {

    @Query(value = "{email: '?0'}", fields = "{'name': 1, 'email': 1}")
    Author findAuthorByEmail(String email);
}
