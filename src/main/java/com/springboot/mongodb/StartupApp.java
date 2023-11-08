package com.springboot.mongodb;

import com.springboot.mongodb.entity.Author;
import com.springboot.mongodb.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class StartupApp implements CommandLineRunner {

    @Autowired
    AuthorRepository authorRepo;
    @Override
    public void run(String... args) throws Exception {


        if(authorRepo.findAll().isEmpty()) {
            Author author = new Author(null, "mounir", "m@gmail.com", "pwd");
            Author author1 = new Author(null, "omar", "o@gmail.com", "pwd");
            authorRepo.insert(Arrays.asList(author, author1));
        }
    }
}
