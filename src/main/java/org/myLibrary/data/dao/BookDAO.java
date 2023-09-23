package org.myLibrary.data.dao;

import org.myLibrary.business.models.Author;
import org.myLibrary.business.models.Book;
import org.myLibrary.business.models.Genre;
import org.myLibrary.exception.ExceptionHandler;
import org.myLibrary.exception.ThrowableAction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements DAO<Book> {

    private final Connection connection;

    public BookDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Book get(int id) {
        return executeQuery(book -> {
            final String query = "SELECT * FROM book WHERE id = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        book.setId(resultSet.getInt("id"));
                        book.setTitle(resultSet.getString("title"));
                        // ... Set other properties
                    }
                }
            }
        }, new Book());
    }

    @Override
    public List<Book> getByName(String title) {
        return executeQuery(bookList -> {
            final String query = "SELECT * FROM book WHERE title LIKE ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, "%" + title + "%");
                try (ResultSet rs = preparedStatement.executeQuery()) {
                    while (rs.next()) {
                        Book book = new Book();
                        book.setId(rs.getInt("id"));
                        book.setTitle(rs.getString("title"));
                        // ... Set other properties
                        bookList.add(book);
                    }
                }
            }
        }, new ArrayList<>());
    }

    public List<Book> getByAuthor(Author author) {
        return executeQuery(bookList -> {
            final String query = "SELECT * FROM book WHERE id_author = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, author.getId());
                try (ResultSet rs = preparedStatement.executeQuery()) {
                    while (rs.next()) {
                        Book book = new Book();
                        book.setId(rs.getInt("id"));
                        book.setTitle(rs.getString("title"));
                        // ... Set other properties
                        bookList.add(book);
                    }
                }
            }
        }, new ArrayList<>());
    }

    public List<Book> getByGenre(Genre genre) {
        return executeQuery(bookList -> {
            final String query = "SELECT * FROM book WHERE id_genre = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, genre.getId());
                try (ResultSet rs = preparedStatement.executeQuery()) {
                    while (rs.next()) {
                        Book book = new Book();
                        book.setId(rs.getInt("id"));
                        book.setTitle(rs.getString("title"));
                        // ... Set other properties
                        bookList.add(book);
                    }
                }
            }
        }, new ArrayList<>());
    }

    @Override
    public List<Book> getAll() {
        return executeQuery(bookList -> {
            final String query = "SELECT * FROM book;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Book book = new Book();
                    book.setId(rs.getInt("id"));
                    book.setTitle(rs.getString("title"));
                    // ... Set other properties
                    bookList.add(book);  // changed resultSet to bookList
                }
            }
        }, new ArrayList<>());
    }

    @Override
    public void save(Book book) {
        executeAction(saveBook -> {
            final String query = "INSERT INTO book (title, id_genre, id_author, year_publication) VALUES (?, ?, ?, ?);";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, book.getTitle());
                preparedStatement.setInt(2, book.getGenre().getId());
                preparedStatement.setInt(3, book.getAuthor().getId());
                preparedStatement.setInt(4, book.getPublicationYear());
                preparedStatement.executeUpdate();
            }
        }, book);
    }

    @Override
    public void update(Book book, String[] params) {
        executeAction(updateBook -> {
            final String query = "UPDATE book SET title = ?, id_genre = ?, id_author = ?, year_publication = ? WHERE id = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, params[0]);
                preparedStatement.setInt(2, Integer.parseInt(params[1]));
                preparedStatement.setInt(3, Integer.parseInt(params[2]));
                preparedStatement.setInt(4, Integer.parseInt(params[3]));
                preparedStatement.setInt(5, book.getId());
                preparedStatement.executeUpdate();
            }
        }, book);
    }

    @Override
    public void delete(Book book) {
        executeAction(deleteBook -> {
            final String query = "DELETE FROM book WHERE id = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, book.getId());
                preparedStatement.executeUpdate();
            }
        }, book);
    }

    private <T> T executeQuery(ThrowableAction<T> action, T t) {
        try {
            action.run(t);
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
        return t;
    }

    private void executeAction(ThrowableAction<Book> action, Book book) {
        try {
            action.run(book);
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }
}
