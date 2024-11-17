package com.example.Online.Book.Store.service;

import com.example.Online.Book.Store.dao.AuthorDao;
import com.example.Online.Book.Store.dao.BookDao;
import com.example.Online.Book.Store.dao.PublisherDao;
import com.example.Online.Book.Store.model.Author;
import com.example.Online.Book.Store.model.Book;
import com.example.Online.Book.Store.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private PublisherDao publisherDao;

    // CRUD for Book
    public Book createBook(Book book, Long authorId, Long publisherId) {
        Author author = authorDao.findById(authorId).orElseThrow();
        Publisher publisher = publisherDao.findById(publisherId).orElseThrow();
        book.setAuthor(author);
        book.setPublisher(publisher);
        author.addBook(book);
        publisher.addBook(book);
        return bookDao.save(book);
    }

    public Book getBook(Long id) {
        return bookDao.findById(id).orElseThrow();
    }

    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookDao.findById(id).orElseThrow();
        book.setTitle(bookDetails.getTitle());
        return bookDao.save(book);
    }

    public void deleteBook(Long id) {
        Book book = bookDao.findById(id).orElseThrow();
        book.getAuthor().removeBook(book);
        book.getPublisher().removeBook(book);
        bookDao.delete(book);
    }

    // CRUD for Author
    public Author createAuthor(Author author) {
        return authorDao.save(author);
    }

    public Author getAuthor(Long id) {
        return authorDao.findById(id).orElseThrow();
    }

    public List<Author> getAllAuthors() {
        return authorDao.findAll();
    }

    public Author updateAuthor(Long id, Author authorDetails) {
        Author author = authorDao.findById(id).orElseThrow();
        author.setName(authorDetails.getName());
        return authorDao.save(author);
    }

    public void deleteAuthor(Long id) {
        Author author = authorDao.findById(id).orElseThrow();
        author.getBooks().forEach(book -> book.setAuthor(null));
        authorDao.delete(author);
    }

    // CRUD for Publisher
    public Publisher createPublisher(Publisher publisher) {
        return publisherDao.save(publisher);
    }

    public Publisher getPublisher(Long id) {
        return publisherDao.findById(id).orElseThrow();
    }

    public List<Publisher> getAllPublishers() {
        return publisherDao.findAll();
    }

    public Publisher updatePublisher(Long id, Publisher publisherDetails) {
        Publisher publisher = publisherDao.findById(id).orElseThrow();
        publisher.setName(publisherDetails.getName());
        return publisherDao.save(publisher);
    }

    public void deletePublisher(Long id) {
        Publisher publisher = publisherDao.findById(id).orElseThrow();
        publisher.getBooks().forEach(book -> book.setPublisher(null));
        publisherDao.delete(publisher);
    }
}
