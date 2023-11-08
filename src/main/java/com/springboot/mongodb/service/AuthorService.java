package com.springboot.mongodb.service;

import com.springboot.mongodb.entity.Author;
import com.springboot.mongodb.repository.AuthorRepository;
import com.springboot.mongodb.repository.CustomAuthorRepo;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthorService {

    final AuthorRepository authorRepo;
//    final CustomAuthorRepo customAuthorRepo;

    public List<Author> findAll() {
        return authorRepo.findAll();
    }

    public Author findById(String id) {
        return authorRepo.findById(id).orElseThrow(() -> new RuntimeException("author not found"));
    }

    public List<Author> insertAll(List<Author> authors) {
        return authorRepo.saveAll(authors);
    }

    public Author insert(Author entity) {
        if( entity.getId() != null){
            throw new RuntimeException();
        }
        return authorRepo.insert(entity);
    }

    public Author update(Author entity) {

        Author author = findById(entity.getId());
        author.setName(entity.getName());
        author.setEmail(entity.getEmail());
        author.setPhone(entity.getPhone());

        return authorRepo.save(entity);
    }

    public void updateEmail(String email, String name, String phone) {
        authorRepo.updateEmail(email, name, phone);
    }

    public Author findAuthorByEmail(String email) {
        return authorRepo.findAuthorByEmail(email);
    }

    public void deleteById(String id) {
        //Author author = findById(id);
        authorRepo.deleteById(id);
    }
}
