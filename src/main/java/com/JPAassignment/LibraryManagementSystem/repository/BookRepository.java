package com.JPAassignment.LibraryManagementSystem.repository;

import com.JPAassignment.LibraryManagementSystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);

    List<Book> findByPublishedDateAfter(LocalDate date);

    public List<Book> findByAuthorId(Long authorId);

}