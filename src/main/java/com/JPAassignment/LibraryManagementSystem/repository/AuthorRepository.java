package com.JPAassignment.LibraryManagementSystem.repository;

import com.JPAassignment.LibraryManagementSystem.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    public List<Author> findByName(String name);
}