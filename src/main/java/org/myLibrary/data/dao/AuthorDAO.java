package org.myLibrary.data.dao;

import org.myLibrary.business.models.Author;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AuthorDAO implements DAO<Author> {
    private final Connection connection;

    public AuthorDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Author get(int id) {
        final String query = "SELECT * FROM author WHERE id = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Author author = new Author();
                    author.setId(resultSet.getInt("id"));
                    author.setLastName(resultSet.getString("lastname"));
                    author.setFirstName(resultSet.getString("firstname"));
                    return author;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
