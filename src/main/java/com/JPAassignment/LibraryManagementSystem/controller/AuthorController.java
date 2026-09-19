package com.JPAassignment.LibraryManagementSystem.controller;

import com.JPAassignment.LibraryManagementSystem.entity.Author;
import com.JPAassignment.LibraryManagementSystem.service.LibraryManagementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final LibraryManagementService libraryManagementService;

    public AuthorController(LibraryManagementService libraryManagementService) {
        this.libraryManagementService = libraryManagementService;
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author){
        return libraryManagementService.createAuthor(author);
    }

    @GetMapping
    public List<Author> getAllAuthors(){
        return libraryManagementService.getAllAuthors();
    }

    @GetMapping("/{authorId}")
    public Author getAuthorById(@PathVariable Long authorId){
        return libraryManagementService.getAuthorById(authorId);
    }

    @PutMapping("/{authorId}")
    public Author updateAuthor(@PathVariable Long authorId, @RequestBody Author author){
        return libraryManagementService.updateAuthor(authorId,author);
    }

    @DeleteMapping("/{authorId}")
    public void deleteAuthor(@PathVariable Long authorId){
        libraryManagementService.deleteAuthor(authorId);
    }

    @GetMapping("/search/{name}")
    public List<Author> findAuthorsByName(@PathVariable String name){
        return libraryManagementService.findAuthorsByName(name);
    }

}
