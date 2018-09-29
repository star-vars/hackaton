package com.rozzer.spring.managers;

import com.google.common.collect.Lists;
import com.rozzer.manager.CoreObjectManager;
import com.rozzer.manager.Manager;
import com.rozzer.model.Book;
import com.rozzer.spring.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookManager implements Manager<Book> {

    private BookRepository bookRepository;

    @Autowired
    public BookManager(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        init();
    }

    public void init() {
        this.bookRepository.save(new Book("Jack"));
        this.bookRepository.save(new Book("Chloe"));
        this.bookRepository.save(new Book("Kim"));
        this.bookRepository.save(new Book("David"));
        this.bookRepository.save(new Book("Michelle"));
        CoreObjectManager.getManagerFactory().register(Book.class, this);
    }

    public List<Book> getAll() {
        return Lists.newArrayList(bookRepository.findAll());
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public void delete(Book book) {
        bookRepository.delete(book);
    }

    public Book getById(Long id) {
        return bookRepository.findById(id).get();
    }

    public Book create() {
        Book book = new Book();
        save(book);
        return book;
    }
}
