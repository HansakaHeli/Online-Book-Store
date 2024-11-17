package com.example.Online.Book.Store.dao;

import com.example.Online.Book.Store.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, Long> {
}
