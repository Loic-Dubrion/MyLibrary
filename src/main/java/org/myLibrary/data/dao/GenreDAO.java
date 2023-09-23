package org.myLibrary.data.dao;

import org.myLibrary.business.models.Genre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO implements DAO<Genre> {
    private final Connection connection;

    public GenreDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Genre get(int id) {
        final String query = "SELECT * FROM genre WHERE id = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Genre genre = new Genre();
                    genre.setId(resultSet.getInt("id"));
                    genre.setName(resultSet.getString("name"));
                    return genre;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Genre> getByName(String name) {
        final String query = "SELECT * FROM genre WHERE name = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Genre genre = new Genre();
                    genre.setId(resultSet.getInt("id"));
                    genre.setName(resultSet.getString("name"));
                    return (List<Genre>) genre;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Genre> getAll() {
        final String query = "SELECT * FROM genre;";
        List<Genre> genres = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Genre genre = new Genre();
                genre.setId(resultSet.getInt("id"));
                genre.setName(resultSet.getString("name"));
                genres.add(genre);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genres;
    }

    @Override
    public void save(Genre genre) {
        final String query = "INSERT INTO genre (name) VALUES (?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, genre.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Genre genre, String[] params) {
        final String query = "UPDATE genre SET name = ? WHERE id = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, params[0]);
            preparedStatement.setInt(2, genre.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Genre genre) {
        final String query = "DELETE FROM genre WHERE id = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, genre.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
