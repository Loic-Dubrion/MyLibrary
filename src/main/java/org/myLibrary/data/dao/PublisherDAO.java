package org.myLibrary.data.dao;

import models.Publisher;
import java.util.List;
import java.sql.*;

public class PublisherDAO implements DAO<Publisher> {
    private Connection connection;

    public PublisherDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Publisher get(int id) {
        // Implémentez la logique pour obtenir un Publisher de la base de données
        return null;
    }

    @Override
    public List<Publisher> getAll() {
        // Implémentez la logique pour obtenir tous les Publishers de la base de données
        return null;
    }

    @Override
    public void save(Publisher Publisher) {
        // Implémentez la logique pour sauvegarder un Publisher dans la base de données
    }

    @Override
    public void update(Publisher Publisher, String[] params) {
        // Implémentez la logique pour mettre à jour un Publisher dans la base de données
    }

    @Override
    public void delete(Publisher Publisher) {
        // Implémentez la logique pour supprimer un Publisher de la base de données
    }

}

