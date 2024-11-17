package com.example.Online.Book.Store.dao;

import com.example.Online.Book.Store.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDao extends JpaRepository<Author, Long> {
}
