package com.example.Online.Book.Store.controller;

import com.example.Online.Book.Store.model.Author;
import com.example.Online.Book.Store.model.Publisher;
import com.example.Online.Book.Store.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        return ResponseEntity.ok(bookService.createAuthor(author));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getAuthor(id));
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        return ResponseEntity.ok(bookService.getAllAuthors());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author authorDetails) {
        return ResponseEntity.ok(bookService.updateAuthor(id, authorDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        bookService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }


}
