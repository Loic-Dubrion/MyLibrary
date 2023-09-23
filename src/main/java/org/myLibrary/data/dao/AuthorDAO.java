package org.myLibrary.data.dao;

import models.Author;
import java.util.List;
import java.sql.*;

public class AuthorDAO implements DAO<Author> {
    private Connection connection;

    public AuthorDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Author get(int id) {
        // Implémentez la logique pour obtenir un Author de la base de données
        return null;
    }

    @Override
    public List<Author> getAll() {
        // Implémentez la logique pour obtenir tous les Authors de la base de données
        return null;
    }

    @Override
    public void save(Author Author) {
        // Implémentez la logique pour sauvegarder un Author dans la base de données
    }

    @Override
    public void update(Author Author, String[] params) {
        // Implémentez la logique pour mettre à jour un Author dans la base de données
    }

    @Override
    public void delete(Author Author) {
        // Implémentez la logique pour supprimer un Author de la base de données
    }
}
