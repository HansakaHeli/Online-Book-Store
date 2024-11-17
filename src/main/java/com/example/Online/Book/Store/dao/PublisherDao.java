package com.example.Online.Book.Store.dao;

import com.example.Online.Book.Store.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherDao extends JpaRepository<Publisher, Long> {
}
