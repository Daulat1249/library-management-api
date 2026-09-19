package com.JPAassignment.LibraryManagementSystem.controller;

import com.JPAassignment.LibraryManagementSystem.entity.Book;
import com.JPAassignment.LibraryManagementSystem.service.LibraryManagementService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final LibraryManagementService libraryManagementService;

    public BookController(LibraryManagementService libraryManagementService) {
        this.libraryManagementService = libraryManagementService;
    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return libraryManagementService.createBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return libraryManagementService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable Long bookId){
        return libraryManagementService.getBookById(bookId);
    }

    @PutMapping("/{bookId}")
    public Book updateBook(@PathVariable Long bookId, @RequestBody Book book){
        return libraryManagementService.updateBook(bookId,book);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Long bookId){
        libraryManagementService.deleteBook(bookId);
    }

    // Custom Query: Find books by title
    // Example URL: GET http://localhost:8080/books/search?title=Dune
    @GetMapping("/search")
    public List<Book> findBooksByTitle(@RequestParam String title) {
        return libraryManagementService.findBooksByTitle(title);
    }

    // Custom Query: Find books published after a certain date
    // Example URL: GET http://localhost:8080/books/search/publishedAfter?date=2000-01-01
    @GetMapping("/search/publishedAfter")
    public List<Book> findBooksPublishedAfter(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date)
    {
        return libraryManagementService.findBooksPublishedAfter(date);
    }

    // Custom Query: Find all books by a specific author
    // Example URL: GET http://localhost:8080/books/author/1
    @GetMapping("/author/{authorId}")
    public List<Book> findBooksByAuthorId(@PathVariable Long authorId) {
        return libraryManagementService.findBooksByAuthorId(authorId);
    }
}
