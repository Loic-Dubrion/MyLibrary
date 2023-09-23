package org.myLibrary.data.dao;

import models.Genre;
import java.util.List;
import java.sql.*;

public class GenreDAO implements DAO<Genre> {
    private Connection connection;

    public GenreDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Genre get(int id) {
        // Implémentez la logique pour obtenir un Genre de la base de données
        return null;
    }

    @Override
    public List<Genre> getAll() {
        // Implémentez la logique pour obtenir tous les Genres de la base de données
        return null;
    }

    @Override
    public void save(Genre Genre) {
        // Implémentez la logique pour sauvegarder un Genre dans la base de données
    }

    @Override
    public void update(Genre Genre, String[] params) {
        // Implémentez la logique pour mettre à jour un Genre dans la base de données
    }

    @Override
    public void delete(Genre Genre) {
        // Implémentez la logique pour supprimer un Genre de la base de données
    }

}
