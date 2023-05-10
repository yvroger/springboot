package com.example.demo.book.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.book.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
