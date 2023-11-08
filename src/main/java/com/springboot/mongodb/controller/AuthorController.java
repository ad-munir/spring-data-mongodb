package com.springboot.mongodb.controller;

import com.springboot.mongodb.entity.Author;
import com.springboot.mongodb.service.AuthorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(authorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        return ResponseEntity.ok(authorService.findById(id));
    }

    @PutMapping("/customUpdate")
    public ResponseEntity<?> updateEmail(@RequestParam @Email String email,
                            @RequestParam String name,
                            @RequestParam String phone
    ) {
        authorService.updateEmail(email, name, phone);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> findAuthorByEmail(@PathVariable @Email String email) {
        return ResponseEntity.ok(authorService.findAuthorByEmail(email));
    }

//    @PostMapping
//    public ResponseEntity<?> insertAll(List<Author> authors) {
//        return ResponseEntity.ok(authorService.insertAll(authors));
//    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody @Valid Author entity) {
        return ResponseEntity.ok(authorService.insert(entity));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid Author entity) {
        return ResponseEntity.ok(authorService.update(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        authorService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
