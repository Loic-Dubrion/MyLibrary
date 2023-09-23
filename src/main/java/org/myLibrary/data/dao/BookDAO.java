package org.myLibrary.data.dao;

import models.Book;

import java.sql.*;
import java.util.List;

public class BookDAO implements DAO<Book> {

    private Connection connection;

    public BookDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Book get(int id) {

        return null;
    }

    @Override
    public List<Book> getAll() {

        return null;
    }

    @Override
    public void save(Book book) {

    }

    @Override
    public void update(Book book, String[] params) {

    }

    @Override
    public void delete(Book book) {

    }
}
