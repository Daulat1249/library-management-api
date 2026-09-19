package com.JPAassignment.LibraryManagementSystem.service;

import com.JPAassignment.LibraryManagementSystem.entity.Author;
import com.JPAassignment.LibraryManagementSystem.entity.Book;
import com.JPAassignment.LibraryManagementSystem.repository.AuthorRepository;
import com.JPAassignment.LibraryManagementSystem.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LibraryManagementService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public LibraryManagementService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    //create
    public Author createAuthor(Author author){
        return authorRepository.save(author);
    }

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    //retrieve
    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    //retrieve single by ID
    public Author getAuthorById(Long authorId){
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found with id: "+authorId));
    }

    public Book getBookById(Long bookId){
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id: "+bookId));
    }

    @Transactional
    public Author updateAuthor(Long authorId, Author updatedAuthor){
        Author author = getAuthorById(authorId);
        author.setName(updatedAuthor.getName());

        return author;
    }

    @Transactional
    public Book updateBook(Long bookId, Book updatedBook){
        Book book = getBookById(bookId);
        book.setTitle(updatedBook.getTitle());
        book.setPublishedDate(updatedBook.getPublishedDate());
        return book;
    }

    //Delete
    public void deleteAuthor(Long authorId){
        authorRepository.deleteById(authorId);
    }

    public void deleteBook(Long bookId){
        bookRepository.deleteById(bookId);
    }

    //Custom Queries
    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> findBooksPublishedAfter(LocalDate date) {
        return bookRepository.findByPublishedDateAfter(date);
    }

    public List<Author> findAuthorsByName(String name) {
        return authorRepository.findByName(name);
    }

    public List<Book> findBooksByAuthorId(Long authorId) {
        return bookRepository.findByAuthorId(authorId);
    }
}
